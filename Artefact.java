//The class 'Artefact' is one of three subclasses which a Collectible can be an instance of.
public class Artefact extends Collectible
{
    private String name;
    private int weight; //This can be used with value to perform a calculation to give the approximate market value of the artefact.
    
    //Class Constructor.
    public Artefact(String name,int weight, String type, int value)
    {
        super(type,value);
        this.name=name;
        this.weight=weight;
    }
    
    //Getters:
    
    //The method 'getValue' which is in the superclass is overrided below returning the value of the object multipled by its weight. 
    public int getValue()
    {
        return super.getValue() * weight;
    }
    
    /*The method 'getDescription' which is in the superclass is overrided below printing out information regarding the properties of the 
    artefact object.*/
    public String getDescription(Player player)
    {
      return "You have found a " + name + ", it has been added to your inventory." + 
      "\nWith a rarity factor of " + super.getValue() + " and weight of " + weight + "g." + 
      "\nAccording to numerous experts, the market value of the " + name + " is £" + getValue() + ".";
    }
    
    public String getName()
    {
        return name;
    }
    
}
