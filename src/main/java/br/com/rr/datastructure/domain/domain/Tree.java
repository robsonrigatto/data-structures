package br.com.rr.datastructure.domain.domain;

public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

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

    public Integer getMin() {
        return this.getMin(this.root);
    }

    private Integer getMin(Node node) {
        if(node == null) {
            return null;
        }

        if(node.getLeft() == null) {
            return node.getValue();
        }

        return getMin(node.getLeft());
    }

    public Integer getSize() {
        return this.getSize(this.root);
    }

    private Integer getSize(Node node) {
        if(node == null) {
            return 0;
        }

        Integer leftSize = this.getSize(node.getLeft());
        Integer rightSize = this.getSize(node.getRight());

        return leftSize > rightSize ? leftSize + 1 : rightSize + 1;
    }

    public void remove(Integer value) {
        this.root = this.remove(value, this.root);
    }

    private Node remove(Integer value, Node node) {
        if(node == null) {
            return null;
        }

        if(node.getValue() > value) {
            node.setLeft(this.remove(value, node.getLeft()));
            return node;
        }

        if(node.getValue() < value) {
            node.setRight(this.remove(value, node.getRight()));
            return node;
        }

        if(node.getLeft() == null && node.getRight() == null) {
            return null;
        }

        if(node.getLeft() == null) {
            return node.getRight();
        }

        if(node.getRight() == null) {
            return node.getLeft();
        }

        Integer minInorder = this.getMin(node.getRight());
        node.setValue(minInorder);
        node.setRight(remove(minInorder, node.getRight()));

        return node;
    }
}