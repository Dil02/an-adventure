// This class defines an Exception where the user input is blank.
class BlankInput extends Exception
{
    public BlankInput()
    {
        super("ERROR: You have not entered anything.");
    }
}
