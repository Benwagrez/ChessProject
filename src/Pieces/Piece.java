package Pieces;
import Boards.*;
public abstract class Piece{
  
/*
 *Abstract class that all pieces will inherit/extend
 *This requires them to share the same abstract methods
 */
  public Board chess=new Board();
  public final String color;
  public final String name;
  /*
   *Currently X and Y coordinates of the object, non
   *abstract because these will be a consistent variable
   */
  
  public Piece(String color, String name){
      this.color = color;
      this.name = name;
  }
  
  /*
   *Constructor of the method, non-abstract because
   *there is a consistent need for a constructor
   *to assign a piece to a player and/or color
   *as well as to a board, which will contain
   *values other pieces have on board.
   */
  
  public abstract boolean pathValid(int fX, int fY);
  
  /*
   *An abstract method that will return a boolean
   *if the path is valid, which is checked over
   *the chess board array based on the final X
   *and Y value the piece has. Abstract classes are
   *instantiated by calling a method and ending with
   *a semicolon
   */
  
  public abstract boolean pathDraw(int iX, int iY,int fX, int fY);
  
  /*
   *Draws the new path of the object and stores
   *and it's new coordinate values based on it's
   *initial x and y coordinates and it's final 
   *coordinates
   */
  
  //public abstract Type getType();
  
  /*
   *Possibly needed - TBD
   *Identifies the type of piece the object is
   */
  
}
