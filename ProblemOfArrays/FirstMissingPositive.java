package ProblemOfArrays;
import java.util.*;
import java.util.Scanner;

public class FirstMissingPositive {
//	Process1
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static int FirstMis1(int arr[]) {
		Arrays.sort(arr);
		int k=1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==k) {
				k++;
			}
		}
		return k;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int FirstMis2(int nums[]) {
		int n = nums.length;
        
        // Check if 1 is present in the array
        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) {
            return 1;
        }
        
        // Replace non-positive and out-of-range elements with 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        
        // Mark visited elements by negating the value at index (element - 1)
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[val] = -Math.abs(nums[val]);
            }
        }
        
        // Find the first missing positive integer
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        
        if (nums[0] > 0) {
            return n;
        } else {
            return n + 1;
        }
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int arr1[]=arr.clone();
//		Process1
		System.out.println("Process1:");
		System.out.println(FirstMis1(arr));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(FirstMis2(arr1));
	}
}
