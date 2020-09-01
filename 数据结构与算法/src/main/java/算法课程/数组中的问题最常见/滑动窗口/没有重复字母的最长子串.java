package 算法课程.数组中的问题最常见.滑动窗口;


/**
 * 3\438\76
 */
public class 没有重复字母的最长子串 {

    public static void main(String[] args) {
        String str = "abcaabbcc";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;

        while (l < s.length()){
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)] = 1;
            }else{
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
