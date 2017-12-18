package Pieces;
public class Knight extends Piece{
	String color;
	public Knight(String color, String name){
		
		super(color,name); // Super points toward the abstract Piece class constructor with following parameter : String color; String name;
		color=this.color;
	}
	
	/*
	 *A constructor for Knight that takes a String input to set the color of the piece.
	 */
	
	 public boolean pathValid(int fX, int fY) {
		 if(chess.spotValues[fY][fX].isOccupied(color)==false && (pathDraw(iX,iY,fX,fY)==true)) {
			 return true;
		 }
			 return false;
		 }
	 /*
	  *Checking if the path is valid, using two boolean methods isOccupied and pathDraw
	  */
	  
	  public boolean pathDraw(int iX, int iY,int fX, int fY){
		 double slope = ((double)(Math.abs(fY-iY)/Math.abs(fX-iX)));
		 if(slope!=2||slope!=.5){
			 return false;
		 }//Checking if path taken is possible (Knight - diagonal slope of 2 or .5)
		 if((Math.abs(fX-iX))>2||(Math.abs(fY-iY)>2)){
			 return false;
		 }//Checking if change in x and y are over 2 - if so - impossible
	     return true;
	  }

	  /*
	   *Checking every square in path to see if occupied (Is Knight - only one checks needed)
	   */
}
