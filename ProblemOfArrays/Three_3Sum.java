//Problem21
package ProblemOfArrays;

import java.util.*;


public class Three_3Sum {
	public static void Print(List<List<Integer>> arr) {
		for(List<Integer> num : arr) {
			System.out.println(num);
		}
	}
	
//	Process1
//	Time Complexity:O(N^3)
//	Space Complexity:O(1)
	public static  List<List<Integer>> threeSum(int[] nums) {
		int n=nums.length;
		List<List<Integer>> Ans=new ArrayList<>();
		// Sorting the array 
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
     
                        Ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        
                    } 
                }
            }
        }
         Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> currentList : Ans) {
            if (set.add(currentList)) {
                // If the set didn't already contain the list, add it to the result
                result.add(currentList);
            }
        }

        return result;
    }
//	Process2
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static List<List<Integer>> threeSum1(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> val=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                
                if(sum==0){
                    val.add(Arrays.asList(nums[i],nums[l],nums[r]));
                   l++;r--;
                }
                else if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
       
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> currentList : val) {
            if (set.add(currentList)) {
               
                result.add(currentList);
            }
        }

        return result;
	}
	
//	Process3
//	Time Complexity:(N^2)
//	Space Complexity:(N)
	 public static List<List<Integer>> threeSum2(int[] nums) {
	        List<List<Integer>> ans = new ArrayList<>();

	        // Sort the array
	        Arrays.sort(nums);

	        for (int i = 0; i < nums.length - 2; i++) {
	            // Skip duplicate elements for i
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }

	            int j = i + 1;
	            int k = nums.length - 1;

	            while (j < k) {
	                int sum = nums[i] + nums[j] + nums[k];

	                if (sum == 0) {
	                    // Found a triplet with zero sum
	                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

	                    // Skip duplicate elements for j
	                    while (j < k && nums[j] == nums[j + 1]) {
	                        j++;
	                    }

	                    // Skip duplicate elements for k
	                    while (j < k && nums[k] == nums[k - 1]) {
	                        k--;
	                    }

	                    // Move the pointers
	                    j++;
	                    k--;
	                } else if (sum < 0) {
	                    // Sum is less than zero, increment j to increase the sum
	                    j++;
	                } else {
	                    // Sum is greater than zero, decrement k to decrease the sum
	                    k--;
	                }
	            }
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
		System.out.println("Process1:");
		List<List<Integer>> Ans1=threeSum(arr);
		Print(Ans1);
		System.out.println();
		System.out.println("Process2:");
		List<List<Integer>> Ans2=threeSum1(arr);
		Print(Ans2);
		System.out.println();
		System.out.println("Process3:");
		List<List<Integer>> Ans3=threeSum2(arr);
		Print(Ans3);
		
		
	}
}
