import java.util.Random; //Imports the random class.
import java.lang.Math; //Imports the Math library.
//The 'Character' class defines a blueprint for Player and NPC objects.
public class Character
{
    private String name;
    private double health;
    private int iQ;
    private int strength;
    
    public Character(String x, int y, int z) //Class Constructor,every Character has a starting health of 100.
    {
        name=x;
        health=100.0;
        iQ=y;
        strength=z;
    }
    
    /*This function allows the user to complete a quiz, where the questions are printed and they are expected to input an answer.
    The number of correct answer is returned."*/
    
    public int Quiz(Biome [] locations,int j,Character x) 
    {
            int correct=0;
            Game.guiMain.output.append(x.getName() +" your test will be on " + locations[j].getQuestions().getTopic() + "." + "\n");
           for(int i=0; i<3; i++)
           {
               String answer=Game.inputString("Question " + (i+1) + ": " + locations[j].getQuestions().getQuestion(i));
               
               if(answer.toLowerCase().equals(locations[j].getQuestions().getAnswer(i)))
               {
                   correct=correct+1;
               }
           }          
          return correct;
    }
    
    /*The function below enables the player to have a battle with the NPC, where they have to try to guess an integer within a given range
    and if successfull they dodge the attack. The number of times the player is hit is returned.*/
    
    public int battle(Character player,Character y)
    {
        Game.guiMain.output.append("The only way to defeat " + y.getName() + " the guardian is to counter his attacks and wait for him to tire!"
        + "\n");
        Game.guiMain.output.append("Try to successfully guess the integer for the given range, if sucessfull you will counter " + y.getName() + "'s attacks."
        + "\n");
        Game.guiMain.output.append("Beware adventurer if you fail to evade an attack your health and strength will suffer." + "\n");
        
        NPC obj=(NPC) y;
        
        int hit=0;
        int answer=0;
        Random random= new Random();
        int upper=0;
        
        for(int i=1; i<=5; i++)
        {
            upper=random.nextInt(10000/i);
            int a=random.nextInt((upper-(upper-i))+1)+(upper-i); //This is inclusive of the upper.
            Game.guiMain.output.append("The actual number is (remove this after testing): " + a + "\n"); //Used for testing purposes.
            answer=Game.inputInt("Guess the integer between: " + (upper-i) + "-" + upper);
            
            if(answer==a)
            {
                Game.guiMain.output.append("Evaded!" + "\n");
            
            }
            else
            {
                Game.guiMain.output.append(y.getName() + " " + obj.getAttack(random.nextInt(3)) + "\n");
                hit=hit+1;
            }
        }
        
        return hit;
    }
    
    //Getters:
    
    public String getName()
    {
        return name;
    }
    
    public double getHealth()
    {
        return health;
    }
    
    public int getIQ()
    {
        return iQ;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    //Setters:
    
    public void setHealth(double value)
    {
        health=health+value;
    }
    
    public void setIQ(int value)
    {
        iQ=iQ+value;
    }
    
    public void setStrength(int value)
    {
        strength=strength+value;
    }
    
}
