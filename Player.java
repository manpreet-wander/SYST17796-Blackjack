
package ca.sheridancollege.project;


public abstract class Player {

    private String name; // the unique name for this player

    public Player() {
        this.name = "Player";
    }

    public Player(String name) {
        this.name = name;
    }

  
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    
    public abstract void play();

    
    public abstract void declareWinner();
}
