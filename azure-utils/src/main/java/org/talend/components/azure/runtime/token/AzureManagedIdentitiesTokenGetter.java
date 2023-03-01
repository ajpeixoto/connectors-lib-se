package org.talend.components.azure.runtime.token;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


import static org.talend.components.azure.runtime.token.EndpointUtil.RESOURCE;


public class AzureManagedIdentitiesTokenGetter {


    private static Logger LOGGER = LoggerFactory.getLogger(AzureManagedIdentitiesTokenGetter.class);

    private static String url = "http://169.254.169.254/metadata/identity/oauth2/token?api-version=2018-02-01&resource=" + RESOURCE;



//    public String retrieveUserAssignedManagedIdentityToken(String managedIdentityClientId) {
//
//        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder()
//                .managedIdentityClientId(managedIdentityClientId)
//                .build();
//        List<String> scopes = Collections.singletonList(RESOURCE+ "/.default");
//        final TokenRequestContext tokenRequestContext = new TokenRequestContext().setScopes(scopes);
//        final Mono<AccessToken> token = defaultCredential.getToken(tokenRequestContext);
//        final AccessToken block = token.block();
//        return block.getToken();
//    }

    public String retrieveSystemAssignMItoken() throws IOException {

            String accesstoken = "";
            URL msiEndpoint = new URL(url);
            HttpURLConnection con = (HttpURLConnection) msiEndpoint.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Metadata", "true");

            if (con.getResponseCode() != 200) {
                final String err = IOUtils.toString(con.getErrorStream(), StandardCharsets.UTF_8);
                throw new IOException("Error calling managed identity token endpoint. " + err);
            }

            final String content = IOUtils.toString(con.getInputStream(), StandardCharsets.UTF_8);
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(content);


            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    jsonToken = parser.nextToken();

                    if ("access_token".equals(fieldName)) {
                        accesstoken = parser.getValueAsString();
                        LOGGER.info("Access Token: " + accesstoken.substring(0, 5) + "..." + accesstoken.substring(accesstoken.length() - 5));
                        return accesstoken;
                    }
                }
            }

        LOGGER.info("content: " + content);
        throw new IOException("No token available.");
    }
}
