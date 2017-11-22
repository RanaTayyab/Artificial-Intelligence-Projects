/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessplayer;

import Chess.ChessGame;

/**
 *
 * @author mubasher.baig
 */
public class L144316 extends ChessPlayer{
	chessMove bestMove = null;
    private int cutOffsProduced;
	 private final BoardEvaluator boardevaluator;
	 
	 public L144316()
	 {
		 this.boardevaluator = new StBoardEvaluator();
	 }
	
    
    public chessMove decideMoveUsingMinimax(ChessGame gameState, int MaxDepth, String Player){
   
    	String chessboard = gameState.getChessBoard().toString();
    
    	
    	  final long startTime = System.currentTimeMillis();
    	  
    	//chessMove bestMove = null;
    	  int highestSeenValue = Integer.MIN_VALUE;
          int lowestSeenValue = Integer.MAX_VALUE;
          int currentValue;
          chessMove move=null;
          System.out.println(Player + " Thinking upto depth = " + MaxDepth);
          
           int numMoves = Player.length();//gameState.currentPlayer().getLegalMoves().size();
           
           for (int i = 0;i<numMoves;i++/*final Move move : this.moveSorter.sort((board.currentPlayer().getLegalMoves()))*/)
           {
             //  final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
               if (/*moveTransition.getMoveStatus().isDone()*/true) {
            	   currentValue = Player.equals("Player2")?
            			   minAlphaBeta(gameState, MaxDepth - 1, highestSeenValue, lowestSeenValue,Player) :
                               maxAlphaBeta(gameState, MaxDepth - 1, highestSeenValue, lowestSeenValue,Player); 
            			   if (Player.equals("Player1") && currentValue > highestSeenValue) {
                               highestSeenValue = currentValue;
                               bestMove = move;
                               //setChanged();
                               //notifyObservers(bestMove);
                           }
                           else if (Player.equals("Player2") && currentValue < lowestSeenValue) {
                               lowestSeenValue = currentValue;
                               bestMove = move;
                               //setChanged();
                               //notifyObservers(bestMove);
                           }
               }
           }
    	
           long executionTime = System.currentTimeMillis() - startTime;
    	
    	
    	
          return bestMove;
    }

	public String toString()
	{
		return "MiniMaxWithAlphaBetaPruning";
	}
	
	
	
	  public int minAlphaBeta(final ChessGame board,
              final int depth,
              final int highest,
              final int lowest, String player) {
   if (depth == 0 ) {
       return this.boardevaluator.Evaluate(board, depth,player);
   }
   int currentLowest = lowest;
   for (int i = 0;i<player.length();i++/*final Move move : this.moveSorter.sort((board.currentPlayer().getLegalMoves()))*/)
   {
     //  final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
       if (/*moveTransition.getMoveStatus().isDone()*/true) {
           currentLowest = Math.min(currentLowest, maxAlphaBeta(board,
                   calculateQuiescenceDepth(board, bestMove, depth), highest, currentLowest, player));
           if (currentLowest <= highest) {
               this.cutOffsProduced++;
               break;
           }
       }
   }
   return currentLowest;
}
	  
	  
		
	  private int calculateQuiescenceDepth(ChessGame board, chessMove bestMove2, int depth) {
		// TODO Auto-generated method stub
		     return depth - 1;
	    }

	    private static String calculateTimeTaken(final long start, final long end) {
	        final long timeTaken = (end - start) / 1000000;
	        return timeTaken + " ms";
	    }


	public int maxAlphaBeta(final ChessGame board,
              final int depth,
              final int highest,
              final int lowest, String player) {
   if (depth == 0 ) {
       return this.boardevaluator.Evaluate(board, depth,player);
   }
   int currentHighest = highest;
   for (int i = 0;i<player.length();i++/*final Move move : this.moveSorter.sort((board.currentPlayer().getLegalMoves()))*/) {
     //  final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
	   if (/*moveTransition.getMoveStatus().isDone()*/true) {
		   currentHighest = Math.max(currentHighest, minAlphaBeta(board,
                   calculateQuiescenceDepth(board, bestMove, depth), highest, currentHighest, player));
           if (currentHighest >= highest) {
               this.cutOffsProduced++;
               break;
           }
       }
   }
   return currentHighest;
}
	
	

}
