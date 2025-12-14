
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GroupOfCards {
    private ArrayList<Card> cards;
    private int size; 

    public GroupOfCards() {
        this.cards = new ArrayList<>();
        this.size = 0;
    }

    public GroupOfCards(int size) {
        this();
        this.size = size;
    }

   
    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void addCard(Card c) {
        if (c != null) {
            this.cards.add(c);
        }
    }

    
    public Card removeCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.remove(index);
        }
        return null;
    }

    
    public Card removeTopCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

   
    public void shuffle() {
        Collections.shuffle(cards);
    }

    
    public ArrayList<Card> clear() {
        ArrayList<Card> copy = new ArrayList<>(cards);
        cards.clear();
        return copy;
    }

   
    public int currentSize() {
        return cards.size();
    }

    
    public int getSize() {
        return size;
    }

    
    public void setSize(int size) {
        this.size = size;
    }
}
