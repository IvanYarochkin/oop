package by.tc.task01.filehelper;

import java.io.File;
import java.io.IOException;

public final class FileHelper {
    private static final String FILE_PATH;

    static {
        try {
            File file = File.createTempFile("appliances_db", "txt");
            FILE_PATH = file.getAbsolutePath();
            file.deleteOnExit();
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private FileHelper() {

    }

    public static String getFilePath() {
        return FILE_PATH;
    }
}
