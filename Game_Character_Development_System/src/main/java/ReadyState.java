
public class ReadyState extends State {

    public ReadyState(Character character) {
        super(character);
    }

    public void action() {
        System.out.println("Welcome to Mafia City!");
        System.out.println("Enter your character's name:");
        String name = this.getCharacter().readUserInput();
        this.getCharacter().setName(name);
        
        String[] options = { "Continue" };
        switch (this.getCharacter().readUserChoice(options)) {
            case 1:
                this.getCharacter().setState(new ActionSelectionState(this.getCharacter()));
                break;
        }
    }
}
