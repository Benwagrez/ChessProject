package Pieces;

import Boards.Board;

public class Queen extends Piece{
	public boolean enpassantable=false;
	public Queen(Board chess, String color, String name){
		
		super(chess,color,name); // Super points toward the abstract Piece class constructor with following parameter : Board, chessString color; String name;
	}
	
	/*
	 *A constructor for Queen that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int iX, int iY, int fX, int fY) {
		 
		 if((chess.spotValues[fY][fX].isOccupied()==false && (pathDraw(iX,iY,fX,fY)==true))) {
			 return true;
		 }
		 if(chess.spotValues[fY][fX].isOccupied()==true && !chess.spotValues[iY][iX].piece.color.equals(chess.spotValues[fY][fX].piece.color) && pathDraw(iX,iY,fX,fY)==true) {
			 return true;
		 }
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
			  double slope = ((double)(Math.abs(tempfY-tempiY)/Math.abs(tempfX-tempiX)));
			  if(slope!=1 && slope!=0){
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
			  else
			  {
				  for(int i = 1; i<((int)(Math.abs(tempfX-tempiX)));i++){
		
					if((tempfY-tempiY)>0)//Adjusting variable y coordinate
						vY--;
					else
						vY++;
					if((tempfX-tempiX)>0)//Adjusting variable x coordinate
						vX++;
					else
						vX--;
		
					if(chess.spotValues[vY][vX].isOccupied()==true){
						return false;
					}
		
				  }
			  }

	  }
		  if(tempfX==tempiX) {
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

	  /*
	   *Checking every square in path to see if occupied (If Knight - No check needed)
	   */
	  }
}
