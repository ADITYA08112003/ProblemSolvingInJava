package ProblemsOnStrings;

import java.util.*;
import java.util.Scanner;

public class RearrangeCharactersToFormAPalindrome {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(N)
	public static boolean Palindrome1(String str) {
		int OddCount=0;
		char Ans[]=str.toCharArray();
		for(char c:Ans) {
			int count=0;
			for(char S:Ans) {
				if(c==S) {
					count++;
				}
			}
			if(count%2!=0) {
				OddCount++;
			}
		}
		if(OddCount>1) {
			return false;
		}
		else {
			return true;
		}
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static boolean Palindrome2(String S) {
		// Create an array to store the frequency of each character in the string
        int[] charCount = new int[256];
        
        // Count the frequency of each character in the string
        for (char c : S.toCharArray()) {
            charCount[c]++;
        }
        
        // Initialize a variable to count the number of characters with odd frequency
        int oddCount = 0;
        
        // Iterate through the character frequencies
        for (int count : charCount) {
            // If the frequency of a character is odd, increment the oddCount
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // If the string has at most one character with odd frequency, it can be rearranged to form a palindrome
        return oddCount <= 1 ? true : false;
	}
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static boolean Palindrome3(String S) {
		 // Create a HashMap to store the frequency of each character in the string
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count the frequency of each character in the string
        for (char ch : S.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        
        // Count the number of characters with odd frequency
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // If the number of characters with odd frequency is at most 1, return 1 (true)
        // Otherwise, return 0 (false)
        return oddCount <= 1 ? true : false;
	}
//	Process4
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static boolean Palindrome4(String S) {
		int Count[]=new int[256];
		int OddCount=0;
		for(char c:S.toCharArray()) {
			Count[c]++;
			if(Count[c]%2==1) {
				OddCount++;
			}
			else {
				OddCount--;
			}
		}
		if(OddCount>1) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
//		Process1
		System.out.println("Process1");
		System.out.println(Palindrome1(str));
		System.out.println();
//		Process2
		System.out.println("Process2");
		System.out.println(Palindrome2(str));
		System.out.println();
//		Process3
		System.out.println("Process3");
		System.out.println(Palindrome3(str));
		System.out.println();
//		Process4
		System.out.println("Process4");
		System.out.println(Palindrome4(str));
	}
}
