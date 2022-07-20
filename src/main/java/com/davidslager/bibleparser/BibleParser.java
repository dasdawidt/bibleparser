package com.davidslager.bibleparser;

import com.davidslager.bible.Book;
import com.davidslager.bible.Chapter;
import com.davidslager.bible.Translation;
import com.davidslager.bible.Verse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Locale;

abstract class BibleParser {

    public static Translation parse(File file) throws IOException {
        BufferedReader br;
        Translation translation = new Translation();
        br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8));
        br.readLine();
        String line = br.readLine();
        while (!line.startsWith("=ALL")) {
            if (line.startsWith("=")) { //start of book
                line = line.substring(1); //remove "=" prefix
                Book book = new Book();
                book.setNumber(Integer.parseInt(line.split(" ")[0]));
                book.setName(line.split(" ")[1]);
                line = br.readLine();
                book.setAbbreviation(line.split(" ")[0]);
                System.out.println(book.getName().toUpperCase(Locale.ROOT) + ": '" + book.getAbbreviation().toLowerCase(Locale.ROOT) + "',");
                while (!line.startsWith("END")) { //inside book
                    Chapter chapter = new Chapter();
                    String chapterAndVerse = line.split(" ")[1]; //cc:vv
                    chapter.setNumber(Integer.parseInt(chapterAndVerse.split(":")[0]));
                    while (line.startsWith(book.getAbbreviation() + " " + chapter.getNumber())) {
                        Verse verse = new Verse();
                        chapterAndVerse = line.split(" ")[1]; //cc:vv
                        verse.setNumber(Integer.parseInt(chapterAndVerse.split(":")[1]));
                        int startOfText = line.lastIndexOf(chapterAndVerse) + chapterAndVerse.length() + 1;
                        verse.setText(line.substring(startOfText));
                        chapter.getVerses().add(verse);
                        line = br.readLine();
                    }
                    book.getChapters().add(chapter);
                }
                translation.getBooks().add(book);
            }
            line = br.readLine();
        }
        br.close();
        return translation;
    }
}