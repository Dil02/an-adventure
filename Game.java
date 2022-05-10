import java.util.Random; //Imports the random class.
import java.util.Scanner; //Imports the scanner class.
import java.io.*; //Imports the I/O class.
import java.util.ArrayList; // Import the ArrayList class.
import java.awt.*; // Imports the Abstract Window Toolkit.
import java.awt.event.*;
//The 'Game' class contains all the additional methods required for the program to run.
public class Game
{
   static StartScreen guiMain;
    /* The main method below is where the game runs, this includes creating a player, enabling transition between biomes and also 
   interacting with non-player characters.*/
   
    public static void main(String [] args) throws IOException
   {
       guiMain= new StartScreen();
       Random random = new Random();
       printWelcome();
       Player player= new Player(enterName("Enter your name."),100,50);
       guiMain.output.append("............................." + "\n");
       guiMain.output.append(player.getName() + ", you must remain aware of your iQ, health and strength." + "\n");
       guiMain.output.append("Keep your iQ above 70 and your health and strength above 0." + "\n");
       guiMain.output.append("Lastly, good luck!" + "\n");
       guiMain.output.append("............................." + "\n");
       printPlayerStats(player);
       String [] biome_Names= {"Desert","Forest","Grasslands","Tundra","Marine"};
       
       Biome [] locations = new Biome [5];
       for(int i=0; i<locations.length; i++)
       {
           locations[i]=createBiome(biome_Names[i]);
       }
       
       int j=0;
       //The player is only able to continue to other biomes if their health, strength and iQ meets certain thresholds.
       while((j<locations.length) && (player.getHealth() > 0) && (player.getIQ() > 60) && (player.getStrength() >0))
       {
       guiMain.output.append("\n");
       guiMain.output.append("............................." + "\n");
       guiMain.output.append("Welcome to Level " + (j+1) + "- You are located in the " + locations[j].getBiomeName() + "." + "\n");
       printBiomeDescription(locations[j].getBiomeName());
       guiMain.output.append("............................." + "\n");
       String opponent_Name="";
       String opponent_Type="";
       
       if(locations[j].getGuardian() instanceof Wizard)
       {
           opponent_Type="wizard";
       }
       else if(locations[j].getGuardian() instanceof Archer)
       {
           opponent_Type="archer";
       }       
       else
       {
           opponent_Type="ninja";
       } 
       
       opponent_Name=locations[j].getGuardian().getName();
       guiMain.output.append("The guardian is " + opponent_Name + " a " + opponent_Type + "!" + "\n");
       NPC tempGuardian= (NPC) locations[j].getGuardian();
       guiMain.output.append(opponent_Name + "'s speciality is " + tempGuardian.getSpeciality() + "." + "\n");
       guiMain.output.append(opponent_Name + "'s iQ is " + locations[j].getGuardian().getIQ() + "." + "\n");
     
       guiMain.output.append("These are the items currently in the biome:" + "\n");
       guiMain.output.append("Item A: " + locations[j].getCollectible_1().getType() + "\n");
       guiMain.output.append("Item B: " + locations[j].getCollectible_2().getType() + "\n");
       String option=inputString("Choose one item you would like to pick up.");
       
       while((!option.equals("A")) && (!option.equals("B")) && (!option.equals("a")) && (!option.equals("b")))
       {
           option=inputString("Sorry that item is not available.");
       }
       if((option.equals("A")) || (option.equals("a")))
       {
           if(locations[j].getCollectible_1() instanceof Potion)
           {
               player.setHealth((int)Math.round(locations[j].getCollectible_1().getValue()));
           }
           else
           {
               player.getCollectible().add(locations[j].getCollectible_1());
               player.setScore(locations[j].getCollectible_1().getValue());
               //^Artefact is added to the player's inventory.
           } 
           guiMain.output.append(locations[j].getCollectible_1().getDescription(player) + "\n"); //Late dynamic binding.
       }
       else
       {
           if(locations[j].getCollectible_2() instanceof Potion)
           {
               player.setHealth((int)Math.round(locations[j].getCollectible_2().getValue()));
           }
           else
           {
               player.getCollectible().add(locations[j].getCollectible_2());
               player.setScore(locations[j].getCollectible_2().getValue());
               //^Artefact is added to the player's inventory.
           }
           guiMain.output.append(locations[j].getCollectible_2().getDescription(player) + "\n"); //Late dynamic binding.
       }
       printPlayerStats(player);
       //Introduce the NPC's to the room based on whether they are null or not.
       if((locations[j].getNPC_1() !=null) && (locations[j].getNPC_2() !=null))
       {
           option=inputString("There is someone hiding behind the door would you like to talk them? (Y/N)");
           while((!option.equals("Y")) && (!option.equals("y")) && (!option.equals("N")) && (!option.equals("n")))
           {
               option=inputString("Ooops! Looks like you chose an option that is not available. Please try again.");
           }
           if((option.equals("Y")) || (option.equals("y")))
           {
               NPC tempNPC1=(NPC) locations[j].getNPC_1();
               player=tempNPC1.interact(player,locations[j].getGuardian()); //Late dynamic binding.
           }
           printPlayerStats(player);
           option=inputString("Listen...! There is a banging noise coming from a trapdoor. Would you like to investigate? (Y/N)");
           while((!option.equals("Y")) && (!option.equals("y")) && (!option.equals("N")) && (!option.equals("n")))
           {
               option=inputString("Ooops! Looks like you chose an option that is not available. Please try again.");
           }
           if((option.equals("Y")) || (option.equals("y")))
           {
               NPC tempNPC2=(NPC) locations[j].getNPC_2();
               player=tempNPC2.interact(player,locations[j].getGuardian()); //Late dynamic binding.
           }
       }
       else if(locations[j].getNPC_1() !=null)
       {
           option=inputString("Would you like to take that ladder thats seems to go down forever? (Y/N)");
           while((!option.equals("Y")) && (!option.equals("y")) && (!option.equals("N")) && (!option.equals("n")))
           {
               option=inputString("Ooops! Looks like you chose an option that is not available. Please try again.");
           }
           if((option.equals("Y")) || (option.equals("y")))
           {
               NPC tempNPC1=(NPC) locations[j].getNPC_1();
               player=tempNPC1.interact(player,locations[j].getGuardian()); //Late dynamic binding.
           }
       }
       else if(locations[j].getNPC_2() !=null)
       {
           option=inputString("'"+ player.getName() + "!' " + "It looks like someone is calling you, shall we find out who? (Y/N)");
           while((!option.equals("Y")) && (!option.equals("y")) && (!option.equals("N")) && (!option.equals("n")))
           {
               option=inputString("Ooops! Looks like you chose an option that is not available. Please try again.");
           }
           if((option.equals("Y")) || (option.equals("y")))
           {
               NPC tempNPC2=(NPC) locations[j].getNPC_2();
               player=tempNPC2.interact(player,locations[j].getGuardian()); //Late dynamic binding.
           }
       }
       
       printPlayerStats(player); 
       guiMain.output.append("Time to decide, will you fight or test your knowledge?" + "\n");
       String answer=inputString("Enter 'F' to fight or 'Q' to prove your intellect.");
       
       while((!answer.equals("Q")) && (!answer.equals("q")) && (!answer.equals("F")) && (!answer.equals("f")))
       {
          answer=inputString("Ooops! Looks like you chose an option that is not available. Please try again.");
       }
       
       if((answer.equals("Q")) || (answer.equals("q")))
       {
           player=performQuiz(player,locations,j,opponent_Name,opponent_Type); 
       }
       else
       {  
           player=performBattle(player,locations,j);
       }
       printPlayerStats(player);
       j=j+1;
    }
    
       guiMain.output.append("\n");
       int pieces=0;
       for(int i=0; i<player.getCollectible().size(); i++)
       {
           if(player.getCollectible().get(i) instanceof Piece)
           {
               pieces=pieces+1;
           }
       }
       if(pieces == 5)
       {
           guiMain.output.append("Congratulations Adventurer!" + "\n");
           guiMain.output.append("You have successfully collected all the pieces." + "\n");
       }
       else if(player.getHealth() <=0)
       {
           guiMain.output.append("Better luck next time " + player.getName() + " you were a valiant explorer, but you died a terrible death!" + "\n"); 
       }
       else if(player.getStrength() <=0)
       {
           guiMain.output.append("For even the smartest of minds require strength, you have failed." + "\n");
       }
       else if(player.getIQ() <70)
       {
           guiMain.output.append("Oh no! It seems your intelligence has taken a deep decline since you started. But hey, you can always try again!" 
           + "\n");
       }
       else
       {
          guiMain.output.append("Unfortunately you were unsuccessful whilst trying to recover all the pieces. Better luck next time!" + "\n");
       }
       setLeaderboard(player,pieces);
       printPlayerStats(player);
       guiMain.output.append("Your final score is " + player.getScore() + "." + "\n");
       guiMain.output.append("............................." + "\n");
       for(int i=0; i<player.getCollectible().size(); i++)
       {
           if(i==0)
           {
               guiMain.output.append("Here is a summary of the artefacts you have recovered." + "\n");
           }
           guiMain.output.append("Item " + (i+1) + ": " + player.getCollectible().get(i).getDescription(player) + "\n");
       }
       guiMain.output.append("............................." + "\n");
       guiMain.output.append("Thank you for playing, Goodbye!" + "\n");
       guiMain.output.append("You can view your position on the leaderboard ---->"+"\n");
    }
   
   /*This method is used when the player chooses to engage in a quiz, which consists of three questions. It also adjusts the player's iQ
   depending on how many questions are answered correctly.*/
   public static Player performQuiz(Player player,Biome [] locations, int j,String opponent_Name,String opponent_Type)
   {
       int player_score=player.Quiz(locations,j,player);
          for(int k=1; k<=player_score; k++)
          {
              player.setCorrect();
          }
               
          player.setIQ(5*player_score); //For every question answered correctly, the player's IQ increases by 5.
          player.setIQ((3-player_score)*-10); 
          
          int opponent_score=0;
          
          opponent_score=locations[j].getGuardian().Quiz(locations,j,locations[j].getGuardian());
           
           guiMain.output.append(player.getName() + " you answered " + player_score + " questions correctly." + "\n");
           guiMain.output.append("Your opponent answered " + opponent_score + " questions correctly." + "\n");
           
           if(player_score > opponent_score)
           {
               guiMain.output.append("Congrats!, you have proven your worth against " + opponent_Name + " the " + opponent_Type + "." + "\n");
               player.setScore(10);
               Piece tempPiece = (Piece) locations[j].getPiece();
               tempPiece.setLocation(locations[j].getBiomeName());
               player.getCollectible().add(tempPiece);
               guiMain.output.append("You have been rewarded with a torch piece." + "\n");
               locations[j].getGuardian().setHealth(-1*locations[j].getGuardian().getHealth()); //Sets the guardian's health to 0.
               locations[j].getGuardian().setIQ(-1*locations[j].getGuardian().getIQ()); // Sets the guardian's IQ to 0.
               NPC tempGuardian = (NPC) locations[j].getGuardian();
               tempGuardian.setState("Defeated");
               guiMain.output.append("The guardian's iQ is now: " + locations[j].getGuardian().getIQ() + "\n");
               guiMain.output.append("The guardian's health is now: " + locations[j].getGuardian().getHealth() + "\n");
           }
           else if(player_score == opponent_score)
           {
               guiMain.output.append("It is a stalemate!" + "\n");
               guiMain.output.append("You must now fight to prove you are worthy!" + "\n");
               player.setScore(5);
               locations[j].getGuardian().setIQ(locations[j].getGuardian().getIQ()/-2); // Reduces the guardian's IQ by half.
               guiMain.output.append("The guardian's iQ is now: " + locations[j].getGuardian().getIQ() + "\n");
               player=performBattle(player,locations,j);                  
           }    
           else
           {
               guiMain.output.append("You have failed!" + "\n");
               player.setHealth(-5);
               locations[j].getGuardian().setIQ(15); // Increases the guardian's IQ by 15.
               guiMain.output.append("Your iQ is now " + player.getIQ() + "." + "\n");
               guiMain.output.append("The guardian's iQ is now: " + locations[j].getGuardian().getIQ() + "\n");
           }
           
           return player;
       }
   
   /* This method enables the user to battle against the guardian if they choose to do so. Which involves dodging the guardian's attacks.
   The player's health, iQ and strength is adjusted.*/
   public static Player performBattle(Player player,Biome [] locations, int j)
   {
          int damage=0; 
          damage=player.battle(player,locations[j].getGuardian());
          
          if(damage !=0)
          {
              player.setIQ(-10);
          }
          if(damage <=3)
          {
              guiMain.output.append("Well done " + player.getName() + " you have successfully defeated the guardian." + "\n");
              player.setScore(10);
              guiMain.output.append("You have been rewarded with a torch piece." + "\n");
              Piece tempPiece2 = (Piece) locations[j].getPiece();
              tempPiece2.setLocation(locations[j].getBiomeName());
              player.getCollectible().add(tempPiece2);
              locations[j].getGuardian().setHealth(-1*locations[j].getGuardian().getHealth()); //Sets the guardian's health to 0.
              locations[j].getGuardian().setIQ(-1*locations[j].getGuardian().getIQ()); // Sets the guardian's IQ to 0.
              locations[j].getGuardian().setStrength(-1*locations[j].getGuardian().getStrength()); //Sets the guardian's health to 0.
              NPC tempGuardian = (NPC) locations[j].getGuardian();
              tempGuardian.setState("Defeated");
          }
          else
          {
              guiMain.output.append("Oh no!" + " you have lost the battle you were hit " + (damage/5) + " times." + "\n");
              locations[j].getGuardian().setStrength(-10);
          }
          
          player.setStrength(-1*damage);
          player.setHealth(-1.0*((int)Math.round(damage)));
          
          return player;
   }
   
   /*This method is used to create 'Biomes' which consists of collectibles, NPCs and a guardian.*/
   public static Biome createBiome(String name)
   {
       Random random = new Random();
       int number=random.nextInt(10);
       if(number >6)
       {
          return new Biome(name,null,null,createNPC(),createCollectible(),createCollectible(),createPiece(),createQuestions()); 
       }
       else if((number <6) && (number >=3))
       {
          return new Biome(name,createNPC(),null,createNPC(),createCollectible(),createCollectible(),createPiece(),createQuestions()); 
       }
       else
       {
          return new Biome(name,createNPC(),createNPC(),createNPC(),createCollectible(),createCollectible(),createPiece(),createQuestions()); 
       }
   }
   
   //This method returns an object of the superclass type Collectible but the instance type is choosen at random.
   public static Collectible createCollectible()
   {
       Random random = new Random();
       int number=random.nextInt(11);
       
       if(number >5)
       {
           return createPotion();
       }
       else
       {
           return createArtefact();
       }
   }
   
   /*This method is used to create a potion object, its properties are created randomly and can either reduce or increase the player's health.*/
   public static Collectible createPotion()
   {
       Random random = new Random();
       int number=random.nextInt((10 - -10) + 0) + -10;
       if(number >=0)
       {
           Collectible potion = new Potion("Health Increase","Potion",number);
           return potion;
       }
       else
       {
           Collectible potion = new Potion("Health Decrease","Potion",number);
           return potion;
       }

   }
   
   /*This method is used to create an artefact object, the name is chosen at random and so is its numerical value.*/
   public static Collectible createArtefact()
   {
      String [] possible_items={"Journal","Silver Llama","Golden Turtle","Sliver Brooch",
      "Bronze Coin","Ottoman Ring", "Antique Pocket Watch","Yuan Dynasty Urn","Cham Lion Mask"};
      Random random = new Random();
      int number=random.nextInt(9);           
      int weight=random.nextInt(10 + 1) + 1;
      
      Collectible artefact = new Artefact(possible_items[number],weight,"Artefact",number);
      return artefact;
   }
   
   //This function return an object of the superclass type Collectible but also an instance of the Piece class.
   public static Collectible createPiece()
   {
       Collectible piece = new Piece("","Torch Piece",10); //Substitution Principle
       return piece;
   }
   
   //This function returns an object of the superclass type NPC but the instance type is chosen at random.
   public static NPC createNPC()
   {
       Random random = new Random();
       int number=random.nextInt(11);
       
       if(number >6)
       {
           return createWizard();
       }
       else if((number <6) && (number >3))
       {
           return createArcher();
       }
       else
       {
           return createNinja();
       }
   }
   
   //This function returns an object of the type NPC but also an instance of the Wizard class.
   public static NPC createWizard()
   {
       Random random = new Random();
       String [] names={"Merlin","Gandalf","Harry","Dumbledore","Yoda"};
       
       NPC wizard = new Wizard("Undefeated","Geography",names[random.nextInt(5)],120,40);  //Substitution Principle
       return wizard;
   }
   
   //This function returns an object of the type NPC but also an instance of the Archer class.
   public static NPC createArcher()
   {
       Random random = new Random();
       String [] names={"Oliver","Robin","Clint","Odysseus","Hou Yi"};
       
       NPC archer = new Archer("Undefeated","Science",names[random.nextInt(5)],85,60); //Substitution Principle
       return archer;
   }
   
   //This function returns an object of the type NPC but also an instance of the Ninja class.
   public static NPC createNinja()
   {
       Random random = new Random();
       String [] names={"Snake Eyes","Storm Shadow","the unknown"};
       
       NPC ninja = new Ninja("Undefeated","Unknown",names[random.nextInt(3)],90,80); //Substitution Principle
       return ninja;
   }
   
   //This procedure prints out the properties of the player.
   public static void printPlayerStats(Player player)
   {
       guiMain.healthOutput.setText("Health: " + player.getHealth());
       guiMain.strengthOutput.setText("Strength: " + player.getStrength());
       guiMain.iQOutput.setText("iQ: " + player.getIQ());
       guiMain.scoreOutput.setText("Score: " + player.getScore());
       guiMain.correctOutput.setText("Questions Answered Correctly: " + player.getCorrect());
       int pieces=0;
       for(int i=0; i<player.getCollectible().size(); i++)
       {
           if(player.getCollectible().get(i) instanceof Piece)
           {
               pieces=pieces+1;
           }
       }
       guiMain.torchPiecesOutput.setText("Torch Pieces: " + pieces);
   }
   
   //This function returns an instance of the Question class, in which the questions and answers are chosen randomly.
   public static Question createQuestions()
   {
       Random random= new Random();
       int number=random.nextInt(20);
       if(number>=16)
       {
           String question1="What common English verb becomes its own past tence by rearranging its letters?";
           String answer1="eat";
           String question2="It occurs once in a minute, twice in a moment, but never in an hour.";
           String answer2="m";
           String question3="What can travel around the world while staying in a corner?";
           String answer3="stamp";
           return new Question("General Knowledge",question1,answer1,question2,answer2,question3,answer3);
       }
       
       else if((number >=12) && (number <16))
       {
           String question1="Ohms measure what?";
           String answer1="resistance";
           String question2="What is the hardest natural substanace in the world?";
           String answer2="diamond";
           String question3="Metals expand when heated and do what when cooled?";
           String answer3="contract";
           return new Question("Science",question1,answer1,question2,answer2,question3,answer3);
       }
       
       else if((number >=8) && (number <12))
       {
           String question1="Who is that with a neck and no head, two arms and no hands?  What is it?";
           String answer1="shirt";
           String question2="What English word retains the same pronunciation, even after you take away four of its five letters?";
           String answer2="queue";
           String question3="What is it that given one, you'll have either two or none?";
           String answer3="choice";
           return new Question("Unknown",question1,answer1,question2,answer2,question3,answer3);
       }
       
       else if((number >=4) && (number <8))
       {
           String question1="In 1666 there was a big fire which destroyed much of which English city?";
           String answer1="london";
           String question2="In which year did World War 2 begin?";
           String answer2="1939";
           String question3="Give the door number of a famous fictional detective living in london.";
           String answer3="221b";
           return new Question("History",question1,answer1,question2,answer2,question3,answer3);        
       }
       
       else
       {
           String question1="Which is the most sparsely populated country in the world?";
           String answer1="namibia";
           String question2="On which continent is the largest desert in the world?";
           String answer2="africa";
           String question3="Which is the world's largest country?";
           String answer3="russia";
           return new Question("Geography",question1,answer1,question2,answer2,question3,answer3);           
       }
   }
   
   //The procedure below prints out the biome description based on the location argument.
   public static void printBiomeDescription(String location)
   {
       if(location.equals("Tundra"))
       {
           guiMain.output.append("The climate is chilly and it is snowing!" + "\n");  
       }
       else if(location.equals("Desert"))
       {
           guiMain.output.append("It is humid and you are feeling tired." + "\n");
       }
       else if(location.equals("Forest"))
       {
           guiMain.output.append("The trees are tall along with fog." + "\n");
       }
       else if(location.equals("Marine"))
       {
           guiMain.output.append("The sea spreads out far with nothing but silence." + "\n");
       }
       else
       {
           guiMain.output.append("The ground is muddy and you are feeling energetic." + "\n");
       }
   }
   
   //This procedure prints out a welcome message for the player.
   public static void printWelcome()
   {
       guiMain.output.append("Hello Adventurer!" + "\n");
       guiMain.output.append("Your task is to travel the world seeking..." + "\n");
       guiMain.output.append("The pieces of a mystical torch with the hope of..." + "\n"); 
       guiMain.output.append("Assembling them together to reveal the location of a great treasure!" + "\n");
       guiMain.output.append("\n");
   }
   
   //This procedure writes the current player's stats to a csv file, the information is sorted beforehand.
   public static void setLeaderboard(Player player, int pieces) throws IOException
   {
       BufferedReader inputStream = new BufferedReader(new FileReader("Leaderboard.csv"));
       ArrayList<String> names = new ArrayList<String>(); //Creates an ArrayList.
       ArrayList<String> properties = new ArrayList<String>(); //Creates an ArrayList.
       String s=inputStream.readLine();
       while(s !=null)
       {
         names.add(s);
         properties.add(inputStream.readLine());
         s=inputStream.readLine();
       }
       
       inputStream.close();
       names.add(player.getName());
       properties.add(pieces + "," + player.getHealth() + "," + player.getIQ() + "," + player.getStrength() + "," + player.getScore());
       
       for(int i=0; i<names.size(); i++)// Sorts the Leaderboard based on the score of each player, highest to lowest.
       {
           for(int k=1; k<(names.size()-i); k++)
           {
             String [] temp1=properties.get(k-1).split(",");
             String [] temp2=properties.get(k).split(",");
             int valueA=Integer.parseInt(temp1[4]);
             int valueB=Integer.parseInt(temp2[4]);
             
             if(valueB > valueA)
             {
                String temp3=properties.get(k-1);
                String temp4=names.get(k-1);
                properties.set(k-1,properties.get(k));
                names.set(k-1,names.get(k));
                properties.set(k,temp3);
                names.set(k,temp4);
             }
           }
       }
       
       PrintWriter outputStream = new PrintWriter(new FileWriter("Leaderboard.csv")); //Writes Player information to .csv file.
       for(int j=0; j<names.size(); j++)
       {
           outputStream.println(names.get(j));
           outputStream.println(properties.get(j));
       }
    
       outputStream.close();
   }
   
   // This procedure outputs the information from the .csv file to a TextArea in the Leaderboard GUI.
   public static String printLeaderboard()
   {
       try
       {
          Leaderboard guiLeaderboard = new Leaderboard();
          BufferedReader inputStream = new BufferedReader(new FileReader("Leaderboard.csv"));
          String s= inputStream.readLine();
          int position=0;
          guiLeaderboard.temp.append("Players Are Ranked By Score" + "\n");
          guiLeaderboard.temp.append("\n");
           while(s !=null)
           {
               position++;
               guiLeaderboard.temp.append(position + ":" + "\n");
               guiLeaderboard.temp.append("\n");
               guiLeaderboard.temp.append("Name: " + s + "\n");
               
               s=inputStream.readLine();
               String [] properties=s.split(",");
               
               guiLeaderboard.temp.append("Torch Pieces : " + properties[0] + "\n");
               guiLeaderboard.temp.append("Health : " + properties[1] + "\n");               
               guiLeaderboard.temp.append("iQ : " + properties[2] + "\n");               
               guiLeaderboard.temp.append("Strength : " + properties[3] + "\n");               
               guiLeaderboard.temp.append("Score : " + properties[4] + "\n");
               guiLeaderboard.temp.append("*****************************" + "\n");
               guiLeaderboard.temp.append("\n");
               s=inputStream.readLine();
           }
       
           inputStream.close();
           return "" + "\n";
       }
       catch(IOException e)
       {
           return "An error has occured" + "\n";
       }

   }
   
   //This function allows the user to enter their Name, which must contain at least 3 characters with a maximum of 10 characters.
   public static String enterName(String message)
   {
       String name="";
       for(;;)try
       {
           name=inputString(message);
           if((name.length() <3) || (name.length() >10))
           {
               throw new StringLength(); // If the user enters a String which does not meet the criteria an exception is thrown.
           }
           break;
       }
       catch(StringLength e)
       {
           guiMain.output.append("The name '" + name + "' is not suitable." + " A player's name must have between 3-10 characters." + "\n");
       }
      
       return name;
   }
    
   //This function allows the user to enter a String value.
   public static String inputString(String message)
   {
       Scanner scanner = new Scanner(System.in);
       guiMain.output.append(message + "\n");
       String text_input="";

       for(;;)try
       {
          text_input=guiMain.inputText();
          if(text_input.equals(""))
          {
              throw new BlankInput();
          }
          break;
       }
       catch(BlankInput e)
       {
          
       }
       
       return text_input;
   }
   
   //This function allows the user to enter an integer value.
   public static int inputInt(String message)
   {
       String x="";
       int value=0;
       // The user is prompted to enter an appropriate String value and if an exception is thrown they are asked again.
       for(;;) try
       {
           x=inputString(message);
           value=Integer.parseInt(x); //Here is where the possibility of an NumberFormatException being thrown.
           break; // Only if the String value has been successful parsed can the loop be exited.
       }
       catch(NumberFormatException e) //NumberFormatException is the exception thrown if the entered String cannot be parsed into an Integer.
       {
           guiMain.output.append("Sorry you entered '" + x + "' which is not an integer. Please try again." + "\n");
       }
       
       return value;
   }
}
