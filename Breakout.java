import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
public class Breakout extends JPanel { // breakout is a jpanel, creates a jpanel on top of the jframe
    // instance variables
    private GameWindow gw; // gw is an object of the class GameWindow
    private Paddle paddle; // allows paddle to be used in any method or constructor in the breakout class
    private Score scoreClass;
    private Boolean gameOver;
    private Random rand;
    private int scores;
    private Ball ball;

    private Boolean gameWon;
    

    private ArrayList<Brick> bricks; // creates a list of bricks, which is a type of arraylist
    private ArrayList<Color>colors; // creates a list of colors, which is a type of arraylist
    private ArrayList<Powerup> powerups;
    private ArrayList<Powerup2> powerup2;
    /** <> means that the only type of object that can be stored in the array is a brick object */


    // constructors

     //@param win connects gamewindow with the breakout constructor
    public Breakout(GameWindow win){ // parameter is win, which is an object of the class GameWindow
        gw = win;
        setBounds(50,50,gw.getWidth()-100,gw.getHeight()-75); // sets the size and position of the window
        setBackground(Color.CYAN); // This sets the background color of the gw panel, which is created on top of window.
        rand = new Random();

        paddle = new Paddle(this);// sets the paddle to be the default paddle object created with breakout passed in (on top of breakout)
        // private does not allow the variable to be accessed outside the class
        // to specify where the brick will be
        ball = new Ball(this);
        bricks = new ArrayList<Brick>(); 
        colors = new ArrayList<Color>();
        powerups = new ArrayList<Powerup>();
        scoreClass = new Score(gw);
        powerup2 = new ArrayList<Powerup2>();
        colors.add(Color.PINK);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.WHITE);
        colors.add(Color.ORANGE);
        colors.add(Color.YELLOW);
        gameWon = false;
        gameOver = false; // sets gameOver to be false, which means the game is not over yet
        // bricks.add(new Brick(this, 100, 0, Color.RED)); // adds a brick to the list of bricks
        // bricks.add(new Brick(this, 200, 0, Color.RED)); // adds a brick to the list of bricks
        makeGrid();

        /** creates an arraylist of bricks, which will only store brick objects
         */
        // keylistener
        addKeyListener(new KeyListener(){ // quick fix adds the required methods

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) { /** this runs when the key e is pressed, which is specified in the paramter of keyPressed() */
                paddle.keyPressed(e); // different than the keyPressed function in the paddle class, this is the keyPressed function in breakout
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
             
            } // adds the keylistener to breakout

        
      
            });
        setFocusable(true); // allows the breakout panel to be focused, so that the keylistener can be used, makes breakout the file
        // that is being focused on, where the meaningful parts of the code are


    }
    // methods
    /**
     * 
     * @param g
     */
    @Override
    // jframe, jpanel all have paint methods, this paint method overrides jpanels paint method
    // g is an object that allows us to access the graphics class
    public void paint(Graphics g){ 
        super.paint(g); // causes a smooth transition
        paddle.paint(g); // calls the paint method of the paddle class, accesses paddle class painting it
        ball.paint(g); // same thing, but for the ball shape
        
        // g.drawString(totalScore, 50,400); // draws the score at the top left corner
        // bricks.get(0).paint(g);
        // bricks.get(1).paint(g);
        for (int x =0; x<bricks.size(); x++){ // x is 0 because the first itme in the array list is position 0, x++ is the same as x+=1
            bricks.get(x).paint(g); // paints the brick object, which is stored in the arraylist
            // adds a brick to the list of bricks
            // uses bricks.size as the amount of bricks in the arraylist is always changing
        }
        for (int x=0;x<powerups.size();x++){
            powerups.get(x).paint(g);
        }

        for (int x=0;x<powerup2.size();x++){
            powerup2.get(x).paint(g);
        }
      
     
        if (gameOver== true && gameWon == false){ // if statement that checks to see if the game is over
            g.drawString("You lose !!   Game Over !!", 200, 400); // draws a string saying game over, and places it at 200, 200
        }
        if (gameWon){
            g.drawString("You Won!!" + gw.getScore().getActualScore(), 200, 400); // draws a string saying game over, and places it at 200, 200


        }

    }
    public void makeGrid(){
        int xOffset = 0;
        int yOffset= 0;
        
        for (int x =0; x<100; x++){ // x is 0 because the first itme in the array list is position 0, x++ is the same as x+=1, this loop creates 100 bricks
            bricks.add(new Brick(this, xOffset, yOffset, colors.get(rand.nextInt(8)))); // adds a brick to the list of bricks
            xOffset += 50; // adds 50 to the x offset, so that the bricks are spaced out
            if (xOffset > 450){ // if statement that checks to see if the x offset is greater than 400
                xOffset = 0; // resets the x offset to 0
                yOffset+=25;
        }}
        for (int x=0;x<1;x++){
            powerups.add(new Powerup(this, rand.nextInt(400), rand.nextInt(300,500), Color.PINK));

        }
        for (int x=0;x<1;x++){
            powerup2.add(new Powerup2(this, rand.nextInt(400), rand.nextInt(300,500), Color.GREEN));

        }
        this.repaint();
    
        }
        
        /** this for loop creates 100 brick objects, and moves them every ten bricks. The xoffset is reset when there are ten bricks across the window
         * yoffset is increased every ten bricks
         */
    

   
    public void move() { // this method is constantly claled in the gamewindow class
        paddle.move();
        ball.move();
        
        if (paddle.collision() == true){ // if statement checks to see if the paddle has collided with the ball
            ball.setYSpeed(-ball.getYSpeed()); 

        }
        
       
        for (int x = 0; x<powerups.size();x++){
            if (powerup2.get(x).collision()){
                // System.out.println("Lando has landed");
                // powerups.get(x).setActive(true);
                powerup2.get(x).setActive(true);
                if (powerup2.get(x).getActive()== true){
                    paddle.setBounds(paddle.getxpos(), paddle.getypos(), 250,10);
                    this.repaint();
                    powerup2.get(x).setActive(false);
                    powerup2.remove(x);
                    powerup2.add(new Powerup2(this, rand.nextInt(400), rand.nextInt(300,500), Color.GREEN));

                }
                
                
                this.repaint();



            }
        } 
        
        for (int x = 0; x<powerups.size();x++){
            if (powerups.get(x).collision()){
                // System.out.println("Lando has landed");
                // powerups.get(x).setActive(true);
                ball.setpowerupActive(true);
                powerups.remove(x);
                powerups.add(new Powerup(this, rand.nextInt(400), rand.nextInt(300,500), Color.PINK));
                this.repaint();


            }
        } 
    
        for (int x = 0;x<bricks.size();x++){ // this loop checks to see if the ball has collided with any of the bricks
            if (bricks.get(x).collision()){ // checks each brick in the array list to see if it has collided
                bricks.remove(x); // removes the brick from the array list
                ball.setYSpeed(-ball.getYSpeed());
                x--; // decreases the x value by one, so that the loop does not skip a brick, decrement operator
                
                for (int y= 0; y<powerups.size();y++){
                    if (ball.getpowerupActive() == true){     // if a powerup is collected, the next brick gives twice the points
                        gw.getScore().setActualScore(gw.getScore().getActualScore() + bricks.get(x).getDoubleScore());
                        ball.setpowerupActive(false); 
                        this.repaint();
                 
                    } else{
                        gw.getScore().setActualScore(gw.getScore().getActualScore() + bricks.get(x).getPoints());
                        this.repaint();

                    }
                }
            
                

                if (gw.getScore().getActualScore() + bricks.get(x).getPoints() > 25){
                    ball.setYSpeed(8);
                    paddle.setBounds(paddle.getxpos(),paddle.getypos(),125 ,10);
                    this.repaint();
                }
                if (gw.getScore().getActualScore() + bricks.get(x).getPoints() > 50){
                    ball.setYSpeed(10);
                    paddle.setBounds(paddle.getxpos(),paddle.getypos(),100 ,10); 
                    this.repaint();          
                }
                if (gw.getScore().getActualScore() + bricks.get(x).getPoints() > 75){
                    ball.setYSpeed(12);
                    paddle.setBounds(paddle.getxpos(),paddle.getypos(),100 ,10);
                    this.repaint();
                }
                if (bricks.size()==0){
                    System.out.println("game over");
                    gameWon = true;
                }
                System.out.println(bricks.get(x).getPoints()+"brick value");
                System.out.println(gw.getScore().getActualScore()+"Total points");
                this.repaint();



            }

            
        }
        if (ball.getYpos()>=gw.getHeight()-90){ // this checks the yposition of the ball object
            gameOver = true; // sets gameover to true, which means the game is over
            paddle.stop_movement(); // calls the stop_movement function in paddle to stop the movement
            ball.stop_movement();// calls the stop_movment function in ball to stop the movement
            gw.gameOver(); // this calls the gameover function that is in gamewindow, setting isRunning to false, which ends the game  
            // if (gw.getScore().getActualScore()>=50){
            //     gameWon = true;

            // }
            
        }
        
        /**
         * this function calls the move function in paddle and the move function in ball
         * ball.setYspeed sets the y speed to the negative value of the current yspeed
         */

    
    }
    public void draw(Graphics g){
        /**
         * this function calls the paint function in breakout
         */
    }
    // getters; allows access of private instance variables in other classes
    public Ball getBall(){ 
        /** these functions return the ball and paddle objects, which are private, allowing them to be used in classes like paddle 
         * or ball
        */
        return ball; 
    }
    public Paddle getPaddle(){
        /**
         * this method returns the paddle object that is in the breakout class, allowing it to be used in other classes
         */
        return paddle;
    }
    public ArrayList<Brick> getBricks(){
        /**
         * this method returns the arraylist of bricks, allowing it to be used in other classes
         */
        return bricks;
    }
    public Score getScore(){
        /**
         * this method returns the score object, allowing it to be used in other classes
         */
        return scoreClass;
    }   
    public ArrayList<Powerup> getPowerup(){
        return powerups;
    }
}





// the parameter win is passed in as 'this' in the GameWindow file, on line nine,  which creates the object of the class GameWindow using the 
// breakout constructor, 'this' is passed in as win.
// This is why it is called an anonymous object, because it is declared later as gw in the breakout constructor