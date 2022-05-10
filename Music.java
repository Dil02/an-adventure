import java.io.File; //Imports the File class.
import javax.sound.sampled.AudioInputStream; //Imports the Java sound class, which provides interfaces for the playback of sound files.
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Music
{
    Clip clip;
    
    public void playMusic(String path)
    {
        try
        {
          File musicPath = new File(path); 
          
          if(musicPath.exists())
          {
              AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
              clip = AudioSystem.getClip();
              clip.open(audioInput);
              clip.start();
              clip.loop(Clip.LOOP_CONTINUOUSLY); // The sound file continues to play unless it is interrupted.
          }
          else
          {
              Game.guiMain.output.append("Cannot locate file" + "\n");
          }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    // This function enables the user to pause the music.
    public void pauseMusic()
    {
        long clipTimePosition =clip.getMicrosecondPosition(); // Gets the current timestamp of the music file being played.
        clip.stop(); //Stops playback.
        clip.setMicrosecondPosition(clipTimePosition); //Ensures the clip object retains the current timestamp, enabling play/pause.
    }
}
