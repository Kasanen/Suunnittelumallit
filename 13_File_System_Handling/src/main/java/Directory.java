import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    public void remove(FileSystemElement element) {
        children.remove(element);
    }

    public FileSystemElement getChild(int index) {
        return children.get(index);
    }

    public int getTotalSize() {
        int total = 0;
        for (FileSystemElement child : children) {
            total += child.getSize();
        }
        return total;
    }

    @Override
    public int getSize() {
        return getTotalSize();
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }
}
