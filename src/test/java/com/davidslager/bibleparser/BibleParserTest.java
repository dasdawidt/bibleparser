package com.davidslager.bibleparser;

import com.davidslager.bible.Translation;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BibleParserTest {

    @org.junit.jupiter.api.Test
    void parse() {
        File file = new File("C:\\Users\\David\\OneDrive\\Ablage\\Bibeln\\extrahiert\\glo\\books.txt");
        Translation translation = null;
        try {
            translation = BibleParser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(translation);
        System.out.println(translation);
    }
}