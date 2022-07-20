package class_03;

/**
 * @author Kui Lian
 * @date 2022/7/20 - 14:51
 * @Description:
 */
public class BSAwesome {
    //arr整体无序 arr相邻的数不相等
    public static int oneMinIndex(int[] arr)
    {
        if (arr == null || arr.length ==0)
        {
            return -1;
        }
        int N = arr.length;
        //边界条件
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1])
        {
            return 0;
        }
        if (arr[N-1]<arr[N-2])
        {
            return N-1;
        }
        int L =0;
        int R = N-1;
        //L..R一定有局部最小
        while (L < R-1){
            int mid = (R+L)/2;
            if (arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1])
            {
                return mid;
            }else{
                // mid-1 < mid  直接舍弃右边 去左边找最小
                if (arr[mid-1]<arr[mid]){
                    R = mid-1;
                }else{
                    //mid-1>mid
                    L = mid + 1;
                }
            }
        }
        //此时从while条件里出来时  一定只剩两个
        return arr[L] < arr[R] ? L : R;
    }

    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLength,int maxValue)
    {
        int len = (int) (Math.random() * maxLength);
        int[] arr = new int[len];
        if (len>0)
        {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }
    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");

    }
}
