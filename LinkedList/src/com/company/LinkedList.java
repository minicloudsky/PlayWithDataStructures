package com.company;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import javax.security.auth.callback.TextInputCallback;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    // 虚拟头结点 dummyHead
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表元素个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表的 index(0 - based) 位置添加新的元素 e
    // 在链表中不是常用操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. index eror .");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 尾节点添加节点
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表的 第 index (0 - based) 个位置的元素
    // 在链表藏獒囊个不是一个常用操作，练习用
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index Error");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    // 获取链表第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 设置第 index 位置的值为 e
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index Error");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否含有元素 e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e == e) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur + " -> ");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    // 从链表中删除 index (0 - based) 位置的元素，返回删除的元素
    // 在链表中不是一个常用操作，练习用
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index Error");
        Node prev = dummyHead;
        // 让 prev 走到待删除节点的前一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;
        size--;
        return deleteNode.e;
    }

    // 删除第一个元素
    public E removeFirst() {
        return this.remove(0);
    }

    // 删除最后一个元素
    public E removeLast() {
        return this.remove(size - 1);
    }


}
