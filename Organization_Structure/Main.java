public class Main {

    public static void main(String[] args) throws Exception {

        Component organization = new Organization();

        Component dep1 = new Department("Carolina");
        Component dep2 = new Department("NewYork");

        Component emp1 = new Employee("John Pork", 50);
        Component emp2 = new Employee("Arnold Donlads", 100);
        Component emp3 = new Employee("Nate Middle", 5000);
        Component emp4 = new Employee("Richard", 403);

        organization.add(dep1);
        organization.add(dep2);

        dep1.add(emp4);
        dep1.add(emp3);
        dep2.add(emp1);

        organization.printData();
        organization.getTotalSalary();

        System.out.println("--- XML FORMAT ---");
        organization.printXML();
    }
}
