package class_03;

import java.util.Arrays;


/**
 * @author Kui Lian
 * @date 2022/7/20 - 11:27
 * @Description:
 */
public class Code01_BSExist {
    //返回最左大于number的位置 arr有序
    public static int mostLeftIndex(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            // ans 更新
            int mid = (L + R) / 2;
            if (arr[mid] >= number) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    // for test
    public static int test2(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test2(arr, value) != mostLeftIndex(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * @return boolean
     * @Date 11:31 2022/7/20
     * @Param [arr, value]
     * @Description: 保证数组是有序的前提下，二分法
     */
    private static boolean find(int[] arr, int value) {
        if (arr == null && arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }

        }
        return false;
    }
}
