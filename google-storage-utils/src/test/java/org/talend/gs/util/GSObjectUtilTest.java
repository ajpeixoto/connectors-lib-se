package org.talend.gs.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.*;

class GSObjectUtilTest {

    @Test
    void checkSizeOfFilesInFolderTest() {
        Path pathToDirectory = Paths.get("src", "test", "resources", "dirWithThreeFiles");
        Path pathToFile1 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "1.csv");
        Path pathToFile2 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "2.csv");
        Path pathToFile3 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "3.csv");
        Path pathToFile4 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "inner", "1.csv");

        String expectedRelativePathToFile1 = "/1.csv";
        String expectedRelativePathToFile2 = "/2.csv";
        String expectedRelativePathToFile3 = "/3.csv";
        String expectedRelativePathToFile4 = "/inner/1.csv";

        File rootFile = new File(pathToDirectory.toUri());
        GSObjectUtil gsObjectUtil = new GSObjectUtil();
        Map<String, File> files = gsObjectUtil.generateFileMap(rootFile, "/");
        assertEquals(4, files.size());

        File expectedFile1 = new File(pathToFile1.toUri());
        File expectedFile2 = new File(pathToFile2.toUri());
        File expectedFile3 = new File(pathToFile3.toUri());
        File expectedFile4 = new File(pathToFile4.toUri());

        assertTrue(files.containsKey(expectedRelativePathToFile1));
        assertTrue(files.containsKey(expectedRelativePathToFile2));
        assertTrue(files.containsKey(expectedRelativePathToFile3));
        assertTrue(files.containsKey(expectedRelativePathToFile4));

        assertEquals(expectedFile1.getAbsoluteFile(), files.get(expectedRelativePathToFile1).getAbsoluteFile());
        assertEquals(expectedFile2.getAbsoluteFile(), files.get(expectedRelativePathToFile2).getAbsoluteFile());
        assertEquals(expectedFile3.getAbsoluteFile(), files.get(expectedRelativePathToFile3).getAbsoluteFile());
        assertEquals(expectedFile4.getAbsoluteFile(), files.get(expectedRelativePathToFile4).getAbsoluteFile());
    }

    @Test
    void checkSizeOfFilesInFolder2Test() {
        Path pathToDirectory = Paths.get("src", "test", "resources", "dirWithThreeFiles");
        Path pathToFile1 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "1.csv");
        Path pathToFile2 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "2.csv");
        Path pathToFile3 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "3.csv");
        Path pathToFile4 = Paths.get("src", "test", "resources", "dirWithThreeFiles", "inner", "1.csv");

        String expectedRelativePathToFile1 = "1.csv";
        String expectedRelativePathToFile2 = "2.csv";
        String expectedRelativePathToFile3 = "3.csv";
        String expectedRelativePathToFile4 = "inner/1.csv";

        File rootFile = new File(pathToDirectory.toUri());
        GSObjectUtil gsObjectUtil = new GSObjectUtil();
        Map<String, File> files = gsObjectUtil.generateFileMap(rootFile, "");
        assertEquals(4, files.size());

        File expectedFile1 = new File(pathToFile1.toUri());
        File expectedFile2 = new File(pathToFile2.toUri());
        File expectedFile3 = new File(pathToFile3.toUri());
        File expectedFile4 = new File(pathToFile4.toUri());

        assertTrue(files.containsKey(expectedRelativePathToFile1));
        assertTrue(files.containsKey(expectedRelativePathToFile2));
        assertTrue(files.containsKey(expectedRelativePathToFile3));
        assertTrue(files.containsKey(expectedRelativePathToFile4));

        assertEquals(expectedFile1.getAbsoluteFile(), files.get(expectedRelativePathToFile1).getAbsoluteFile());
        assertEquals(expectedFile2.getAbsoluteFile(), files.get(expectedRelativePathToFile2).getAbsoluteFile());
        assertEquals(expectedFile3.getAbsoluteFile(), files.get(expectedRelativePathToFile3).getAbsoluteFile());
        assertEquals(expectedFile4.getAbsoluteFile(), files.get(expectedRelativePathToFile4).getAbsoluteFile());
    }

    @Test
    void oneFileWithCustomPathTest() {
        Path pathToFile = Paths.get("src", "test", "resources", "empty.csv");
        String pathToFolder = "/folder/folder";
        File expectedFile = new File(pathToFile.toUri());
        GSObjectUtil gsObjectUtil = new GSObjectUtil();

        Map<String, File> files = gsObjectUtil.generateFileMap(expectedFile, pathToFolder);

        String expectedRelativePathToFile = "/folder/folder/empty.csv";

        assertEquals(1, files.size());
        assertTrue(files.containsKey(expectedRelativePathToFile));
        assertEquals(expectedFile.getAbsoluteFile(), files.get(expectedRelativePathToFile).getAbsoluteFile());
    }

    @Test
    void oneFileWithOtherCustomPathTest() {
        Path pathToFile = Paths.get("src", "test", "resources", "empty.csv");
        String pathToFolder = "folder/folder";
        File expectedFile = new File(pathToFile.toUri());
        GSObjectUtil gsObjectUtil = new GSObjectUtil();

        Map<String, File> files = gsObjectUtil.generateFileMap(expectedFile, pathToFolder);

        String expectedRelativePathToFile = "folder/folder/empty.csv";

        assertEquals(1, files.size());
        assertTrue(files.containsKey(expectedRelativePathToFile));
        assertEquals(expectedFile.getAbsoluteFile(), files.get(expectedRelativePathToFile).getAbsoluteFile());
    }

    @Test
    void folderWithOtherCustomPathTest() {
        Path pathToFolder = Paths.get("src", "test", "resources", "dirWithThreeFiles", "inner");
        String pathToGSFolder = "folder";
        File folder = new File(pathToFolder.toUri());
        GSObjectUtil gsObjectUtil = new GSObjectUtil();

        Map<String, File> files = gsObjectUtil.generateFileMap(folder, pathToGSFolder);

        String expectedRelativePathToFile = "folder/1.csv";
        File expectedFile = new File(pathToFolder + "/1.csv");

        assertEquals(1, files.size());
        assertTrue(files.containsKey(expectedRelativePathToFile));
        assertEquals(expectedFile.getAbsoluteFile(), files.get(expectedRelativePathToFile).getAbsoluteFile());
    }

    @ParameterizedTest
    @CsvSource({
            "1.csv,1.csv",
            "inner/1.csv,inner/1.csv",
            "inner/*.csv,inner/1.csv",
            "inner/(1).csv,inner/1.csv",
            "inner/[1].csv,inner/1.csv",
            "inner2/\\(empty\\).csv,inner2/(empty).csv"
    })
    void genFileFilterList(final String fileTemplate, final String expectedName) {
        final List<Map<String, String>> list = new ArrayList<>();
        list.add(new HashMap<String, String>() {{
            put(fileTemplate, "fooName.csv");
        }});
        final String localdir = "src/test/resources/dirEmptyFiles";
        final String remotedir = "someDir";

        final GSObjectUtil gsObjectUtil = new GSObjectUtil();
        final Map<String, String> map = gsObjectUtil.genFileFilterList(list, localdir, remotedir);

        Assertions.assertFalse(map.isEmpty());
        for (final Entry<String, String> entry : map.entrySet()) {
            Assertions.assertEquals(Paths.get(localdir, expectedName).toAbsolutePath().toString(), entry.getKey());
        }
    }
}