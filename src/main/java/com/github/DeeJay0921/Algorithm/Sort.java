package com.github.DeeJay0921.Algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array3 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array4 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array5 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array6 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);
        sort2(array3);
        sort2(array4);
        sort2(array5);
        sort2(array6);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }

    // 冒泡排序
    // 按照从小到大排序
    public static void sort1(int[] array) {

        if (array.length <= 1) {
            return; //如果只有一个元素就不用排序了
        }

        for (int i = 0; i < array.length; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                //此处你可能会疑问的j<array.length-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (array[j] > array[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break; //没有数据交换，数组已经有序，退出排序
            }
        }
    }

    // 快速排序  参考 [https://blog.csdn.net/shujuelin/article/details/82423852]
    // 按照从小到大排序
    public static void sort2(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    // 归并排序 [https://blog.csdn.net/qq_36442947/article/details/81612870]
    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void sort3(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length]; //辅助数组
        int p1 = left, p2 = mid + 1, k = left; //p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                tmp[k++] = arr[p1++];
            } else {
                tmp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            tmp[k++] = arr[p1++]; //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        }
        while (p2 <= right) {
            tmp[k++] = arr[p2++]; //同上
        }

        //复制回原素组
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2; //划分子序列
            mergeSort(arr, start, mid); //对左侧子序列进行递归排序
            mergeSort(arr, mid + 1, end); //对右侧子序列进行递归排序
            merge(arr, start, mid, end); //合并
        }
    }

    // 插入排序 [https://blog.csdn.net/qq_42857603/article/details/81605124]
    public static void sort4(int[] arr) {
        for (int index = 1; index < arr.length; index++) {//外层向右的index，即作为比较对象的数据的index
            int temp = arr[index]; //用作比较的数据
            int leftindex = index - 1;
            while (leftindex >= 0 && arr[leftindex] > temp) {//当比到最左边或者遇到比temp小的数据时，结束循环
                arr[leftindex + 1] = arr[leftindex];
                leftindex--;
            }
            arr[leftindex + 1] = temp; //把temp放到空位上
        }
    }

    // 选择排序 [https://www.cnblogs.com/LearnAndGet/p/10242484.html] selectSort
    public static void sort5(int[] arr) {
        int maxElement = 0;
        int maxElementIndex = 0;
        //外层循环，控制选择的次数，数组长度为6，一共需要选择5次
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (maxElement < arr[j]) {
                    maxElement = arr[j];
                    maxElementIndex = j;
                }
            }
            //每次选择完成后，max中存放的是该轮选出的最大值
            //将max指向位置的元素和数组最后一个元素位置互换
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = maxElement;
            arr[maxElementIndex] = temp;
            //清空max和index，便于下次
            maxElement = 0;
            maxElementIndex = 0;
        }
    }

    // 堆排序 [https://blog.csdn.net/qq_36186690/article/details/82505569]
    public static void sort6(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j); //将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j); //重新对堆进行调整
        }

    }

    // 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp; //将temp值放到最终的位置
    }

    // 交换元素
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

