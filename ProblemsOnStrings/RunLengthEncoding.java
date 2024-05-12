package ProblemsOnStrings;

import java.util.Scanner;

public class RunLengthEncoding {
	
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static String Encoding1(String str) {
		String ans="";
		int n=str.length();
		for(int i=0;i<n;i++) {
			int count=1;
			while(i<n-1 && str.charAt(i)==str.charAt(i+1)) {
				i++;
				count++;
			}
			String val=count+"";
			ans+=str.charAt(i)+""+val;
		}
		return ans;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static String Encoding2(String str) {
		StringBuilder val=new StringBuilder();
		int count=1;
		for(int i=1;i<=str.length();i++) {
			if(i==str.length() || str.charAt(i)!=str.charAt(i-1)) {
				val.append(str.charAt(i-1));
				val.append(count);
				count=1;
			}
			else {
				count++;
			}
		}
		return val.toString();
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		String str1=str.toString();
//		Process1
		System.out.println("Process1:");
		System.out.println(Encoding1(str));
//		Process2
		System.out.println("Process2:");
		System.out.println(Encoding2(str1));
	}
}
