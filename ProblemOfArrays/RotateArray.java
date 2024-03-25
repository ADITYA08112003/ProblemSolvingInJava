//Problem3

package ProblemOfArrays;

import java.util.Scanner;

public class RotateArray {
	public static  void print(int []arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
//	Process1
//	Time Complexity:O(n*K)
//	Space Complexity:O(1)
	public static int[] RotateProcess1(int arr[],int n,int k) {
		int temp=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=temp;
		return arr;
	}
	
//	Process2
//	Time Complexity:O(n+K)
//	Space Complexity:O(K)
	public static int[] RotateProcess2(int arr[],int n,int k) {
		int temp[]=new int[k];
		int j=0;
		for(int i=n-k;i<n;i++) {
			temp[j]=arr[i];
			j++;
		}
		for(int i=n-1;i>=k;i--) {
			arr[i]=arr[i-k];
		}
		int k1=0;
		for(int i=0;i<k;i++) {
			arr[i]=temp[k1];
			k1++;
		}
		
		return arr;
	}
	
//	Process3
	public static  void reverse(int arr[],int l,int h) {
		int i=l,j=h;
		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
//	Time Complexity:O(n)
//	Space Complexity:O(1)
	
	public static int[] RotateProcess3(int arr[],int n,int k) {
		reverse(arr,n-k,n-1);
		reverse(arr,0,n-k-1);
		reverse(arr,0,n-1);
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int arr1[]=new int[n];
		for(int i=0;i<n;i++) {
			arr1[i]=arr[i];
		}
		int arr2[]=new int[n];
		for(int i=0;i<n;i++) {
			arr2[i]=arr[i];
		}
		System.out.print("Enter the number of Rotation:");
		int k=s.nextInt();
		k=k%n;
//		Process1
		System.out.println("Process1:");
		for(int i=1;i<=k;i++) {
			RotateProcess1(arr,n,k);
		}
		print(arr);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		RotateProcess2(arr1,n,k);
		print(arr1);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		RotateProcess3(arr2,n,k);
		print(arr2);
		System.out.println();
	}
}
