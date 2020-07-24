package com.example.demo.adt;

import org.junit.Test;

public class ListTest {
    @Test
    public void test(){
        InterfaceIseqList<String> b=new ISeqList1<>();
        System.out.println(b.isEmpty());
        System.out.println(b.length());

        b.add("a");
        b.add("a");
        b.add("b");
        b.removeAll("a");
        System.out.println(b.length());
        //HashMap
        //Queue
        //ArrayList
        //AbstractQueuedSynchronizer
        //ConcurrentHashMap
    }
    @Test
    public void test2(){
        int i = (5 - 1) & 6;
        System.out.println(i);
    }
}
