package com.davidslager.bibleparser;

import com.davidslager.bible.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

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
                int typeNumber = Integer.parseInt(line.split(" ")[0]);
                BookType type = Stream.of(
                        BookTypeOldTestament.valueOf(typeNumber),
                        BookTypeNewTestament.valueOf(typeNumber)
                    )
                        .filter(Optional::isPresent)
                        .findFirst()
                        .get().orElse(null);
                book.setType(type);
                line = line.substring(4); // remove three digit chapter number
                book.setName(extractBookName(line));
                line = br.readLine(); // read first line with verse
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

    /**
     * Extracts the book name out of the book title line.
     * @param line the line that contains the book name.
     *             Might look something like {@code "Deuteronomy 5 Mose (Deuteronomium) - Deuteronomy"}.
     * @return the book name
     */
    private static String extractBookName(String line) {
        var words = line.split("-");
        if (words.length == 1) return words[0];
        // transform <english name> <local name> - <english name> into <local name>
        return words[0].trim().replaceFirst(words[1].trim().replaceAll(" ", ""), "").trim();
    }
}