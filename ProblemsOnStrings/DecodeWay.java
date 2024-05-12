package ProblemsOnStrings;

import java.util.*;
import java.util.Scanner;

public class DecodeWay {
//	Process1
//	Time Complexity:O(2^N)
//	Space Complexity:O(N)
	public static int Decode1(String s) {
		if (s == null || s.isEmpty()) {
            return 0;
        }
        return recDecoding(0, s);
	}
	public static int recDecoding(int index, String s) {
        // Base condition
        if (index == s.length()){
            return 1;
        }
        if (s.charAt(index) == '0' ) {
            return 0;
        }
        if( index == s.length() - 1){
            return 1;
        }
        return recDecoding(index + 1, s) + (Integer.parseInt(s.substring(index, index + 2)) <= 26 ? recDecoding(index + 2, s) : 0);
    }
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	
	public static int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return recDecoding1(0, s);
    }
	private static Map<Integer, Integer> hash=new HashMap<>();

	    
	    public static int recDecoding1(int index, String s) {
	        // Base condition
	        if (index == s.length() ) {
	            return 1;
	        }
	        if (s.charAt(index) == '0' ) {
	            return 0;
	        }
	        if(index == s.length() - 1){
	            return 1;
	        }
	        if (hash.containsKey(index)) {
	            return hash.get(index);
	        }
	        int result = recDecoding1(index + 1, s) + 
	                     ((Integer.parseInt(s.substring(index, index + 2)) <= 26) ? recDecoding1(index + 2, s) : 0);
	        hash.put(index, result);
	        return result;
	    }
	    
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
//		Process1
		System.out.println("Process1");
		System.out.println(Decode1(str));
		System.out.println();
//		Process2
		System.out.println("Process2");
		System.out.println(numDecodings(str));
	}
}
