import java.util.Random; //Import the random class.
//The 'Ninja' class is one of three subclasses of which a non-player character can be an instance of.
public final class Ninja extends NPC
{
   private int intelligence; //This value is used to adjust's the player's iQ.
   
   //Class Constructor.
   public Ninja(String state, String speciality, String name, int iQ, 
    int strength)
    {
        super("hit you with multiple shurikens!","snuck up on you!","caught you!",state,speciality,name,iQ,strength);
        Random random = new Random();
        intelligence=random.nextInt((15 - -15)+1)+15;
    }
   
   /*This function overrides the 'interact' method in the 'NPC' superclass and adjusts the player's iQ based on the value of intelligence,
   this value could either reduce or increase the player's intelligence.*/
   public Player interact(Player player, Character x)
   {
       player=super.interact(player,x);
       player.setIQ(intelligence);
       if(intelligence >0)
       {
           Game.guiMain.output.append("You will need all your strength, including that of your mind." + "\n");
           Game.guiMain.output.append("Your intelligence has been increased by " + intelligence + "." + "\n");
           return player;
       }
       Game.guiMain.output.append("Your mind has suffered, your intelligence has declined by " + intelligence + "." + "\n");
       return player;
   }
}