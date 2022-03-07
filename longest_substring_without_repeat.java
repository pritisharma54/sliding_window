import java.util.*;

public class Solution {
        
	public static int lengthOfLongestSubstring(String s) {
		// Write your code here.
        if(s.length() == 0)
            return 0;
        int i=0,j=0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int ans_win=Integer.MIN_VALUE;
        
        while(j<s.length()){
            char ch=s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            
            if(mp.size() == j-i+1){
                ans_win=Math.max(ans_win,j-i+1);
                j++;
            }
            else if(mp.size() < j-i+1){
                 while(mp.size() < j-i+1){
						char ci=s.charAt(i);
                        if(mp.containsKey(ci)){
                            mp.put(ci,mp.get(ci)-1);
                        }
                        if(mp.get(ci)==0){
                            mp.remove(ci);
                        }
                        i++;
                    }
                    j++;
               }
          }
            
            return ans_win;
            
            
        }
       
}
