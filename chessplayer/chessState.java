/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessplayer;

/**
 *
 * @author mubasher.baig
 */
public class chessState {
    int state[][];
    int player;
    chessState(){
        state = new int[8][8];
        player = 1;
    }
}
