//Problem2

package ProblemOfArrays;

import java.util.HashMap;
import java.util.Scanner;

public class FindMajorityElemntInArray {
//	Process1
	
//	Time Complexity:O(n^2)
//	Space Complexity:O(1)
	public static int MajorityElementProcess1(int arr[],int n) {
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			if(count>n/2) {
				return arr[i];
			}
		}
		return -1;
	}
	
//	Process2
	
//	Time Complexity:O(n)
//	Space Complexity:O(n)
	public static int MajorityElementProcess2(int arr[],int n) {
//		Creating a HashMap of Key and Value
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
//		Initially  put the first element of array with frequency one
		hmap.put(arr[0], 1);
		
		int maxFrequency=1;
		int maxElement=arr[0];
		for(int i=1;i<n;i++) {
//			Check the next array are in hashmap or not
			boolean KeyExists=hmap.containsKey(arr[i]);
			if(KeyExists) {
//				carried last frequency of array element
				int existingFreq=hmap.get(arr[i]);
//				update the last frequency of arraay element
				hmap.put(arr[i], existingFreq+1);
			}
			else {
				hmap.put(arr[i], 1);
			}
			int freq=hmap.get(arr[i]);
			if(freq>maxFrequency) {
				maxFrequency=freq;
				maxElement=arr[i];
			}
		}
		if(maxFrequency > (n/2)) {
			return maxElement;
		}
		else {
			return -1;
		}
	}
//	Process3
//	Time Complexity:O(n)
//	Space Complexity:O(1)
//	Solved by Boyer's Moore Algorithms
	public static int MajorityElementProcess3(int arr[],int n) {
		int cand=0	;
		int count=0;
		for(int i=0;i<n;i++) {
			if(count==0) {
				cand=arr[i];
			}
			if(cand==arr[i]) {
				count++;
			}
			else {
				count--;
			}
		}
		return cand;
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
		int ans1=MajorityElementProcess1(arr,n);
		System.out.println("Majority Element:"+ans1);
		System.out.println();
//		process2
		System.out.println("Process2:");
		int ans2=MajorityElementProcess2(arr,n);
		System.out.println("Majority Element:"+ans2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		int ans3=MajorityElementProcess3(arr,n);
		System.out.println("Majority Element:"+ans3);
		
	}
}
