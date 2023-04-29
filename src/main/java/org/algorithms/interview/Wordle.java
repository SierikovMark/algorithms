package org.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

public class Wordle {

    public List<String> findMatch(String guess, String secretWord) {
        validateInput(guess, secretWord);

        guess = guess.toLowerCase();
        secretWord = secretWord.toLowerCase();

        int length = secretWord.length();
        List<Boolean> takenPosition = new ArrayList<>();
        List<String> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            takenPosition.add(false);
        }

        for (int i = 0; i < length; i++) {
             char checkedLetter = guess.charAt(i);
             char checkedSecretLetter = secretWord.charAt(i);
             if (checkedLetter == checkedSecretLetter) {
                 takenPosition.set(i, true);
                 result.add("GREEN");
                 continue;
             }

            for (int j = 0; j < length; j++) {
                 if (i == j) {
                     continue;
                 }
                checkedSecretLetter = secretWord.charAt(j);
                 if (checkedLetter == checkedSecretLetter
                         && !takenPosition.get(j)
                         && guess.charAt(j) != checkedLetter) {
                     takenPosition.set(j, true);
                     result.add("YELLOW");
                     break;
                 }
            }

            if (result.size() < i + 1) {
                result.add("GRAY");
            }

        }

        return result;
    }

    private static void validateInput(String guess, String secretWord) {
        if (guess == null) {
            throw new RuntimeException("Guessed word cannot be null");
        }
        if (secretWord == null) {
            throw new RuntimeException("Secret word cannot be null");
        }
        if (guess.length() != secretWord.length()) {
            throw new RuntimeException("Guessed word should be the same length as secret word");
        }
    }
}
