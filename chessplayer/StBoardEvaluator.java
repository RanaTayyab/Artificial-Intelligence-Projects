package chessplayer;

import Chess.ChessGame;

public class StBoardEvaluator implements BoardEvaluator {

    private final static int CHECK_MATE_BONUS = 10000;
    private final static int CHECK_BONUS = 50;
    private final static int CASTLE_BONUS = 60;
    private final static int CASTLE_CAPABLE_BONUS = 25;
    private final static int MOBILITY_MULTIPLIER = 2;
    private final static int ATTACK_MULTIPLIER = 2;
    private final static int TWO_BISHOPS_BONUS = 50;
    private static final StBoardEvaluator INSTANCE = new StBoardEvaluator();

    public StBoardEvaluator() {
    }

    public static StBoardEvaluator get() {
        return INSTANCE;
    }

	@Override
	public int Evaluate(ChessGame gameState, int MaxDepth, String player) {
		
		   return score("player1", MaxDepth) - score("player2", MaxDepth);
		
	}

	
	    private static int score( String player,
	                              int depth) {
									return depth;
	      /*  return mobility(player) +
	               kingThreats(player, depth) +
	               attacks(player) +
	               castle(player) +
	               pieceEvaluations(player) +
	               pawnStructure(player); */
	    }

	
}
