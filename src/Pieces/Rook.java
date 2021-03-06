package Pieces;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Boards.Board;

public class Rook extends Piece{
	public Rook(Board chess, String color, String name){
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
		canCastle=true;
	}

	/*
	 *A constructor for Rook that takes a String input to set the color of the piece.
	 */

	public boolean pathValid(int iX, int iY, int fX, int fY) {
		//check if rook can move
		if(chess.spotValues[fY][fX].isOccupied()==false && pathDraw(iX,iY,fX,fY)){
			if(chess.spotValues[iY][iX].piece.color.equals("White")) {
				if(chess.spotValues[7][4].piece!=null) {
					if(chess.spotValues[7][4].piece.name.equals("King")) {
						if(!isTesting)chess.spotValues[7][4].piece.canCastle=false;
					}
				}

			}
			else if(chess.spotValues[iY][iX].piece.color.equals("Black")) {
				if(chess.spotValues[0][4].piece!=null) {
					if(chess.spotValues[0][4].piece.name.equals("King")) {
						if(!isTesting)chess.spotValues[0][4].piece.canCastle=false;
					}
				}
			}
			return true;			
		}
		//check if rook can take
		if(chess.spotValues[fY][fX].isOccupied()==true && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[fY][fX].piece.color) && pathDraw(iX,iY,fX,fY)) {
			return true;
		}
		else
			return false;
	}

	/*
	 *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	 */

	public boolean pathDraw(int iX, int iY,int fX, int fY){
		int tempiX = iX;
		int tempiY = 8-iY;
		int tempfX = fX;
		int tempfY = 8-fY;
		int vY = iY, vX = iX;
		if(tempfX!=tempiX) {
			if(tempfY!=tempiY){
				return false;
			}
		}
		if(tempfX==tempiX && tempfY==tempiY) {
			return false;
		}
		if(tempfY-tempiY==0)
		{
			for(int i = 1; i<((int)(Math.abs(tempfX-tempiX)));i++){

				if((tempfX-tempiX)>0)//Adjusting variable y coordinate
					vX++;
				else
					vX--;

				if(chess.spotValues[vY][vX].isOccupied()==true){
					return false;
				}

			}
		}
		else if(tempfX-tempiX==0)
		{
			for(int i = 1; i<((int)(Math.abs(tempfY-tempiY)));i++){

				if((tempfY-tempiY)>0)//Adjusting variable y coordinate
					vY--;
				else
					vY++;

				if(chess.spotValues[vY][vX].isOccupied()==true){
					return false;
				}

			}
		}
		return true;
	}

	/*
	 *Checking every square in path to see if occupied (Is Knight - No check needed)
	 */
	public boolean pawnCheck(int iX, int iY, int fX, int fY) {
		return false;
	}
}
