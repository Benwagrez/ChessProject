package Boards;

import Pieces.*;
public class Spot {
    int x, y;
    Piece piece;
    /*
     *Instance fields with x and y coordinates and the piece.
     */
    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void occupySpot(Piece piece){
        //if piece already here, set it dead
        if(this.piece == null && !(this.piece.color.equals(piece.color))) {
            //place piece here
            this.piece = piece;
        }
        
    }

    public boolean isOccupied(String tcolor) {
        if(piece != null) {
        	if(piece.color!=tcolor) {
            return true;
        	}
        }
        return false;
    }

    public Piece releaseSpot() {
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

}
