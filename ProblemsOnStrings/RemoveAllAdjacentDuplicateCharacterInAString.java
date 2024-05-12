package ProblemsOnStrings;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicateCharacterInAString {
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(N)
//	Using Stack
	public static String Remove1(String str) {
		Stack<Character> stack=new Stack<>();
		for(char ch:str.toCharArray()) {
			if(!stack.isEmpty() && stack.peek()==ch) {
				stack.pop();
			}
			else {
				stack.push(ch);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(char ch:stack) {
			sb.append(ch);
		}
		return sb.toString();
		
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	Fast and Slow
	public static String Remove2(String str) {
		int n=str.length();
		char ch[]=str.toCharArray();
		int slow=0;
		for(int fast=0;fast<n;fast++) {
			if(slow==0 || ch[slow-1]!=ch[fast]) {
				ch[slow++]=ch[fast];
			}
			else {
				slow--;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<slow;i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
//		Process1
		System.out.println("Process1:");
		System.out.println(Remove1(str));
//		Process2
		System.out.println("Process2:");
		System.out.println(Remove2(str));
	}
}
