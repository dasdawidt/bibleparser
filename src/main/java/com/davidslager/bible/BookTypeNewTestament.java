package com.davidslager.bible;

import java.util.Arrays;
import java.util.Optional;

public enum BookTypeNewTestament implements BookType {
    MATTHEW(101),
    MARK(102),
    LUKE(103),
    JOHN(104),
    ACTS(105),
    ROMANS(106),
    FIRST_CORINTHIANS(107),
    SECOND_CORINTHIANS(108),
    GALATIANS(109),
    EPHESIANS(110),
    PHILIPPIANS(111),
    COLOSSIANS(112),
    FIRST_THESSALONIANS(113),
    SECOND_THESSALONIANS(114),
    FIRST_TIMOTHY(115),
    SECOND_TIMOTHY(116),
    TITUS(117),
    PHILEMON(118),
    HEBREWS(119),
    JAMES(120),
    FIRST_PETER(121),
    SECOND_PETER(122),
    FIRST_JOHN(123),
    SECOND_JOHN(124),
    THIRD_JOHN(125),
    JUDE(126),
    REVELATION(127);

    private final int value;

    public static Optional<BookTypeNewTestament> valueOf(int value) {
        return Arrays.stream(BookTypeNewTestament.values())
                .filter(t -> t.getValue() == value)
                .findFirst();
    }

    BookTypeNewTestament(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
