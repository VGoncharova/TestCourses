package linkedlist;

import java.util.*;

public class LinkedList<Param> implements List<Param> {
    private class Knot<Param> {
        public Knot<Param> prev;
        public Knot<Param> next;
        public Param value;

        public Knot(Knot<Param> prev, Knot<Param> next, Param value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public Knot<Param> head;
    public Knot<Param> tail;


    public LinkedList() {

    }


    @Override
    public int size() {
        Knot<Param> pointer = head;
        int size = 0;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Knot<Param> pointer = head;
        while (pointer!=null){
            if (pointer.value.equals(o)){
                return true;
            }else{
                pointer = pointer.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<Param> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Param param) {
        if (head==null&&tail==null){
            Knot<Param> element = new Knot<>(null, null, param);
             head=element;
             tail=element;
        }else {
            Knot<Param> element = new Knot<>(tail, null, param);
            tail.next=element;
            tail=element;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Param> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Param> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Param get(int index) {
        Knot<Param> pointer = head;
        for (int i = 0; i <index ; i++) {
            pointer=pointer.next;
        }
        return pointer.value;
    }

    @Override
    public Param set(int index, Param element) {
        return null;
    }

    @Override
    public void add(int index, Param element) {

    }

    @Override
    public Param remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Param> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Param> listIterator(int index) {
        return null;
    }

    @Override
    public List<Param> subList(int fromIndex, int toIndex) {
        return null;
    }
}

