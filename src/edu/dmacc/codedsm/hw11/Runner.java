package edu.dmacc.codedsm.hw11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        Map<String, List<Integer>> deck = createDeck();

        for (int i = 0; i < 50; i++) {
            List<Card> chosenCards = DeckRandomizer.chooseRandomCards(deck, 2);
            //System.out.println("chosenCards = " + chosenCards);
        }

    }

    private static Map<String, List<Integer>> createDeck() {
        Map<String, List<Integer>> deck = new HashMap<>();
        deck.put("Clubs", createCards());
        deck.put("Diamonds", createCards());
        deck.put("Spades", createCards());
        deck.put("Hearts", createCards());
        return deck;
    }

    private static List<Integer> createCards() {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            cards.add(i);
        }
        return cards;
    }
}