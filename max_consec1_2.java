// max consec 1s with k=1 leetcode
//https://www.codingninjas.com/codestudio/problems/flip-bit-to-win_1229408?leftPanelTab=0
public class Solution {
    public static int flipBit(int input) {
        // Write your code here.
		int k=1;
		char[] nums = Integer.toBinaryString(input).toCharArray();
		
		int start = 0, max_len = 0, zero_count = 0;
        for(int end = 0 ; end < nums.length ; end++) {
            if(nums[end] == '0') zero_count++;
            while(zero_count > k) {
                if(nums[start] == '0') zero_count--;
                start++;
            }
            max_len = Math.max(max_len, end - start + 1);
        }
        return max_len;
    }
}
