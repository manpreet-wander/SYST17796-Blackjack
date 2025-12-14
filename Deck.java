/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author kaura
 */


import java.util.ArrayList;
import java.util.List;


public class Deck extends GroupOfCards {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Deck() {
        super(52);
        buildDeck();
        shuffle();
    }

    private void buildDeck() {
        // clear any cards if present
        this.clear();
        // create the 52 cards
        for (String s : SUITS) {
            for (String r : RANKS) {
                int v;
                switch (r) {
                    case "Ace":
                        v = 11; // treat ace as 11 initially; Hand logic will reduce if needed
                        break;
                    case "King":
                    case "Queen":
                    case "Jack":
                        v = 10;
                        break;
                    default:
                        v = Integer.parseInt(r);
                        break;
                }
                this.addCard(new StandardCard(s, r, v));
            }
        }
    }

   
    public Card dealTopCard() {
        return removeTopCard();
    }

   
    public Card safeDeal() {
        if (currentSize() == 0) {
            buildDeck();
            shuffle();
        }
        return dealTopCard();
    }

    
    public List<Card> getAllCards() {
        return this.getCards();
    }
}
