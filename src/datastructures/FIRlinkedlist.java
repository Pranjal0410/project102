package datastructures;

import models.Fir;

public class FIRlinkedlist {
    private class Node {
        Fir fir;
        Node next;

        Node(Fir fir) {
            this.fir = fir;
            next = null;
        }
    }

    private Node head;

    public FIRlinkedlist() {
        head = null;
    }

    public void addFIR(Fir fir) {
        Node newNode = new Node(fir);
        
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Fir searchFIR(String firNumber) {
        Node current = head;
        while (current != null) {
            if (current.fir.getFirNumber().equals(firNumber)) {
                return current.fir;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAllFIRs() {
        if (head == null) {
            System.out.println("No FIRs in the system.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.fir);
            System.out.println("------------------------");
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
} 