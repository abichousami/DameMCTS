package mcts;


import java.util.ArrayList;
import java.util.List;



public class State {
    private Board board;
    private int playerNo;
    private int visitCount;
    private double winScore;

    public State() {
        board = new Board();
        this.board.allPossibleMoves(this.playerNo);
    }

    public State(State state) {
        this.board = new Board(state.getBoard());
        this.playerNo = state.getPlayerNo();
        this.visitCount = state.getVisitCount();
        this.winScore = state.getWinScore();
        this.board.allPossibleMoves(this.playerNo);
    }

    public State(Board board) {
        this.board = new Board(board);
        this.board.allPossibleMoves(this.playerNo);
    }

    Board getBoard() {
        return board;
    }

    void setBoard(Board board) {
        this.board = board;
    }

    int getPlayerNo() {
        return playerNo;
    }

    void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    int getOpponent() {
        return 3 - playerNo;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    double getWinScore() {
        return winScore;
    }

    void setWinScore(double winScore) {
        this.winScore = winScore;
    }

    public List<State> getAllPossibleStates() {
    	
        List<State> possibleStates = new ArrayList<>();
        this.board.allPossibleMoves(this.playerNo);
        List<Moves> availablePositions = this.board.totalMove;
        
        availablePositions.forEach(p -> {
            State newState = new State(this.board);
            newState.setPlayerNo(3 - this.playerNo);
            newState.getBoard().performMove(newState.getPlayerNo(), p.MoveI,p.MoveF);
            possibleStates.add(newState);
        });
        return possibleStates;
    }

    void incrementVisit() {
        this.visitCount++;
    }

    void addScore(double score) {
        if (this.winScore != Integer.MIN_VALUE)
            this.winScore += score;
    }

    void randomPlay() {
    	
        List<Moves> availablePositions = this.board.totalMove;
        int totalPossibilities = board.totalMove.size();
        int selectRandom = (int) (Math.random() * ((totalPossibilities - 1) + 1));
        this.board.performMove(this.playerNo, availablePositions.get(selectRandom).MoveI,availablePositions.get(selectRandom).MoveF);
        System.out.println("");
        board.printBoard();
        System.out.println("");
    }
    

    void togglePlayer() {
        this.playerNo = 3 - this.playerNo;
    }
}
