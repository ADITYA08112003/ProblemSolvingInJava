//Problem11
package ProblemOfArrays;

import java.util.Arrays;
import java.util.Scanner;

//Process1
//Time Complexity:O(N^2)
//Space Complexity:O(1)
//All Arrays
public class SearchInRotatedSortedArray {
	public static boolean SearchProc1(int arr[],int n,int sum) {
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]+arr[j]==sum) {
					return true;
				}
			}
		}
		return false;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	Only Valid for Sorted Array
	public static boolean SearchProc2(int arr[],int n,int sum) {
		int l=0,r=n-1;
		for(int i=0;i<n;i++) {
			if(r>l) {
				if(arr[l]+arr[r]==sum) {
					return true;
				}
				else if(arr[l]+arr[r]>sum) {
					r--;
				}
				else {
					l++;
				}
			}
		}
		return false;
	}
	
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	All Arrays
	public static boolean SearchProc3(int arr[],int n,int sum) {
		int i=0;
		for(;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				break;
			}
		}
		int l=(i+1)%n;
		int r=i;
		while(l!=r) {
			if(arr[l]+arr[r]==sum) {
				return true;
			}
			else if(arr[l]+arr[r]<sum) {
				l=(l+1)%n;
			}
			else {
				r=(n+r-1)%n;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int arr2[]=arr.clone();
		System.out.print("SUM is:");
		int sum=s.nextInt();
//		Process1
		System.out.println("Process1:");
		System.out.println(SearchProc1(arr,n,sum));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		Arrays.sort(arr);
		System.out.println(SearchProc2(arr,n,sum));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(SearchProc3(arr2, n, sum));
	}
}
