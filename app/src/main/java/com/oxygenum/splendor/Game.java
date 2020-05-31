package com.oxygenum.splendor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Handler;
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

    ArrayList<Card> cardDeck1 = new ArrayList<>();
    ArrayList<Card> cardDeck2 = new ArrayList<>();
    ArrayList<Card> cardDeck3 = new ArrayList<>();
    ArrayList<Aristocrate> aristocratesDeck = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Integer> checked = new ArrayList<>();
    TextView[] playerChips = new TextView[5];
    TextView[] playerCards = new TextView[5];
    TextView[] chips = new TextView[6];
    TextView points;
    GameState GameStateClient;
    TableLayout[] tableLayouts;
    int chosenCard = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle b = getIntent().getExtras();
        //Brazowe
        cardDeck1.add(new Card(3, 0, 0, 1, 1, 1, 1));
        cardDeck1.add(new Card(3, 0, 0, 0, 1, 0, 2));
        cardDeck1.add(new Card(3, 0, 0, 2, 0, 0, 2));
        cardDeck1.add(new Card(3, 0, 1, 0, 3, 0, 1));
        cardDeck1.add(new Card(3, 0, 0, 0, 0, 0, 3));
        cardDeck1.add(new Card(3, 0, 0, 1, 1, 2, 1));
        cardDeck1.add(new Card(3, 0, 0, 2, 1, 2, 0));
        cardDeck1.add(new Card(3, 1, 0, 0, 0, 4, 0));
        cardDeck2.add(new Card(3, 1, 0, 3, 0, 2, 2));
        cardDeck2.add(new Card(3, 1, 2, 3, 0, 0, 3));
        cardDeck2.add(new Card(3, 2, 0, 0, 2, 1, 4));
        cardDeck2.add(new Card(3, 2, 0, 5, 0, 0, 0));
        cardDeck2.add(new Card(3, 2, 0, 0, 3, 0, 5));
        cardDeck2.add(new Card(3, 3, 6, 0, 0, 0, 0));
        cardDeck3.add(new Card(3, 3, 0, 3, 3, 3, 5));
        cardDeck3.add(new Card(3, 4, 0, 0, 7, 0, 0));
        cardDeck3.add(new Card(3, 4, 3, 0, 6, 0, 3));
        cardDeck3.add(new Card(3, 5, 3, 0, 7, 0, 0));
        //Niebieski
        cardDeck1.add(new Card(1, 0, 2, 1, 0, 0, 0));
        cardDeck1.add(new Card(1, 0, 1, 1, 2, 0, 1));
        cardDeck1.add(new Card(1, 0, 1, 1, 1, 0, 1));
        cardDeck1.add(new Card(1, 0, 0, 0, 1, 1, 3));
        cardDeck1.add(new Card(1, 0, 3, 0, 0, 0, 0));
        cardDeck1.add(new Card(1, 0, 0, 1, 2, 0, 2));
        cardDeck1.add(new Card(1, 0, 2, 0, 0, 0, 2));
        cardDeck1.add(new Card(1, 1, 0, 0, 4, 0, 0));
        cardDeck2.add(new Card(1, 1, 0, 0, 3, 2, 2));
        cardDeck2.add(new Card(1, 1, 3, 0, 0, 2, 3));
        cardDeck2.add(new Card(1, 2, 0, 5, 0, 3, 0));
        cardDeck2.add(new Card(1, 2, 0, 0, 0, 5, 0));
        cardDeck2.add(new Card(1, 2, 4, 2, 1, 0, 0));
        cardDeck2.add(new Card(1, 3, 0, 0, 0, 6, 0));
        cardDeck3.add(new Card(1, 3, 5, 3, 3, 0, 3));
        cardDeck3.add(new Card(1, 4, 0, 7, 0, 0, 0));
        cardDeck3.add(new Card(1, 4, 3, 6, 0, 3, 0));
        cardDeck3.add(new Card(1, 5, 0, 7, 0, 3, 0));
        //Zielony
        cardDeck1.add(new Card(4, 0, 0, 2, 0, 1, 0));
        cardDeck1.add(new Card(4, 0, 0, 0, 2, 2, 0));
        cardDeck1.add(new Card(4, 0, 0, 1, 0, 3, 1));
        cardDeck1.add(new Card(4, 0, 1, 1, 1, 1, 0));
        cardDeck1.add(new Card(4, 0, 2, 1, 1, 1, 0));
        cardDeck1.add(new Card(4, 0, 2, 0, 2, 1, 0));
        cardDeck1.add(new Card(4, 0, 0, 0, 3, 0, 0));
        cardDeck1.add(new Card(4, 1, 4, 0, 0, 0, 0));
        cardDeck2.add(new Card(4, 1, 0, 3, 3, 0, 2));
        cardDeck2.add(new Card(4, 1, 2, 2, 0, 3, 0));
        cardDeck2.add(new Card(4, 2, 1, 4, 0, 2, 0));
        cardDeck2.add(new Card(4, 2, 0, 0, 0, 0, 5));
        cardDeck2.add(new Card(4, 2, 0, 0, 0, 5, 3));
        cardDeck2.add(new Card(4, 3, 0, 0, 0, 0, 6));
        cardDeck3.add(new Card(4, 3, 3, 5, 3, 3, 0));
        cardDeck3.add(new Card(4, 4, 0, 3, 0, 6, 3));
        cardDeck3.add(new Card(4, 4, 0, 0, 0, 7, 0));
        cardDeck3.add(new Card(4, 5, 0, 0, 0, 7, 3));
        //Czerwone
        cardDeck1.add(new Card(5, 0, 0, 3, 0, 0, 0));
        cardDeck1.add(new Card(5, 0, 3, 1, 1, 0, 0));
        cardDeck1.add(new Card(5, 0, 0, 0, 0, 2, 1));
        cardDeck1.add(new Card(5, 0, 2, 2, 0, 0, 1));
        cardDeck1.add(new Card(5, 0, 1, 2, 0, 1, 1));
        cardDeck1.add(new Card(5, 0, 1, 1, 0, 1, 1));
        cardDeck1.add(new Card(5, 0, 0, 2, 2, 0, 0));
        cardDeck1.add(new Card(5, 1, 0, 4, 0, 0, 0));
        cardDeck2.add(new Card(5, 1, 3, 0, 2, 3, 0));
        cardDeck2.add(new Card(5, 1, 3, 2, 2, 0, 0));
        cardDeck2.add(new Card(5, 2, 0, 1, 0, 4, 2));
        cardDeck2.add(new Card(5, 2, 5, 3, 0, 0, 0));
        cardDeck2.add(new Card(5, 2, 5, 0, 0, 0, 0));
        cardDeck2.add(new Card(5, 3, 0, 0, 6, 0, 0));
        cardDeck3.add(new Card(5, 3, 3, 3, 0, 5, 3));
        cardDeck3.add(new Card(5, 4, 0, 0, 0, 0, 7));
        cardDeck3.add(new Card(5, 4, 0, 0, 3, 3, 6));
        cardDeck3.add(new Card(5, 5, 0, 0, 3, 0, 7));
        //Białe
        cardDeck1.add(new Card(2, 0, 1, 0, 0, 2, 2));
        cardDeck1.add(new Card(2, 0, 1, 0, 2, 0, 0));
        cardDeck1.add(new Card(2, 0, 1, 0, 1, 1, 1));
        cardDeck1.add(new Card(2, 0, 0, 0, 0, 3, 0));
        cardDeck1.add(new Card(2, 0, 0, 0, 0, 2, 2));
        cardDeck1.add(new Card(2, 0, 1, 0, 1, 1, 2));
        cardDeck1.add(new Card(2, 0, 1, 3, 0, 1, 0));
        cardDeck1.add(new Card(2, 1, 0, 0, 0, 0, 4));
        cardDeck2.add(new Card(2, 1, 2, 0, 2, 0, 3));
        cardDeck2.add(new Card(2, 1, 0, 2, 3, 3, 0));
        cardDeck2.add(new Card(2, 2, 2, 0, 4, 0, 1));
        cardDeck2.add(new Card(2, 2, 0, 0, 5, 0, 0));
        cardDeck2.add(new Card(2, 2, 3, 0, 5, 0, 0));
        cardDeck2.add(new Card(2, 3, 0, 6, 0, 0, 0));
        cardDeck3.add(new Card(2, 3, 3, 0, 5, 3, 3));
        cardDeck3.add(new Card(2, 4, 7, 0, 0, 0, 0));
        cardDeck3.add(new Card(2, 4, 6, 3, 3, 0, 0));
        cardDeck3.add(new Card(2, 5, 7, 3, 0, 0, 0));

        aristocratesDeck.add(new Aristocrate(4, 5));
        aristocratesDeck.add(new Aristocrate(1, 2));
        aristocratesDeck.add(new Aristocrate(1, 4));
        aristocratesDeck.add(new Aristocrate(2, 3));
        aristocratesDeck.add(new Aristocrate(3, 5));
        aristocratesDeck.add(new Aristocrate(2, 3, 5));
        aristocratesDeck.add(new Aristocrate(1, 4, 5));
        aristocratesDeck.add(new Aristocrate(1, 2, 4));
        aristocratesDeck.add(new Aristocrate(2, 3, 1));
        aristocratesDeck.add(new Aristocrate(3, 4, 5));

        int playerCount = b.getInt("playersNumber", 0);
        players.add(new Player("Gracz 1", b.getBoolean("p1", true), R.color.player1));
        players.add(new Player("Gracz 2", b.getBoolean("p2", true), R.color.player4));
        if (playerCount > 2){
            players.add(new Player("Gracz 3", b.getBoolean("p3", true), R.color.colorAccent));
            if (playerCount > 3){
                players.add(new Player("Gracz 4", b.getBoolean("p4", true), R.color.colorPrimary));
            }
        }

        Random rand = new Random();
        Collections.shuffle(cardDeck1, rand);
        Collections.shuffle(cardDeck2, rand);
        Collections.shuffle(cardDeck3, rand);
        Collections.shuffle(aristocratesDeck, rand);
        GameStateClient = new GameState(cardDeck1, cardDeck2, cardDeck3, aristocratesDeck, players);
        playerCount = GameStateClient.numberOfPlayers();
        setCard(GameStateClient.returnCard(3, 1), 3, 1);
        setCard(GameStateClient.returnCard(3, 2), 3, 2);
        setCard(GameStateClient.returnCard(3, 3), 3, 3);
        setCard(GameStateClient.returnCard(3, 4), 3, 4);
        setCard(GameStateClient.returnCard(2, 1), 2, 1);
        setCard(GameStateClient.returnCard(2, 2), 2, 2);
        setCard(GameStateClient.returnCard(2, 3), 2, 3);
        setCard(GameStateClient.returnCard(2, 4), 2, 4);
        setCard(GameStateClient.returnCard(1, 1), 1, 1);
        setCard(GameStateClient.returnCard(1, 2), 1, 2);
        setCard(GameStateClient.returnCard(1, 3), 1, 3);
        setCard(GameStateClient.returnCard(1, 4), 1, 4);

        switch (playerCount) {
            case 1:
                TableLayout ar1 = findViewById(R.id.ar1);
                TableLayout ar5 = findViewById(R.id.ar5);
                TableLayout ar3 = findViewById(R.id.ar3);
                ar3.setVisibility(View.INVISIBLE);
                ar1.setVisibility(View.INVISIBLE);
                ar5.setVisibility(View.INVISIBLE);
                setAristocrates(GameStateClient.returnAristocrate(0), 2);
                setAristocrates(GameStateClient.returnAristocrate(1), 4);
                break;
            case 2:
                ar1 = findViewById(R.id.ar1);
                ar5 = findViewById(R.id.ar5);
                ar1.setVisibility(View.INVISIBLE);
                ar5.setVisibility(View.INVISIBLE);
                setAristocrates(GameStateClient.returnAristocrate(0), 2);
                setAristocrates(GameStateClient.returnAristocrate(1), 3);
                setAristocrates(GameStateClient.returnAristocrate(2), 4);
                break;
            case 3:
                ar3 = findViewById(R.id.ar3);
                ar3.setVisibility(View.INVISIBLE);
                setAristocrates(GameStateClient.returnAristocrate(0), 1);
                setAristocrates(GameStateClient.returnAristocrate(1), 2);
                setAristocrates(GameStateClient.returnAristocrate(2), 4);
                setAristocrates(GameStateClient.returnAristocrate(3), 5);
                break;
            case 4:
                setAristocrates(GameStateClient.returnAristocrate(0), 1);
                setAristocrates(GameStateClient.returnAristocrate(1), 2);
                setAristocrates(GameStateClient.returnAristocrate(2), 3);
                setAristocrates(GameStateClient.returnAristocrate(3), 4);
                setAristocrates(GameStateClient.returnAristocrate(4), 5);
                break;
        }

        playerChips[0] = findViewById(R.id.chips1);
        playerChips[1] = findViewById(R.id.chips2);
        playerChips[2] = findViewById(R.id.chips3);
        playerChips[3] = findViewById(R.id.chips4);
        playerChips[4] = findViewById(R.id.chips5);

        playerCards[0] = findViewById(R.id.card1);
        playerCards[1] = findViewById(R.id.card2);
        playerCards[2] = findViewById(R.id.card3);
        playerCards[3] = findViewById(R.id.card4);
        playerCards[4] = findViewById(R.id.karta5);

        chips[0] = findViewById(R.id.zeton1);
        chips[1] = findViewById(R.id.zeton2);
        chips[2] = findViewById(R.id.zeton3);
        chips[3] = findViewById(R.id.zeton4);
        chips[4] = findViewById(R.id.zeton5);
        chips[5] = findViewById(R.id.zeton6);

        points = findViewById(R.id.punkty);

        tableLayouts = new TableLayout[12];
        tableLayouts[0] = findViewById(R.id.card_1_1);
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
            final TextView act_chips = playerChips[i];
            final int nr = i;
            act_chips.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (checked.size() != 0) {

                        for (int i = 0; i < 5; i++) {
                            if (checked.contains(i)) {
                                scaleView(playerChips[i], 1.2f, 1f);
                                checked.remove(Integer.valueOf(i));

                            }
                        }
                    }
                    scaleView(v, 1, 1.2f);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                    final View widok = v;
                    builder.setTitle("Prośba o potwierdzenie");
                    builder.setMessage("Czy chcesz dwa chips tego koloru?")
                            .setCancelable(false)
                            .setPositiveButton("TAK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    if (GameStateClient.getChips(nr) >= 4) {
                                        GameStateClient.decrementChips(nr);
                                        GameStateClient.decrementChips(nr);
                                        GameStateClient.returnPlayer().addChips(nr);
                                        GameStateClient.returnPlayer().addChips(nr);
                                        setChips();
                                        setPlayerField();
                                        AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
                                        alert.setTitle("Komunikat");
                                        alert.setMessage("Teraz tura następnego gracza");
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                            }
                                        });
                                        alert.show();
                                        if (!GameStateClient.nextPlayerTurn()) {
                                            computerPlayer();
                                        }
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                setPlayerField();
                                            }
                                        }, 1);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                                        builder.setTitle("Nieprawidlowy ruch");
                                        builder.setMessage("Nie mozesz wziac dwoch zetonow, jesli w stosie jest mniej niż 4")
                                                .setNeutralButton("OK", null);
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
                    int clickedChipsNr = returnNr(getResources().getResourceEntryName(act_chips.getId()));
                    if(!checked.contains(clickedChipsNr)){
                        scaleView(v, 1, 1.2f);
                        checked.add(clickedChipsNr);
                    }
                    else{
                        scaleView(v, 1.2f, 1f);
                        checked.remove(checked.indexOf(clickedChipsNr));
                    }
                    if (checked.size() == 3) {
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
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                setPlayerField();
            }
        }, 1);

    }

    public void chips_positive() {
        boolean status = true;
        for (int i = 0; i < 5; i++) {
            if (checked.contains(i)) {
                scaleView(playerChips[i], 1.2f, 1f);
                if (GameStateClient.getChips(i) == 0) {
                    status = false;
                }
            }

        }
        if (status) {
            for (int i = 0; i < 5; i++) {
                if (checked.contains(i)) {
                    GameStateClient.returnPlayer().addChips(i);
                    GameStateClient.decrementChips(i);
                }

            }
            checked.removeAll(checked);
            setChips();
            setPlayerField();
            AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
            alert.setTitle("Komunikat");
            alert.setMessage("Teraz tura następnego gracza");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!GameStateClient.nextPlayerTurn()) {
                        computerPlayer();
                    }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            setPlayerField();
                        }
                    }, 1);
                }
            });
            alert.show();

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
            builder.setTitle("Nieprawidlowy ruch");
            builder.setMessage("Nie mozesz wziac zetonow, jesli w stosie juz ich nie ma")
                    .setNeutralButton("OK", null);
            builder.create().show();
        }
    }

    public void chips_negative() {
        for (int i = 0; i < 5; i++) {
            if (checked.contains(i)) {
                scaleView(playerChips[i], 1.2f, 1f);
                checked.remove(checked.indexOf(i));
            }
        }
        setChips();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                setPlayerField();
            }
        }, 1);
    }

    public void setChips() {
        playerChips[0].setText(GameStateClient.getChipsStr(0));
        playerChips[1].setText(GameStateClient.getChipsStr(1));
        playerChips[2].setText(GameStateClient.getChipsStr(2));
        playerChips[3].setText(GameStateClient.getChipsStr(3));
        playerChips[4].setText(GameStateClient.getChipsStr(4));
    }

    public void setPlayerField() {
        for (int i = 0; i < 5; i++) {
            playerCards[i].setText(GameStateClient.returnPlayer().getCardSymbolsStr(i));
            chips[i].setText(GameStateClient.returnPlayer().getChipsStr(i));
        }
        chips[5].setText(GameStateClient.returnPlayer().getChipsStr(5));
        points.setText(GameStateClient.returnPlayer().getPointsStr());
        View playerBackground = findViewById(R.id.tlo);
        playerBackground.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(GameStateClient.returnPlayer().getBackground())));
    }

    public void unsetAristocrate(int nr) {
        TableLayout ar1 = findViewById(R.id.ar1);
        TableLayout ar2 = findViewById(R.id.ar2);
        TableLayout ar3 = findViewById(R.id.ar3);
        TableLayout ar4 = findViewById(R.id.ar4);
        TableLayout ar5 = findViewById(R.id.ar5);
        TableLayout[] ar = new TableLayout[5];
        ar[0] = ar1;
        ar[1] = ar2;
        ar[2] = ar3;
        ar[3] = ar4;
        ar[4] = ar5;
        int status = 0;
        for (int i = 0; i < 5; i++) {
            if (ar[i].getVisibility() != View.INVISIBLE) {
                if (status == nr) {
                    ar[i].setVisibility(View.INVISIBLE);
                }
                status++;
            }
        }
    }

    public void setAristocrates(Aristocrate ar, int nr) {
        TextView w1;
        TextView w2;
        TextView w3;
        int ile = ar.getFields();
        switch (nr) {
            case 1:
                w1 = findViewById(R.id.ar1Con2);
                w2 = findViewById(R.id.ar1con3);
                w3 = findViewById(R.id.ar1Con1);

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
                break;
            case 2:
                w1 = findViewById(R.id.ar2Con2);
                w2 = findViewById(R.id.ar2Con3);
                w3 = findViewById(R.id.ar2Con1);

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
                break;
            case 3:
                w1 = findViewById(R.id.ar3Con2);
                w2 = findViewById(R.id.ar3Con3);
                w3 = findViewById(R.id.ar3Con1);

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
                break;
            case 4:
                w1 = findViewById(R.id.ar4Con2);
                w2 = findViewById(R.id.ar4Con3);
                w3 = findViewById(R.id.ar4Con1);

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
                break;
            case 5:
                w1 = findViewById(R.id.ar5Con2);
                w2 = findViewById(R.id.ar5Con3);
                w3 = findViewById(R.id.ar5Con1);

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
                break;

        }

    }

    public void clickCard(View view) {
        int clickedCard = -1;
        for (int i = 0; i < 12; i++) {
            if (tableLayouts[i].getId() == view.getId()) {
                clickedCard = i;
            }
        }

        if (chosenCard != clickedCard) {
            setOpacityCards(0.5f);
            view.setAlpha(1.0f);
            scaleView(view, 1, 1.05f);
            scaleView(view, 1.05f, 1f);
            chosenCard = clickedCard;
        } else {
            int era = clickedCard / 4 + 1;
            int nr = clickedCard % 4 + 1;
            if (GameStateClient.canObtain(GameStateClient.returnCard(era, nr), GameStateClient.returnPlayer())) {
                GameStateClient.swapCard(era, nr); //rowniez dodaje karte graczowi
                int ktory = GameStateClient.checkAristocrate(GameStateClient.returnPlayer());
                if (ktory != -1) {
                    unsetAristocrate(ktory);
                }
                setCard(GameStateClient.returnCard(era, nr), era, nr);
                setChips();
                setPlayerField();
                AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
                alert.setTitle("Info");
                alert.setMessage("Teraz tura następnego gracza");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!GameStateClient.nextPlayerTurn()) {
                            computerPlayer();
                        }
                        setOpacityCards(1f);
                        chosenCard = -44;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                setPlayerField();
                            }
                        }, 1);
                    }
                });
                alert.show();

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
                builder.setTitle("Nieprawidlowy ruch");
                builder.setMessage("Nie mozesz wziac kart jeśli Cię na nią nie stać")
                        .setNeutralButton("OK", null);
                builder.create().show();
            }
            clickedCard = -1;
        }
    isWin();
    }

    public void clickCardComputer(int era, int nr) {
        //Toast.makeText(this, era+" "+nr, Toast.LENGTH_LONG).show();
        GameStateClient.swapCard(era, nr); //rowniez dodaje karte graczowi
        int ktory = GameStateClient.checkAristocrate(GameStateClient.returnPlayer());
        if (ktory != -1) {
            unsetAristocrate(ktory);
        }
        setCard(GameStateClient.returnCard(era, nr), era, nr);
        setChips();
        setPlayerField();
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
                alert.setTitle("KOMP KLIK KARD");
                alert.setMessage("Teraz tura następnego gracza");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!GameStateClient.nextPlayerTurn()) {
                            computerPlayer();
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                setPlayerField();
                            }
                        }, 1);
                    }
                });
                alert.show();
            }
        }, 2000);
    isWin();
    }

    public int returnNr(String s) {
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
            TextView tvPoints = findViewById(R.id.points_1_1);
            TableLayout tlColor = findViewById(R.id.card_1_1);
            tlColor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            tvPoints.setText(card.getPointsStr());
        }
        if (era == 1 && nr == 2) {
            TextView w1 = findViewById(R.id.wymaganie_1_karta_1_2);
            TextView w2 = findViewById(R.id.wymaganie_2_karta_1_2);
            TextView w3 = findViewById(R.id.wymaganie_3_karta_1_2);
            TextView w4 = findViewById(R.id.wymaganie_4_karta_1_2);
            TextView punkty = findViewById(R.id.punkty_1_2);
            TableLayout kolor = findViewById(R.id.karta_1_2);
            kolor.setBackground(getDrawable(card.getColorDrawable()));
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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
            w4.setBackground(getDrawable(card.getWym1Background()));
            w3.setBackground(getDrawable(card.getWym2Background()));
            w1.setBackground(getDrawable(card.getWym3Background()));
            w2.setBackground(getDrawable(card.getWym4Background()));
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

    public void computerPlayer() {
        int decision = GameStateClient.decision(GameStateClient.returnPlayer());
        int decisionCheck = GameStateClient.checkDecision(GameStateClient.returnPlayer());
        Toast.makeText(this, "ile kart"+decisionCheck, Toast.LENGTH_LONG).show();
        if (decision != -1) {
            int era = decision / 10;
            int nr = decision % 10;
            clickCardComputer(era, nr);
        } else {
            int[] chipsState = GameStateClient.getChipsAll();
            ArrayList<Integer> choosen = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                if (chipsState[i] != 0) {
                    choosen.add(i);
                }
            }
            Collections.shuffle(choosen);
            if (choosen.size() > 2) {
                click3Chips(choosen.get(0), choosen.get(1), choosen.get(2));
            } else {
                for (int j = 0; j < choosen.size(); j++) {
                    if (choosen.get(j) >= 4) {
                        click2Chips(choosen.get(j));
                        break;
                    }
                }
            }
        }
    }

    public void click3Chips(int a, int b, int c) {
        GameStateClient.returnPlayer().addChips(a);
        GameStateClient.decrementChips(a);
        GameStateClient.returnPlayer().addChips(b);
        GameStateClient.decrementChips(b);
        GameStateClient.returnPlayer().addChips(c);
        GameStateClient.decrementChips(c);
        setChips();
        setPlayerField();
        AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
        alert.setTitle("Pobrano 3 razy 1 zeton");
        alert.setMessage("Teraz tura następnego gracza");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (!GameStateClient.nextPlayerTurn()) {
                    computerPlayer();
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        setPlayerField();
                    }
                }, 1);
            }
        });
        alert.show();
    }

    public void click2Chips(int nr) {
        GameStateClient.decrementChips(nr);
        GameStateClient.decrementChips(nr);
        GameStateClient.returnPlayer().addChips(nr);
        GameStateClient.returnPlayer().addChips(nr);
        setChips();
        setPlayerField();
        AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
        alert.setTitle("Pobrano 2 takie same zetony");
        alert.setMessage("Teraz tura następnego gracza");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (!GameStateClient.nextPlayerTurn()) {
                    computerPlayer();
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        setPlayerField();
                    }
                }, 1);
            }
        });
        alert.show();

    }

    public void isWin(){
        if (GameStateClient.returnPlayer().getPoints() >= 15){
            AlertDialog.Builder alert = new AlertDialog.Builder(Game.this);
            alert.setTitle("Wygrana");
            alert.setMessage("Wygral gracz"+ GameStateClient.returnPlayer().getName());
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            alert.show();
        }
    }
}