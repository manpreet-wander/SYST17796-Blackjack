
package ca.sheridancollege.project;

import java.util.ArrayList;


public abstract class Game {

    private String name;
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
        name = "Game";
    }

    public Game(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players != null ? players : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    
    public abstract void play();

    
    public abstract void declareWinner();
}
