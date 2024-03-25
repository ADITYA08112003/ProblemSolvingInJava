package ProblemOfArrays;
import java.util.*;
import java.util.Scanner;

public class SortColors {
	public static void Print(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
//	Process1
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static int[] SortColorPro1(int []arr,int n) {
		Arrays.sort(arr);
		return arr;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] SortColorPro2(int[] arr,int n) {
		int c1=0,c2=0,c3=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==0) {
				c1++;
			}
			if(arr[i]==1) {
				c2++;
			}
			if(arr[i]==2) {
				c3++;
			}
		}
		int k=0;
		for(int i=0;i<c1;i++) {
			arr[k++]=0;
		}
		for(int i=0;i<c2;i++) {
			arr[k++]=1;
		}
		for(int i=0;i<c3;i++) {
			arr[k++]=2;
		}
		return arr;
	}
	
//	Process3
	private static void swap(int[] arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] SortColorPro3(int[] arr,int n) {
		int c=0,l=0,h=n-1;
		while(c<=h) {
			if(arr[c]==0) {
				swap(arr,c++,l++);
			}
			else if(arr[c]==1) {
				c++;
			}
			else {
				swap(arr,c,h--);
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
//		in a array only three types of input are present such '0' ,'1' ,'2'. 
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int arr1[] =arr.clone();
		int arr2[]=arr.clone();
//		process1
		System.out.println("Process1:");
		int ans[]=SortColorPro1(arr,n);
		Print(ans);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans1[]=SortColorPro2(arr1,n);
		Print(ans1);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		int ans2[]=SortColorPro3(arr2,n);
		Print(ans2);
	}
}
