//The class 'Potion' is one of three subclasses which a Collectible can be an instance of.
public class Potion extends Collectible
{
   private String effect; // This could be health increase or decrease.
    
    //Class Constructor.
    public Potion(String effect, String type, int value)
    {
        super(type,value);
        this.effect=effect;
    }
    
    //Getters:
    public String getEffect()
    {
        return effect;
    }
    
    /*The method 'getDescription' which is in the superclass is overrided below printing out information regarding the properties of the 
    potion object.*/
    public String getDescription(Player player)
    {
        if(getEffect().equals("Health Decrease"))
        {
           return "Oh dear, that potion was poison!" + "\nYou lost " + getValue() + " health." + 
           "\nYour health is now "+ player.getHealth() + ".";
        }
        else
        {
           return "Lucky you! You just consumed a health potion." + 
           "\nYou gain " + getValue() + " health." + "\nYour health is now " + player.getHealth() + ".";
        }        
    }

}
