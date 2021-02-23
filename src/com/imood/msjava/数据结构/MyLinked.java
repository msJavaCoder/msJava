package com.imood.msjava.数据结构;

/**
 * @author msJava
 * @Description: 链表基础操作
 */
public class MyLinked {

    /**
     * 静态内部类 定义链表
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //  头结点 、 尾结点 、 链表实际长度
    private Node head;
    private Node last;
    private int size;


    /**
     * 指定位置插入元素
     *
     * @param data
     * @param index
     * @throws Exception
     */
    public void inser(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表实际节点范围！");
        }

        Node insertNode = new Node(data);

        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            last.next = insertNode;
            insertNode = last;
        } else {
            // 获得 插入的位置前面一个元素
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 删除指定位置的链表元素
     *
     * @param index 指定位置
     * @return 删除的元素
     * @throws Exception
     */
    public Node delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表实际节点范围！");
        }

        Node removeNode = null;

        if (size == 0) {
            removeNode = head;
            head = head.next;
        } else if (size - 1 == index) {
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return removeNode;
    }

    /**
     * 获取指定位置的前一个元素
     *
     * @param index 指定位置
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表实际节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


}
