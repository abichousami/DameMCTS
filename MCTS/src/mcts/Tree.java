package mcts;

import java.util.concurrent.TimeUnit;

public class Tree {
	
    static Node root;
    
    public Tree() {
       root = new Node();
        
        
        System.out.println("Tree() cree");
    }

    public Tree(Node root) {

        System.out.println("Tree(Node root)");
        this.root = root;
    }

    static  public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addChild(Node parent, Node child) {
        System.out.println("enfant ajouté");
        
        if(parent.getChildArray().size()==0)System.out.println("_");
        else System.out.print("_FILS_ ");//child.state.get.
//      try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        parent.getChildArray().add(child);
    }

}
