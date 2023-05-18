package org.algorithms.learn;

import java.util.HashSet;
import java.util.Set;

public class ArrayPalindrome {

    boolean isPalindrome(String[] arr) {
        if (arr == null) {
            return false;
        }

        int arraySize = arr.length;
        if (arraySize == 0 || arraySize == 1) {
            return true;
        }

        int lo = 0;
        int hi = arraySize - 1;

        Set<Integer> modifiedIndexes = new HashSet<>();

        while (lo < hi) {
            String lowElement = arr[lo];
            String hiElement = arr[hi];

            if (lowElement.equals(hiElement)) {
                lo++;
                hi--;
                continue;
            }

            String lowCandidateShort = lowElement.substring(0, lowElement.length() - 1);

            if (lowCandidateShort.equals(hiElement) && lo + 1 != hi
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(lo)) {
                arr[lo + 1] = lowElement.charAt(lowElement.length() - 1) + arr[lo + 1];
                modifiedIndexes.add(lo);
                modifiedIndexes.add(lo + 1);
                lo++;
                hi--;
                continue;
            }

            if (lowCandidateShort.equals(lowElement.charAt(lowElement.length() - 1) + hiElement) && lo + 1 == hi) {
                return true;
            }

            String hiCandidateShort = hiElement.substring(1);

            if (lowCandidateShort.equals(hiCandidateShort)
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(hi - 1)
                    && !modifiedIndexes.contains(lo)) {
                arr[lo + 1] = lowElement.charAt(lowElement.length() - 1) + arr[lo + 1];
                arr[hi - 1] = arr[hi - 1] + hiElement.charAt(0);
                modifiedIndexes.add(lo);
                modifiedIndexes.add(hi);
                modifiedIndexes.add(lo + 1);
                modifiedIndexes.add(hi - 1);
                lo++;
                hi--;
                continue;
            }

            String hiCandidateExtended = arr[hi - 1].charAt(arr[hi - 1].length() - 1) + hiElement;

            if (lowElement.equals(hiCandidateExtended)
                    && !modifiedIndexes.contains(hi - 1)
                    && !modifiedIndexes.contains(lo)
                    && !modifiedIndexes.contains(hi)) {
                arr[hi - 1] = arr[hi - 1].substring(0, arr[hi - 1].length() - 1);
                modifiedIndexes.add(hi - 1);
                modifiedIndexes.add(hi);
                lo++;
                hi--;
                continue;
            }

            if (lowCandidateShort.equals(hiCandidateExtended)
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(hi - 1)
                    && !modifiedIndexes.contains(lo)
                    && !modifiedIndexes.contains(hi)) {
                arr[lo + 1] = lowElement.charAt(lowElement.length() - 1) + arr[lo + 1];
                arr[hi - 1] = arr[hi - 1] + hiElement.charAt(0);
                modifiedIndexes.add(lo);
                modifiedIndexes.add(hi);
                modifiedIndexes.add(lo + 1);
                modifiedIndexes.add(hi - 1);
                lo++;
                hi--;
                continue;
            }

            String lowCandidateExtended = lowElement + arr[lo + 1].charAt(0);

            if (lowCandidateExtended.equals(hiElement) && lo + 1 != hi
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(lo)) {
                arr[lo + 1] = arr[lo + 1].substring(1);
                modifiedIndexes.add(lo);
                modifiedIndexes.add(lo + 1);
                lo++;
                hi--;
                continue;
            }

            if (lowCandidateExtended.equals(hiElement.substring(1)) && lo + 1 == hi) {
                return true;
            }

            if (lowCandidateExtended.equals(hiCandidateShort)
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(hi - 1)
                    && !modifiedIndexes.contains(lo)
                    && !modifiedIndexes.contains(hi)) {
                arr[lo + 1] = arr[lo + 1].substring(1);
                arr[hi - 1] = arr[hi - 1] + hiElement.charAt(0);
                modifiedIndexes.add(lo);
                modifiedIndexes.add(hi);
                modifiedIndexes.add(lo + 1);
                modifiedIndexes.add(hi - 1);
                lo++;
                hi--;
                continue;
            }

            if (lowCandidateExtended.equals(hiCandidateExtended)
                    && !modifiedIndexes.contains(lo + 1)
                    && !modifiedIndexes.contains(hi - 1)
                    && !modifiedIndexes.contains(lo)
                    && !modifiedIndexes.contains(hi)) {
                arr[lo + 1] = arr[lo + 1].substring(1);
                arr[hi - 1] = arr[hi - 1].substring(0, arr[hi - 1].length() - 1);
                modifiedIndexes.add(lo);
                modifiedIndexes.add(hi);
                modifiedIndexes.add(lo + 1);
                modifiedIndexes.add(hi - 1);
                lo++;
                hi--;
                continue;
            }

            return false;
        }

        return true;
    }
}
