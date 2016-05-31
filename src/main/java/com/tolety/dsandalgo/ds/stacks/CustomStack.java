package com.tolety.dsandalgo.ds.stacks;

public class CustomStack {

    Node current;
    int maxSize;
    int size;

    public CustomStack(int size) {
        this.maxSize = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean push(int value) {
        if (size < maxSize) {
            Node node = new Node(value);
            node.prev = current;
            current = node;
            size++;
            return true;
        }
        return false;
    }

    public int pop() {
        if (size > 0) {
            Node node = current;
            current = current.prev;
            size--;
            return node.data;
        }
        return 0;
    }

    public int peek() {
        if (size > 0) {
            return current.data;
        }
        return 0;
    }

    public void printStack() {
        Node temp = current;
        if (temp != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            } while (temp != null);
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        CustomStack stack = new CustomStack(5);
        stack.push(4);
        stack.push(6);
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(5);
        stack.printStack();
    }
}
