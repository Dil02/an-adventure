import java.awt.*; //Imports the Abstract Window Toolkit.
import java.awt.event.*;
public class Leaderboard extends Frame implements ActionListener
{
    TextArea temp;
    private GridBagConstraints gbc = new GridBagConstraints();
    
    // Leaderboard GUI Constructor
    public Leaderboard()
    {
        super("Player Leaderboard");
        setSize(1300,800);
        setLayout(new GridBagLayout());
        
        Button a = new Button ("Return");
        gbc.gridx=0;
        gbc.gridy=2;
        add(a,gbc);
        a.addActionListener(this);
        
        temp= new TextArea(40,100);
        gbc.gridx=2;
        gbc.gridy=2;
        add(temp,gbc);
        
        temp.setEditable(false);
        setVisible(true);
        setBackground(new Color(216,204,194));
    }
    
    // This procedure is invoked when the user presses the "Return" button which closes the Leaderboard GUI.
    public void actionPerformed(ActionEvent e)
    {
        this.dispose();
    } 
    
}