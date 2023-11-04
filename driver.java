import java.util.Scanner;

public class driver {
    public static void main(String args[]){

        BlackJack bj = new BlackJack();
        boolean running = true;
        int round = 0;

        while (running){


            if (round % 2 == 0 && round != 0){
                bj.createDeck();
                bj.shuffleDeck();
            }
            bj.checkBlackJack();
            bj.makeDecision();
            round++;
            running = bj.anotherHand();
            bj.dealCards();


        }







    }
}