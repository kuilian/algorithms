package novice_class_22_07_13;

/**
 * @author Kui Lian
 * @date 2022/7/18 - 10:43
 * @Description: 打印一个数的二进制
 */
public class Code_PrintB {

    public static void main(String[] args) {
        int num = 1024;
        print(num);
    }

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            // 1 左移32位  1000 0000 0000 0000 0000 0000 0000 0000
            System.out.print((num & (1<< i)) == 0 ? "0" : "1");

        }
        System.out.println();
    }
}
