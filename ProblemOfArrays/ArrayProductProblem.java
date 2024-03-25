package ProblemOfArrays;

import java.util.Scanner;

public class ArrayProductProblem {
	public static void Print(int []arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static int[] Product1(int []arr,int n) {
		int output[]=new int[n];
		int leftpro=1;
		for(int i=0;i<n;i++) {
			if(i-1>=0) {
				leftpro*=arr[i-1];
			}
			int rightpro=1;
			for(int j=i+1;j<n;j++) {
				rightpro*=arr[j];
			}
			output[i]=leftpro*rightpro;
		}
		return output;
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static int[] Product2(int []arr,int n) {
		int left[]=new int[n];
		int right[]=new int[n];
		int output[]=new int[n];
		left[0]=1;
		for(int i=0;i<n;i++) {
			if(i-1>=0) {
				left[i]=left[i-1]*arr[i-1];
			}
		}
		right[n-1]=1;
		for(int i=n-1;i>=0;i--) {
			if(i+1<n) {
				right[i]=right[i+1]*arr[i+1];
			}
		}
		for(int i=0;i<n;i++) {
			output[i]=left[i]*right[i];
		}
		return output;
	}
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] Product3(int []arr,int n) {
		int left[]=new int[n];
		left[0]=1;
		for(int i=1;i<n;i++) {
			left[i]=left[i-1]*arr[i-1];
		}
		int right=1;
		for(int i=n-1;i>=0;i--) {
			left[i]=left[i]*right;
			right=right*arr[i];
		}
		return left;
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
		int ans1[]=Product1(arr,n);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2[]=Product2(arr,n);
		Print(ans2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		int ans3[]=Product3(arr,n);
		Print(ans3);
	}
}
