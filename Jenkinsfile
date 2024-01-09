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
final def gitCredentials = usernamePassword(
  credentialsId: 'github-credentials',
  usernameVariable: 'GITHUB_LOGIN',
  passwordVariable: 'GITHUB_TOKEN')
final def sonarCredentials = usernamePassword(
  credentialsId: 'sonar-credentials',
  passwordVariable: 'SONAR_PASSWORD',
  usernameVariable: 'SONAR_LOGIN')
final String podLabel = "connectors-lib-se-${UUID.randomUUID().toString()}".take(53)
final String tsbiImage = 'jdk11-svc-springboot-builder'
final String tsbiVersion = '2.9.18-2.4-20220104141654'
final String m2 = "/tmp/jenkins/tdi/m2/"
String junits = ""

// In PR environment, the branch name is not valid and should be swap with pr name.
final String pullRequestId = env.CHANGE_ID
final String branch_name = pullRequestId != null ? env.CHANGE_BRANCH : env.BRANCH_NAME
String extraBuildParams = ''

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
        /*
        booleanParam(
          name: 'UPDATE_SNAPSHOT',
          defaultValue: true,
          description: '''
            UPDATE_SNAPSHOT : Add the --update-snapshot (-U) option to all maven cmd.
            Uncheck this may lean to not have the last version of deployed connectors-se''')
        */
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
        stage('Maven sonar') {
            steps {
                script {
                    /*
                    // Build the extraBuildParams content depending on actual run
                    extraBuildParams = extraBuildParams_assembly(
                            fail_at_end,
                            params.UPDATE_SNAPSHOT as Boolean,
                            isOnMasterOrMaintenanceBranch)
                    */
                    withCredentials([nexusCredentials,
                                     sonarCredentials,
                                     gitCredentials]) {
                        if (pullRequestId != null) {

                            println 'Run analysis for PR'
                            sh """\
                            bash .jenkins/mvn_sonar_pr.sh \
                                '${branch_name}' \
                                '${env.CHANGE_TARGET}' \
                                '${pullRequestId}'
                            """.stripIndent()
                        } else {
                            echo 'Run analysis for branch'
                            sh """\
                            bash .jenkins/mvn_sonar_branch.sh \
                            '${branch_name}'
                            """.stripIndent()
                        }
                    }
                }
            }
        }

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

/*
    post {
        success {
            slackSend(color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", channel: "${slackChannel}")
        }
        failure {
            slackSend(color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", channel: "${slackChannel}")
        }
    }
*/
}



/**
 * Assembly all needed items to put inside extraBuildParams
 *
 * @param Boolean fail_at_end, if set to true, --fail-at-end will be added
 * @param Boolean snapshot_update, if set to true, --update-snapshots will be added
 * @param Boolean use_light_maven_enforcer, if set to true, --define use-maven-enforcer-light-rules
 *
 * @return extraBuildParams as a string ready for mvn cmd
 */
private String extraBuildParams_assembly(Boolean fail_at_end,
                                         Boolean snapshot_update,
                                         Boolean use_light_maven_enforcer) {
    String extraBuildParams

    println 'Processing extraBuildParams'
    println 'Manage the env.MAVEN_SETTINGS and env.DECRYPTER_ARG'
    final List<String> buildParamsAsArray = ['--settings',
                                             env.MAVEN_SETTINGS,
                                             env.DECRYPTER_ARG] as List<String>
    println 'Manage the EXTRA_BUILD_PARAMS'
    buildParamsAsArray.add(params.EXTRA_BUILD_PARAMS)
    println 'Manage the failed-at-end option'
    if (fail_at_end) {
        buildParamsAsArray.add('--fail-at-end')
    }
    println 'Manage the --update-snapshots option'
    if (snapshot_update) {
        buildParamsAsArray.add('--update-snapshots')
    }

    println 'Manage the maven-enforcer profile'
    if (use_light_maven_enforcer) {
        buildParamsAsArray.add('--define use-maven-enforcer-light-rules')
    }

    println 'Construct extraBuildParams'
    extraBuildParams = buildParamsAsArray.join(' ')
    println "extraBuildParams: $extraBuildParams"

    return extraBuildParams
}