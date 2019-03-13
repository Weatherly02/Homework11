package edu.dmacc.codedsm.hw11;

import java.util.*;

public class BlackJack {

    public static void main(String[] args) {
        Map<String, List<Integer>> deck = new HashMap<>();
        deck.put("Clubs", createCards());
        deck.put("Diamonds", createCards());
        deck.put("Spades", createCards());
        deck.put("Hearts", createCards());

        for (String suitInDeck : deck.keySet()) {
            List<Integer> cardsInDeck = deck.get(suitInDeck);
            for (Integer cardValue : cardsInDeck) {
                //System.out.println(suitInDeck + " - " + cardValue);
            }
        }

        List<Card> myHand = new ArrayList<>();

        Card firstCard = DeckRandomizer.chooseRandomCards(deck, 1).get(0);
        Card secondCard = DeckRandomizer.chooseRandomCards(deck, 1).get(0);
        int sum = firstCard.value + secondCard.value;

        myHand.add(firstCard);
        myHand.add(secondCard);

        deck.get(firstCard.suit).remove(firstCard.value);
        deck.get(secondCard.suit).remove(secondCard.value);

        printMyHand(myHand);

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            System.out.println("\nPress 1 to hit or 2 to stand.");
            String hitOrStand = scanner.next();

            if (hitOrStand.equals("1")) {
                Card nextCard = DeckRandomizer.chooseRandomCards(deck, 1).get(0);
                sum = firstCard.value + secondCard.value + nextCard.value;
                myHand.add(nextCard);
                deck.get(nextCard.suit).remove(nextCard.value);
                printMyHand(myHand);
            } else if (hitOrStand.equals("2")) {
                System.out.format("\nYour total is: %d", sum);
                playing = false;
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public static void printMyHand(List<Card> myHand) {
        for (int i = 0; i < myHand.size(); i++) {
            Card getCard = myHand.get(i);
            System.out.print(getCard.suit + " - " + getCard.value);

            if (i + 1 < myHand.size()) {
                System.out.print(", ");
            }
        }
    }

    public static List<Integer> createCards() {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            cards.add(i);
        }
        return cards;


    }
}

