package com.github.DeeJay0921.DataStructure;

public class CreateDoublyLinkedList {
    public static void main(String[] args) {
        // Complete createDoublyLinkedList() method to make the program output "3,2,1"
        LinkedListNode head = createDoublyLinkedList();
        LinkedListNode tail = head.next.next;
        System.out.println("" + tail.value + "," + tail.prev.value + "," + tail.prev.prev.value);
    }

    // Create a doubly linked list: 1 ⇋ 2 ⇋ 3 and return the head node
    public static LinkedListNode createDoublyLinkedList() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        LinkedListNode third = new LinkedListNode(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        return head;
    }
}
