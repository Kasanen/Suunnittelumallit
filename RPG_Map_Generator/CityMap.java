package RPG_Map_Generator;

import java.util.Random;

import RPG_Map_Generator.Tiles.BuildingTile;
import RPG_Map_Generator.Tiles.RoadTile;
import RPG_Map_Generator.Tiles.ForestTile;


public class CityMap extends Map {
    private Random random = new Random();

    @Override
    public Tile createTile() {
        int tileType = random.nextInt(3); // 0, 1, or 2
        
        switch (tileType) {
            case 0:
                return new BuildingTile();
            case 1:
                return new RoadTile();
            case 2:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}
