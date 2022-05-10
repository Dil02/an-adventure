//This class is used as a blueprint for question objects containing the question topic and questions along with their answers.
public class Question
{
    private String topic;
    private String [] questions= new String [3];
    private String [] answers= new String [3];
    
    //Class Constructor, which assigns values to both the questions and answers arrays.
    public Question(String topic,String question1, String answer1, String question2,
    String answer2, String question3, String answer3)
    {
        this.topic=topic;
        
        questions[0]=question1;
        questions[1]=question2;
        questions[2]=question3;
        
        answers[0]=answer1;
        answers[1]=answer2;
        answers[2]=answer3;
    }
    
    //Getters:
    
    public String getQuestion(int x)
    {
        return questions[x];
    }   
    
    public String getAnswer(int x)
    {
        return answers[x];
    }
    
    public String getTopic()
    {
        return topic;
    }
}
