package org.example.patterns.twoPointers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ReverseWordsinAString {
    public static void main(String args[]){
        String s = "blue is sky the";
        System.out.println(reverseWords(s));
        System.out.println(reverseWordsOptimized(s));
    }
    public static String reverseWords(String s) {
        int left = 0;
        int right = 0;
        int len = s.length();
        if(len == 0){
            return "";
        }
        ArrayList<String> arr = new ArrayList<>();
        while(right < len){
            if(s.charAt(left) == ' ' && s.charAt(right) == ' '){
                left++;
                right++;
            }else if (s.charAt(left) != ' ' && s.charAt(right) != ' ' && right == len-1){
                arr.add(s.substring(left,right+1));
                break;
            }
            else if(s.charAt(left) != ' ' && s.charAt(right) == ' '){
                arr.add(s.substring(left,right));
                right++;
                left = right;
            }
            else{
                right++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size()-1; i>=0; i--){
            sb.append(arr.get(i));
            if(i !=0){
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static String reverseWordsOptimized(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
