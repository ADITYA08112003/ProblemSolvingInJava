//Problem8

package ProblemOfArrays;

import java.util.Scanner;

public class ReplaceElementsWithGreatestElemnentOnRightSide {
	
	public static void Print(int arr[]) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
//	Process1
//	Time Complexity:O(n^2)
//	Space Complexity:O(1)
	public static int[] ReplaceElementPro1(int []arr) {
		for(int i=0;i<arr.length-1;i++) {
			int max=arr[i+1];
			for(int j=i+2;j<arr.length;j++) {
				if(max<arr[j]) {
					max=arr[j];
				}
			}
			arr[i]=max;
		}
		arr[arr.length-1]=-1;
		return arr;
	}
//	Process2
//	Time Complexity:O(N)
//	SPace Complexity:O(1)
	public static int[] ReplaceElementPro2(int []arr) {
		int max=arr[arr.length-1];
		arr[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--) {
			int temp=arr[i];
			arr[i]=max;
			if(max<temp) {
				max=temp;
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
		int []a=ReplaceElementPro1(arr);
		Print(a);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int []a1=ReplaceElementPro2(arr1);
		Print(arr1);
	}
}
