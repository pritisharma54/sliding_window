/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    Where N is the number of elements in the given array Arr.
    https://www.codingninjas.com/codestudio/problems/count-subarrays-having-product-less-than-k_1214643?leftPanelTab=0
*/

import java.util.ArrayList;

public class Solution {
	public static int countSubarrays(ArrayList<Integer> nums, int k) {
         if (k == 0) return 0;
        int cnt = 0;
        long pro = 1;
        for (int i = 0, j = 0; j < nums.size(); j++) {
            pro *= nums.get(j);
            while (i <= j && pro >= k) {
                pro /= nums.get(i++);
            }
            cnt += j - i + 1;
        }
        return cnt;    
	}
}
