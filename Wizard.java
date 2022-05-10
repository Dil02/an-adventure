import java.util.Random; //Imports the random class.
//The 'Wizard' class is one of three subclasses which a non-player character can be an instance of.
public final class Wizard extends NPC
{
   private int spell; // Will be applied to Strength;
   
   //Class Constructor.
   public Wizard(String state, String speciality, String name, int iQ, 
    int strength)
    {
        super("threw a fireball at you!","froze you!","turned you into stone!",state,speciality,name,iQ,strength);
        Random random = new Random();
        spell=random.nextInt((20 - -20)+1)+20;;
    }
   
    /*This function overrides the 'interact' method in the superclass 'NPC', based on the value of spell, the player's strength is adjusted*/
    public Player interact(Player player, Character x)
    {
        player=super.interact(player,x);
        player.setStrength(spell);
        if(spell >0)
        {
            Game.guiMain.output.append("I have increased your strength by " + spell + " noble adventurer." + "\n");
            return player;
        }

        Game.guiMain.output.append("You will not succeed, for I have drained your strength by " + spell + "." + "\n");
        return player;
    }
}
