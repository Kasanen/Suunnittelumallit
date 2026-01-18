package RPG_Map_Generator.Tiles;

import RPG_Map_Generator.Tile;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }
    
    @Override
    public String getType() {
        return "Road";
    }
    
    @Override
    public void action() {
        System.out.println("Entering road");
    }
}