package RPG_Map_Generator;

import java.util.Random;

import RPG_Map_Generator.Tiles.SwampTile;
import RPG_Map_Generator.Tiles.WaterTile;
import RPG_Map_Generator.Tiles.ForestTile;


public class WildernessMap extends Map {
    private Random random = new Random();

    @Override
    public Tile createTile() {
        int tileType = random.nextInt(3); // 0, 1, or 2
        
        switch (tileType) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                return new SwampTile();
        }
    }
}
