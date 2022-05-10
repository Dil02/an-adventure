import java.util.Random;// Imports the random class. 
//The 'NPC' class is a unique blueprint for non-player characters including properties such as their current state and type of attacks.
public class NPC extends Character
{
    private String state;
    private String speciality;
    private String [] attacks= new String [3]; //Contains a selection of strings which describes the attack performed by the NPC.
    
    //Class Constructor, which intialises the instance variables with the provided arguments.
    public NPC(String attack1,String attack2, String attack3,String state, String speciality, String name, int iQ, 
    int strength)
    {
       super(name,iQ,strength);
       this.state=state;
       this.speciality=speciality;
       attacks[0]=attack1;
       attacks[1]=attack2;
       attacks[2]=attack3;
       
    }
    
    /*The function 'Quiz' overrides the method in the 'Character' superclass and instead checks if the NPC's speciality matches the question
    topic and if so,the method returns '3' symbolising the NPC answered all questions correctly. Otherwise, a random number is generated 
    from between 0-2 and returned.*/
    public int Quiz(Biome [] locations, int j, Character x)
    {
        Random random = new Random();
        int number=random.nextInt(3);
        NPC obj=(NPC) x;
        
        if(locations[j].getQuestions().getTopic().equals(obj.getSpeciality())) //Perhaps use the NPC's iQ to decide the quiz score as well.
        {
            return 3;
        }
        
        return number;
    }
    
    /*This function enables player interaction with an NPC and the player's iQ is adjusted as a reward for the interaction.*/
    public Player interact(Player player,Character x)
    {
        Game.guiMain.output.append("Hello " + player.getName() + "!" + "\n");
        Game.guiMain.output.append("You are speaking with " + getName() + "." + "\n");
        Game.guiMain.output.append("My master is " + x.getName() + "." + "\n");
        player.setIQ(2);
        
        return player;
    }
    
    //Setters:
    
    public void setState(String x)
    {
        state=x;
    }
    
    //Getters:
    
    public String getState()
    {
        return state;
    }
    
    public String getSpeciality()
    {
        return speciality;
    }
    
    public String getAttack(int i)
    {
        return attacks[i];
    }
}
