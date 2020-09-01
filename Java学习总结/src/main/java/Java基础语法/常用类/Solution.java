package Java基础语法.常用类;

import java.util.*;


import java.util.*;

/**
 * 老师您好：很感谢您百忙之中面试我，下面是我的思路：

 * 我使用了栈的方式，让字符串转成的数组中的元素逐个加入栈：
 * 我整体思路是如果要放入的元素和栈顶元素相同，那么就让栈顶元素出栈，但是这里面有个问题：
 * 就是我们要求的是全部相邻的都要去除，所以如果我之前已经pop出去一个相同元素，正好此时要入栈
 * 的元素和之前元素相同，所以我需要一个坐标来保存之前那个相同的元素（也就是最后一个pop出去的）
 * 每次入栈都要满足几个条件：要存入的元素和栈顶元素不同；并且和之前pop出去的元素不同。
 *
 * 关于更新index：首先pop出去的肯定作为index；其次需要将栈顶元素作为index（前提是栈非空）
 *
 * 关于我选取栈：
 * 我了解的JavaAPI中可以作为栈的有三种：Stack、LinkedList、ArrayDeque
 * Stack因为加锁性能低的原因我没有选，因为这里是单线程环境；
 * Array相比LinkedList在增删元素时效率很低，所以我选择Linkedlist。
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(distinctString("accafaaaaabb"));
    }

    public static String distinctString(String S) {
        char[] s = S.toCharArray();
        int len = s.length;
        LinkedList<Character> stack = new LinkedList<>();
        char index = ' ';
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || s[i] != stack.getLast()) {
                if (s[i] != index) {
                    stack.add(s[i]);
                    index = s[i];
                } else if (!stack.isEmpty()) {
                    index = stack.getLast();
                }
            } else {
                index = stack.removeLast();
            }
        }

        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str.append(c);
        }
        return str.toString();
    }
}