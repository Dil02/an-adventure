// This class defines an Exception where the user input is an invalid length.
class StringLength extends Exception
{
    public StringLength()
    {
        super("ERROR: Your input does not meet the criteria.");
    }
}
