/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
/**
 *
 * @author kaura
 */


/**
 * Blackjack player implementation for console play.
 */
public class BlackjackPlayer extends Player {
    private Hand hand;

    public BlackjackPlayer(String name) {
        super(name);
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
        System.out.println(getName() + "'s turn. Current hand: " + hand + " (Total: " + hand.calculateTotal() + ")");
    }

    @Override
    public void declareWinner() {
        System.out.println(getName() + " wins!");
    }

    
    public boolean wantsToHit() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Hit or Stand? (h/s): ");
            String line = sc.nextLine().trim().toLowerCase();
            if (line.isEmpty()) continue;
            char c = line.charAt(0);
            if (c == 'h') return true;
            if (c == 's') return false;
            System.out.println("Please enter 'h' for hit or 's' for stand.");
        }
    }



}
