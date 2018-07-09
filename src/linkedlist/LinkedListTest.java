package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    @Test
    public void isEmpty(){
        LinkedList<String> isEmpty = new LinkedList<>();
        assertTrue(isEmpty.isEmpty());
    }

    @Test
    public void addElements(){
        LinkedList<String> elements = new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            elements.add(String.valueOf(i));
        }
        assertTrue(elements.get(4).equals("4"));
    }
}
