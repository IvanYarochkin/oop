package by.tc.task01.reader;

import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


public class Reader {
    private static final String FILE_PROPERTIES = "/file.properties";
    private static final String FILE_DIRECTORY = "file.path";
    private static final String FILE_NAME = "file.name";

    private String filePath;


    public void acquireFilePath() {
        try {
            Properties properties = new Properties();
            properties.load(Reader.class.getResourceAsStream(FILE_PROPERTIES));
            filePath = properties.getProperty(FILE_DIRECTORY) + properties.getProperty(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String> readFromFile() {
        if ( filePath == null ) {
            acquireFilePath();
        }
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(Paths.get(filePath))
                    .filter(Strings::isNotEmpty)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // TODO: 20.10.2017 Add my exception if it's necessary
            e.printStackTrace();
        }
        return lines;
    }
}