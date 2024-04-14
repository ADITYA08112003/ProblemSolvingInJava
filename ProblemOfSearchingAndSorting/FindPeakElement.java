package ProblemOfSearchingAndSorting;

import java.util.Scanner;

public class FindPeakElement {
	
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int Peak1(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>arr[i+1]) {
				return i;
			}
			
		}
		return arr.length-1;
	}
	
//	Process2
//	Time Complexity:O(logN)
//	Space Complexity:O(logN)
	public static int Peak2(int nums[],int start,int end) {
		int mid=(start+end)/2;
		if((mid==0 || nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])) {
			return mid;
		}
		else if(mid>0 && nums[mid-1]>nums[mid]) {
			return Peak2(nums,start,mid-1);
		}
		return Peak2(nums, mid+1, end);
	}
	
//	Process3
//	Time Complexity:O(logN)
//	Space Complexity:O(1)
	public static int Peak3(int []nums) {
		int start=0,end=nums.length-1;
		while(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]>nums[mid+1]) {
				end=mid;
			}
			else {
				start=mid+1;
			}
		}
		return start;
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
		System.out.println(Peak1(arr));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(Peak2(arr,0,n-1));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(Peak3(arr));
	}
}
