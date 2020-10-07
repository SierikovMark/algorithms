package org.algorithms.leetcode;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int k = i + 1;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (end - start < k - j + 1) {
                    start = j;
                    end = k + 1;
                }
                j--;
                k++;
            }
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (end - start < k - j + 1) {
                    start = j;
                    end = k + 1;
                }
                j--;
                k++;
            }
        }
        return s.substring(start, end);
    }

    public static String longestPalindromeBruteForce(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring)) {
                    if (longest.length() < substring.length()) {
                        longest = substring;
                    }
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("fkyidosnupvunmklebjiepwdmfhqjfjgtcdivzgibcewxviirtneumvhcwzvstvtnzrnzknehahdipswtvgmqhmexnjtqcpngvojdxmhwqhrdcgybehvrfsqkroaztrhyeuuzkthfhwtbfnyghlzjqsqjpqvsrkabcxylpgylzzgyzmhruqyezfcvzcmzzuvtxlbfyukhvnytetagrhsebodddqiowahvflakfkefzlwkdjyxtymypkqkeniriybvdcfnqogilpeiviatavcbtxogxenbfhpfqklrekqefzjunpzrenqhorpqnhxllceubkndibdypbmbjscnryafertbursmghissihgmsrubtrefayrncsjbmbpydbidnkbuecllxhnqprohqnerzpnujzfeqkerlkqfphfbnexgoxtbcvataiviepligoqnfcdvbyirinekqkpymytxyjdkwlzfekfkalfvhawoiqdddobeshrgatetynvhkuyfblxtvuzzmczvcfzeyqurhmzygzzlygplyxcbakrsvqpjqsqjzlhgynfbtwhfhtkzuueyhrtzaorkqsfrvhebygcdrhqwhmxdjovgnpcqtjnxemhqmgvtwspidhahenkznrzntvtsvzwchvmuentriivxwecbigzvidctgjfjqhfmdwpeijbelkmnuvpunsodiykf"));
        System.out.println(longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz"));
    }
}
