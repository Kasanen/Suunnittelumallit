
public class Employee extends Component {

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;

    }

    @Override
    public void getTotalSalary() {
        this.total = this.salary;
    }

    @Override
    public void printXML(){
        
        System.out.println("     " + "<employee name=\"" + this.name + "\" salary=\"" + this.salary + "\"/>");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}
