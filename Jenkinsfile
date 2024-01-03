/**
 * Copyright (C) 2006-2024 Talend Inc. - www.talend.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
final String slackChannel = 'components-ci'
final nexusCredentials = usernamePassword(
        credentialsId: 'nexus-artifact-zl-credentials',
        usernameVariable: 'NEXUS_USER',
        passwordVariable: 'NEXUS_PASSWORD')
final String podLabel = "connectors-lib-se-${UUID.randomUUID().toString()}".take(53)
final String tsbiImage = 'jdk11-svc-springboot-builder'
final String tsbiVersion = '2.9.18-2.4-20220104141654'
final String m2 = "/tmp/jenkins/tdi/m2/"
String junits = ""

pipeline {
    parameters {
        choice(name: 'Action',
                choices: ['Build', 'Build&Deploy'],
                description: 'Kind of running : \nBuild : just build without deploy\nBuild&Deploy : Build and deploy artifact to Nexus')
        string(name: "pom_path",
                description: "Warning! Don't specify path to common (aggregator) pom.xml. Use a path to the exact pom file inside github repository",
                defaultValue: "")
        booleanParam(name: "skip_tests",
                description: "whether skip the junits",
                defaultValue: false)
    }

    agent {
        kubernetes {
            label podLabel
            yaml """
apiVersion: v1
kind: Pod
spec:
    containers:
        -
            name: '${tsbiImage}'
            image: 'artifactory.datapwn.com/tlnd-docker-dev/talend/common/tsbi/${tsbiImage}:${tsbiVersion}'
            command: [cat]
            tty: true
            volumeMounts: [
                {name: m2main, mountPath: /root/.m2/repository}, 
                {name: dockercache, mountPath: /root/.dockercache}
            ]
            resources: {requests: {memory: 3G, cpu: '2.5'}, limits: {memory: 3G, cpu: '2.5'}}
            env:
                - name: DOCKER_HOST
                  value: tcp://localhost:2375
        - 
            name: docker-daemon
            image: artifactory.datapwn.com/docker-io-remote/docker:23.0.6-dind
            env:
                - name: DOCKER_TLS_CERTDIR
                  value: ""
            securityContext:
                privileged: true   
    volumes:
        -
            name: m2main
            hostPath: {path: ${m2} }
        -
            name: dockercache
            hostPath: {path: /tmp/jenkins/tdi/docker}
    imagePullSecrets:
        - name: talend-registry
"""
        }
    }

    environment {
        MAVEN_OPTS = '-Dmaven.artifact.threads=128 -Dorg.slf4j.simpleLogger.showThreadName=true -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss'
        deploymentSuffix = ''
    }

    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '5', numToKeepStr: '5'))
        timeout(time: 45, unit: 'MINUTES')
        skipStagesAfterUnstable()
    }

    stages {
        stage('Build') {
            when {
                expression {
                    params.Action == 'Build'
                }
            }
            steps {
                container(tsbiImage) {
                    withCredentials([nexusCredentials]) {
                        script {
                            if ("pom.xml" == params.pom_path) {
                                sh "echo 'You do not need to use an aggregator pom here: ${pom_path}. And you should not.'"
                                return
                            }
                            if (params.skip_tests) {
                                junits = "-DskipTests"
                            }
                            sh "echo 'mvn -f ${pom_path} -U  clean install ${junits}  -s .jenkins/settings.xml' "
                            sh "mvn -f ${pom_path} -U  clean install ${junits}  -s .jenkins/settings.xml"
                        }
                    }
                }
            }
            post {
                success {
                    script {
                        archiveArtifacts "**/target/*.jar"
                    }
                }
            }
        }

        stage('Build & Deployment') {
            when {
                expression {
                    params.Action == 'Build&Deploy'
                }
            }
            steps {
                container(tsbiImage) {
                    withCredentials([nexusCredentials]) {
                        script {
                            if ("pom.xml" == params.pom_path) {
                                sh "echo 'You do not need to use an aggregator pom here: ${pom_path}. And you should not.'"
                                return
                            }
                            sh "echo 'mvn -f ${pom_path} clean -U -V deploy -s .jenkins/settings.xml' "
                            sh "mvn -f ${pom_path} clean -U -V deploy -s .jenkins/settings.xml"
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            slackSend(color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", channel: "${slackChannel}")
        }
        failure {
            slackSend(color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", channel: "${slackChannel}")
        }
    }
}