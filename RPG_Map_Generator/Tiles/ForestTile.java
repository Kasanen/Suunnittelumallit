package RPG_Map_Generator.Tiles;

import RPG_Map_Generator.Tile;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }
    
    @Override
    public String getType() {
        return "Forest";
    }
    
    @Override
    public void action() {
        System.out.println("Entering forest");
    }
}