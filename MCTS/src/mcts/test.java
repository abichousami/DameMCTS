package mcts;

import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	      /*Board board = new Board();
	      board.printBoard();
	      //board.performMove(board.P1, new Position(1,3), new Position(0,2));
	      
	      board.VueGrille();
	      //board.performMove(board.P1, new Position(0,4), new Position(1,3));
	      //board.performMove(board.P2, new Position(5,1), new Position(0,0));
	      System.out.println("");
	      
	      board.VueGrille();
	      
	      //board.selectionnerCases(6, 0, board.P1);
	      //board.selectionnerCases(6, 8, board.P1);
	    //  board.selectionnerCases(6, 4, board.P1);
	      board.VueGrille();
	      System.out.println("");
	      board.printBoard();

	      board.performMove(board.P2, new Position(0,0), new Position(5,1));
	      //board.selectionnerCases(5, 4, board.P1);
	      //board.selectionnerCases(5, 4, board.P1);

	      //board.selectionnerCases(5, 4, board.P1);
	      //board.selectionnerCases(2, 0, board.P2);
	      System.out.println("");
	      board.printBoard();
	      //board.performMove(board.P1, new Position(6,0), new Position(4,2));
	      System.out.println("");
	      board.printBoard();
	    //  board.allPossibleMoves(board.P1);

	      board.allPossibleMoves(board.P1);
	      System.out.println("");
	      board.printBoard();
	      
	      board.VueGrille();
	      
	      board.totalMove.forEach(Moves -> {
	    	  
	    	  System.out.println(Moves.MoveI.getX()+","+Moves.MoveI.getY()+"--->"+Moves.MoveF.getX()+","+Moves.MoveF.getY());
	      
	      });  

	        List<Moves> availablePositions = board.totalMove;
	      int totalPossibilities = board.totalMove.size();
	      int selectRandom = (int) (Math.random() * ((totalPossibilities - 1) + 1));
	        board.performMove(1, availablePositions.get(selectRandom).MoveI,availablePositions.get(selectRandom).MoveF);
	        board.allPossibleMoves(board.P1);
	        board.VueGrille();*/
		// Tree gameTree;
		    MonteCarloTreeSearch mcts;

		   
		  //      gameTree = new Tree();
		        mcts = new MonteCarloTreeSearch();
		        Board board = new Board();
		        System.out.println("status======"+board.checkStatus()); 
		       // board.performMove(board.P1, new Position(1,3), new Position(0,2));
		       // System.out.println("status======"+board.checkStatus()); 
		          
			      board.VueGrille();
			      //
			      
			    //board.performMove(board.P1, new Position(0,4), new Position(1,3));
			    //System.out.println("status======"+board.checkStatus()); 
		        
			    //
			   // board.performMove(board.P1, new Position(5,1), new Position(0,0));
			     // System.out.println("");
			      //System.out.println("status======"+board.checkStatus()); 
			          
			      	
		            int player = Board.P2;
		        
		            mcts.setLevel(3);
		        	board = mcts.findNextMove(board, player);
		                       
		                        System.out.println("player"+player);
		        
		        int winStatus = board.checkStatus();
		        System.out.println("board final");
		        board.VueGrille();
		       
		        Node root1= Tree.getRoot();
		        root1= root1.getParent();
		        // root1= root1.getParent();
		        //UCT.afficheBestNodeWithUCT(root1);
		        
		       root1.parcourir(root1);
		      
		        	
		        }
		        
		    
		        

		        
	

}
