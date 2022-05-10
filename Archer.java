import java.util.Random; //Imports the random class.
//The 'Archer' class is one of three subclasses which a non-player character can be an instance of.
public final class Archer extends NPC
{
   private boolean theft; // Depending on the value, a player's inventory is adjusted.
   
   //Class Constructor.
   public Archer(String state, String speciality, String name, int iQ, 
    int strength)
    {
        super("captured you with a net arrow.","tied your feet together and you fell flat on your face!", "ripped your shirt.", state,speciality,name,iQ,strength);
        Random random= new Random();
        int number=random.nextInt(2);
        if(number==0)
        {
          theft=false;
        }
        else
        {
          theft=true;
        }
    }
   
   /*This function overrides the 'interact' method in the superclass 'NPC', and it modifies the player's inventory based on the value of 
   the boolean theft.*/
   public Player interact(Player player, Character x)
   {
       player=super.interact(player,x);
       if((theft==true) && (player.getCollectible().size() !=0))
       {
           if(player.getCollectible().get(player.getCollectible().size()-1) instanceof Piece)
           {
               Game.guiMain.output.append("Ooh that is a nice " + player.getCollectible().get(player.getCollectible().size()-1).getType() + " you have there."
               + "\n");
           }
           else
           {
               Artefact tempArtefact = (Artefact) player.getCollectible().get(player.getCollectible().size()-1);
               Game.guiMain.output.append("Ooh that is a nice " + tempArtefact.getName() + " you have there." + "\n");
           }
           player.getCollectible().remove(player.getCollectible().size()-1);
           Game.guiMain.output.append("You don't mind if I take that do you? Bye!" + "\n");
           return player;
       }
       Game.guiMain.output.append("Hmm, it seems I'm not my usual self today. I don't feel like stealing from you!" + "\n");
       return player;
   }
}
