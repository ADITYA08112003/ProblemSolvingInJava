//Problem5
package ProblemOfArrays;
import java.util.*;
import java.util.Scanner;

public class HowManyNumberAreSmallerThanTheCurrentNumber {
	
	public static void Print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static int[] SmallerNumProc1(int []arr,int n) {
		int newarr[]=new int[n];
		for(int i=0;i<n;i++) {
			int k=0;
			for(int j=0;j<n;j++) {
				if(arr[j]<arr[i]) {
					k++;
				}
			}
			newarr[i]=k;
		}
		return newarr;
	}
//	Process2
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static int[] SmallerNumProc2(int []arr,int n) {
		int result[]=arr.clone();
		Arrays.sort(result);
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<result.length;i++) {
//			 The putIfAbsent method ensures that if a key is already present, its index is not overwritten.
			map.putIfAbsent(result[i], i);
		}
		for(int i=0;i<arr.length;i++) {
			result[i]=map.get(arr[i]);
		}
		return result;
	}
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] SmallerNumProc3(int []arr,int n) {
//		Create a new array of size 101
		int smaller[]=new int[101];
//		Traverse i/p array
		for(int i=0;i<arr.length;i++) {
			smaller[arr[i]]++;
		}
//		Prefix Sum
		for(int i=1;i<101;i++) {
			smaller[i]+=smaller[i-1];
		}
//		Traverse i/p array
		for(int i=0;i<arr.length;i++) {
			int position=arr[i];
			if(position==0) {
				arr[i]=0;
			}
			else {
				arr[i]=smaller[position-1];
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
//		int arr1[]=Arrays.copyOf(arr, n);
		int arr1[]=arr.clone();//The clone() method is used to create a shallow copy of the original array 
		int arr2[]=arr.clone();
//		Process1
		System.out.println("Process1:");
		int ans1[]=SmallerNumProc1(arr,n);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2[]=SmallerNumProc2(arr1, n);
		Print(ans2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		int ans3[]=SmallerNumProc3(arr2,n);
		Print(ans3);
	}
}
