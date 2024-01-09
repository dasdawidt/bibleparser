package com.davidslager.bible;

import java.util.Arrays;
import java.util.Optional;

public enum BookTypeOldTestament implements BookType {
    GENESIS(1),
    EXODUS(2),
    LEVITICUS(3),
    NUMBERS(4),
    DEUTERONOMY(5),
    JOSHUA(6),
    JUDGES(7),
    RUTH(8),
    FIRST_SAMUEL(9),
    SECOND_SAMUEL(10),
    FIRST_KINGS(11),
    SECOND_KINGS(12),
    FIRST_CHRONICLES(13),
    SECOND_CHRONICLES(14),
    EZRA(15),
    NEHEMIAH(16),
    ESTHER(17),
    JOB(18),
    PSALM(19),
    PROVERBS(20),
    ECCLESIASTES(21),
    SONG_OF_SOLOMON(22),
    ISAIAH(23),
    JEREMIAH(24),
    LAMENTATIONS(25),
    EZEKIEL(26),
    DANIEL(27),
    HOSEA(28),
    JOEL(29),
    AMOS(30),
    OBADIAH(31),
    JONAH(32),
    MICAH(33),
    NAHUM(34),
    HABAKKUK(35),
    ZEPHANIAH(36),
    HAGGAI(37),
    ZECHARIAH(38),
    MALACHI(39);

    private final int value;

    public static Optional<BookTypeOldTestament> valueOf(int value) {
        return Arrays.stream(BookTypeOldTestament.values())
                .filter(t -> t.getValue() == value)
                .findFirst();
    }

    BookTypeOldTestament(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
