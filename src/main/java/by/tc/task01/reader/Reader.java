package by.tc.task01.reader;

import by.tc.task01.writer.Writer;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    private final String FILE_PATH = "src/main/resources/appliances_db.txt";

    private Reader() {
    }

    private static class SingletonHolder {
        private static final Reader INSTANCE = new Reader();
    }

    public static Reader getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getFilePath() {
        return FILE_PATH;
    }

    public List<String> readFromFile() {
        Writer.getInstance().write();

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(Paths.get(FILE_PATH))
                    .filter(Strings::isNotEmpty)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer.getInstance().deleteFile();

        return lines;
    }
}