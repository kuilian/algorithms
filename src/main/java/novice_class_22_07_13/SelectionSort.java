package novice_class_22_07_13;

/**
 * @author Kui Lian
 * @date 2022/7/18 - 14:45
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {20, 19, 2, 3, 4, 1, 29};
        printArr(arr);
        insertSort2(arr);
        printArr(arr);
    }

    private static void insertSort2(int[] arr) {
        //设置边界值
        if (arr == null && arr.length < 2) {
            return;
        }
        // 0~0之间已经是有序的了 所以从1 开始
        // 0 ~ 1 之间有序
        // 0 ~ 2 有序
        // 0 ~ 3 有序...
        //变的是尾数
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            //新进来的数 是end 如果新进来的数比原来的大 则有序 比原来的小 则end-1 和 end交换 一直到左边没有了或者前一个数比后一个数小才停止
            int newIndex = end;
            while (newIndex - 1 >= 0 && arr[newIndex]<arr[newIndex-1]){
                swap(arr,newIndex-1,newIndex);
                newIndex--;
            }
        }
    }

    private static void insertSort1(int[] arr) {
        //设置边界值
        if (arr == null && arr.length < 2) {
            return;
        }
        // 0~0之间已经是有序的了 所以从1 开始
        // 0 ~ 1 之间有序
        // 0 ~ 2 有序
        // 0 ~ 3 有序...
        //变的是尾数
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            //新进来的数 是end 如果新进来的数比原来的大 则有序 比原来的小 则end-1 和 end交换 一直到左边没有了或者前一个数比后一个数小才停止
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }

    }

    private static void bubbleSort(int[] arr) {

        //设置边界值
        if (arr == null && arr.length < 2) {
            return;
        }
        //冒泡排序
        // 0 ~ n-1
        // 0 ~ n-2
        // 0~ end 做的事情
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            // 0~n-1 里 ，1 和2 之间比较 1比2大，则1 2交换位置 3 4 比较 3比4大 3 4交换位置 。。。
            // 最后一次是 end-1 end 比较
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * @return void
     * @Date 14:53 2022/7/18
     * @Param [arr]
     * @Description:选择排序
     */
    private static void selectionSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        // 0 ~ n-1 ... 选择最小的值然后放到 0的位置
        // 1 ~ n-1 ... 选择最小的值然后放到 1的位置
        // 2 ~ n-1 ... 选择最小的值然后放到 2的位置
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    //如果j位置的值小于 minIndex位置的值 则两个交换
//                    minIndex = j;
//                }
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * @return void
     * @Date 14:53 2022/7/18
     * @Param [arr, i, j]
     * @Description: 交换值
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
