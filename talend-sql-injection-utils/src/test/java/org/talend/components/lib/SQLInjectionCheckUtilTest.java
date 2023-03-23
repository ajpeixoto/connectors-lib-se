package org.talend.components.lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SQLInjectionCheckUtilTest {


    @Test
    void validateSQLInjection() {

        String[] correct = {"TableName", "_my_identifier", "My$identifier", "идентификатор", "内清表", "3rd_identifier"};
        for (String name : correct) {
            final boolean result = SQLInjectionCheckUtil.checkSQLInjection(name);
            Assertions.assertFalse(result);
        }

        String[] riskyOnes = {"\"AAA\\\" ; drop table \\\"ABCDE\" ", "105 OR 1=1", "45 --", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa259"};
        for (String name : riskyOnes) {
            boolean result = SQLInjectionCheckUtil.checkSQLInjection(name);
            Assertions.assertTrue(result);
        }
    }
}