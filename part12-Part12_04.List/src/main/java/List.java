/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class List<T> {
    private T[] list;
    private int freeIndex;

    public List() {
        list = (T[]) new Object[10];
        freeIndex = 0;
    }

    public void add(T value) {
        if (freeIndex == list.length) {
                grow();
        }

        list[freeIndex] = value;
        freeIndex++;
    }
    
    public T get(T item){
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return list[i];
            }
        }
        return null;
    }

    private void grow() {
        int newSize = list.length + list.length / 2;
        T[] newValuesList = (T[]) new Object[newSize];
        for (int i = 0; i < list.length; i++) {
                newValuesList[i] = list[i];
        }
        list = newValuesList;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }

        shiftValuesLeft(indexOfValue);
        freeIndex--;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void shiftValuesLeft(int fromIndex) {
        for (int i = fromIndex; i < list.length; i++) {
            list[i] = list[i + 1];
        }
    }

    public int size() {
        return freeIndex;
    }
}
