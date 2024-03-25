//Problem4
package ProblemOfArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SingleNumber {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static int SingleNumProc1(int []arr,int n) {
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			if(count%2!=0) {
				return arr[i];
			}
		}
		return -1;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static int SingleNumProc2(int arr[],int n) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int num : arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}
			else {
				map.put(num, 1);
			}
		}
		
		for(int num : arr) {
			if(map.get(num)%2!=0) {
				return num;
			}
		}
		return -1;
	}
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int SingleNumProc3(int arr[],int n) {
		int ans=0;
		for(int num : arr) {
			ans^=num;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
// Copy elements from source to destination using Arrays.copyOf
		int arr1[]=Arrays.copyOf(arr, n);
// Copy elements from source to destination using System.arraycopy
		int arr2[]=new int[n];
		System.arraycopy(arr, 0, arr2, 0, n);
		
//		Process1
		System.out.println("Process1:");
		int ans1=SingleNumProc1(arr,n);
		System.out.println(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2=SingleNumProc2(arr1,n);
		System.out.println(ans2);
		System.out.println();
//		Process3
		System.out.println("Process3");
		int ans3=SingleNumProc3(arr2,n);
		System.out.println(ans3);
	}
}
