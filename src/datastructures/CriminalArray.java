package datastructures;

import models.Criminal;

public class CriminalArray {
    private Criminal[] criminals;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public CriminalArray() {
        criminals = new Criminal[INITIAL_CAPACITY];
        size = 0;
    }

    public void insert(Criminal criminal) {
        if (size == criminals.length) {
            resize();
        }
        criminals[size++] = criminal;
    }

    private void resize() {
        Criminal[] newArray = new Criminal[criminals.length * 2];
        System.arraycopy(criminals, 0, newArray, 0, criminals.length);
        criminals = newArray;
    }

    public Criminal search(String id) {
        for (int i = 0; i < size; i++) {
            if (criminals[i].getId().equals(id)) {
                return criminals[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
} 