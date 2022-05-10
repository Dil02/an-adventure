//The class 'Piece' is one of three subclasses which a Collectible can be an instance of.
public class Piece extends Collectible
{
    private String location; //Stores the location of where the torch piece was found.
    
    public Piece(String location, String type, int value)//Class Constructor.
    {
        super(type,value);
        this.location=location;
    }
    
    //Getters:
    
    public String getLocation()
    {
        return location;
    }
    
    /*The method 'getDescription' which is in the superclass is overrided below printing out information regarding the properties of the 
    Piece object.*/
    public String getDescription(Player player)
    {
        return "Torch Piece- Location: " + location + ".";
    }
    
    //Setters:
    
    public void setLocation(String location)
    {
        this.location=location;
    }
}
