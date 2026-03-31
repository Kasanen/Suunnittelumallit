public class SearchVisitor implements FileSystemVisitor {
    private String searchWord;

    public SearchVisitor(String searchWord) {
        this.searchWord = searchWord;
    }

    @Override
    public void visit(File file) {
        if (file.getName() == searchWord) {
            System.out.println("File: " + file.getName() + ", Size: " + file.getSize());
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getName() == searchWord) {
            int size = directory.getTotalSize();
            System.out.println("Directory: " + directory.getName() + ", Total size: " + size);
        }
    }
}
