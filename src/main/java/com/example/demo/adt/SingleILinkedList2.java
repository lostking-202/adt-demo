package com.example.demo.adt;

//含有头节点和尾节点的单向链表,头节点一定有而且为空节点
public class SingleILinkedList2<T> implements InterfaceLinkedList<T>{
    protected Node<T> head;
    protected Node<T> foot;
    public SingleILinkedList2(){
        head=foot=new Node<>(null);
    }
    public SingleILinkedList2(Node<T> head){
        this();
        this.head.next=head;
        this.foot=head;
    }
    @Override
    public boolean isEmpty() {
        return this.head.next==null;
    }

    @Override
    public int length() {
        int length=0;
        Node<T> currentNode=this.head.next;
        while(currentNode!=null){
            currentNode=currentNode.next;
            length++;
        }
        return 0;
    }

    @Override
    public T get(int index) {
        Node<T> currentNode=this.head.next;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T set(int index, T data) {
        Node<T> currentNode=this.head.next;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        T old=currentNode.data;
        currentNode.data=data;
        return old;
    }

    @Override
    public boolean add(int index, T data) {
        Node<T> currentNode=this.head.next;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        Node<T> next=currentNode.next;
        currentNode.next=new Node<>(data,next);
        return true;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public boolean removeAll(T data) {
        boolean isRemoved=false;
        Node<T> front=this.head;
        Node<T> pre=front.next;
        while(pre!=null){
            if(data.equals(pre.data)){
                if(data.equals(foot.data)){
                    this.foot=front;
                }
                front.next=pre.next;
                pre=front.next;
                isRemoved=true;
            }else{
                //指针后移
                front=pre;
                pre=pre.next;
            }
        }
        return isRemoved;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        this.head.next=null;
        this.foot=this.head;
    }
}
