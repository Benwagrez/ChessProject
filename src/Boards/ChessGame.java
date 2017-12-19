package Boards;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ChessGame extends JFrame implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;//Serial ID for unique chess games
	JLayeredPane layeredPane;
  JPanel chessBoard;
  JLabel chessPiece;
  int xAdjustment;
  int yAdjustment;
 
  public ChessGame(){
	  
	  Board newGame = new Board();//Instantiate Board object w/ spots
	  newGame.boardSetUp();
	  Dimension boardSize = new Dimension(600, 600);//Instantiate Visual representation of Board.
	 
	  //  Use a Layered Pane for this this application
	  layeredPane = new JLayeredPane();
	  getContentPane().add(layeredPane);
	  layeredPane.setPreferredSize(boardSize);
	  layeredPane.addMouseListener(this);
	  layeredPane.addMouseMotionListener(this);
	 
	  //Add a chess board to the Layered Pane 
	 
	  chessBoard = new JPanel();
	  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
	  chessBoard.setLayout( new GridLayout(8, 8) );
	  chessBoard.setPreferredSize( boardSize );
	  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
	  JLabel Vpiece = new JLabel();
      for (int i = 0; i < 64; i++) {
      JPanel square = new JPanel( new BorderLayout() );
      chessBoard.add( square );

      int row = (i / 8) % 2;

      if (row == 0)
      square.setBackground( i % 2 == 0 ? Color.blue : Color.white );//Adjusting for First square
      else
      square.setBackground( i % 2 == 0 ? Color.white : Color.blue );//Setting colored boxes for chess board

      if(newGame.spotValues[row][i].piece!=null)
      {
        switch(newGame.spotValues[row][i].piece.name){
          case "Bishop":
          Vpiece = new JLabel( new ImageIcon("Bishop.jpg") );
          break;
          
          case "King":
          Vpiece = new JLabel( new ImageIcon("King.jpg") );
          break;
          
          case "Queen":
          Vpiece = new JLabel( new ImageIcon("Queen.jpg") );
          break;

          case "Pawn":
          Vpiece = new JLabel( new ImageIcon("Pawn.jpg") );
          break;

          case "Rook":
          Vpiece = new JLabel( new ImageIcon("Rook.jpg") );
          break;

          case "Knight":
          Vpiece = new JLabel( new ImageIcon("Knight.jpg") );
          break;
        }
        JPanel panel = (JPanel)chessBoard.getComponent(i);
        panel.add(Vpiece);
      }
    }
 
  }
 
  public void mousePressed(MouseEvent e){
	  chessPiece = null;
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  
	  if (c instanceof JPanel) 
	  return;
	 
	  Point parentLocation = c.getParent().getLocation();
	  xAdjustment = parentLocation.x - e.getX();
	  yAdjustment = parentLocation.y - e.getY();
	  chessPiece = (JLabel)c;
	  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
	  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	  }
	 
	  //Move the chess piece around
	  
	  public void mouseDragged(MouseEvent me) {
	  if (chessPiece == null) return;
	 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	 }
	 
	  //Drop the chess piece back onto the chess board
	 
	  public void mouseReleased(MouseEvent e) {
	  if(chessPiece == null) return;
	 
	  chessPiece.setVisible(false);
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JLabel){
	  Container parent = c.getParent();
	  parent.remove(0);
	  parent.add( chessPiece );
	  }
	  else {
	  Container parent = (Container)c;
	  parent.add( chessPiece );
	  }
	 
	  chessPiece.setVisible(true);
	  }
	 
	  public void mouseClicked(MouseEvent e) {
	  
	  }
	  public void mouseMoved(MouseEvent e) {
	  }
	  public void mouseEntered(MouseEvent e){
	  
	  }
	  public void mouseExited(MouseEvent e) {
	  
	  }
	 
	  public static void main(String[] args) {
	  JFrame frame = new ChessGame();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
	 }
}
 