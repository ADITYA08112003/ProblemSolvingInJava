package ProblemsOnStrings;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInAString {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static int UniqueCharIndex(String str) {
		char ch[]=str.toCharArray();
		int n=str.length();
		for(int i=0;i<n;i++) {
			int count=1;
			for(int j=0;j<n;j++) {
				if(i==j) {
					continue;
				}
				if(ch[i]==ch[j]) {
					count++;
					break;
				}
			}
			if(count==1) {
				return i;
			}
		}
		return -1;
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	 public static char FirstUniqueChar1(String s) {
	        // Create a HashMap to store characters and their frequencies
	        Map<Character, Integer> charCount = new HashMap<>();

	        // Populate the HashMap with character frequencies
	        for (char c : s.toCharArray()) {
	            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
	        }

	        // Find the first unique character
	        for (char c : s.toCharArray()) {
	            if (charCount.get(c) == 1) {
	                return c;
	            }
	        }

	        // If no unique character found, return a default character
	        return '\0';
	    }
	 public static int UniqueCharIndex1(String str) {
		 char ans=FirstUniqueChar1(str);
		 for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)==ans) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
//	 Process3
//	 Time Complexity:O(N)
//	 Space Complexity:O(1)
	 public static int nonRepeatingString(String string) {
	        int[] index = new int[26];
	        int[] count = new int[26];

	        // Initialize index and count arrays
	        Arrays.fill(index, -1);
	        Arrays.fill(count, 0);

	        // Populate count and index arrays
	        for (int i = 0; i < string.length(); i++) {
	            char x = string.charAt(i);
	            count[x - 'a']++;
	            index[x - 'a'] = i;
	        }

	        int minValue = Integer.MAX_VALUE;
	        char value = '\0';

	        // Find the minimum index of non-repeating character
	        for (int i = 0; i < count.length; i++) {
	            if (count[i] == 1 && index[i] < minValue) {
	                minValue = index[i];
	                value = (char) (i + 'a');
	            }
	        }

	        // Print the result
	        if (value != '\0') {
	           return minValue;
	        } else {
	            return -1;
	        }
	    }

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
//		Process1
		System.out.println("Process1:");
		System.out.println(UniqueCharIndex(str));
//		Process2
		System.out.println("Process2:");
		System.out.println(UniqueCharIndex1(str));
//		Process3
		System.out.println("Process3:");
		System.out.println(nonRepeatingString(str));
		
	}
}
