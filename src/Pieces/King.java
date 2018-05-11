package Pieces;

import Boards.Board;

public class King extends Piece{
	public King(Board chess, String color, String name){

		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
		canCastle=true;
	}

	/*
	 *A constructor for King that takes a String input to set the color of the piece.
	 */


	public boolean pathValid(int iX, int iY, int fX, int fY) {
		if(chess.spotValues[fY][fX].isOccupied()==false && pathDraw(iX,iY,fX,fY)) {
			
			if(isTesting) {
			return true;
			}
			System.out.println("cant castle");
			canCastle=false;
			return true;
			
		}	 
		if(chess.spotValues[fY][fX].isOccupied()==true && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[fY][fX].piece.color) && pathDraw(iX,iY,fX,fY)) {
			
			if(isTesting) {
				return true;
			}
			System.out.println("cant castle");
			canCastle=false;
			return true;
			
		}
		if(color=="White") {
			if(!isTesting) {
				System.out.println(canCastle);
			System.out.println(fX==6);
			System.out.println(fY==7);
			System.out.println(!chess.spotValues[7][6].isOccupied());
			System.out.println(!chess.spotValues[7][5].isOccupied());
			System.out.println(!chess.spotValues[7][6].isProtectedByBlack);
			System.out.println(!chess.spotValues[7][5].isProtectedByBlack);}
			if(canCastle==true && fX==6 && fY==7 && !chess.spotValues[7][6].isOccupied() && !chess.spotValues[7][5].isOccupied() && !chess.spotValues[7][6].isProtectedByBlack && !chess.spotValues[7][5].isProtectedByBlack) {
				if(isTesting) {
					return true;
				}
				System.out.println("w Is k Casrtling");
				isKCastling=true;//King side castling
				return true;
				
			} else if(canCastle==true && fY==7 && (fX==1||fX==2) && !chess.spotValues[7][3].isOccupied() && !chess.spotValues[7][2].isOccupied() && !chess.spotValues[7][1].isOccupied() && !chess.spotValues[7][3].isProtectedByBlack && !chess.spotValues[7][2].isProtectedByBlack) {
				if(isTesting) {
					return true;
				}
				System.out.println("w Is q Casrtling");
				isQCastling=true;//Queen side castling
				return true;
				
			}
		}
		if(color=="Black") {
			if(canCastle==true && fX==6 && fY==0 && !chess.spotValues[0][6].isOccupied() && !chess.spotValues[0][5].isOccupied() && !chess.spotValues[0][6].isProtectedByWhite && !chess.spotValues[0][5].isProtectedByWhite) {
				if(isTesting) {
					return true;
				}
				System.out.println("Is k Casrtling");
				isKCastling=true;//King side castling
				
				return true;
			} else if(canCastle==true && fY==0 && (fX==1||fX==2) && !chess.spotValues[0][3].isOccupied() && !chess.spotValues[0][2].isOccupied() && !chess.spotValues[0][1].isOccupied() && !chess.spotValues[0][3].isProtectedByWhite && !chess.spotValues[0][2].isProtectedByWhite) {
				if(isTesting) {
					return true;
				}
				System.out.println("Is Q Casrtling");
				isQCastling=true;//Queen side castling
				return true;
				
			}
		}
		return false;
	}

	/*
	 *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	 */

	public boolean pathDraw(int iX, int iY,int fX, int fY){
		if(fX==iX && fY==iY) {
			return false;
		}
		if((Math.abs(fX-iX))>1||(Math.abs(fY-iY)>1)){
			return false;
		}//Checking if change in x and y are over 1 - if so - impossible
		if(chess.spotValues[fY][fX].isProtectedByBlack && color=="White") {
			return false;
		} else if(chess.spotValues[fY][fX].isProtectedByWhite && color=="Black") {
			return false;
		}
		return true;
	}

	/*
	 *Checking every square in path to see if occupied (If King - limited checks)
	 */
	public boolean pawnCheck(int iX, int iY, int fX, int fY) {
		return false;
	}
}
