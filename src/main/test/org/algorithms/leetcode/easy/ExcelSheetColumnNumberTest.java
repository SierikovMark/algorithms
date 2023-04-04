package org.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelSheetColumnNumberTest {

    ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();

    public static Stream<Arguments> testData() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("A", 1))
                .add(Arguments.of("AB", 28))
                .add(Arguments.of("ZY", 701))
                .build();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void should_return_proper_value(String input, int expectedColumnNumber) {
        int columnNumber = excelSheetColumnNumber.titleToNumber(input);
        assertEquals(expectedColumnNumber, columnNumber);
    }


}