package com.davidslager.bible;

import java.util.ArrayList;

public class Translation {
    private String id;
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Translation %s]\t%s", id, name));
        for (Book book : books) {
            sb.append("\n");
            sb.append(book.toString());
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}