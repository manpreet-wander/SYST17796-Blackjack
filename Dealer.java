/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author kaura
 */

public class Dealer extends Player {
    private Hand hand;

    public Dealer() {
        super("Dealer");
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void receiveCard(Card c) {
        hand.add(c);
    }

    @Override
    public void play() {
        System.out.println("Dealer's turn. Current hand: " + hand + " (Total: " + hand.calculateTotal() + ")");
    }

    @Override
    public void declareWinner() {
        System.out.println("Dealer wins!");
    }

   
    public boolean wantsToHit() {
        return hand.calculateTotal() < 17;
    }
}
