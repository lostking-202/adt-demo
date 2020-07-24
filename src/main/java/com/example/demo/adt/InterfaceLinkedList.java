package com.example.demo.adt;

public interface InterfaceLinkedList<T>{
    boolean isEmpty();
    int length();
    T get(int index);
    T set(int index,T data);
    boolean add(int index,T data);
    boolean add(T data);
    boolean removeAll(T data);
    T remove(int index);
    void clear();
    String toString();
}
