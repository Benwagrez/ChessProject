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

    public void occupySpot(Piece piece, String color){
        //if piece already here, set it dead
        if(this.piece != null) {
            this.piece=null;
        }
        //place piece here
        this.piece = piece;
        this.color=color;
    }

    public boolean isOccupied() {
        if(piece != null) {
            return true;
        }
        return false;
    }

    public Piece releaseSpot() {
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

}
