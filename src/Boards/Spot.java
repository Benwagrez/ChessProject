package Boards;

import Pieces.*;
public class Spot {
    public int x, y;
    public Piece piece;
    /*
     *Instance fields with x and y coordinates and the piece.
     */
    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void occupySpot(Piece piece){
        if(this.piece == null || !(this.piece.color.equals(piece.color))) {
            this.piece = piece;
        }
    }
    //If there's no other piece on the new square, or if the colors of the two pieces are not the same, take the piece.
    public boolean isOccupied() {
        if(piece != null) {
        	return true;
        }
        return false;
    }
    //Check to see if new spot is occupied or not.
    public void enPassant(Piece piece){
    	if(this.piece == null || !(this.piece.color.equals(piece.color)) && (this.piece.enpassantable) && (spotValues[y+1][x].piece.name=="Pawn")) {
            this.piece = piece;
        }
    }
}