//Problem9
package ProblemOfArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
	
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static int ShortestUnsortedPro1(int arr[],int n) {
		int start=n,end=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					start=Math.min(start, i);
					end=Math.max(end, j);
				}
			}
		}
		if(end-1<0) {
			return 0;
		}
		else {
			return end-start+1;
		}
	}
	
//	Process2
//	Time Complexity:O(NlogN)
//	Space Complexity:O(N)
	public static int ShortestUnsortedPro2(int arr[],int n) {
		int arr1[]=arr.clone();
		Arrays.sort(arr1);
		int start=n,end=0;
		for(int i=0;i<n;i++) {
			if(arr1[i]!=arr[i]) {
				start=Math.min(start, i);
				end=Math.max(end, i);
			}
		}
		if(end-1<0) {
			return 0;
		}
		else {
			return end-start+1;
		}
	}
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static int ShortestUnsortedPro3(int arr[],int n) {
		Stack<Integer> st=new Stack<>();
		int start=n;
		for(int i=0;i<n;i++) {
			if(st.empty()) {
				st.push(i);
				i++;
			}
			else {
				if(arr[st.peek()]>arr[i]) {
					start=Math.min(start, st.peek());
					st.pop();
				}
				else {
					st.push(i);
					i++;
				}
			}
		}
		st.clear();
		int end=0;
		for(int i=n-1;i>=0;) {
			if(st.empty()) {
				st.push(i);
				i--;
			}
			else {
				if(arr[st.peek()]<arr[i]) {
					end=Math.max(end, st.peek());
					st.pop();
				}
				else {
					st.push(i);
					i--;
				}
			}
		}
		if(start>=end) {
			return 0;
		}
		else {
			return end-start+1;
		}
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
		System.out.println(ShortestUnsortedPro1(arr,n));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(ShortestUnsortedPro2(arr, n));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(ShortestUnsortedPro3(arr, n));
				
	}
}
