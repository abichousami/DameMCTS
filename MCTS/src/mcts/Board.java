package mcts;



import java.util.ArrayList;
import java.util.List;





public class Board {
	int[][] boardValues;

	List<Moves> totalMove = new ArrayList<>(); 
	public static final int DEFAULT_BOARD_SIZE = 9;

	public static final int IN_PROGRESS = -1;
	public static final int DRAW = 0;
	public static final int P1 = 1;
	public static final int P2 = 2;


	public Board() {
		boardValues = new int[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
		for(int k=0; k<9*3; k+=2){
			int i;
			int j;
			i=k/9;
			j=k%9;
			boardValues[i+6][j]=P1;

			boardValues[i][9-j-1]=P2;

			//			getCase(j).add(creerPion(Couleur.NOIR, false));
			//getCase(9*9-j-1).add(creerPion(Couleur.BLANC, true));

		}

	}
	

	
	
	public Board(int boardSize) {
		boardValues = new int[boardSize][boardSize];
	}

	public Board(int[][] boardValues) {
		this.boardValues = boardValues;
	}



	public Board(Board board) {
		int boardLength = board.getBoardValues().length;
		this.boardValues = new int[boardLength][boardLength];
		int[][] boardValues = board.getBoardValues();
		int n = boardValues.length;
		for (int i = 0; i < n; i++) {
			int m = boardValues[i].length;
			for (int j = 0; j < m; j++) {
				this.boardValues[i][j] = boardValues[i][j];
			}
		}
	}

	public void performMove(int player, Position p1,Position p) {

		if(Math.abs(p.getX()-p1.getX())==2){
			int i = (p.getX()+p1.getX())/2;
			int j = (p.getY()+p1.getY())/2;
			boardValues[i][j]=0;}
		boardValues[p.getX()][p.getY()] = player;
		boardValues[p1.getX()][p1.getY()] = 0;


	}



	public int[][] getBoardValues() {
		return boardValues;
	}


	public void setBoardValues(int[][] boardValues) {
		this.boardValues = boardValues;
	}



	public int checkStatus() { 

		int j1=0;
		int j2=0;
		int j7=0;

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){

				if (boardValues[i][j]==1) j1++; 
				if (boardValues[i][j]==2) j2++; 
			}
		}
		if (j1<10){ return P2;}
		else
			if (j2<10){ return P1;}
			else{return IN_PROGRESS;}


		/*
				if (boardValues[i][j]==1) j1++; 
				if (boardValues[i][j]==2) j2++; 
				if (boardValues[i][j]==7) j7++; 


			}

    	}

    	if (j1==0){ return P2;}
    	else
    		if (j2==0){ return P1;}
    	else{
    		if (j7==0){
    			if(j1>j2)return P1;
    			else if(j1<j2)return P2;



    			return DRAW;}
    		else{
		return IN_PROGRESS;*/
	}



	public void printBoard() {
		int size = this.boardValues.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(boardValues[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void  VueGrille()
	{



		System.out.println("  0   1   2   3   4   5   6   7   8\t\t\t\t\t");
		System.out.println(" _________________________________");
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print("| ");
				if (boardValues[i][j]!=0){

					if(boardValues[i][j]==P1)
						System.out.print("X" + " ");
					else
						if(boardValues[i][j]==P2)
							System.out.print("O" + " ");
						else
							if(boardValues[i][j]==7) System.out.print("=" + " ");
				}

				else

					System.out.print(" " + " ");
			}
			System.out.println("|");
			System.out.println("|___|___|___|___|___|___|___|___|___|  "+i);
		}
		//System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");


	}	




	public void allPossibleMoves( int couleur){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){

				if (boardValues[i][j]==couleur){
					selectionnerCases(i, j, couleur);

				}
			}
		}
	}



	public void selectionnerCases(int i, int j, int couleur){

		if(couleur==P1){


			if(i-1>=0 && j-1>=0 && boardValues[i-1][j-1]==0){
				//boardValues[i-1][j-1]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i-1,j-1)));

			}
			else if(i-2>=0 && j-2>=0 && boardValues[i-2][j-2]==0 && !((boardValues[i-1][j-1])==couleur)&& !((boardValues[i-1][j-1])==7)){
				//boardValues[i-2][j-2]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i-2,j-2)));
			}

			if(i-1>=0 && j+1<9 && boardValues[i-1][j+1]==0){
				//boardValues[i-1][j+1]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i-1,j+1)));
			}
			else if(i-2>=0 && j+2<9 && boardValues[i-2][j+2]==0 && !((boardValues[i-1][j+1])==couleur)&& !((boardValues[i-1][j+1])==7)){
				//boardValues[i-2][j+2]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i-2,j+2)));
			}
		}
		else{
			if(i+1<9 && j+1<9 && boardValues[i+1][j+1]==0){
				//boardValues[i+1][j+1]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i+1,j+1)));
			}
			else if(i+2<9 && j+2<9 && boardValues[i+2][j+2]==0 && !((boardValues[i+1][j+1])==couleur)&& !((boardValues[i+1][j+1])==7)){
				//boardValues[i+2][j+2]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i+2,j+2)));
			}
			if(i+1<9 && j-1>=0 && boardValues[i+1][j-1]==0){
				//boardValues[i+1][j-1]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i+1,j-1)));
			}
			else if(i+2<9 && j-2>=0 && boardValues[i+2][j-2]==0 && !((boardValues[i+1][j-1])==couleur)&& !((boardValues[i+1][j-1])==7)){
				//boardValues[i+2][j-2]=7;
				totalMove.add(new Moves(new Position(i,j),new Position(i+2,j-2)));


			}


		}

	}


	public void printStatus() {

		switch (this.checkStatus()) {
		case P1:
			System.out.println("Player 1 wins");
			break;
		case P2:
			System.out.println("Player 2 wins");
			break;
		case DRAW:
			System.out.println("Game Draw");
			break;
		case IN_PROGRESS:
			System.out.println("Game In rogress");
			break;
		}
	}
}
