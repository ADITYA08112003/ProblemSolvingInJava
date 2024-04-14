package ProblemOfSearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class SortAnArrayOf012 {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static void SortColor1(int []arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
//	Process2
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static void SortColor2(int arr[]) {
		Arrays.sort(arr);
	}
	
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	2 passes/parses/iteration
//	Counting sort
	public static void SortColor3(int arr[]) {
		int c0=0,c1=0,c2=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				c0++;
			}
			else if(arr[i]==1) {
				c1++;
			}
			else {
				c2++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(i<c0) {
				arr[i]=0;
			}
			else if(i<c0+c1) {
				arr[i]=1;
			}
			else {
				arr[i]=2;
			}
		}
	}
	
//	Process4
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	1 Passes /parses/ iteration
	
	public static void swap(int arr[],int l,int h) {
		int temp=arr[l];
		arr[l]=arr[h];
		arr[h]=temp;
	}
	public static void SortColor4(int []arr) {
		int c=0,l=0,h=arr.length-1;
		while(c<=h) {
			if(arr[c]==0) {
				swap(arr,c,l);
				c++;
				l++;
			}
			else if(arr[c]==1) {
				c++;
			}
			else {
				swap(arr,c,h);
				h--;
			}
		}
	}
	public static void Print(int arr[]) {
		for(int i : arr) {
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
		int arr2[]=arr.clone();
		int arr3[]=arr.clone();
//		Process1
		System.out.println("Process1:");
		SortColor1(arr);
		Print(arr);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		SortColor2(arr1);
		Print(arr1);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		SortColor3(arr2);
		Print(arr2);
		System.out.println();
//		Process4
		System.out.println("Process4:");
		SortColor4(arr3);
		Print(arr3);
	}
}
