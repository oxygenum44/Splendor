package com.oxygenum.splendor;

public class Aristocrate {
    private int wym1;
    private int wym2;
    private int wym3;

    public int getWym1() {
        return wym1;
    }

    public int getWym2() {
        return wym2;
    }

    public int getWym3() {
        return wym3;
    }

    public int getStatus() {
        return status;
    }

    private int status;

    public Aristocrate(int wym1, int wym2, int wym3) {
        this.status = 3;
        switch (wym1){
            case 1:
                this.wym1 = R.drawable.karta;
                break;
            case 2:
                this.wym1 = R.drawable.karta2;
                break;
            case 3:
                this.wym1 = R.drawable.karta3;
                break;
            case 4:
                this.wym1 = R.drawable.karta4;
                break;
            case 5:
                this.wym1 = R.drawable.karta5;
                break;
        }

        switch (wym2){
            case 1:
                this.wym2 = R.drawable.karta;
                break;
            case 2:
                this.wym2 = R.drawable.karta2;
                break;
            case 3:
                this.wym2 = R.drawable.karta3;
                break;
            case 4:
                this.wym2 = R.drawable.karta4;
                break;
            case 5:
                this.wym2 = R.drawable.karta5;
                break;
        }

        switch (wym3){
            case 1:
                this.wym3 = R.drawable.karta;
                break;
            case 2:
                this.wym3 = R.drawable.karta2;
                break;
            case 3:
                this.wym3 = R.drawable.karta3;
                break;
            case 4:
                this.wym3 = R.drawable.karta4;
                break;
            case 5:
                this.wym3 = R.drawable.karta5;
                break;
        }
    }

    public Aristocrate(int wym1, int wym2) {
        this.status = 2;
        switch (wym1){
            case 1:
                this.wym1 = R.drawable.karta;
                break;
            case 2:
                this.wym1 = R.drawable.karta2;
                break;
            case 3:
                this.wym1 = R.drawable.karta3;
                break;
            case 4:
                this.wym1 = R.drawable.karta4;
                break;
            case 5:
                this.wym1 = R.drawable.karta5;
                break;
        }

        switch (wym2){
            case 1:
                this.wym2 = R.drawable.karta;
                break;
            case 2:
                this.wym2 = R.drawable.karta2;
                break;
            case 3:
                this.wym2 = R.drawable.karta3;
                break;
            case 4:
                this.wym2 = R.drawable.karta4;
                break;
            case 5:
                this.wym2 = R.drawable.karta5;
                break;
        }
    }
}