
import java.util.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> A, int K) 
	{
		//	  Write your code here.
        int N=A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>(); 
        int left=0;
        int right=0;
        int maxk=Integer.MIN_VALUE;
        while(right < N){
            // calculations
            while(q.size() > 0 && q.getLast() < A.get(right))
                q.removeLast();
            q.add(A.get(right));
            if(right-left+1 < K){
                right++; 
            } else if(right-left+1==K){
                // take ans from calculations and remove from queue
                ans.add(q.peek());  
                // sliding the window
                if(A.get(left)== q.peek()){  
                    q.poll();  
                }
                
                right++;
                left++;
            }
        }
       
        return ans;
	}
}
