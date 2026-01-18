package RPG_Map_Generator;

import RPG_Map_Generator.Tile;

public abstract class Map {
    // Luodaan 2 ulotteinen taulukko kartoille
    protected Tile[][] tiles = new Tile[5][5];

    // Metodi kartan luomiseen
    public void createMap() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                tiles[y][x] = createTile();
            }
        }
        display();
    }

    // Metodi kartan näyttämiseen
    public void display() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(tiles[y][x].getCharacter());
            }
            System.out.println();
        }
    }

    public abstract Tile createTile();
}
