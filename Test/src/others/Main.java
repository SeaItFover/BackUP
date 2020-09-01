    package others;

    import java.util.Arrays;
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            System.out.println(res());
        }

        public static long res() {
            Scanner scanner = new Scanner(System.in);
            long res = 0;
            int n = scanner.nextInt();
            scanner.nextLine();
            String temp = scanner.nextLine();
            String[] strings = temp.split(" ");
            if (n != strings.length){
                return -1;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(arr);

            int chu = n / 3;
            int mod = n % 3;
            for (int i = n - 1; i >= 0 && chu > 0 ; i--) {
                for (int j = 0; j < 2; j++){
                    res += arr[i];
                    i--;
                }
                //i--;
                chu--;
            }
            for (int i = 0; i < mod; i++){
                res += arr[i];
            }
            return res;
        }
    }
