package com.example.demo.adt;

//只含有头节点的单向链表
public class SingleILinkedList<T> implements InterfaceLinkedList<T>{
    protected Node<T> headNode;
    public SingleILinkedList(Node<T> head){
        this.headNode=head;
    }
    @Override
    public boolean isEmpty() {
        return this.headNode==null;
    }

    @Override
    public int length() {
        int length=0;
        Node<T> p=headNode;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }

    @Override
    public T get(int index) {
        Node<T> p=headNode;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p.data;
    }

    @Override
    public T set(int index, T data){
        Node<T> p=headNode;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        T old=p.data;
        p.data=data;
        return old;
    }

    @Override
    public boolean add(int index, T data) {
        Node<T> p=headNode;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        Node<T> node=new Node<>(data,p.next);
        p.next=node;
        return true;
    }

    @Override
    public boolean add(T data) {
        Node<T> p=headNode;
        while(p!=null){
            p=p.next;
        }
        Node<T> node=new Node<>(data,null);
        p.next=node;
        return true;
    }

    @Override
    public boolean removeAll(T data) {
        int length=0;
        Node<T> p=headNode;
        while(p!=null){
            p=p.next;
            if(data.equals(p.data)){
                remove(length);
                //比如移除了第5个节点，原来的第6个节点变成了现在的第5个节点
                length--;
            }
            length++;
        }
        return true;
    }

    @Override
    public T remove(int index) {
        Node<T> p=headNode;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        T data=p.next.data;
        p.next.next=p.next;
        return data;
    }

    @Override
    public void clear() {
        headNode=null;
    }
}

