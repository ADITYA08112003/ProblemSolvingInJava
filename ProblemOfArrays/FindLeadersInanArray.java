//Problem10
package ProblemOfArrays;

import java.util.Scanner;

public class FindLeadersInanArray {
	
//	Process1
	
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static void FindLeaderProc1(int arr[],int n) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]<arr[j]) {
					max=Integer.MIN_VALUE;
					break;
				}
				else {
					max=arr[i];
				}
			}
			if(max==arr[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.print(arr[n-1]+" ");
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static void FindLeaderProc2(int []arr,int n) {
		int max=Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>max) {
				System.out.print(arr[i]+" ");
			}
			max=Math.max(max, arr[i]);
		}
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
		FindLeaderProc1(arr,n);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		FindLeaderProc2(arr, n);
	}
}
