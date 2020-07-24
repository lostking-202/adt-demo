package com.example.demo.adt;

//简单的底层是数组的list，允许空值，允许重复，数组的大小等于list的大小，需要随时扩容
public class ISeqList1<T> implements InterfaceIseqList<T> {

    Object[] table;

    //只表示list的大小，不表示数组大小
    int length;

    public ISeqList1(){
        table=new Object[0];
        length=table.length;
    }

    public ISeqList1(int size){
        table=new Object[size];
        length=table.length;
    }
    @Override
    public boolean isEmpty() {
        return length<1;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int index) {
        if(index>=0&&index<this.length){
            return (T) this.table[index];
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if(index>=0&&this.length()>index&&data!=null){
            T old=this.get(index);
            this.table[index]=data;
            return old;
        }
        return null;
    }

    @Override
    public T remove(int index) {
        Object[] temp=this.table;
        fastRemove(temp,index);
        length--;
        return (T)temp[index];
    }

    private void fastRemove(Object[] temp,int index){
        table=new Object[length-1];
        for(int i=0;i<index-1;i++){
            table[i]=temp[i];
        }
        if(temp.length>index+1){
            for(int i=index;i<temp.length-1;i++){
                table[i]=temp[i+1];
            }
        }

    }

    //移除所有equals的元素
    @Override
    public boolean removeAll(T data) {
        Object[] temp=this.table;
        //每移除一个元素，索引必须向前偏移一位
        int j=0;
        if(data==null){
            for(int i=0;i<temp.length;i++){
                if(temp[i]==null){
                    fastRemove(table,i-j);
                    j++;
                    length--;
                }
            }
        }else{
            for(int i=0;i<temp.length;i++){
                if(data.equals(temp[i])){
                    fastRemove(table,i-j);
                    j++;
                    length--;
                }
            }
        }
        return true;
    }

    @Override
    public int indexOf(T data) {
        if(data==null){
            for(int i=0;i<length;i++){
                if(table[i]==null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<length;i++){
                if(data.equals(table[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        if(data==null){
            for(int i=length;i>0;i--){
                if(table[i]==null){
                    return i;
                }
            }
        }else{
            for(int i=length;i>0;i--){
                if(data.equals(table[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean add(int index, T data) {
        if(index>table.length){
            Object[] temp=this.table;
            //对数组进行扩容处理
            table=new Object[index];
            for(int i=0;i<temp.length-1;i++){
                table[i]=temp[i];
            }
            temp[index]=data;
            length=index;
            return true;
        }
        if(index<table.length){
            Object[] temp=this.table;
            //对数组进行扩容处理
            table=new Object[table.length+1];
            for(int i=0;i<index;i++){
                table[i]=temp[i];
            }
            table[index]=data;
            for(int i=index+1;i<length;i++){
                table[i+1]=temp[i];
            }
            length++;
            return true;
        }
        return false;
    }
    @Override
    public boolean add(T data) {
        //对数据进行扩容处理
        Object[] temp=this.table;
        table=new Object[length+1];
        for(int i=0;i<length;i++){
            table[i]=temp[i];
        }
        table[length]=data;
        length++;
        return true;
    }
}
