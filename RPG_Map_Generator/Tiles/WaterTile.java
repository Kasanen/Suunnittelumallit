package RPG_Map_Generator.Tiles;

import RPG_Map_Generator.Tile;

public class WaterTile extends Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }
    
    @Override
    public String getType() {
        return "Water";
    }
    
    @Override
    public void action() {
        System.out.println("Entering water");
    }
}