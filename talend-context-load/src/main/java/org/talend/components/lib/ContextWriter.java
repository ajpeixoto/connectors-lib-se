package org.talend.components.lib;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


public class ContextWriter {

    File tmpFile;
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextWriter.class);


    public ContextWriter(String seed) throws IOException {

        tmpFile = new File(
                FileUtils.getTempDirectoryPath() + "tmp_" + seed);
        LOGGER.info("Trying to create tmp file: " + tmpFile.getPath());
        try {
            FileUtils.touch(tmpFile);
        } catch (IOException e) {
            tmpFile = new File("tmp_" + seed);
            LOGGER.info("Trying to create tmp file: " + tmpFile.getPath());
            FileUtils.touch(tmpFile);
        }
    }


    public void write2File(List<String> paraList)  {
        final List<String> contexts = paraList.stream()
                .filter(e -> e.startsWith("--context_param") || e.startsWith("--context_type")).collect(Collectors.toList());
        try {
            FileUtils.writeLines(tmpFile, contexts);
            contexts.stream().forEach(e -> paraList.remove(e));
            paraList.add("--context_file " + getBase64FilePath());
        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
            e.printStackTrace();
        }


    }

    public String getTmpFilePath() {
        return tmpFile.getAbsolutePath();
    }

    public String getBase64FilePath() {
        return Base64.getEncoder().encodeToString(tmpFile.getAbsolutePath().getBytes());
    }

    public void clean() {
        if (tmpFile != null) {
            LOGGER.info("Deleting tmp file: " +tmpFile.getAbsolutePath());
            tmpFile.delete();
        }

    }
}
