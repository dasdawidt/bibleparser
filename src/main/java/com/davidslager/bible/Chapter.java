package com.davidslager.bible;

import java.util.ArrayList;

public class Chapter {
    private int number;
    private ArrayList<Verse> verses = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Chapter %s]", number));
        for (Verse verse : verses) {
            sb.append("\n");
            sb.append(verse.toString());
        }
        return sb.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Verse> getVerses() {
        return verses;
    }

    public void setVerses(ArrayList<Verse> verses) {
        this.verses = verses;
    }
}
