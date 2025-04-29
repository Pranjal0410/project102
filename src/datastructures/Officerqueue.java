package datastructures;

import models.Officer;
import java.util.LinkedList;
import java.util.Queue;

public class Officerqueue {
    private Queue<Officer> officers;

    public Officerqueue() {
        this.officers = new LinkedList<>();
    }

    public void addOfficer(Officer officer) {
        officers.offer(officer);
    }

    public Officer getNextOfficer() {
        return officers.poll();
    }

    public boolean isEmpty() {
        return officers.isEmpty();
    }

    public int size() {
        return officers.size();
    }
} 