
import java.nio.file.*;

public class Logger {
    private static Logger instance;
    private String currentFile;

    private Logger() {
        this.currentFile = "default_log.txt";
        Path path = Paths.get(currentFile);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Default log file created");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String newName) {
        if (currentFile != newName) {
            Path source = Paths.get(currentFile);
            Path target = Paths.get(newName);
            try {
                if (Files.exists(target)) {
                    System.out.println("Overwriting");
                    nuke(newName);

                    System.out.println("Setting file name to: " + newName);
                    Files.move(source, target);
                    currentFile = newName;
                } else {
                    System.out.println("Setting file name to: " + newName);
                    Files.move(source, target);
                    currentFile = newName;
                }

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void write(String text) {
        if (currentFile != null) {
            Path path = Paths.get(currentFile);
            try {
                System.out.println("Logged: " + text);
                Files.writeString(path, text + System.lineSeparator(), StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE);

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void nuke(String fileName) {
        Path path = Paths.get(fileName);
        try {
            System.out.println("Nuke file: " + fileName);
            Files.delete(path);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void close() {
        System.out.println("Logger closed!");
        currentFile = null;
    }

}

/*
 * public static void main(String[] args) throws IOException {
 * Path path = Paths.get("example.txt");
 * 
 * // 1. Read all content
 * String content = Files.readString(path);
 * 
 * // 2. Modify content
 * content = content.replace("oldWord", "newWord");
 * 
 * // 3. Write back to file (overwrite)
 * Files.writeString(path, content);
 * }
 */