public class ActionSelectionState extends State {

    public ActionSelectionState(Character character) {
        super(character);
    }

    public void action() {

        String[] options = { "Train", "Meditate", "Fight", "Exit" };

        String characterLVL = this.getCharacter().getLVL();

        switch (this.getCharacter().readUserChoice(options)) {
            case 1:
                System.out.println("Beating up some thugs...");
                this.getCharacter().addEXP(2);
                break;
            case 2:
                if (characterLVL.equals("Thief") || characterLVL.equals("Hitman")) {
                    System.out.println("Meditating in the park...");
                    this.getCharacter().addEXP(1);
                    this.getCharacter().addHP(10);
                } else {
                    System.out.println("You are not skilled enough to meditate.");
                }
                break;
            case 3:
                if (characterLVL.equals("Hitman")) {
                    System.out.println("Fighting a rival gang member...");
                    this.getCharacter().addHP(-20);
                    this.getCharacter().addEXP(5);
                    break;
                } else {
                    System.out.println("You are not skilled enough to fight.");
                }
                break;
            case 4:
                System.out.println("Exiting the game...");
                this.getCharacter().endGame();
                break;
        }
    }
}
