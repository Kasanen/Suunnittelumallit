package RPG_Map_Generator.Tiles;

import RPG_Map_Generator.Tile;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }
    
    @Override
    public String getType() {
        return "Building";
    }
    
    @Override
    public void action() {
        System.out.println("Entering building");
    }
}