package com.oxygenum.splendor;

import java.util.ArrayList;

public class GameState {
    private int id;
    private ArrayList<Card> level1_stos;
    private ArrayList<Card> level2_stos;
    private ArrayList<Card> level3_stos;
    private ArrayList<Card> level1_board;
    private ArrayList<Card> level2_board;
    private ArrayList<Card> level3_board;
    private ArrayList<Aristocrate> aristocrates;
    private ArrayList<Aristocrate> aristocrates_board;
    private ArrayList<Player> players;
    private int[] chips;
    private int graczAktualny;

    public void incrementChips(int nr) {
         chips[nr]--;
    }

    public void incrementChipsPlus(int nr, int ile) {
        chips[nr] = chips[nr] + ile;
    }

    public void nextGracz(){
        graczAktualny++;
        graczAktualny = graczAktualny%numberOfPlayers();
            }

    public String getChipsStr(int nr) {
        return Integer.toString(chips[nr]);
    }

    public int getChips(int nr) {
        return chips[nr];
    }

    public Player returnGracz(){
        return players.get(graczAktualny);
    }

    public GameState(ArrayList<Card> level1_stos, ArrayList<Card> level2_stos, ArrayList<Card> level3_stos, ArrayList<Aristocrate> aristocrates, ArrayList<Player> players) {
        this.id = id;
        this.level1_stos = level1_stos;
        this.level2_stos = level2_stos;
        this.level3_stos = level3_stos;
        this.level1_board = new ArrayList<>();
        this.level2_board = new ArrayList<>();
        this.level3_board = new ArrayList<>();
        this.aristocrates = aristocrates;
        this.aristocrates_board = new ArrayList<>();
        this.players = players;
        for(int i=0;i<4;i++){
            level1_board.add(level1_stos.remove(0));
            level2_board.add(level2_stos.remove(0));
            level3_board.add(level3_stos.remove(0));
        }
        this.aristocrates = aristocrates;
        for(int i=0;i<players.size() + 1;i++){
            aristocrates_board.add(aristocrates.remove(0));
        }
        this.chips = new int[5];
        for(int i=0;i<5;i++) {
            chips[i] = players.size() + 2;
        }
        graczAktualny = 0;

    }


    public Card returnCard(int era, int nr){
        Card card;
        switch (era){
            case 1:
                card = level1_board.get(nr-1);
                break;
            case 2:
                card = level2_board.get(nr-1);
                break;
            case 3:
                card = level3_board.get(nr-1);
                break;
            default: card = null;

        }
        return card;
    }

    public boolean canObtain(Card card, Player player){
        int brak = 0;
        if(card.getNumber_of_niebieski() - player.getChips(0) - player.getCardSymbols(0) > 0){
            brak++;
        }
        if(card.getNumber_of_bialy() - player.getChips(1) - player.getCardSymbols(1) > 0){
            brak++;
        }
        if(card.getNumber_of_brazowy() - player.getChips(2) - player.getCardSymbols(2) > 0){
            brak++;
        }
        if(card.getNumber_of_zielony() - player.getChips(3) - player.getCardSymbols(3) > 0){
            brak++;
        }
        if(card.getNumber_of_czerwony() - player.getChips(4) - player.getCardSymbols(4) > 0){
            brak++;
        }
        if (brak <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Aristocrate returnAristocrate(){
        return aristocrates_board.remove(0);
    }

    public int numberOfPlayers(){
        return players.size();
    }

    public void swapCard(int era, int nr){
        int[] chips = new int[5];
        switch(era){
            case 1:
                chips = returnGracz().buyKarta(level1_board.get(nr-1));
                returnGracz().addKarta(level1_board.get(nr-1));
                level1_board.set(nr-1, level1_stos.remove(0));
                break;
            case 2:
                chips = returnGracz().buyKarta(level2_board.get(nr-1));
                returnGracz().addKarta(level2_board.get(nr-1));
                level2_board.set(nr-1, level2_stos.remove(0));
                break;
            case 3:
                chips = returnGracz().buyKarta(level3_board.get(nr-1));
                returnGracz().addKarta(level3_board.get(nr-1));
                level3_board.set(nr-1, level3_stos.remove(0));
                break;
        }
        for (int i = 0; i<5;i++){
            incrementChipsPlus(i, chips[i]);
        }
    }
}
