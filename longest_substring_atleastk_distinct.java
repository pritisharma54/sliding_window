public long kDistinctCharacters(String s, int k) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0;

        long ans = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            end++;
            

            while (map.size() >= k) {
                char pre = s.charAt(begin);
                if (map.containsKey(pre)) {
                    map.put(pre, map.getOrDefault(pre, 0) - 1);
                    if (map.get(pre) == 0) {
                        map.remove(pre);
                    }
                }
                ans += s.length() - end + 1;
                begin++;
            }
            
          
        }

        return ans;
    }
