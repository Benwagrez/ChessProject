package Pieces;
public class Knight extends Piece{

	 public boolean pathValid(int fX, int fY) {
		 
		 return true;
	 }
	  
	  public int[] pathDraw(int iX, int iY,int fX, int fY){
		  int[] dest=new int[2];
		  if(chess.spotValues[fY][fX].isOccupied()) {
			  dest= {iX,iY};
		  } else {
			  dest= {fX,fY};
		  }
		  return dest;
	  }
}