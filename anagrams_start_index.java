import java.util.*;

public class Solution {
    public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
       // Write your code here.
        HashMap<Character,Integer> mp=new HashMap<>();
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(int i=0;i<m;i++){
            char c= ptr.charAt(i);
            if(mp.containsKey(c))
                mp.put(c,mp.get(c)+1);
            else{
                mp.put(c,1);
            }

        }

        int i=0,j=0;
        int count = mp.keySet().size();

        while(j<str.length()){
            char c=str.charAt(j);
            if(mp.containsKey(c))
                mp.put(c,mp.get(c)-1);

            if(mp.get(c) !=null && mp.get(c) == 0)
                count--;

            if(j-i+1<m)
                j++;
            else if(j-i+1==m){
                char ci=str.charAt(i);
                if(count == 0){
                    ans.add(i);

                }

                if(mp.containsKey(ci))
                    mp.put(ci,mp.get(ci)+1);

                if(mp.get(ci) !=null && mp.get(ci) == 1)
                    count++;

                i++;
                j++;
            }

        }

        return ans;
    }
}
