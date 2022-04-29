
/*
    Time Complexity - O(N)
    Space Complexity - O(1)

    where N is the length of the array.
    https://www.codingninjas.com/codestudio/problems/minimum-subarray-with-required-sum_696460?leftPanelTab=0
 */
import java.util.ArrayList;

public class Solution 
{

	public static ArrayList<Integer> minSubarray(ArrayList<Integer> arr, int n, int x) 
    {
		int startIndex = 0, minLength = n + 1;

		// Variables to keep track of the current window
		int start = 0, end = 0;

		int sum = 0;

		while (end < n) 
        {
			// Add a new element to the window's sum
			sum += arr.get(end);

			// While the sum exceeds the X
			while (sum > x) 
            {
				if (end - start + 1 < minLength) 
                {
					minLength = end - start + 1;
					startIndex = start;
				}

				// Shrink the window
				sum -= arr.get(start);
				start++;
			}

			// Expand the window
			end++;
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();

		// IF no such subarray exist, return empty subarray
		if (minLength == n + 1) 
        {
			return ans;
		}

		for (int i = startIndex; i < startIndex + minLength; i++) 
        {
			ans.add(arr.get(i));
		}

		return ans;
	}
}
