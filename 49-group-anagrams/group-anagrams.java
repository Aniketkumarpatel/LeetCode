 import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: sorted word -> list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // convert string to char array and sort
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // add to map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        
        // return grouped values
        return new ArrayList<>(map.values());
    }

    // Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        
        List<List<String>> result = sol.groupAnagrams(strs);
        System.out.println(result);
    }
}