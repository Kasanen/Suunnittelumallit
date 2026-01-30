
public abstract class Component {

    protected String name;
    protected int salary;
    protected int total;

    public Component(String name) {
        this.name = name;
        this.total = 0;
    }

    public void printData() {
        System.out.println(this.name);
        if (this.salary > 0) {
            System.out.println(this.salary + "€");
        }
    };

    public void getTotalSalary() {
        System.out.println("Organization total salary: " + this.total + "€");
    }

    public void printXML() {
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract Component getChild(int index);

}
