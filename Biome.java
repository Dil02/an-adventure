//This class is used to create the biomes which are the different areas the player is transported to. It contains NPCs and collectibles.
public class Biome
{
    private String name;
    private Character NPC_1; //Note: There is a maximum of two NPC's the player can interact with excluding the guardian.
    private Character NPC_2; //Note: There is a maximum of two NPC's the player can interact with excluding the guardian.
    private Character guardian;
    private Collectible collectible_1;
    private Collectible collectible_2;
    private Collectible piece;
    private Question questions;
    
    
    //Class Constructor, used to initalise the biome with NPCs, collectibles and a question object.
    public Biome(String name, Character NPC_1, Character NPC_2, Character guardian, Collectible collectible_1, Collectible collectible_2,
    Collectible piece,Question questions)
    {
        this.name=name;
        this.NPC_1=NPC_1;
        this.NPC_2=NPC_2;
        this.guardian=guardian;
        this.collectible_1=collectible_1;
        this.collectible_2=collectible_2;
        this.piece=piece;
        this.questions=questions;
    }
        
    //Getters:
    
    public String getBiomeName()
    {
        return name;
    }
    
    public Character getNPC_1()
    {
        return NPC_1;
    }
    
    public Character getNPC_2()
    {
        return NPC_2;
    }
    
    public Character getGuardian()
    {
        return guardian;
    }
    
    public Question getQuestions()
    {
        return questions;
    }
    
    public Collectible getCollectible_1()
    {
        return collectible_1;
    }
    
    public Collectible getCollectible_2()
    {
        return collectible_2;
    }
    
    public Collectible getPiece()
    {
        return piece;
    }
}
