package Practise;

import java.util.ArrayDeque;//QUESTION: https://leetcode.com/problems/valid-parentheses/

public class ValidParenthesis {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stack.offerLast(ch);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else{
                if(ch == '}' && stack.peekLast() != '{'){
                    return false;
                }
                else if(ch == ']' && stack.peekLast() != '['){
                    return false;
                }
                else if(ch == ')' && stack.peekLast() != '('){
                    return false;
                }
                else{
                    stack.pollLast();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}