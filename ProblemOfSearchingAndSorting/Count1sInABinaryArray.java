package ProblemOfSearchingAndSorting;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Count1sInABinaryArray {
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int CountOne1(int []arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				count++;
			}
		}
		return count;
	}
	
//	Process2
//	Time Complexity:O(logN)
//	Space Complexity:O(logN)
	public static int CountOne2(int arr[],int low,int high) {
		if(high>=low) {
			int mid=(low+high)/2;
			if(arr[mid]==0) {
				return CountOne2(arr, low, mid-1);
			}
			else {
				if(arr[mid+1]==0 || mid==high) {
					return mid+1;
				}
				else {
					return CountOne2(arr, mid+1, high);
				}
			}
			
		}
		return 0;
	}

//	Process3
//	Time Complexity:O(logN)
//	Space Complexity:O(1)
	public static int CountOne3(int arr[]) {
		int n=arr.length;
		int low=0;
		int high=n-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==0) {
				high=mid-1;
			}
			else {
				if(arr[mid+1]==0 || mid==n-1) {
					return mid+1;
				}
				else {
					low=mid+1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int arr[]= {1,1,1,1,1,1,0,0,0,0};
		int arr1[]= {1,1,1,0,0};
		
//		arr element is only 0 and 1
		
//		Process1
		System.out.println("Process1:");
		System.out.println(CountOne1(arr));
		System.out.println(CountOne1(arr1));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(CountOne2(arr,0,arr.length-1));
		System.out.println(CountOne2(arr1,0,arr1.length-1));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(CountOne3(arr));
		System.out.println(CountOne3(arr1));
		System.out.println();
	}
}
