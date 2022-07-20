package com.davidslager.bible;

import java.util.ArrayList;

public class Book {
    private int number;
    private String abbreviation;
    private String name;
    private ArrayList<Chapter> chapters = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Book %s]\t%s\t(%s)", number, name, abbreviation));
        for (Chapter chapter : chapters) {
            sb.append("\n");
            sb.append(chapter.toString());
        }
        return sb.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}