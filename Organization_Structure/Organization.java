
import java.util.*;

public class Organization extends Component {

    private List<Component> children = new ArrayList<>();

    public Organization() {
        super("");
    }

    @Override
    public void printData() {
        super.printData();
        for (Component child : this.children) {
            child.printData();
        }
    }

    @Override
    public void getTotalSalary() {
        for (Component child : this.children) {
            child.getTotalSalary();
            this.total += child.total;
        }
        super.getTotalSalary();

    }

    @Override
    public void printXML() {
       
        System.out.println(" "+"<organization>");
        for (Component child : this.children) {
            child.printXML();
        }
        System.out.println(" "+"</organization>");
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);
    }
}
