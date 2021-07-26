package com.yyf.lagou;

import sun.awt.geom.AreaOp;

import java.util.*;

public class SimpleMap implements Map {

    private int size = 0;
    //初始化容量16
    private int capacity = 1 << 4;
    //负载因子
    private double loadRate = 0.75d;
    //数组容器
    private Node[] table = null;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Set set = this.keySet();
        return set.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        Collection values = this.values();
        return values.contains(value);
    }

    @Override
    public Object get(Object key) {
        //size = 0
        if(size == 0 || table == null) return null;
        int hashCode = hash(key);
        //计算下标位置
        Node node = table[hashCode & (table.length - 1)];
        if(null != node){
            if(hashCode == node.hashCode && key.equals(node.key)){
                return node.value;
            }else {
                if(node.next != null){
                    //遍历链表获取key对应的值
                    Node tmp = node.next;
                    while (tmp != null){
                        if(hashCode == tmp.hashCode && key.equals(node.key)){
                            return node.value;
                        }
                        tmp.next = tmp;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if(null == table) reSize();
        int hashCode = hash(key);
        int index = hashCode & (table.length - 1);
        Node newNode = new Node(key, value, hashCode);
        Node indexNode = table[index];
        if(indexNode == null){
            table[index] = newNode;
        }else {
            if(indexNode.hashCode == newNode.hashCode && indexNode.key.equals(key)){
                indexNode.value = newNode.value;
            }else {
                while (indexNode.next != null){
                    indexNode = indexNode.next;
                }
                indexNode.next = newNode;
            }
        }
        size++;
        if(size > table.length * loadRate) reSize();
        return null;
    }

    @Override
    public Object remove(Object key) {
        int hashCode = hash(key);
        int index = hashCode & (table.length - 1);
        Object result = null;
        Node tmp = table[index];
        if(tmp != null){
            if(tmp.hashCode == hashCode && key.equals(tmp.key)){
                result = tmp;
                table[index] = tmp.next;
            }else {
                while (tmp.next != null){
                    if (tmp.next.hashCode == hashCode && key.equals(tmp.next.key)){
                        result = tmp.next.value;
                        tmp.next = tmp.next.next;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
        }
        return result;
    }

    @Override
    public void putAll(Map m) {
        Set<Map.Entry> set = m.entrySet();
        set.forEach(entry -> this.put(entry.getKey(),entry.getValue()));
    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        HashSet<Object> ketSet = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null){
                if(table[i].next != null){
                    Node tmp = table[i];
                    while (tmp != null){
                        ketSet.add(tmp.key);
                        tmp = tmp.next;
                    }
                }else {
                    ketSet.add(table[i].key);
                }
            }
        }
        return ketSet;
    }

    @Override
    public Collection values() {
        ArrayList<Object> values = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null){
                if(table[i].next != null){
                    Node tmp = table[i];
                    while (tmp != null){
                        values.add(tmp.value);
                        tmp = tmp.next;
                    }
                }else {
                    values.add(table[i].value);
                }
            }
        }
        return values;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public int hash(Object key){
        return key.hashCode() ^ (key.hashCode() >> 16);
    }

    //扩容
    public void reSize(){
        Node[] newTable;
        int oldLength = 0;
        if(table == null){
            newTable = new Node[capacity];
        }else {
            oldLength = table.length;
            if(oldLength < Integer.MAX_VALUE){
                newTable = new Node[oldLength * 2];
            }else {
                newTable = table;
            }
        }
        //rehash
        if(oldLength > 0 && newTable.length > oldLength){
            for (int i = 0; i < oldLength; i++) {
                Node node = table[i];
                if(node != null){
                    while (node != null) {
                        int index = node.hashCode & (newTable.length - 1);
                        if (newTable[index] == null) {
                            newTable[index] = node;
                        } else {
                            Node tmp = newTable[index];
                            while (tmp.next != null) {
                                tmp = tmp.next;
                            }
                            tmp.next = node;
                        }
                        node = node.next;
                    }
                }
            }
        }
        table = newTable;
    }

    class Node{

        private Object key;

        private Object value;

        private int hashCode;

        private Node next;

        public Node(Object key, Object value, int hashCode){
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setHashCode(int hashCode){
            this.hashCode = hashCode;
        }

        public int getHashCode(){
            return hashCode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        SimpleMap simpleMap = new SimpleMap();
        simpleMap.put("sda1","1");
        simpleMap.put("qwd2","2");
        simpleMap.put("asd3","3");
        simpleMap.put("asa4","4");
        simpleMap.put("fsd5","5");
        simpleMap.put("gkf6","6");
        simpleMap.put("afs7","7");
        simpleMap.put("asd8","8");
        simpleMap.put("gfg9","9");
        simpleMap.put("sdf10","10");
        simpleMap.put("sdf11","11");
        simpleMap.put("sdf12","12");
        simpleMap.put("sdf13","13");
        System.out.println(simpleMap.size);
        System.out.println(simpleMap.keySet());
        System.out.println(simpleMap.values());
    }
}
