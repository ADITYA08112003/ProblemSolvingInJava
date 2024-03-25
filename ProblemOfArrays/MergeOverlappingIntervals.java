package ProblemOfArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class MergeOverlappingIntervals {

//	Process1
//  Time Complexity:O(NlogN)
//  Space Complexity:O(N)
    public static int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add non-overlapping interval to the result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }
//    Process2
//    Time Complexity:O(NlogN)
//    Space Complexity:O(N)
    
    public static void mergeIntervals(List<int[]> intervals) {
    	 // Step 1: Sort intervals based on the start times
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
     // Step 2: Initialize a stack to store merged intervals
        Stack<int[]> stack = new Stack<>();
     // Step 3: Push the first interval onto the stack
        int n = intervals.size();
        stack.push(intervals.get(0));
        // Step 4: Iterate through the sorted intervals and merge overlapping ones
        for (int i = 1; i < n; i++) {
            int[] top = stack.peek();
            if (top[1] <= intervals.get(i)[0]) {
            	 // Non-overlapping interval, push onto the stack
                stack.push(intervals.get(i));
            } else if (top[1] < intervals.get(i)[1]) {
            	// Overlapping interval, merge with the top interval on the stack
                top[1] = intervals.get(i)[1];
                stack.pop();
                stack.push(top);
            }
        }
        // Step 5: Print or process the merged intervals
        while (!stack.isEmpty()) {
            int[] top = stack.peek();
            System.out.println(top[0] + " " + top[1]);
            stack.pop();
        }
    }
//  Process3
//  Time Complexity:O(NlogN)
//  Space Complexity:O(N)
    
    public static int[][] merge(int[][] intervals) {
        //declaring an array list to store the pairs
   ArrayList<int[]> list=new ArrayList<>();
   
   //sorting the given interval array based on starting point
   Arrays.sort(intervals,(a,b)->a[0]-b[0]);
   
   //defining start and end point
   int start=intervals[0][0];
   int end=intervals[0][1];
   
   //we will iterate through the 2d array intervals so in each iteration we will get a row[1D array] as i
   
   for(int[] i:intervals){
       //check if end point of 1st pair if greater than the starting point of the 2nd pair or not, basically we check it's in overlapping condition or not
       
       if(i[0]<=end){
           end=Math.max(end,i[1]);
       }
       
       //otherwise add it in the list
       else{
           list.add(new int[]{start,end});
           start=i[0];
           end=i[1];
       }
       
   }
   
   list.add(new int[]{start,end});
   return list.toArray(new int[0][]);
   }

    public static void main(String[] args) {
//    	Process1
    	System.out.println("Process1:");
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = merge1(intervals1);
        System.out.println(Arrays.deepToString(result1));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = merge1(intervals2);
        System.out.println(Arrays.deepToString(result2));
        
//        Process2
        System.out.println("Process2:");
        List<int[]> intervals = new ArrayList<>(Arrays.asList(
                new int[]{6, 8},
                new int[]{1, 9},
                new int[]{2, 4},
                new int[]{4, 7}
        ));
        mergeIntervals(intervals);
//        Process3
        System.out.println("Process3:");
        int[][] intervals11 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result11 = merge(intervals11);
        System.out.println(Arrays.deepToString(result11));

        int[][] intervals21 = {{1, 4}, {4, 5}};
        int[][] result21 = merge(intervals21);
        System.out.println(Arrays.deepToString(result21));
        
    }
}
