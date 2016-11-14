package poo.demos.containers;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimplyLinkedListTests {

    @Test
    public void addToList_producesCorrectIndex() {
        final SimplyLinkedList list = new SimplyLinkedList();
        int resultIndex = list.add("O Herrera é amigo");
        assertEquals(0, resultIndex);
        resultIndex = list.add("E o Nuno também");
        assertEquals(1, resultIndex);
    }

    @Test
    public void size_producesCorrectSize() {
        final SimplyLinkedList list = new SimplyLinkedList();
        list.add("O BdC não presta");
        list.add("e o outro também não");
        assertEquals(2, list.size());
    }

    @Test
    public void sizeOnEmptyList_producesZero() {
        final SimplyLinkedList list = new SimplyLinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void sizeOnANonEmptyList_producesCorrectValue() {
        final SimplyLinkedList list = new SimplyLinkedList();
        list.add("Estas galinhas não se calam...");
        list.add("E nem sequer veêm que estou aqui a escrever acerca delas :-P");
        assertEquals(2, list.size());
    }

    @Test
    public void isEmptyOnAnEmptyList_producesTrue() {
        final SimplyLinkedList list = new SimplyLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyOnANonEmptyList_producesFalse() {
        final SimplyLinkedList list = new SimplyLinkedList();
        list.add("Estas galinhas não se calam...");
        assertFalse(list.isEmpty());
    }

    @Test
    public void getOnANonEmptyList_producesCorrectElement() {
        final SimplyLinkedList list = new SimplyLinkedList();
        final String elem = "Estas galinhas não se calam...";
        final String anotherElement = "Este é que é!";
        list.add(elem);
        list.add(anotherElement);
        assertSame(elem, list.get(0));
        assertSame(anotherElement, list.get(1));
    }

    @Test
    public void test() {
        final SimplyLinkedList<String> list = new SimplyLinkedList<>();
        list.add("SLB");
        list.add("SLB");
        list.add("SLB");
        list.add("GLORIOSO, SLB");
        list.add("GLORIOOSOO, S L B");

        int[] array = { 26, 21, 21 };
        for(int elem : array)
            System.out.println(elem);

        for(int idx = 0; idx < list.size(); ++idx)
            System.out.println(list.get(idx));

        Iterable<String> iterable = list;
        Iterator<String> itr = iterable.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        for(String elem : iterable)
            System.out.println(elem);
    }
}
