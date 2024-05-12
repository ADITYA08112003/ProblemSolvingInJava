package ProblemsOnStrings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class RemoveAllDuplicateFromTheInputString {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static String Remove1(String str) {
		  // Convert the string to a character array
        char[] charArray = str.toCharArray();
        
        // Length of the string
        int len = charArray.length;
        
        // Iterate through each character in the array
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            
            // Check if the current character is not already removed
            if (currentChar != '\0') {
                // Iterate through the remaining characters in the array
                for (int j = i + 1; j < len; j++) {
                    // If a duplicate is found, remove it by replacing it with '\0'
                    if (charArray[j] == currentChar) {
                        charArray[j] = '\0';
                    }
                }
            }
        }
        
        // Construct the resulting string without duplicates
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            // Append only non-null characters to the result string
            if (c != '\0') {
                result.append(c);
            }
        }
        
        return result.toString();
	}
	
//	Process2
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static String Remove2(String str) {
		if (str == null || str.isEmpty()) {
            return str;
        }

        // Convert the string to a character array
        char[] chars = str.toCharArray();

        // Sort the character array
        Arrays.sort(chars);

        int n = chars.length;
        int index = 0; // Index to track non-duplicate characters

        // Traverse the sorted character array to remove duplicates
        for (int i = 0; i < n; i++) {
            // If the current character is different from the previous character, copy it to the non-duplicate position
            if (i == 0 || chars[i] != chars[i - 1]) {
                chars[index++] = chars[i];
            }
        }

        // Construct a new string from the non-duplicate characters
        return new String(chars, 0, index);
	}
	
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(N)
//	Hashing Based
	 public static String Remove3(String str) {
	        if (str == null || str.isEmpty()) {
	            return str;
	        }

	        // Create a set to store unique characters
	        Set<Character> uniqueChars = new HashSet<>();
	        
	        // Create a StringBuilder to construct the string with unique characters
	        StringBuilder result = new StringBuilder();

	        // Traverse the string and add non-duplicate characters to the result
	        for (char ch : str.toCharArray()) {
	            if (!uniqueChars.contains(ch)) {
	                result.append(ch);
	                uniqueChars.add(ch);
	            }
	        }

	        return result.toString();
	    }
//	 Process4
//	 Time Complexity:O(N)
//	 Space Complexity:O(K)
//	 Counting sort Based
	 public static String Remove4(String str) {
	        if (str == null || str.isEmpty()) {
	            return str;
	        }

	        // Assuming ASCII characters (0-127)
	        boolean[] seen = new boolean[128];
	        StringBuilder result = new StringBuilder();

	        for (char ch : str.toCharArray()) {
	            if (!seen[ch]) {
	                result.append(ch);
	                seen[ch] = true;
	            }
	        }

	        return result.toString();
	    }
//	 Process5
	 public static String Remove5(String str) {
	        if (str == null || str.isEmpty()) {
	            return str;
	        }

	        int checker = 0;
	        StringBuilder result = new StringBuilder();

	        for (int i = 0; i < str.length(); ++i) {
	            int val = str.charAt(i) - 'a'; // Assuming lowercase English alphabets
	            if ((checker & (1 << val)) == 0) {
	                result.append(str.charAt(i));
	                checker |= (1 << val);
	            }
	        }

	        return result.toString();
	    }


	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
//		copy one string to another string
		String str1=str.toString();
		String str2=new String(str);
		String str3=str.substring(0);
		String str4=str.concat("");
		String str5=String.valueOf(str);
//		process1
		System.out.println("Process1:");
		System.out.println(Remove1(str));
//		Process2
		System.out.println("Process2:");
		System.out.println(Remove2(str1));
//		Process3
		System.out.println("Process3:");
		System.out.println(Remove3(str2));
//		Process4
		System.out.println("Process4:");
		System.out.println(Remove4(str3));
//		Process5
		System.out.println("Process5:");
		System.out.println(Remove5(str4));
		
	}
}
