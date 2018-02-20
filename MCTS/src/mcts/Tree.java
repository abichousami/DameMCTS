package mcts;

public class Tree {
    Node root;

    public Tree() {
        root = new Node();
        System.out.println("Tree() cree");
    }

    public Tree(Node root) {

        System.out.println("Tree(Node root)");
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addChild(Node parent, Node child) {
        System.out.println("enfant ajouté");
        
        parent.getChildArray().add(child);
    }

}
