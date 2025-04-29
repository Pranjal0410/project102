package datastructures;

import models.Criminal;

public class CriminalBST {
    private class Node {
        Criminal criminal;
        Node left, right;

        Node(Criminal criminal) {
            this.criminal = criminal;
            left = right = null;
        }
    }

    private Node root;

    public CriminalBST() {
        root = null;
    }

    public void insert(Criminal criminal) {
        root = insertRec(root, criminal);
    }

    private Node insertRec(Node root, Criminal criminal) {
        if (root == null) {
            root = new Node(criminal);
            return root;
        }

        if (criminal.getId().compareTo(root.criminal.getId()) < 0)
            root.left = insertRec(root.left, criminal);
        else if (criminal.getId().compareTo(root.criminal.getId()) > 0)
            root.right = insertRec(root.right, criminal);

        return root;
    }

    public Criminal search(String id) {
        Node result = searchRec(root, id);
        return result == null ? null : result.criminal;
    }

    private Node searchRec(Node root, String id) {
        if (root == null || root.criminal.getId().equals(id))
            return root;

        if (id.compareTo(root.criminal.getId()) < 0)
            return searchRec(root.left, id);

        return searchRec(root.right, id);
    }
} 