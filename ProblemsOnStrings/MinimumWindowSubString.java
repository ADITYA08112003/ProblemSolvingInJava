package ProblemsOnStrings;

import java.util.Scanner;

public class MinimumWindowSubString {
//	Process1
//	Time Complexity:O(n^2*K)
//	Space Complexity:O(N*K)
	public static String minWindow1(String s,String t) {
		int minLen=Integer.MAX_VALUE;
		String minWindow="";
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String substring=s.substring(i,j);
				if(ContainsAllChars(substring,t) && substring.length()<minLen) {
					minLen=substring.length();
					minWindow=substring;
				}
			}
		}
		return minWindow;
	}
	private static boolean ContainsAllChars(String str,String t) {
		int[] count=new int[256];
		for(char c:t.toCharArray()) {
			count[c]++;
		}
		for(char c:str.toCharArray()) {
			if(count[c]>0) {
				count[c]--;
			}
		}
		for(int cnt:count) {
			if(cnt>0) {
				return false;
			}
		}
		return true;
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static final int no_of_chars = 256;
	  
    public static String findSubString(String string, String pat) {
        int len1 = string.length();
        int len2 = pat.length();

        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int[] hash_pat = new int[no_of_chars];
        int[] hash_str = new int[no_of_chars];

        for (int i = 0; i < len2; i++) {
            hash_pat[pat.charAt(i)]++;
        }

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE, count = 0;
        
        for (int j = 0; j < len1; j++) {
            hash_str[string.charAt(j)]++;

            if (hash_pat[string.charAt(j)] != 0 && hash_str[string.charAt(j)] <= hash_pat[string.charAt(j)]) {
                count++;
            }

            if (count == len2) {
                while (hash_str[string.charAt(start)] > hash_pat[string.charAt(start)] || hash_pat[string.charAt(start)] == 0) {
                    if (hash_str[string.charAt(start)] > hash_pat[string.charAt(start)]) {
                        hash_str[string.charAt(start)]--;
                    }
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }
        
        return string.substring(start_index, start_index + min_len);
    }
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String val=s.next();
//		Process1
		System.out.println("Process1");
		System.out.println(minWindow1(str,val));
		System.out.println();
//		Process2
		System.out.println("Process2");
		System.out.println(findSubString(str, val));
	}
}
