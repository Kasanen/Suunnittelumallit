
import java.util.Scanner;

public class Character {
    private static Scanner scanner = new Scanner(System.in);
    private State state;

    private double balance = 0.0;

    private String name = "Mafia";
    private String LVL = "Crook";
    private int XP = 0;
    private int HP = 100;

    public Character() {
        state = new ReadyState(this);
    }

    public void operate() {
        while (true) {
            if (state == null) {
                // should never happen
                System.out.println("There was an error with the game.");
                return;
            }
            state.action();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    // Character related methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLVL(String LVL) {
        this.LVL = LVL;
    }

    public String getLVL() {
        return LVL;
    }

    public void addEXP(int amount) {
        System.out.println("EXP +" + amount);
        XP += amount;

        if (XP >= 99) {
            setLVL("Boss");
            System.out.println("You've reached the maximum level!");
            endGame();
        } else if (XP >= 35) {
            setLVL("Hitman");
        } else if (XP >= 10) {
            setLVL("Thief");
        }
    }

    public int getEXP() {
        return XP;
    }

    public void addHP(int amount) {
        System.out.println("HP: " + amount);

        if (HP + amount > 100) {
            HP = 100;
        } else {
            HP += amount;
        }

        if (HP <= 0) {
            System.out.println("You got killed by the rival gang!");
            endGame();
        }
    }

    public int getHP() {
        return HP;
    }

    public void endGame() {
        System.out.println("Game Over!");
        getStatus();
        System.exit(0);
    }

    public void getStatus() {
        System.out.println(
                "\n" + this.getName() + " | " + this.getLVL() + " | EXP: " + this.getEXP() + " | HP: " + this.getHP());
    }

    public String readUserInput() {
        return scanner.nextLine();
    }

    public int readUserChoice(String[] options) {
        // Character stats
        getStatus();

        // print options
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }
        // read user input
        return Integer.parseInt(readUserInput());
    }

    public void issueTickets() {
        System.out.println("Printing tickets...");
    }
}
