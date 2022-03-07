public class Solution {
    
    public static String smallestWindow(String A, String B) {
        if(B.length() > A.length()) return "";

        return MinimumWindow(A.toCharArray(), B.toCharArray());

    }
     public static String MinimumWindow(char[] s, char[] t){
        
        int start = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        int m[] = new int[256];

        for(int i=0;i<t.length;i++){
            if(m[t[i]] == 0) count++;
            m[t[i]]++;
        }
        int i=0;
        int j=0;

        while(j < s.length){
            
            m[s[j]]--;

            if(m[s[j]] == 0)
                count--;

            if(count == 0){

                while(count == 0){

                    if(ans > j - i +1 ){
                        ans = Math.min(ans, j -i +1 );
                        start = i;
                    }

                    m[s[i]]++;
                    if(m[s[i]] > 0){
                        count++;
                    }
                    i++;

                }

            }
            j++;
        }
        if(ans != Integer.MAX_VALUE){
            return String.valueOf(s).substring(start, start + ans);
        }
        return "" ;

    }

}
