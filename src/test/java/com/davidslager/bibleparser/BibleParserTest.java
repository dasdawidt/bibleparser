package com.davidslager.bibleparser;

import com.davidslager.bible.Translation;

import javax.json.bind.JsonbBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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
        try (
                var writer = new PrintWriter("bible.json");
                var jsonb = JsonbBuilder.create()
        ) {
            writer.write(jsonb.toJson(translation));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}