package org.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTest {

    WordSearch wordSearch = new WordSearch();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(true,
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCESEEEFS"))
                .add(Arguments.of(false,
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCCED"))
                .add(Arguments.of(true,
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "SEE"))
                .add(Arguments.of(false,
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'}
                        }, "ABCB"))
                .build();
    }


    @ParameterizedTest
    @MethodSource("testData")
    void test(boolean expected, char[][] board, String word) {
        boolean exist = wordSearch.exist(board, word);
        assertEquals(expected, exist);
    }

}