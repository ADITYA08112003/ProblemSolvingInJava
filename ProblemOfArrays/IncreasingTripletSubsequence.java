package ProblemOfArrays;

import java.util.Scanner;

public class IncreasingTripletSubsequence {
//	Process1
//	Time Complexity:O(N^3)
//	Space Complexity:O(1)
	public static boolean Triplet1(int []arr,int n) {
		for(int i=0;i<n;i++) {
			for(int j=1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if(arr[i]<arr[j] && arr[j]<arr[k]) {
						return true;
					}
				}
			}
		}
		return false;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static boolean Triplet2(int []arr,int n) {
		int minleft[]=new int[n];
		int maxright[]=new int[n];
		minleft[0]=arr[0];
		for(int i=1;i<n;i++) {
			minleft[i]=Math.min(minleft[i-1], arr[i]);
		}
		maxright[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			maxright[i]=Math.max(maxright[i+1],arr[i]);
		}
		for(int i=1;i<n-1;i++) {
			if(minleft[i-1]<arr[i] && arr[i]<maxright[i+1]) {
				return true;
			}
		}
		return false;
	}
//	Process3
//	time Complexity:O(N)
//	Space Complexity:O(1)
	public static boolean Triplet3(int arr[],int n) {
		if(n<3) {
			return false;
		}
		int minIndex=0;
		int low=-1,mid=-1;
		for(int i=1;i<n;i++) {
			if(arr[i]<arr[minIndex]) {
				minIndex=i;
			}
			else if(mid==-1) {
				low=minIndex;
				mid=i;
			}
			else if(arr[i]<=arr[mid]) {
				low=minIndex;
				mid=i;
			}
			else {
				return arr[low]<arr[mid] && arr[mid]<arr[i];
			}
		}
		return false;
	}
//	Process4
//	Time Complexity:o(N)
//	Space Complexity:O(1)
	public static boolean Triplet4(int []arr,int n) {
		int maxvalue=Integer.MAX_VALUE;
		int minvalue=Integer.MAX_VALUE;
		for(int num : arr) {
			if(num<=minvalue) {
				minvalue=num;
			}
			else if(num<=maxvalue) {
				maxvalue=num;
			}
			else {
				return true;
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
//		Process1
		System.out.println("Process1:");
		System.out.println(Triplet1(arr,n));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(Triplet2(arr,n));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(Triplet3(arr,n));
		System.out.println();
//		Process4
		System.out.println("Process4:");
		System.out.println(Triplet4(arr,n));
	}
}
