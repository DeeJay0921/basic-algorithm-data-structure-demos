package com.github.DeeJay0921.Algorithm;

public class RecusionBinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb"));
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy"));
    }

    public static int binarySearch(String[] strings, String target) {
        int start = 0, end = strings.length;
        return recusionBinarySearch(start, end, strings, target);
    }

    public static int recusionBinarySearch(int start, int end, String[] strings, String target) {
        int mid = (start + end) / 2;
        if (target.equals(strings[mid])) {
            return mid;
        }
        if (end - start == 1) {
            return -1;
        }
        if (target.compareTo(strings[mid]) < 0) {
            return recusionBinarySearch(start, mid, strings, target);
        } else {
            return recusionBinarySearch(mid, end, strings, target);
        }
    }
}
