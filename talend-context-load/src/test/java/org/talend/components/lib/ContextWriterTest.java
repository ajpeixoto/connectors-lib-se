package org.talend.components.lib;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


class ContextWriterTest {
    ContextWriter writer;

    @BeforeEach
    void init() throws IOException {
        writer = new ContextWriter("aaa 中文 の Küß die Hand ну и хорош ты");
    }

    @Test
    void write2File() throws IOException {
        java.util.List<String> paraList = new java.util.ArrayList<String>();
        paraList.add("--context_param new1 = dog");
        paraList.add("--context_param new2 = cat");
        paraList.add("--context_param new3 = 123");
        final ArrayList<String> copy = new ArrayList<>();
        copy.addAll(paraList);

        writer.write2File(paraList);
        final List<String> strings = FileUtils.readLines(new File(writer.getTmpFilePath()), Charset.defaultCharset());
        Assertions.assertEquals(0, paraList.size());
        Assertions.assertLinesMatch(copy, strings);
    }

    @Test
    void getTmpFilePath() {
        Assertions.assertTrue(writer.getTmpFilePath().contains("aaa 中文 の Küß die Hand ну и хорош ты"));
    }

    @Test
    void getBase64FilePath() {
        Assertions.assertTrue(new String(Base64.getDecoder().decode(writer.getBase64FilePath())).contains("aaa 中文 の Küß die Hand ну и хорош ты"));
    }
}