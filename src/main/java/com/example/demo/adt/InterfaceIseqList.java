package com.example.demo.adt;

public interface InterfaceIseqList<T>{

    boolean isEmpty();
    int length();
    T get(int index);
    T set(int index,T data);
    T remove(int index);
    boolean removeAll(T data);
    int indexOf(T data);
    int lastIndexOf(T data);
    String toString();
    boolean add(int index,T data);
    boolean add(T data);
}
