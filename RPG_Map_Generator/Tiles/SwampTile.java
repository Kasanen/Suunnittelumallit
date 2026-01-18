package RPG_Map_Generator.Tiles;

import RPG_Map_Generator.Tile;

public class SwampTile extends Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }
    
    @Override
    public String getType() {
        return "Swamp";
    }
    
    @Override
    public void action() {
        System.out.println("Entering swamp");
    }
}