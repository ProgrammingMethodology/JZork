package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.entities.Player;

/**
 *
 * @author Walkin
 */
public abstract class Command {

    private String secondWord;
    private String thirdWord;
    
    public Command() {
        secondWord = null;
        thirdWord = null;
    }

    public String getSecondWord() {
        return secondWord;
    }
    
    public String getThirdWord() {
        return thirdWord;
    }

    public boolean hasSecondWord() {
        return secondWord != null;
    }
    
    public boolean hasThirdWord() {
        return thirdWord != null;
    }
    
    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public void setThirdWord(String thirdWord) {
        this.thirdWord = thirdWord;
    }
    
    public abstract boolean execute(Player player);
}
