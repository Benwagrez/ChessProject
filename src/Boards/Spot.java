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
        if(this.piece == null || !(this.piece.color.equals(piece.color))) {
            this.piece = piece;
        }
        
    }

    public boolean isOccupied() {
        if(piece != null) {
        	return true;
        }
        return false;
    }
}
