package com.oxygenum.splendor;

import java.util.ArrayList;

public class Card {


    private int color;
    private int points;
    private int number_of_niebieski;
    private int number_of_bialy;
    private int number_of_brazowy;
    private int number_of_zielony;
    private int number_of_czerwony;
    private String wym1;

    public int getNumber_of_niebieski() {
        return number_of_niebieski;
    }

    public int getNumber_of_bialy() {
        return number_of_bialy;
    }

    public int getNumber_of_brazowy() {
        return number_of_brazowy;
    }

    public int getNumber_of_zielony() {
        return number_of_zielony;
    }

    public int getNumber_of_czerwony() {
        return number_of_czerwony;
    }

    private int wym1_tlo;
    private String wym2;
    private int wym2_tlo;
    private String wym3;
    private int wym3_tlo;
    private String wym4;
    private int wym4_tlo;
    private int color_nr;

    public int getColorDrawable() {
        return color;
    }

    public int getColor() {
        return color_nr;
    }


    public String getPointsStr() {
        return Integer.toString(points);
    }

    public int getPoints(){
        return points;
    }

    public String getWym1() {
        return wym1;
    }

    public int getWym1_tlo() {
        return wym1_tlo;
    }

    public String getWym2() {
        return wym2;
    }

    public int getWym2_tlo() {
        return wym2_tlo;
    }

    public String getWym3() {
        return wym3;
    }

    public int getWym3_tlo() {
        return wym3_tlo;
    }

    public String getWym4() {
        return wym4;
    }

    public int getWym4_tlo() {
        return wym4_tlo;
    }


    public Card(int color, int points, int number_of_brazowy, int number_of_bialy, int number_of_czerwony, int number_of_niebieski, int number_of_zielony) {
        this.color_nr = color -1;
        switch (color){
            case 1:
                this.color = R.drawable.karta;
                break;
            case 2:
                this.color = R.drawable.karta2;
                break;
            case 3:
                this.color = R.drawable.karta3;
                break;
            case 4:
                this.color = R.drawable.karta4;
                break;
            case 5:
                this.color = R.drawable.karta5;
                break;
        }
        this.points = points;
        this.number_of_niebieski = number_of_niebieski;
        this.number_of_bialy = number_of_bialy;
        this.number_of_brazowy = number_of_brazowy;
        this.number_of_zielony = number_of_zielony;
        this.number_of_czerwony = number_of_czerwony;
        ArrayList<String> wym = new ArrayList<>();
        ArrayList<Integer> wym_tlo = new ArrayList<>();
        if (number_of_brazowy != 0){
            wym.add(Integer.toString(number_of_brazowy));
            wym_tlo.add(R.drawable.zeton3);
        }
        if (number_of_bialy != 0){
            wym.add(Integer.toString(number_of_bialy));
            wym_tlo.add(R.drawable.zeton2);
        }
        if (number_of_czerwony != 0){
            wym.add(Integer.toString(number_of_czerwony));
            wym_tlo.add(R.drawable.zeton5);
        }
        if (number_of_niebieski != 0){
            wym.add(Integer.toString(number_of_niebieski));
            wym_tlo.add(R.drawable.zeton);
        }
        if (number_of_zielony != 0){
            wym.add(Integer.toString(number_of_zielony));
            wym_tlo.add(R.drawable.zeton4);
        }
        while (wym.size() < 4){
            wym.add("");
            wym_tlo.add(R.drawable.zeton6);
        }
        wym1 = wym.get(0);
        wym2 = wym.get(1);
        wym3 = wym.get(2);
        wym4 = wym.get(3);
        wym1_tlo = wym_tlo.get(0);
        wym2_tlo = wym_tlo.get(1);
        wym3_tlo = wym_tlo.get(2);
        wym4_tlo = wym_tlo.get(3);


    }
}
