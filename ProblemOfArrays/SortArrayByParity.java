package ProblemOfArrays;

import java.util.Scanner;

public class SortArrayByParity {
	
	public static void Print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static int[] ArrayParityProc1(int []arr) {
		int n=arr.length;
		int result[]=new int[n];
		int k=0;
		for(int i=0;i<n;i++) {
			if(arr[i]%2==0) {
				result[k]=arr[i];
				k++;
			}
		}
		for(int i=0;i<n;i++) {
			if(arr[i]%2!=0) {
				result[k]=arr[i];
				k++;
			}
		}
		return result;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] ArrayParityProc2(int []arr) {
		int i=0,j=arr.length-1;
		while(i<j) {
			if(arr[i]%2!=0) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j--;
			}
			else {
				i++;
			}
		}
		return arr;
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
		int ans1[]=ArrayParityProc1(arr);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2[]=ArrayParityProc2(arr1);
		Print(ans2);
	}
}
