package com.oxygenum.splendor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game extends AppCompatActivity {

    ArrayList<Card> spisCard_1 = new ArrayList<>();
    ArrayList<Card> spisCard_2 = new ArrayList<>();
    ArrayList<Card> spisCard_3 = new ArrayList<>();
    ArrayList<Aristocrate> arystokraci = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Integer> zaznaczone = new ArrayList<>();
    TextView[] chipsy = new TextView[5];
    TextView[] karty = new TextView[5];
    TextView[] zetony = new TextView[6];
    TextView punkty;
    GameState Gra1;
    TableLayout[] tableLayouts;
    int wybranaKarta = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Brazowe
        spisCard_1.add(new Card(3, 0, 0, 1, 1, 1, 1));
        spisCard_1.add(new Card(3, 0, 0, 0, 1, 0, 2));
        spisCard_1.add(new Card(3, 0, 0, 2, 0, 0, 2));
        spisCard_1.add(new Card(3, 0, 1, 0, 3, 0, 1));
        spisCard_1.add(new Card(3, 0, 0, 0, 0, 0, 3));
        spisCard_1.add(new Card(3, 0, 0, 1, 1, 2, 1));
        spisCard_1.add(new Card(3, 0, 0, 2, 1, 2, 0));
        spisCard_1.add(new Card(3, 1, 0, 0, 0, 4, 0));
        spisCard_2.add(new Card(3, 1, 0, 3, 0, 2, 2));
        spisCard_2.add(new Card(3, 1, 2, 3, 0, 0, 3));
        spisCard_2.add(new Card(3, 2, 0, 0, 2, 1, 4));
        spisCard_2.add(new Card(3, 2, 0, 5, 0, 0, 0));
        spisCard_2.add(new Card(3, 2, 0, 0, 3, 0, 5));
        spisCard_2.add(new Card(3, 3, 6, 0, 0, 0, 0));
        spisCard_3.add(new Card(3, 3, 0, 3, 3, 3, 5));
        spisCard_3.add(new Card(3, 4, 0, 0, 7, 0, 0));
        spisCard_3.add(new Card(3, 4, 3, 0, 6, 0, 3));
        spisCard_3.add(new Card(3, 5, 3, 0, 7, 0, 0));
        //Niebieski
        spisCard_1.add(new Card(1, 0, 2, 1, 0, 0, 0));
        spisCard_1.add(new Card(1, 0, 1, 1, 2, 0, 1));
        spisCard_1.add(new Card(1, 0, 1, 1, 1, 0, 1));
        spisCard_1.add(new Card(1, 0, 0, 0, 1, 1, 3));
        spisCard_1.add(new Card(1, 0, 3, 0, 0, 0, 0));
        spisCard_1.add(new Card(1, 0, 0, 1, 2, 0, 2));
        spisCard_1.add(new Card(1, 0, 2, 0, 0, 0, 2));
        spisCard_1.add(new Card(1, 1, 0, 0, 4, 0, 0));
        spisCard_2.add(new Card(1, 1, 0, 0, 3, 2, 2));
        spisCard_2.add(new Card(1, 1, 3, 0, 0, 2, 3));
        spisCard_2.add(new Card(1, 2, 0, 5, 0, 3, 0));
        spisCard_2.add(new Card(1, 2, 0, 0, 0, 5, 0));
        spisCard_2.add(new Card(1, 2, 4, 2, 1, 0, 0));
        spisCard_2.add(new Card(1, 3, 0, 0, 0, 6, 0));
        spisCard_3.add(new Card(1, 3, 5, 3, 3, 0, 3));
        spisCard_3.add(new Card(1, 4, 0, 7, 0, 0, 0));
        spisCard_3.add(new Card(1, 4, 3, 6, 0, 3, 0));
        spisCard_3.add(new Card(1, 5, 0, 7, 0, 3, 0));
        //Zielony
        spisCard_1.add(new Card(4, 0, 0, 2, 0, 1, 0));
        spisCard_1.add(new Card(4, 0, 0, 0, 2, 2, 0));
        spisCard_1.add(new Card(4, 0, 0, 1, 0, 3, 1));
        spisCard_1.add(new Card(4, 0, 1, 1, 1, 1, 0));
        spisCard_1.add(new Card(4, 0, 2, 1, 1, 1, 0));
        spisCard_1.add(new Card(4, 0, 2, 0, 2, 1, 0));
        spisCard_1.add(new Card(4, 0, 0, 0, 3, 0, 0));
        spisCard_1.add(new Card(4, 1, 4, 0, 0, 0, 0));
        spisCard_2.add(new Card(4, 1, 0, 3, 3, 0, 2));
        spisCard_2.add(new Card(4, 1, 2, 2, 0, 3, 0));
        spisCard_2.add(new Card(4, 2, 1, 4, 0, 2, 0));
        spisCard_2.add(new Card(4, 2, 0, 0, 0, 0, 5));
        spisCard_2.add(new Card(4, 2, 0, 0, 0, 5, 3));
        spisCard_2.add(new Card(4, 3, 0, 0, 0, 0, 6));
        spisCard_3.add(new Card(4, 3, 3, 5, 3, 3, 0));
        spisCard_3.add(new Card(4, 4, 0, 3, 0, 6, 3));
        spisCard_3.add(new Card(4, 4, 0, 0, 0, 7, 0));
        spisCard_3.add(new Card(4, 5, 0, 0, 0, 7, 3));
        //Czerwone
        spisCard_1.add(new Card(5, 0, 0, 3, 0, 0, 0));
        spisCard_1.add(new Card(5, 0, 3, 1, 1, 0, 0));
        spisCard_1.add(new Card(5, 0, 0, 0, 0, 2, 1));
        spisCard_1.add(new Card(5, 0, 2, 2, 0, 0, 1));
        spisCard_1.add(new Card(5, 0, 1, 2, 0, 1, 1));
        spisCard_1.add(new Card(5, 0, 1, 1, 0, 1, 1));
        spisCard_1.add(new Card(5, 0, 0, 2, 2, 0, 0));
        spisCard_1.add(new Card(5, 1, 0, 4, 0, 0, 0));
        spisCard_2.add(new Card(5, 1, 3, 0, 2, 3, 0));
        spisCard_2.add(new Card(5, 1, 3, 2, 2, 0, 0));
        spisCard_2.add(new Card(5, 2, 0, 1, 0, 4, 2));
        spisCard_2.add(new Card(5, 2, 5, 3, 0, 0, 0));
        spisCard_2.add(new Card(5, 2, 5, 0, 0, 0, 0));
        spisCard_2.add(new Card(5, 3, 0, 0, 6, 0, 0));
        spisCard_3.add(new Card(5, 3, 3, 3, 0, 5, 3));
        spisCard_3.add(new Card(5, 4, 0, 0, 0, 0, 7));
        spisCard_3.add(new Card(5, 4, 0, 0, 3, 3, 6));
        spisCard_3.add(new Card(5, 5, 0, 0, 3, 0, 7));
        //Białe
        spisCard_1.add(new Card(2, 0, 1, 0, 0, 2, 2));
        spisCard_1.add(new Card(2, 0, 1, 0, 2, 0, 0));
        spisCard_1.add(new Card(2, 0, 1, 0, 1, 1, 1));
        spisCard_1.add(new Card(2, 0, 0, 0, 0, 3, 0));
        spisCard_1.add(new Card(2, 0, 0, 0, 0, 2, 2));
        spisCard_1.add(new Card(2, 0, 1, 0, 1, 1, 2));
        spisCard_1.add(new Card(2, 0, 1, 3, 0, 1, 0));
        spisCard_1.add(new Card(2, 1, 0, 0, 0, 0, 4));
        spisCard_2.add(new Card(2, 1, 2, 0, 2, 0, 3));
        spisCard_2.add(new Card(2, 1, 0, 2, 3, 3, 0));
        spisCard_2.add(new Card(2, 2, 2, 0, 4, 0, 1));
        spisCard_2.add(new Card(2, 2, 0, 0, 5, 0, 0));
        spisCard_2.add(new Card(2, 2, 3, 0, 5, 0, 0));
        spisCard_2.add(new Card(2, 3, 0, 6, 0, 0, 0));
        spisCard_3.add(new Card(2, 3, 3, 0, 5, 3, 3));
        spisCard_3.add(new Card(2, 4, 7, 0, 0, 0, 0));
        spisCard_3.add(new Card(2, 4, 6, 3, 3, 0, 0));
        spisCard_3.add(new Card(2, 5, 7, 3, 0, 0, 0));

        arystokraci.add(new Aristocrate(4, 5));
        arystokraci.add(new Aristocrate(1, 2));
        arystokraci.add(new Aristocrate(1, 4));
        arystokraci.add(new Aristocrate(2, 3));
        arystokraci.add(new Aristocrate(3, 5));
        arystokraci.add(new Aristocrate(2, 3, 5));
        arystokraci.add(new Aristocrate(1, 4, 5));
        arystokraci.add(new Aristocrate(1, 2, 4));
        arystokraci.add(new Aristocrate(2, 3, 1));
        arystokraci.add(new Aristocrate(3, 4, 5));

        players.add(new Player("Gracz 1", false, R.color.gracz1));
        players.add(new Player("Gracz 2", false, R.color.colorPrimary));
        //players.add(new Player("Gracz 3", false));
        Random rand = new Random();
        Collections.shuffle(spisCard_1, rand);
        Collections.shuffle(spisCard_2, rand);
        Collections.shuffle(spisCard_3, rand);
        Collections.shuffle(arystokraci, rand);

        Gra1 = new GameState(spisCard_1, spisCard_2, spisCard_3, arystokraci, players);
        setCard(Gra1.returnCard(3, 1), 3, 1);
        setCard(Gra1.returnCard(3, 2), 3, 2);
        setCard(Gra1.returnCard(3, 3), 3, 3);
        setCard(Gra1.returnCard(3, 4), 3, 4);
        setCard(Gra1.returnCard(2, 1), 2, 1);
        setCard(Gra1.returnCard(2, 2), 2, 2);
        setCard(Gra1.returnCard(2, 3), 2, 3);
        setCard(Gra1.returnCard(2, 4), 2, 4);
        setCard(Gra1.returnCard(1, 1), 1, 1);
        setCard(Gra1.returnCard(1, 2), 1, 2);
        setCard(Gra1.returnCard(1, 3), 1, 3);
        setCard(Gra1.returnCard(1, 4), 1, 4);

        int ile = Gra1.numberOfPlayers();

        switch (ile) {
            case 2:
                TableLayout ar1 = findViewById(R.id.ar1);
                TableLayout ar5 = findViewById(R.id.ar5);
                ar1.setVisibility(View.INVISIBLE);
                ar5.setVisibility(View.INVISIBLE);
                setAristocrates(Gra1.returnAristocrate(), 2);
                setAristocrates(Gra1.returnAristocrate(), 3);
                setAristocrates(Gra1.returnAristocrate(), 4);
                break;
            case 3:
                TableLayout ar3 = findViewById(R.id.ar3);
                ar3.setVisibility(View.INVISIBLE);
                setAristocrates(Gra1.returnAristocrate(), 1);
                setAristocrates(Gra1.returnAristocrate(), 2);
                setAristocrates(Gra1.returnAristocrate(), 4);
                setAristocrates(Gra1.returnAristocrate(), 5);
                break;
            case 4:
                setAristocrates(Gra1.returnAristocrate(), 1);
                setAristocrates(Gra1.returnAristocrate(), 2);
                setAristocrates(Gra1.returnAristocrate(), 3);
                setAristocrates(Gra1.returnAristocrate(), 4);
                setAristocrates(Gra1.returnAristocrate(), 5);
                break;
        }

        chipsy[0] = findViewById(R.id.chips1);
        chipsy[1] = findViewById(R.id.chips2);
        chipsy[2] = findViewById(R.id.chips3);
        chipsy[3] = findViewById(R.id.chips4);
        chipsy[4] = findViewById(R.id.chips5);

        karty[0] = findViewById(R.id.karta1);
        karty[1] = findViewById(R.id.karta2);
        karty[2] = findViewById(R.id.karta3);
        karty[3] = findViewById(R.id.karta4);
        karty[4] = findViewById(R.id.karta5);

        zetony[0] = findViewById(R.id.zeton1);
        zetony[1] = findViewById(R.id.zeton2);
        zetony[2] = findViewById(R.id.zeton3);
        zetony[3] = findViewById(R.id.zeton4);
        zetony[4] = findViewById(R.id.zeton5);
        zetony[5] = findViewById(R.id.zeton6);

        punkty = findViewById(R.id.punkty);

        tableLayouts = new TableLayout[12];
        tableLayouts[0] = findViewById(R.id.karta_1_1);
        tableLayouts[1] = findViewById(R.id.karta_1_2);
        tableLayouts[2] = findViewById(R.id.karta_1_3);
        tableLayouts[3] = findViewById(R.id.karta_1_4);
        tableLayouts[4] = findViewById(R.id.karta_2_1);
        tableLayouts[5] = findViewById(R.id.karta_2_2);
        tableLayouts[6] = findViewById(R.id.karta_2_3);
        tableLayouts[7] = findViewById(R.id.karta_2_4);
        tableLayouts[8] = findViewById(R.id.karta_3_1);
        tableLayouts[9] = findViewById(R.id.karta_3_2);
        tableLayouts[10] = findViewById(R.id.karta_3_3);
        tableLayouts[11] = findViewById(R.id.karta_3_4);

        for (int i = 0; i < 5; i++) {
            final TextView act_chips = chipsy[i];
            final int nr = i;
            act_chips.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (zaznaczone.size() != 0) {

                        for (int i = 0; i < 5; i++) {
                            if (zaznaczone.contains(i)) {
                                scaleView(chipsy[i], 1.2f, 1f);
                                //zaznaczone.remove(zaznaczone.indexOf(i));
                                zaznaczone.remove(Integer.valueOf(i));

                            }
                        }
                    }
                    scaleView(v, 1, 1.2f);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                    final View widok = v;
                    builder.setTitle("Prośba o potwierdzenie");
                    builder.setMessage("Czy chcesz dwa zetony tego koloru?")
                            .setCancelable(false)
                            .setPositiveButton("TAK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if (Gra1.getChips(nr) >= 4) {
                                        Gra1.incrementChips(nr);
                                        Gra1.incrementChips(nr);
                                        Gra1.returnGracz().addChips(nr);
                                        Gra1.returnGracz().addChips(nr);
                                        setChips();
                                        AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
                                        alert.setTitle("Komunikat");
                                        alert.setMessage("Teraz tura następnego gracza");
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                            }
                                        });
                                        alert.show();
                                        Gra1.nextGracz();
                                        setPlayerField();
                                    }
                                    else{
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                                        builder.setTitle("Nieprawidlowy ruch");
                                        builder.setMessage("Nie mozesz wziac dwoch zetonow, jesli w stosie jest mniej niż 4")
                                                .setNeutralButton("OK",null);
                                        // Create the AlertDialog object and return it
                                        builder.create().show();
                                    }
                                    scaleView(widok, 1.2f, 1f);

                                }
                            })
                            .setNegativeButton("NIE", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    scaleView(widok, 1.2f, 1f);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return true;
                }
            });
            act_chips.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    scaleView(v, 1, 1.2f);
                    zaznaczone.add(returnNr(getResources().getResourceEntryName(act_chips.getId())));
                    if (zaznaczone.size() == 3) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                        builder.setTitle("Prośba o potwierdzenie");
                        builder.setMessage("Czy wybrales odpowiednie?")
                                .setCancelable(false)
                                .setPositiveButton("TAK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        chips_positive();
                                    }
                                })
                                .setNegativeButton("NIE", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        chips_negative();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
            });

        }
        setChips();
        setPlayerField();

    }

    public void chips_positive() {
        Toast.makeText(Game.this, zaznaczone.toString(), Toast.LENGTH_LONG).show();
        boolean status = true;
        for (int i = 0; i < 5; i++) {
            if (zaznaczone.contains(i)) {
                scaleView(chipsy[i], 1.2f, 1f);
                if (Gra1.getChips(i) == 0){
                    status = false;
                }
            }

        }
        if (status) {
            for (int i = 0; i < 5; i++) {
                if (zaznaczone.contains(i)) {
                    Gra1.returnGracz().addChips(i);
                    Gra1.incrementChips(i);
                }

            }
            zaznaczone.removeAll(zaznaczone);
            setChips();
            AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
            alert.setTitle("Komunikat");
            alert.setMessage("Teraz tura następnego gracza");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            alert.show();
            Gra1.nextGracz();
            setPlayerField();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
            builder.setTitle("Nieprawidlowy ruch");
            builder.setMessage("Nie mozesz wziac zetonow, jesli w stosie juz ich nie ma")
                    .setNeutralButton("OK",null);
            builder.create().show();
        }
    }

    public void chips_negative() {
        for (int i = 0; i < 5; i++) {
            if (zaznaczone.contains(i)) {
                scaleView(chipsy[i], 1.2f, 1f);
                zaznaczone.remove(zaznaczone.indexOf(i));
            }
        }
        setChips();
        setPlayerField();
    }

    public void setChips() {
        chipsy[0].setText(Gra1.getChipsStr(0));
        chipsy[1].setText(Gra1.getChipsStr(1));
        chipsy[2].setText(Gra1.getChipsStr(2));
        chipsy[3].setText(Gra1.getChipsStr(3));
        chipsy[4].setText(Gra1.getChipsStr(4));
    }

    public void setPlayerField() {
        for (int i = 0; i < 5; i++) {
            karty[i].setText(Gra1.returnGracz().getCardSymbolsStr(i));
            zetony[i].setText(Gra1.returnGracz().getChipsStr(i));
        }
        zetony[5].setText(Gra1.returnGracz().getChipsStr(5));
        punkty.setText(Gra1.returnGracz().getPoints());
        View tlo = findViewById(R.id.tlo);
        tlo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(Gra1.returnGracz().getTlo())));
    }

    public void setAristocrates(Aristocrate ar, int nr) {
        TextView w1;
        TextView w2;
        TextView w3;
        int ile = ar.getStatus();
        switch (nr) {
            case 1:
                w1 = findViewById(R.id.arystokrata_1_wymaganie_2);
                w2 = findViewById(R.id.arystokrata_1_wymaganie_3);
                w3 = findViewById(R.id.arystokrata_1_wymaganie_1);

                w1.setBackground(getDrawable(ar.getWym1()));
                w2.setBackground(getDrawable(ar.getWym2()));
                if (ile == 3) {
                    w3.setBackground(getDrawable(ar.getWym3()));
                    w1.setText("3");
                    w2.setText("3");
                    w3.setText("3");
                } else {
                    w3.setVisibility(View.INVISIBLE);
                    w1.setText("4");
                    w2.setText("4");
                }
            case 2:
                w1 = findViewById(R.id.arystokrata_2_wymaganie_2);
                w2 = findViewById(R.id.arystokrata_2_wymaganie_3);
                w3 = findViewById(R.id.arystokrata_2_wymaganie_1);

                w1.setBackground(getDrawable(ar.getWym1()));
                w2.setBackground(getDrawable(ar.getWym2()));
                if (ile == 3) {
                    w3.setBackground(getDrawable(ar.getWym3()));
                    w1.setText("3");
                    w2.setText("3");
                    w3.setText("3");
                } else {
                    w3.setVisibility(View.INVISIBLE);
                    w1.setText("4");
                    w2.setText("4");
                }
            case 3:
                w1 = findViewById(R.id.arystokrata_3_wymaganie_2);
                w2 = findViewById(R.id.arystokrata_3_wymaganie_3);
                w3 = findViewById(R.id.arystokrata_3_wymaganie_1);

                w1.setBackground(getDrawable(ar.getWym1()));
                w2.setBackground(getDrawable(ar.getWym2()));
                if (ile == 3) {
                    w3.setBackground(getDrawable(ar.getWym3()));
                    w1.setText("3");
                    w2.setText("3");
                    w3.setText("3");
                } else {
                    w3.setVisibility(View.INVISIBLE);
                    w1.setText("4");
                    w2.setText("4");
                }
            case 4:
                w1 = findViewById(R.id.arystokrata_4_wymaganie_2);
                w2 = findViewById(R.id.arystokrata_4_wymaganie_3);
                w3 = findViewById(R.id.arystokrata_4_wymaganie_1);

                w1.setBackground(getDrawable(ar.getWym1()));
                w2.setBackground(getDrawable(ar.getWym2()));
                if (ile == 3) {
                    w3.setBackground(getDrawable(ar.getWym3()));
                    w1.setText("3");
                    w2.setText("3");
                    w3.setText("3");
                } else {
                    w3.setVisibility(View.INVISIBLE);
                    w1.setText("4");
                    w2.setText("4");
                }
            case 5:
                w1 = findViewById(R.id.arystokrata_5_wymaganie_2);
                w2 = findViewById(R.id.arystokrata_5_wymaganie_3);
                w3 = findViewById(R.id.arystokrata_5_wymaganie_1);

                w1.setBackground(getDrawable(ar.getWym1()));
                w2.setBackground(getDrawable(ar.getWym2()));
                if (ile == 3) {
                    w3.setBackground(getDrawable(ar.getWym3()));
                    w1.setText("3");
                    w2.setText("3");
                    w3.setText("3");
                } else {
                    w3.setVisibility(View.INVISIBLE);
                    w1.setText("4");
                    w2.setText("4");
                }

        }

    }

    public void click_card(View view) {
        int kliknieta = -1;
        for (int i = 0; i<12;i++){
            if (tableLayouts[i].getId()== view.getId()){
                kliknieta = i;
            }
        }

        if(wybranaKarta != kliknieta){
            setOpacityCards(0.5f);
            view.setAlpha(1.0f);
            scaleView(view, 1, 1.05f);
            scaleView(view, 1.05f, 1f);
            wybranaKarta = kliknieta;
        }
        else{
            int era = kliknieta/4 + 1;
            int nr = kliknieta%4 + 1;
            if (Gra1.canObtain(Gra1.returnCard(era, nr), Gra1.returnGracz())){
                Gra1.swapCard(era, nr); //rowniez dodaje karte graczowi
                setCard(Gra1.returnCard(era, nr), era, nr);
                Gra1.returnGracz().addChips(nr);
                setChips();
                AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
                alert.setTitle("Info");
                alert.setMessage("Teraz tura następnego gracza");
                alert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                alert.show();
                alert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                Gra1.nextGracz();
                setPlayerField();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("Nieprawidlowy ruch");
                builder.setMessage("Nie mozesz wziac karty jeśli Cię na nią nie stać")
                        .setNeutralButton("OK",null);
                builder.create().show();
            }
            kliknieta = -1;
        }

    }

    public int returnNr(String s) {
        Toast.makeText(Game.this, s, Toast.LENGTH_LONG).show();
        return Integer.parseInt(s.substring(s.length() - 1)) - 1;
    }

    public void setOpacityCards(float level) {
        for (int i = 0; i < 12; i++) {
            tableLayouts[i].setAlpha(level);
        }
    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1200);
        v.startAnimation(anim);
    }

    public void setCard(Card card, int era, int nr) {
        if (era == 1 && nr == 1) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_1_1);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_1_1);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_1_1);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_1_1);
            TextView punkty = findViewById(R.id.punkty_1_1);
            TableLayout kolor = findViewById(R.id.karta_1_1);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 1 && nr == 2) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_1_2);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_1_2);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_1_2);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_1_2);
            TextView punkty = findViewById(R.id.punkty_1_2);
            TableLayout kolor = findViewById(R.id.karta_1_2);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 1 && nr == 3) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_1_3);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_1_3);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_1_3);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_1_3);
            TextView punkty = findViewById(R.id.punkty_1_3);
            TableLayout kolor = findViewById(R.id.karta_1_3);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 1 && nr == 4) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_1_4);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_1_4);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_1_4);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_1_4);
            TextView punkty = findViewById(R.id.punkty_1_4);
            TableLayout kolor = findViewById(R.id.karta_1_4);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }

        if (era == 2 && nr == 1) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_2_1);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_2_1);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_2_1);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_2_1);
            TextView punkty = findViewById(R.id.punkty_2_1);
            TableLayout kolor = findViewById(R.id.karta_2_1);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 2 && nr == 2) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_2_2);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_2_2);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_2_2);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_2_2);
            TextView punkty = findViewById(R.id.punkty_2_2);
            TableLayout kolor = findViewById(R.id.karta_2_2);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 2 && nr == 3) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_2_3);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_2_3);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_2_3);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_2_3);
            TextView punkty = findViewById(R.id.punkty_2_3);
            TableLayout kolor = findViewById(R.id.karta_2_3);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 2 && nr == 4) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_2_4);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_2_4);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_2_4);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_2_4);
            TextView punkty = findViewById(R.id.punkty_2_4);
            TableLayout kolor = findViewById(R.id.karta_2_4);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }

        if (era == 3 && nr == 1) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_3_1);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_3_1);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_3_1);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_3_1);
            TextView punkty = findViewById(R.id.punkty_3_1);
            TableLayout kolor = findViewById(R.id.karta_3_1);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 3 && nr == 2) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_3_2);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_3_2);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_3_2);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_3_2);
            TextView punkty = findViewById(R.id.punkty_3_2);
            TableLayout kolor = findViewById(R.id.karta_3_2);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
            punkty.setText(card.getPointsStr());
        }
        if (era == 3 && nr == 3) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_3_3);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_3_3);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_3_3);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_3_3);
            TextView punkty = findViewById(R.id.punkty_3_3);
            TableLayout kolor = findViewById(R.id.karta_3_3);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            punkty.setText(card.getPointsStr());
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
        }
        if (era == 3 && nr == 4) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_3_4);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_3_4);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_3_4);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_3_4);
            TextView punkty = findViewById(R.id.punkty_3_4);
            TableLayout kolor = findViewById(R.id.karta_3_4);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1_tlo()));
            w3.setBackground(getDrawable(card.getWym2_tlo()));
            w1.setBackground(getDrawable(card.getWym3_tlo()));
            w2.setBackground(getDrawable(card.getWym4_tlo()));
            w1.setText(card.getWym1());
            w2.setText(card.getWym2());
            w3.setText(card.getWym3());
            w4.setText(card.getWym4());
            punkty.setText(card.getPointsStr());
            if (card.getWym1() != "") {
                w4.setVisibility(View.VISIBLE);
                w4.setText(card.getWym1());
            } else {
                w4.setVisibility(View.INVISIBLE);
            }
            if (card.getWym2() != "") {
                w3.setVisibility(View.VISIBLE);
                w3.setText(card.getWym2());
            } else {
                w3.setVisibility(View.INVISIBLE);
            }
            if (card.getWym3() != "") {
                w1.setVisibility(View.VISIBLE);
                w1.setText(card.getWym3());
            } else {
                w1.setVisibility(View.INVISIBLE);
            }
            if (card.getWym4() != "") {
                w2.setVisibility(View.VISIBLE);
                w2.setText(card.getWym4());
            } else {
                w2.setVisibility(View.INVISIBLE);
            }
        }

    }

}