// This class is used to define the blueprint of Potion, Artefact and Piece objects, which includes properties they all inherit.
public class Collectible
{
    private int value;
    private String type;
    
    //Class Constructor.
    public Collectible(String type,int value)
    {
        this.type=type;
        this.value=value;
    }
    
    //Getters:
    
    public int getValue()
    {
        return value;
    }
    
    public String getDescription(Player player)
    {
        return "The item has a value of " + value + ".";
    }
    
    public String getType()
    {
        return type;
    }
}
