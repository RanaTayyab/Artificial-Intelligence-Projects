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
abstract class ChessPlayer {
    
    public abstract chessMove decideMoveUsingMinimax(ChessGame gameState , int MaxDepth, String Player);
    
}

