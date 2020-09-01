package leetcode.算法思想.双指针;


import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.getLast() == '(') {
                    stack.removeLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                if (stack.getLast() == '[') {
                    stack.removeLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == '}') {
                if (stack.getLast() == '{') {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {

            return true;
        }
        return false;
    }
}
