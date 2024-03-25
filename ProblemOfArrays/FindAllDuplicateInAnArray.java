package ProblemOfArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindAllDuplicateInAnArray {
	public static void Print(List<Integer> arr) {
		for(int num : arr) {
			System.out.println(num);
		}
	}
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(K)
	public static List<Integer> FindDuplicateProcess1(int []arr,int n){
		List<Integer> a1=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int c=1;
			for(int j=i+1;j<n;j++) {
				if(arr[i]==arr[j]) {
					c++;
				}
			}
			if(c>=2) {
				a1.add(arr[i]);
			}
		}
		return a1;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static List<Integer> FindDuplicateProcess2(int[] arr,int n){
		List<Integer> a1=new ArrayList<Integer>();
		int nums[]=new int[n+1];
		for(int i=0;i<n+1;i++) {
			nums[i]=0;
		}
		for(int i=0;i<n;i++) {
			nums[arr[i]]+=1;
		}
		for(int i=0;i<n+1;i++) {
			if(nums[i]==2) {
				a1.add(i);
			}
		}
		return a1;
	}
	
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	 public static List<Integer> FindDuplicateProcess3(int[] nums) {
	        List<Integer> result = new ArrayList<>();

	        for (int num : nums) {
	            // Get the absolute value of the current number
	            int absNum = Math.abs(num);

	            // If the corresponding element at index absNum is negative, it means absNum is a duplicate
	            if (nums[absNum - 1] < 0) {
	                result.add(absNum);
	            } else {
	                // Mark the element at index absNum as visited by making it negative
	                nums[absNum - 1] = -nums[absNum - 1];
	            }
	        }

	        return result;
	    }
	 
//	 Process4
//	 Time Complexity:O(N)
//	 Space Complexity:O(N)
//	 public static List<Integer> FindDuplicateProcess4(int[] nums) {
//	        List<Integer> result = new ArrayList<>();
//	        Map<Integer, Integer> frequencyMap = new HashMap<>();
//
//	        // Iterate through the array and update the frequency map
//	        for (int num : nums) {
//	            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//	        }
//
//	        // Iterate through the frequency map entries
//	        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//	            // If the frequency is 2, add the corresponding element to the result list
//	            if (entry.getValue() == 2) {
//	                result.add(entry.getKey());
//	            }
//	        }
//	        for(int a : result) {
//	        	System.out.println(a);
//	        }
//	        return result;
//	    }

//	 Process4
//	 Time Complexity:O(N)
//	 Space Complexity:O(1)
	

//		    public static void FindDuplicateProcess4(int[] arr, int n) {
//		        int[] result = new int[2];
//		        int xor = arr[0];
//		        for (int i = 1; i < n; i++) {
//		            xor ^= arr[i];
//		        }
//		        for (int i = 1; i < n - 1; i++) {
//		            xor ^= i;
//		        }
//
//		        // Get the rightmost set bit number
//		        int setNo = xor & ~(xor - 1);
//
//		        int x = 0, y = 0;
//		        // Divide the elements into 2 groups based on the rightmost set bit
//		        for (int i = 0; i < n; i++) {
//		            if ((arr[i] & setNo) != 0) {
//		                x ^= arr[i];
//		            } else {
//		                y ^= arr[i];
//		            }
//		        }
//		        for (int i = 1; i < n - 1; i++) {
//		            if ((i & setNo) != 0) {
//		                x ^= i;
//		            } else {
//		                y ^= i;
//		            }
//		        }
//
//		        result[0] = x;
//		        result[1] = y;
//		        System.out.println(result[0] + " " + result[1]);
//		    }
//	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
//		Process1
		System.out.println("Process1:");
		List<Integer> ans1=FindDuplicateProcess1(arr,n);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		List<Integer> ans2=FindDuplicateProcess2(arr,n);
		Print(ans2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		List<Integer> ans3=FindDuplicateProcess3(arr);
		Print(ans3);
		System.out.println();
//		Process4
//		System.out.println("Process4:");
//		List<Integer> ans4=FindDuplicateProcess4(arr);
//		Print(ans4);
	}
}
