package ProblemOfArrays;

import java.util.Scanner;

public class PartitionEqualSubsetSum {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static boolean Partition1(int arr[],int n) {
		int leftsum=0;
		for(int i=0;i<n;i++) {
			leftsum+=arr[i];
			int rightsum=0;
			for(int j=i+1;j<n;j++) {
				rightsum+=arr[j];
			}
			if(leftsum==rightsum) {
				return true;
			}
		}
		return false;
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static boolean Partition2(int arr[],int n) {
		int sum=0;
		for(int i : arr) {
			sum+=i;
		}
		int leftsum=sum;
		int rightsum=0;
		for(int j=n-1;j>=0;j--) {
			rightsum+=arr[j];
			leftsum-=arr[j];
			if(leftsum==rightsum) {
				return true;
			}
		}
		return false;
	}
	
//Process3
//	best process
//solved by dp
	public static  boolean canPartition(int[] nums) {
	    // Calculate the total sum of the array
	    int totalSum = 0;
	    for (int num : nums) {
	        totalSum += num;
	    }

	    // If the total sum is odd, it cannot be divided into two equal subsets
	    if (totalSum % 2 != 0) {
	        return false;
	    }

	    // Calculate the target sum, which is half of the total sum
	    int targetSum = totalSum / 2;

	    // Create a boolean array dp to represent whether it's possible to reach the sum i
	    boolean[] dp = new boolean[targetSum + 1];
	    dp[0] = true; // It's always possible to reach the sum 0

	    // Iterate through the array and update the dp array
	    for (int num : nums) {
	        for (int i = targetSum; i >= num; i--) {
	            // Update dp[i] based on whether it's possible to reach i - num
	            dp[i] = dp[i] || dp[i - num];
	        }
	    }

	    // The final result is stored in dp[targetSum], which represents whether
	    // it's possible to reach the target sum with a subset of the given array
	    return dp[targetSum];
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		
//		Process1
		System.out.println("Process1:");
		System.out.println(Partition1(arr,n));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(Partition2(arr,n));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(canPartition(arr));
	}
}
