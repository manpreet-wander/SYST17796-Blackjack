/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;



public class BlackjackGame extends Game {

    private Deck deck;
    private BlackjackPlayer player;
    private Dealer dealer;
    private Scanner scanner = new Scanner(System.in);

    public BlackjackGame() {
        super("Blackjack", new ArrayList<Player>());
    }

    @Override
    public void play() {
        System.out.println("=== Welcome to Blackjack ===");
        // create deck and players
        deck = new Deck();
        System.out.print("Enter player name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Player";
        player = new BlackjackPlayer(name);
        dealer = new Dealer();

        // add players to Game list
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        setPlayers(players);

        boolean playAgain = true;
        while (playAgain) {
            playRound();
            System.out.print("\nPlay again? (y/n): ");
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.isEmpty() || ans.charAt(0) != 'y') playAgain = false;
            else {
                // reset hands and (optionally) reshuffle deck
                player = new BlackjackPlayer(player.getName());
                dealer = new Dealer();
                // if deck low, rebuild
                if (deck.currentSize() < 10) {
                    deck = new Deck();
                }
            }
        }
        declareWinner();
    }

    private void playRound() {
        // initial dealing
        player.receiveCard(deck.safeDeal());
        dealer.receiveCard(deck.safeDeal());
        player.receiveCard(deck.safeDeal());
        dealer.receiveCard(deck.safeDeal());

        System.out.println("\nDealer shows: " + dealer.getHand().getCardsInHand().get(0).toString() + " and [hidden]");
        System.out.println(player.getName() + "'s hand: " + player.getHand().toString() + " (Total: " + player.getHand().calculateTotal() + ")");

        // Check immediate blackjack
        if (player.getHand().isBlackjack()) {
            System.out.println("Blackjack! " + player.getName() + " has 21.");
            if (dealer.getHand().isBlackjack()) {
                System.out.println("Dealer also has blackjack. Tie.");
                return;
            } else {
                System.out.println(player.getName() + " wins with Blackjack!");
                return;
            }
        }

        // Player turn
        boolean playerTurnOver = false;
        while (!playerTurnOver) {
            if (player.getHand().isBust()) {
                System.out.println(player.getName() + " busts with total " + player.getHand().calculateTotal());
                return;
            }
            boolean hit = player.wantsToHit();
            if (hit) {
                Card c = deck.safeDeal();
                player.receiveCard(c);
                System.out.println("You were dealt: " + c.toString());
                System.out.println("Hand: " + player.getHand().toString() + " (Total: " + player.getHand().calculateTotal() + ")");
                if (player.getHand().isBust()) {
                    System.out.println(player.getName() + " busts!");
                    return;
                }
            } else {
                playerTurnOver = true;
            }
        }

        // Dealer turn
        System.out.println("\nDealer reveals hidden card: " + dealer.getHand().getCardsInHand().get(1).toString());
        System.out.println("Dealer hand: " + dealer.getHand().toString() + " (Total: " + dealer.getHand().calculateTotal() + ")");
        while (dealer.wantsToHit()) {
            Card c = deck.safeDeal();
            dealer.receiveCard(c);
            System.out.println("Dealer hits and receives: " + c.toString());
            System.out.println("Dealer total: " + dealer.getHand().calculateTotal());
            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busts!");
                System.out.println(player.getName() + " wins!");
                return;
            }
        }

        // Compare
        int pTotal = player.getHand().calculateTotal();
        int dTotal = dealer.getHand().calculateTotal();
        System.out.println("\nFinal totals -> " + player.getName() + ": " + pTotal + " | Dealer: " + dTotal);
        if (pTotal > dTotal) {
            System.out.println(player.getName() + " wins!");
        } else if (dTotal > pTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Push (tie).");
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("Thanks for playing Blackjack.");
    }

}

