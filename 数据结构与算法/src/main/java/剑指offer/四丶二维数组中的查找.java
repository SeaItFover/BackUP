package 剑指offer;

/**
 * 易错点：
 * 开始的时候忘记了加入空数组判断
 */
public class 四丶二维数组中的查找 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result = find(5, arr);
        System.out.println(result);

    }

    //    public static boolean find(int target,int[][] arr){
//        int rows = arr.length;
//        int cols = arr[0].length;
//        int r = 0;
//        int c = cols-1;
//        while (r<arr.length && c>=0){
//            if (target == arr[r][c]){
//                return true;
//            }else if(target>arr[r][c]){
//                r++;
//            }else {
//                c--;
//            }
//        }
//        return false;
//    }
    public static boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        while (r < rows && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
