public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);

    int getSize();
}
