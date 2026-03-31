import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory dir1 = new Directory("Folder_1");
        Directory dir2 = new Directory("Folder_2");

        File file1 = new File("Cats", 250);
        File file2 = new File("Dogs", 500);
        File file3 = new File("Big", 700);

        List<FileSystemElement> FileSystem = new ArrayList<>();
        FileSystem.add(dir1);
        FileSystem.add(dir2);

        dir1.add(file1);
        dir1.add(file2);
        dir2.add(file3);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        for (FileSystemElement element : FileSystem) {
            element.accept(sizeCalculator);
        }

        System.out.println("// Searching with Dogs //");

        SearchVisitor searchVisitor = new SearchVisitor("Dogs");
        for (FileSystemElement element : FileSystem) {
            element.accept(searchVisitor);
        }
    }
}
