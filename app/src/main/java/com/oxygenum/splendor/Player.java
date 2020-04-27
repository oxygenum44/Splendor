package com.oxygenum.splendor;

import java.util.ArrayList;

public class Player {
    public String name;
    private int[] ownedChips;
    private int[] ownedSymbolInCards;
    private ArrayList<Card> ownedCards;
    private ArrayList<Card> reservedCards;
    private Aristocrate[] ownedAristocrate;
    private int points;
    private boolean being;
    private int tint;

    public Player(String name, boolean being, int tint) {
        this.name = name;
        this.being = being;
        //this.being = being;
        this.points = 0;
        //this.ownedAristocrate = new Aristocrate[5];
        //this.reservedCards = new ArrayList<Card>();
        this.ownedSymbolInCards = new int[6];
        this.ownedChips = new int[6];
        for (int i = 0; i < 6; i++) {
            ownedChips[i] = 0;
            ownedSymbolInCards[i] = 0;
        }
        this.tint = tint;

    }

    public String getChipsStr(int nr) {
        return Integer.toString(ownedChips[nr]);
    }

    public int getChips(int nr) {
        return ownedChips[nr];
    }

    public int getTlo() {
        return tint;
    }

    public void addChips(int indeks) {
        ownedChips[indeks]++;
    }

    public void addKarta(Card card){
        points = points + card.getPoints();
        ownedSymbolInCards[card.getColor()]++;
    }

    public int[] buyKarta(Card card){
        int niebiski_cost = card.getNumber_of_niebieski() - ownedSymbolInCards[0];
        int bialy_cost = card.getNumber_of_bialy() - ownedSymbolInCards[1];
        int brazowy_cost = card.getNumber_of_brazowy() - ownedSymbolInCards[2];
        int zielony_cost = card.getNumber_of_zielony() - ownedSymbolInCards[3];
        int czerwony_cost = card.getNumber_of_czerwony() - ownedSymbolInCards[4];
        int[] zaplata = new int[5];
        zaplata[0] = niebiski_cost;
        zaplata[1] = bialy_cost;
        zaplata[2] = brazowy_cost;
        zaplata[3] = zielony_cost;
        zaplata[4] = czerwony_cost;
        ownedChips[0] = ownedChips[0] - niebiski_cost;
        ownedChips[1] = ownedChips[1] - bialy_cost;
        ownedChips[2] = ownedChips[2] - brazowy_cost;
        ownedChips[3] = ownedChips[3] - zielony_cost;
        ownedChips[4] = ownedChips[4] - czerwony_cost;
        points = points + card.getPoints();
        return zaplata;

    }

    public String getPoints() {
        return Integer.toString(points);
    }

    public String getCardSymbolsStr(int nr) {
        return Integer.toString(ownedSymbolInCards[nr]);
    }

    public int getCardSymbols(int nr) {
        return ownedSymbolInCards[nr];
    }

    public void addCardSymbols(int indeks) {
        ownedSymbolInCards[indeks] = ownedSymbolInCards[indeks]++;
    }

}
