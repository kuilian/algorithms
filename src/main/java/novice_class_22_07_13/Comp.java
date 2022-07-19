package novice_class_22_07_13;

/**
 * @author Kui Lian
 * @date 2022/7/19 - 15:26
 * @Description:
 */
public class Comp {
        //返回一个数组，长度跟值都是随机的 左闭右闭区间
    public static int[] lenRandomValueRandom(int length, int maxValue) {
        //长度在[0 - length-1] 之间随机产生
        int len = (int)( Math.random() * length);
        int[] randArray = new int[len];
        //数组的值在[0 -maxValue-1]中等概率出现

        for (int i = 0; i < len; i++) {
            randArray[i] = (int)( Math.random() * maxValue);
        }
        return randArray;
    }
    public static int[] copyArray(int[] arr)
    {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
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
    //a1a2一定等长
    public static boolean isSorted(int[] a1) {
        if ( a1.length<2)
        {
            return true;
        }
        int max = a1[0];
        for (int i = 1; i < a1.length; i++) {
//            if (a1[i] !=a2[i])
//            {
//                return false;
//            }
            if (max > a1[i]) {
                return false;
            }
            max = Math.max(max, a1[i]);
        }
        return true;
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
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue=1000;
        int testTime= 10000;
        for (int i = 0; i < testTime; i++) {
            int[] ar1 = lenRandomValueRandom(maxLen, maxValue);
            int[] tmp = copyArray(ar1);
            selectionSort(ar1);
            if (!isSorted(ar1)) {
                for (int j = 0; j < tmp.length; j++) {
                    System.out.print(tmp[j] + " ");
                }
                System.out.println();
                System.out.println("选择排序错了！");
                break;
            }
        }

    }
}
