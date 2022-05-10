import java.util.ArrayList; // import the ArrayList class.
//The 'Player' class defines a unique blueprint for just the Player including variables such as an ArrayList as an inventory and a score counter.
public final class Player extends Character
{
   private int correct;
   private int score;
   private ArrayList<Collectible> inventory = new ArrayList<Collectible>(); //Creates an ArrayList.
    
    //Class Constructor, a player starts the game with 0 torch pieces and having answered no questions correctly.
    public Player(String name, int iQ, int strength)
    {
       super(name,iQ,strength);
       correct=0;
       score=0;
    }
    
    /*The function 'Quiz' in the superclass 'Character' is overrided below in which the number of correct answers a player has is adjusted
   based on their iQ as well as their health.*/
   
    public int Quiz(Biome [] locations, int j,Character player) 
   {
       int counter=super.Quiz(locations,j,player);
       double health=player.getHealth();
       int iQ=player.getIQ();
       
       if((health >80.0) && (iQ >=100)) //So only if they are of a sound mind can they answer all questions correctly.
       {
           return counter;
       }
       else if(iQ >85) //If iQ is less than 100 the number of correct answer reduces by 1.
       {
           if(counter >=1)
           {
               return counter-1;
           }
           else
           {
               return counter;
           }
       }  
       else
       {
           return 0;
       }
   }
   
   /* The function 'battle' in the superclass 'Character' is overrided below in which the number of hits is multipled by '5'. Which represents
   how much damage occurs everytime the player is hit. This value is then returned.*/
    
   public int battle(Character player,Character y)
   {
       int hits=super.battle(player,y);   
       return hits*5;
   }
    
   //Setters:
      
   public void setCorrect()
   {
       correct= correct +1;
   }
   
   public void setScore(int value)
   {
       score=score+value;
   }
   
   //Getters:
      
   public int getScore()
   {
       return score;
   }
   
   public int getCorrect()
   {
       return correct;
   }

   public ArrayList <Collectible> getCollectible()
   {
       return inventory;
   }
}
