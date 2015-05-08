package gr.teicm.pm.jzork.core;

import gr.teicm.pm.jzork.entities.Player;
import gr.teicm.pm.jzork.interfaces.ICommand;

/**
 *
 * @author Walkin
 */
public abstract class Command implements ICommand{

    
    private String secondWord;
    private String thirdWord;
    public Player player;
    
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
    
    @Override
    public abstract String execute(Player player);
}
