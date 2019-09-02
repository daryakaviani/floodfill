import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class FloodFill extends JApplet implements MouseListener{
    int [][] arr = {    	{1, 2, 1, 3, 2, 3, 1},
            			{2, 3, 1, 3, 2, 1, 2},
            			{1, 1, 2, 1, 2, 3, 1},
            			{3, 3, 1, 2, 3, 1, 3},
            			{2, 1, 2, 3, 1, 2, 1},
            			{1, 2, 1, 2, 3, 1, 2}
        };
        int score = 0;
    public void init() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
       g.clearRect(0,0,1000,1000);
       for (int r = 0; r < arr.length; r++){
           for (int c = 0; c < arr[0].length; c++){
               if (arr[r][c]==1){
                   g.setColor(Color.red);
                   g.fillRect(c*50,r*50,50,50);
               }
               if (arr[r][c]==2){
                   g.setColor(Color.green);
                   g.fillRect(c*50,r*50,50,50);
               }
               if (arr[r][c]==3){
                   g.setColor(Color.blue);
                   g.fillRect(c*50,r*50,50,50);
               }
           }
       }
       g.setColor(Color.black);
       g.drawString("Score: " + score, 400,200);
    }

    void flood(int r, int c, int i, int oi) {
        if(c>=arr[0].length||r>=arr.length||c<0||r<0){
            return;
        }
        if(arr[r][c] != oi){
            return;
        }
        arr[r][c]=i;
        flood(r+1,c,i,oi);
        flood(r-1,c,i,oi);
        flood(r,c+1,i,oi);
        flood(r,c-1,i,oi);
    }
    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}
    
    public void mouseEntered(MouseEvent e){}
    
    public void mouseExited(MouseEvent e){}
    
    public void mouseClicked(MouseEvent e) {
        int col = e.getX()/50;
        int row = e.getY()/50;
        flood(0,0,arr[row][col],arr[0][0]);
        score++;
        // maybe call floodFill passing coordinates 0,0, old color, new color
        // you can probably use e.getKeyChar() for the new color to see results
        repaint();
    }
}