package com.example.demo.adt;

public class CircularSingleLinkedList<T> implements InterfaceLinkedList<T>{
    protected Node<T> head;
    protected Node<T> foot;
    public CircularSingleLinkedList(){
        this.head=new Node<>(null);
        this.head.next=head;
        this.foot=head;
    }
    @Override
    public boolean isEmpty() {
        return this.head.next==this.head;
    }

    @Override
    public int length() {
        Node<T> currentNode=this.head.next;
        int length=0;
        while(currentNode!=head){
            currentNode=currentNode.next;
            length++;
        }
        return length;
    }

    @Override
    public T get(int index) {
        Node<T> currentNode=this.head.next;
        int j=0;
        while(currentNode!=head&&j<index){
            currentNode=currentNode.next;
            j++;
        }
        return currentNode.data;
    }

    @Override
    public T set(int index, T data) {
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        return false;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }
}
