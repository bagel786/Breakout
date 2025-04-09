
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Score extends JPanel{
    private GameWindow gw;
    private int score;

    public Score(GameWindow win){
        gw = win;
        setBounds(100,10,350,25);
        score = 0;

    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 100, 10);
    }
    public int getActualScore(){
        return score;
    }
    public void setActualScore(int p){
        score = p;
    }
    
  

    
    
}
