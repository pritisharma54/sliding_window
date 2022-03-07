import java.util.*;
public class Solution {
	public static int getLengthofLongestSubstring(int k, String s) {
		// Write your code here.
        int i=0,j=0;
        int ans_win=Integer.MIN_VALUE;

        HashMap<Character,Integer> mp = new HashMap<>();

        while(j<s.length()){
            //calculations
            char c=s.charAt(j);
            mp.put(c, mp.getOrDefault(c, 0)+1);
            
           
                while(mp.size() > k){
                    char ci=s.charAt(i);
                    if(mp.containsKey(ci))
                        mp.put(ci,mp.get(ci)-1);
                    if(mp.get(ci) == 0)
                        mp.remove(ci);
                    i++;
                 }
             ans_win=Math.max(ans_win,j-i+1);

            j++;
        }

        return ans_win;

            

	}
}
