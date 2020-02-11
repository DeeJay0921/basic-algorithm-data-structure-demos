package com.github.DeeJay0921.DataStructure;

public class ImplementStack {
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 16;
    private static int lastElementIndex;

    public ImplementStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        lastElementIndex = 0;
    }

    // 将一个元素压入栈内
    public void push(int value) {
        elements[lastElementIndex] = value;
        lastElementIndex += 1;
    }

    // 从栈顶弹出一个元素
    public int pop() {
        lastElementIndex -= 1;
        return elements[lastElementIndex];
    }
}
