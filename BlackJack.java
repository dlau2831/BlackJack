import java.util.*;
import java.util.Scanner;

public class BlackJack {


    public BlackJack() {
        startGame();
    }

    // Draw a card from a deck

    ArrayList<Card> deck;
    int cardindex = 0;

    ArrayList<Card> dealerHand;
    int dealerSum;
    int dealerAceCount;
    ArrayList<Card> playerHand;
    int playerSum;
    int playerAceCount;

    boolean won = false;

    public void startGame() {
        createDeck();
        shuffleDeck();



        dealerHand = new ArrayList<Card>();


        playerHand = new ArrayList<Card>();

        dealCards();






    }

    public void createDeck() {
        deck = new ArrayList<Card>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"D", "C", "H", "S"};
        int i = 0;
        for (String s : suits) {
            for (String r : ranks) {
                Card card = new Card(s, r);
                deck.add(card);
            }
        }


    }

    public void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currentCard);
        }


    }


    public void dealCards() {

        //Give to player
        playerHand.add(deck.get(0));
        deck.remove(0);
        //Give to dealer
        dealerHand.add(deck.get(0));
        deck.remove(0);
        //Give to player (Second Card)
        playerHand.add(deck.get(0));
        deck.remove(0);
        //Hidden Card
        dealerHand.add(deck.get(0));
        deck.remove(0);
        //Give to player (Hit Cards)



        dealerSum = dealerHand.get(0).getValue() + dealerHand.get(1).getValue();
        playerSum = playerHand.get(0).getValue() + playerHand.get(1).getValue();

        System.out.println("Dealer: " + dealerHand.get(0).toString() + " " + dealerHand.get(1).toString() + ": " + dealerSum + "\nPlayer: " + playerHand.get(0).toString() + " " + playerHand.get(1).toString() + ": " + playerSum);

    }

    public boolean checkBlackJack() {

        if (playerSum == 21 && dealerSum == 21) {
            System.out.println("Standoff");
            return true;
        } else if (playerSum == 21 && dealerSum != 21) {
            System.out.println("You win!");
            return true;
        } else return false;
    }

    public boolean anotherHand(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Would you like to play again? [Y/N]: ");
        char userChoice = scnr.next().charAt(0);
        if (userChoice == 'Y' || userChoice == 'y'){
            return true;
        }
        else{
            System.out.println("Ending Session...");
            return false;
        }


    }

    public void makeDecision() {
        boolean makingDecision = true;
        Scanner keyboard = new Scanner(System.in);
        while (makingDecision) {

            if (playerSum < 21) {
                System.out.print("Hit or Stand (H or S): ");
                char choice = keyboard.next().charAt(0);
                if (choice == 'H' || choice == 'h') {
                    playerHand.add(deck.get(0));
                    dealerSum += deck.get(0).getValue();
                    deck.remove(0);
                    makingDecision = false;
                } else if (choice == 's' || choice == 'S') {
                    System.out.println("Standing");
                    makingDecision = false;
                }
                else{
                    System.out.println("Invalid choice.Please enter H or S.");
                }

            }
        }
    }

}




// Bust
// Split doubles,
// Aces (1 or 11)
// Compare value when hitting or standing


