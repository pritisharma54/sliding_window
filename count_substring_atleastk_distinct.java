public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0;

        long ans = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.size() >= k) {
                //n-1-end+1=n-end
                ans += s.length()-end;
                char pre = s.charAt(begin);
                if (map.containsKey(pre)) {
                    map.put(pre, map.getOrDefault(pre, 0) - 1);
                    if (map.get(pre) == 0) {
                        map.remove(pre);
                    }
                }
               
                begin++;
            }
        end++;
        }
        
         

        return ans;
    }
}
