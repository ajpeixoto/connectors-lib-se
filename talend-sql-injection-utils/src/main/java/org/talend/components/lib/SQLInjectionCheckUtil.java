package org.talend.components.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLInjectionCheckUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLInjectionCheckUtil.class);

    public static boolean checkSQLInjection(String identifier) {
        if (identifier == null) {
            return false;
        }
        if (identifier.length() > 255) {
            return true;
        }
        String[] riskyChar = {"\"", ";", "'", "--", "/*", "xp_", "=", " "};
        for (String s : riskyChar) {
            if (identifier.contains(s)) {
                LOGGER.warn("Potential SQL Injection risks: {}", identifier);
                return true;
            }
        }

        return false;
    }
}
