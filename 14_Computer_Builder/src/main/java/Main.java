import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Gaming PC
        System.out.println("GAMING PC");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        gamingDirector.constructComputer();
        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println(gamingPC + "\n");

        // Office PC
        System.out.println("OFFICE PC");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        officeDirector.constructComputer();
        Computer officePC = officeBuilder.getComputer();
        System.out.println(officePC);
    }
}
