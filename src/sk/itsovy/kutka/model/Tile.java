package sk.itsovy.kutka.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tile {
    private int value;
    private Set<Integer> available;

    public Tile(int value) {
        this.value = value;
        this.available = new HashSet<>();
        if (value > 0) {
            available = null;
        } else {
            Integer[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            Collections.addAll(available, temp);
        }


    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean contains(int value) {
        return available.contains(value);
    }

    public void remove(int value) {
        available.remove(value);
    }

    public void add(int value) {
        available.add(value);
    }

    public int getSize() {
        return available.size();
    }

    public Set<Integer> getAvailable() {
        return available;
    }
}
