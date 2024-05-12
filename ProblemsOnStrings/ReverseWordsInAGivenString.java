package ProblemsOnStrings;

import java.util.Scanner;

public class ReverseWordsInAGivenString {
//	Process1
	 public static String reverseWords1(String s) {
	        // Trim the input string to remove leading and trailing spaces
	        s = s.trim();
	        
	        // Split the trimmed string into words using whitespace as the delimiter
	        String[] words = s.split("\\s+");
	        
	        // Reverse the order of words
	        StringBuilder reversed = new StringBuilder();
	        for (int i = words.length - 1; i >= 0; i--) {
	            reversed.append(words[i]).append(" ");
	        }
	        
	        // Remove the trailing space and return the reversed string
	        return reversed.toString().trim();
	    }
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
//		Process1
		System.out.println("Process1:");
		System.out.println(reverseWords1(str));
	}
}
