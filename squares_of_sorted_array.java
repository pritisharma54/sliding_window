//https://www.codingninjas.com/codestudio/problems/squares-of-a-sorted-array_1230552?leftPanelTab=0
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> sqsorted(ArrayList<Integer> arr) {
		// Write your code here.
		int n = arr.size();
		//ArrayList<Integer> squares = new ArrayList<>(n);
		int[] squares = new int[n];
		int highestSquareIdx = n - 1;
		int left = 0, right = n - 1;
		while (left <= right) {
		  int leftSquare = arr.get(left) *  arr.get(left);
		  int rightSquare =  arr.get(right) * arr.get(right);
		  if (leftSquare > rightSquare) {
			squares[highestSquareIdx--] = leftSquare;
			
			left++;
		  } else {

			squares[highestSquareIdx--] = rightSquare;
			
			right--;
		  }
		}
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0;i<squares.length;i++){
			result.add(squares[i]);
		}
		
		return result;
	}
}
