package chessplayer;

import Chess.ChessGame;

public interface BoardEvaluator {
	
	int Evaluate(ChessGame gameState, int MaxDepth, String player);

}
