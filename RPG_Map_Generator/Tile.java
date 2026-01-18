package RPG_Map_Generator;

public abstract class Tile {
    public abstract char getCharacter();
    
    public abstract String getType();

    public abstract void action();
}