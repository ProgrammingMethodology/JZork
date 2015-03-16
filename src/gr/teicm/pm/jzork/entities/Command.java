
package gr.teicm.pm.jzork.entities;

/**
 *
 * @author Walkin
 */
public abstract class Command {
    private String secondWord;
    
    public Command(){
        secondWord = null;
    }

public String getSecondWord()
{
    return secondWord;
}

public boolean hasSecondWord()
{
        return secondWord !=null;
}

public void setSecondWord(String secondWord)
{
        this.secondWord = secondWord;
}

}