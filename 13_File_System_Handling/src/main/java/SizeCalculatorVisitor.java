public class SizeCalculatorVisitor implements FileSystemVisitor {
    @Override
    public void visit(File file) {
        System.out.println("File: " + file.getName() + ", Size: " + file.getSize());
    }
    
    @Override
    public void visit(Directory directory) {
        int size = directory.getTotalSize();
        System.out.println("Directory: " + directory.getName() + ", Total size: " + size);
    }
}
