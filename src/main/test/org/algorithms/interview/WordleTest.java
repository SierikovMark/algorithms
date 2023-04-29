package org.algorithms.interview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordleTest {

    Wordle wordle = new Wordle();

    @Test
    void should_ThrowRuntimeException_when_GuessedWordIsNull() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> wordle.findMatch(null, "SPEED")
        );

        assertEquals("Guessed word cannot be null", exception.getMessage());
    }

    @Test
    void should_ThrowRuntimeException_when_SecretWordIsNull() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> wordle.findMatch("SPEED", null)
        );

        assertEquals("Secret word cannot be null", exception.getMessage());
    }

    @Test
    void should_ThrowRuntimeException_when_LengthDoesntMatch() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> wordle.findMatch("SPEED", "NEED")
        );

        assertEquals("Guessed word should be the same length as secret word", exception.getMessage());
    }

    @Test
    void checkSameWord() {
        List<String> expected = List.of("GREEN", "GREEN", "GREEN", "GREEN", "GREEN");
        List<String> result = wordle.findMatch("SPEED", "SPEED");
        assertEquals(expected, result);
    }

    @Test
    void checkAllLettersAreDifferent() {
        List<String> expected = List.of("GRAY", "GRAY", "GRAY", "GRAY", "GRAY");
        List<String> result = wordle.findMatch("AAAAA", "BBBBB");
        assertEquals(expected, result);
    }

    @Test
    void checkThatOnlyOneLetterIsMarkedAsYellow() {
        List<String> expected = List.of("GRAY", "GRAY", "GRAY", "GRAY", "GREEN");
        List<String> result = wordle.findMatch("AAAAA", "BBBBA");
        assertEquals(expected, result);
    }

    @Test
    void checkComplexCase() {
        List<String> expected = List.of("YELLOW", "YELLOW", "GREEN", "YELLOW", "YELLOW");
        List<String> result = wordle.findMatch("AAABB", "BBAAA");
        assertEquals(expected, result);
    }

}