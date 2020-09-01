package Java集合类.ArrayList.自定义实现ArrayList;

import java.util.Stack;

class Solution {


    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")(()"));
    }
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0 ;
        char[] ss = s.toCharArray() ;
        Stack<Integer> stack = new Stack() ;
        stack.push(-1) ;
        int max = 0 ;
        for(int i = 0 ; i < ss.length ; i++){
            if(ss[i] == '('){
                stack.push(i) ;
            }else{
                stack.pop() ;
                if(stack.isEmpty()){
                    stack.push(i) ;
                }else{
                    max = Math.max(i - stack.peek() , max);
                }
            }
        }
        return max ;
    }
}
