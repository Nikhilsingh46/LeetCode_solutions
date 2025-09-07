class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        int printoutsum = 0;
        boolean hasCentralWord = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (wordCount.getOrDefault(reversed, 0) > 0) {
                palindromeLength += 4;
                wordCount.put(reversed, wordCount.get(reversed) - 1);
            } else {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && count > 0) {
                palindromeLength += 2;
                break; // Only one central word can be used
            }
        }

        return printoutsum;
    }
}
