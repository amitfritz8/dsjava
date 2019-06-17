package org.amit.ds;

import java.util.HashMap;

class LNode{
    int key;
    int value;
    LNode prev;
    LNode next;
 
    public LNode(int key, int value){
        this.key=key;
        this.value=value;
    }
}

class LRUCacheImpl {
    HashMap<Integer, LNode> map = null;
    int cap;
    LNode head = null;
    LNode tail = null;
 
    public LRUCacheImpl(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
    }
 
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
 
        LNode t = map.get(key);
 
        remove(t);
        setHead(t);
 
        return t.value;
    }
 
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	LNode t = map.get(key);
            t.value = value;
 
            remove(t);
            setHead(t);
        }else{ 
            if(map.size()>=cap){
                map.remove(tail.key);
                remove(tail);
            }
 
            LNode t = new LNode(key, value);
            setHead(t);
            map.put(key, t);
        }
    }
 
    //remove a node
    private void remove(LNode t){
        if(t.prev!=null){
            t.prev.next = t.next;
        }else{
            head = t.next;
        }
 
        if(t.next!=null){
            t.next.prev = t.prev;
        }else{
            tail = t.prev;
        }
    }
 
    //set a node to be head
    private void setHead(LNode t){
        if(head!=null){
            head.prev = t;
        }
 
        t.next = head;
        t.prev = null;
        head = t;
 
        if(tail==null){
            tail = head;
        }
    }
}