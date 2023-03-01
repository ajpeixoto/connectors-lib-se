package org.talend.components.azure.runtime.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndpointUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(EndpointUtil.class);

    public static final String DEFAULT_AUTHORITY = "https://login.microsoftonline.com/";

    static final String RESOURCE = "https://storage.azure.com/" ;

    public enum Region {
        AZURE_CLOUD,
        AZURE_CHINA_CLOUD,
        AZURE_GERMAN_CLOUD,
        AZURE_US_GOVERNMENT,
        CUSTOM
    }

    public static String getEndpoint(String region, String customEndpoint) {
        String endpoint = customEndpoint;
        switch (region) {
            case "AZURE_CLOUD":
                endpoint = "core.windows.net";
                break;
            case "AZURE_GERMAN_CLOUD":
                endpoint = "core.cloudapi.de";
                break;
            case "AZURE_US_GOVERNMENT":
                endpoint = "core.usgovcloudapi.net";
                break;
            case "AZURE_CHINA_CLOUD":
                endpoint = "core.chinacloudapi.cn";
                break;
            case "CUSTOM":
                endpoint = customEndpoint.trim();
                break;
            default:
                endpoint = "core.windows.net";
        }
        LOGGER.info("Using endpoint:" + endpoint);
        return endpoint;
    }

    public static String getAuthorityHost(String endpoint) {
        switch (endpoint.trim()) {
            case "core.windows.net":
                return DEFAULT_AUTHORITY;
            case "core.cloudapi.de":
                return "https://login.microsoftonline.de/";
            case "core.usgovcloudapi.net":
                return "https://login.microsoftonline.us/";
            case "core.chinacloudapi.cn":
                return "https://login.chinacloudapi.cn/";
            default:
                System.err.println("Unrecognized ending point: " + endpoint);
                return DEFAULT_AUTHORITY;
        }
    }

}
