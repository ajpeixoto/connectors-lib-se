package org.talend.components.azure.runtime.token;

import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.IClientCredential;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.talend.components.azure.runtime.token.EndpointUtil.RESOURCE;

public class AzureActiveDirectoryTokenGetter {

    private final String tenantId;
    private final String clientId;
    private final String clientSecret;
    private String authorityHost;

    public AzureActiveDirectoryTokenGetter(String tenantId, String clientId, String clientSecret) {
        this(tenantId,clientId,clientSecret,null);
    }

    public AzureActiveDirectoryTokenGetter(String tenantId, String clientId, String clientSecret, String authorityHost) {
        this.tenantId = tenantId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorityHost = authorityHost;

    }

    /**
     * Returns an active directory token will be used for connection
     */
    public String retrieveAccessToken() throws Exception {
        return retrieveAccessToken(EndpointUtil.getEndpoint(EndpointUtil.Region.AZURE_CLOUD.toString(), ""));
    }

    public String retrieveAccessToken(String endpoint) throws Exception {
        if(authorityHost == null){
            authorityHost = EndpointUtil.getAuthorityHost(endpoint);
        }
        IClientCredential credential = ClientCredentialFactory.createFromSecret(clientSecret);
        ConfidentialClientApplication confidentialClientApplication = ConfidentialClientApplication.builder(clientId, credential)
                .authority(authorityHost + tenantId).build();
        Set<String> scopes = Collections.singleton(RESOURCE+ "/.default"); //for azure storage scope should ends with ".default"

        final String azure_blob_aad_scope = System.getenv().get("AZURE_BLOB_SCOPE");
        if (azure_blob_aad_scope != null && !"".equals(azure_blob_aad_scope)) {
            final String[] azure_scopes = azure_blob_aad_scope.split(",");
            scopes.addAll(Arrays.asList(azure_scopes));
        }

        ClientCredentialParameters parameters = ClientCredentialParameters.builder(scopes).build();
        IAuthenticationResult result = confidentialClientApplication.acquireToken(parameters).get();
        return result.accessToken();
    }
}
