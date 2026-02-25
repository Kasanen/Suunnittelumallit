
public class FirstGame extends Game {
    String player;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Initializing game with " + numberOfPlayers + " players.");
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + player + " is taking their turn.");
        this.player = "Player " + player;
    }

    @Override
    public boolean endOfGame() {
        int sum = pickCards();
        System.out.println("Player picked cards with a total sum of " + sum);

        if (sum == 21) {
            return true;
        }

        System.out.println("Player did not win this turn.");
        return false;
    }

    @Override
    public void displayWinner() {
        System.out.println("Congratulations! " + this.player + " won the game!");
    }

    private int pickCards() {
        int card = (int) (Math.random() * 21) + 1;
        return card;
    }
}