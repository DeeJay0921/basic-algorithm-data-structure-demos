package com.github.DeeJay0921.Algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb"));
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy"));
    }

    // 给定一个按照字符串升序升序排好序的用户数组，寻找目标字符串的位置，返回其索引值
    // 如果未找到，返回-1
    public static int binarySearch(String[] strings, String target) {
        int start = 0, end = strings.length - 1;
        while (true) {
            if (strings[start].equals(target)) {
                return start;
            }

            if (strings[end].equals(target)) {
                return end;
            }

            if ((target.compareTo(strings[start]) < 0) || (target.compareTo(strings[end]) > 0)) {
                return -1;
            }

            int mid = (start + end) / 2;
            if (target.compareTo(strings[mid]) < 0) {
                end = mid - 1;
            } else if (target.compareTo(strings[mid]) > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
    }
}
