package leetcode.算法思想.双指针;

public class 判断一个数是否是两整数的平方和 {
    public static void main(String[] args) {
        int val = 13;
        System.out.println(isSquareSum(val));
    }

    public static boolean isSquareSum(int val){
        if (val <= 0){
            return false;
        }
        int low = 0;
        int high = (int)Math.sqrt(val);
        while (low <= high){
            if (low*low + high* high == val){
                System.out.println(low+"*"+low+"+"+high+"*"+high+"="+val);
                return true;
            }else if(low*low + high* high < val){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }
}
