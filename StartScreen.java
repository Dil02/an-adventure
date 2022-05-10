import java.awt.*; //Imports the Abstract Window Toolkit.
import java.awt.event.*;
public class StartScreen extends Frame implements ActionListener
{
    private Button a = new Button ("Play");
    private Button b = new Button ("View Leaderboard");
    private Button c = new Button ("Exit");
    private Button d = new Button ("Music Off");
    private Button f = new Button ("Continue");
    private Label label1 = new Label ("Welcome to An Adventure!");
    private String confirm="No";
    
    TextArea output= new TextArea(40,90); //Main output area.
    TextField userInput= new TextField("",40); // Allows user input.
    static Music musicObject = new Music();
    private GridBagConstraints gbc = new GridBagConstraints();
    
    //Below are the TextFields to display player information:
    TextField healthOutput= new TextField("Health:",13);
    TextField torchPiecesOutput= new TextField("Torch Pieces:",30);
    TextField iQOutput= new TextField("iQ:",12);
    TextField strengthOutput= new TextField("Strength: ",12);
    TextField scoreOutput= new TextField("Score:",13);
    TextField correctOutput = new TextField("Questions Answered Correctly:",30);
    
    // Constructor for GUI.
    public StartScreen()
    {
        super("An Adventure");
        setSize(1300,800);
        add(label1);
        add(a);
        add(b);
        add(c);
        add(d);
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        f.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(new Color(150,184,191));
        musicObject.playMusic("./Uncharted - Nate's Theme.wav");
    }
    
    /* This procedure is invoked when an action event is fired, what the method actually carries out is determined by which button is clicked 
    by the user.*/
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Play"))
        {            
           remove(label1);
           remove(a);
           remove(b);
           remove(c);
           remove(d);
           
           setLayout(new GridBagLayout());
        
           // "Exit" Button:
           gbc.gridx=0;
           gbc.gridy=4;
           add(c,gbc);
           
           // "Health" Readout:
           gbc.gridx=0;
           gbc.gridy=0; 
           healthOutput.setEditable(false);
           add(healthOutput,gbc);
           
           // "iQ" Readout:
           gbc.gridx=1;
           gbc.gridy=0; 
           iQOutput.setEditable(false);
           add(iQOutput,gbc);
           
           // "Score" Readout.
           gbc.gridx=0;
           gbc.gridy=1; 
           scoreOutput.setEditable(false);
           add(scoreOutput,gbc);
           
           // "Strength" Readout.
           gbc.gridx=1;
           gbc.gridy=1; 
           strengthOutput.setEditable(false);
           add(strengthOutput,gbc);
           
           // "torchPieces" Readout:
           gbc.gridx=5;
           gbc.gridy=0; 
           torchPiecesOutput.setEditable(false);
           add(torchPiecesOutput,gbc);
           
           // " Number of Correct Questions" Readout:
           gbc.gridx=5;
           gbc.gridy=1; 
           correctOutput.setEditable(false);
           add(correctOutput,gbc);
           
           // "Music" Button:
           gbc.gridx=5;
           gbc.gridy=4;
           add(d,gbc); 
           
           // "View Leaderboard" Button:
           gbc.gridx=5;
           gbc.gridy=5;
           add(b,gbc); 
           
           // Main Output Text Area:
           gbc.gridx=4;
           gbc.gridy=4;
           output.setEditable(false);
           add(output,gbc);

           // User Input Text Field:
           gbc.gridx=4;
           gbc.gridy=5;
           add(userInput,gbc); 
           
           // "Continue" Button:
           gbc.gridx=4;
           gbc.gridy=6;
           add(f,gbc); 
           
           setVisible(true);
           setBackground(new Color(216,204,210));
        }
        else if(e.getActionCommand().equals("View Leaderboard"))
        {
            Game.printLeaderboard();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Music On"))
        {
            d.setLabel("Music Off");
            musicObject.clip.start();
        }
        else if(e.getActionCommand().equals("Continue"))
        {
            confirm="Yes";
        }
        else
        {
            d.setLabel("Music On");
            musicObject.pauseMusic();
        }
    }
    
    //This function returns a String value entered by the user in the TextField only once they have clicked the "Continue" button.
    public String inputText()
    {
        if(confirm.equals("Yes"))
        {
            confirm="No";
            String text=userInput.getText();
            userInput.setText("");
            return text;
        }
        else
        {
            confirm="No";
            return "";
        }
    }
    
}
