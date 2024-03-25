package ProblemOfArrays;

import java.util.Scanner;

public class InversionsInAnArray {
//	Process1
//	Time Complexity:O(N^2) for global and O(N) for local
//	Space Complexity:O(1)
	public static boolean Inversion1(int[] arr,int n) {
//		global Inversion
		int c=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					c++;
				}
			}
		}
//		local Inversion
		int a=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				a++;
			}
		}
		if(a==c) {
			return true;
		}
		return false;
	}
//	Process2
//	Time Complexity:O(NlogN)
//	Space Comlexity:O(N)
	public static boolean Inversion2(int []arr,int n) {
		int local=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				local++;
			}
		}
		int global=mergesort(arr,0,n-1);
		return local==global;
	}
	private static int mergesort(int[] arr,int low,int high) {
		if(low==high) {
			return 0;
		}
		int mid=(low+high)/2;
		int leftans=mergesort(arr, low, mid);
		int rightans=mergesort(arr, mid+1, high);
		int mergeans=merge(arr,low,mid,high);
		return leftans+rightans+mergeans;
	}
	private static int merge(int []arr,int low,int mid,int high) {
		int n=mid-low+1;
		int m=high-mid;
		int leftarr[]=new int[n];
		int rightarr[]=new int[m];
		int count=0;
		int k=0;
		for(int i=low;i<=mid;i++) {
			leftarr[k++]=arr[i];
		}
		k=0;
		for(int i=mid+1;i<=high;i++) {
			rightarr[k++]=arr[i];
		}
		k=low;
		int i=0,j=0;
		while(i<n && j<m) {
			if(leftarr[i]<=rightarr[j]) {
				arr[k++]=leftarr[i];
				i++;
			}
			else {
				arr[k++]=rightarr[j];
				j++;
				count+=n-i;
			}
		}
		while(i<n) {
			arr[k++]=leftarr[i];
			i++;
		}
		while(j<m) {
			arr[k++]=rightarr[j];
			j++;
		}
		return count;
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
		System.out.println(Inversion1(arr,n));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(Inversion2(arr,n));
		System.out.println();
	}
}
