package br.com.rr.datastructure.domain.domain;

public class Tree {

    private Node root;

    public Tree(Integer value) {
        this.root = new Node(value);
    }

    public void add(Integer value) {
        this.add(root, value);
    }

    private Node add(Node node, Integer value) {
        if (node == null) {
            return new Node(value);
        }

        if (node.getValue().equals(value)) {
            return node;
        }

        if (node.getValue() < value) {
            node.setRight(add(node.getRight(), value));
        } else {
            node.setLeft(add(node.getLeft(), value));
        }

        return node;
    }

    public Node find(Integer value) {
        return this.find(this.root, value);
    }

    private Node find(Node node, Integer value) {
        if(node == null || node.getValue().equals(value)) {
            return node;
        }

        Node found = this.find(node.getLeft(), value);
        if(found == null) {
            found = this.find(node.getRight(), value);
        }

        return found;
    }
}