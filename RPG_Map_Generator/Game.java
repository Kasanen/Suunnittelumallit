package RPG_Map_Generator;

public class Game {

    public static void main(String[] args) {
        Map map = new WildernessMap();  // Valitaan kenttätyyppi
        map.createMap(); // Luodaan kartta
    }
}
