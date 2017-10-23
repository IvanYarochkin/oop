package by.tc.task01.reader;

import by.tc.task01.filehelper.FileHelper;
import by.tc.task01.writer.Writer;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Reader {

    private Reader() {

    }

    public static List<String> readFromFile() {
        Writer.writeDataToFile();

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(Paths.get(FileHelper.getFilePath()))
                    .filter(Strings::isNotEmpty)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}