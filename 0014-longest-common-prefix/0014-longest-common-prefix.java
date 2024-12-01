class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the initial prefix
        String prefix = strs[0];

        // Iterate over the remaining strings
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix while it's not a prefix of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // No common prefix
            }
        }

        return prefix;
    }
}
