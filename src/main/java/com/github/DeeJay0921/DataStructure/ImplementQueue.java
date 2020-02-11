package com.github.DeeJay0921.DataStructure;

public class ImplementQueue {
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 16;
    private static int lastElementIndex;

    public ImplementQueue() {
        this.elements = new int[DEFAULT_CAPACITY];
        lastElementIndex = 0;
    }

    // 将一个元素添加到队列尾部
    public void add(int value) {
        elements[lastElementIndex] = value;
        lastElementIndex += 1;
    }

    // 将一个元素从队列头部移走
    public int remove() {
        lastElementIndex -= 1;
        int firstElement = elements[0];
        for (int i = 0; i <= lastElementIndex; i++) {
            // remove第一个元素 所以置空 将后面所有元素前移一位
            if ((i + 1) >= elements.length) { // 处理数组越界
                elements[i] = 0;
            } else {
                elements[i] = elements[i + 1];
            }
        }
        return firstElement;
    }
}
