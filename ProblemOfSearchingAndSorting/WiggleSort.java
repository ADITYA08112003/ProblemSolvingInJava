package ProblemOfSearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class WiggleSort {
//	process1
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static int[] Wiggle1(int []arr) {
		int n=arr.length;
		Arrays.sort(arr);
		for(int i=1;i<n-1;i+=2) {
			int temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
		}
		return arr;
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] Wiggle2(int []arr) {
		for(int i=1;i<arr.length;i+=2) {
			if(i>0 && arr[i]<arr[i-1]) {
				int temp=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
			if(i<arr.length-1 && arr[i]<arr[i+1]) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		return arr;
	}
	public static void Print(int arr[]) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
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
		int ans1[]=Wiggle1(arr);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2[]=Wiggle2(arr1);
		Print(ans2);
	}
}
