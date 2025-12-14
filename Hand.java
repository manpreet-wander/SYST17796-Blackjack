/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.List;

/**
 *
 * @author kaura
 */


public class Hand extends GroupOfCards {

    public Hand() {
        super(11); // theoretical max cards in blackjack
    }

    public void add(Card c) {
        addCard(c);
    }

    public List<Card> getCardsInHand() {
        return getCards();
    }

   
    public int calculateTotal() {
        int total = 0;
        int aceCount = 0;
        for (Card c : getCardsInHand()) {
            if (c instanceof StandardCard) {
                StandardCard sc = (StandardCard) c;
                total += sc.getValue();
                if ("Ace".equals(sc.getRank())) aceCount++;
            } else {
                // if other Card types are used, skip or handle accordingly
            }
        }
        // reduce aces from 11 to 1 as needed
        while (total > 21 && aceCount > 0) {
            total -= 10; // convert an Ace from 11 to 1
            aceCount--;
        }
        return total;
    }

    public boolean isBust() {
        return calculateTotal() > 21;
    }

    public boolean isBlackjack() {
        return calculateTotal() == 21 && getCardsInHand().size() == 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : getCardsInHand()) {
            sb.append(c.toString()).append(", ");
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
