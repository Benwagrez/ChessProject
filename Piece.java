/*Abstract class that all pieces will inherit/extend
 *This requires them to share the same abstract methods
 */
public abstract class Piece{

  /*An abstract method that will return a boolean
   *if the path is valid, which is checked over
   *the chess board array based on the final X
   *and Y value the piece has. Abstract classes are
   *instantiated by calling a method and ending with
   *a semicolon
   */
  public abstract boolean pathValid(int fX, int fY);
}
