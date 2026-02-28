 class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split by one or more spaces
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse using StringBuilder
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}