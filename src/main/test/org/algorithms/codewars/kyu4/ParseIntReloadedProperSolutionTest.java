package org.algorithms.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseIntReloadedProperSolutionTest {

    ParseIntReloadedProperSolution parseIntReloadedProperSolution = new ParseIntReloadedProperSolution();

    @Test
    void test() {
        int result = parseIntReloadedProperSolution.parseInt("one million two hundred forty five thousand four hundred nine");
        assertEquals(1245409, result);
    }

    @Test
    void test1() {
        int result = parseIntReloadedProperSolution.parseInt("one million forty five thousand four hundred nine");
        assertEquals(1045409, result);
    }

}