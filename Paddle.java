import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Paddle {
    // instance variables; for every instance variable it should be private, they are only declarations, not assignments
    private int xpos; // private variable for use within the class, as long as variables are the same type you can declare them as a list
    private int ypos;
    private int xSpeed;
    private Color color; // remember color is a class so it can be a type
    private  int WIDTH = 150; // capitalized because it is a contant, final means it is a constant, does not change, must be assigned when it is defined
    private  int HEIGHT = 10; // also a constant variable
    
    private Breakout out; // declare Breakout type variable to access methods, causes paddle to not have a default constructor
    // out is a variable of a breakout object, local object of breakout

   
    /**
    *
    *  @param b
    */

    //constructors, default constructor initializes all declared variables
    public Paddle(Breakout b) { // b is the initial Breakout object 
        out = b;
        xpos = 100; //set xpos to be near the bottom of the breakout, middle of the screen
        ypos = out.getHeight()-15;// set ypos to the bottom of the screen
        xSpeed = 6;
        color = Color.RED;
    }
      // methods
    // no need to override because it is not a jframe or jpanel
    /**
     * 
     * @param g
     */
    public void paint(Graphics g){ 
        g.setColor(color); // local variable that is declared in the instance variables
        g.fillRect(xpos, ypos, WIDTH, HEIGHT); 
    }
    public void move() { // this code is looped through the gamewindow playgame, which calls the move method in breakout
        if (xpos +xSpeed>= 0 && xpos+xSpeed<=out.getWidth()-WIDTH){ // code will run if the xpos is within the gamewindow, it also checks to make sure
            // that when xpos is moved it does not exceed the screen limits
            xpos+=xSpeed;
        } 


    /** 
     * this function will move the paddle, if the xpos it is about to be set to wont go off the screen
     */
    }

    public void keyPressed(KeyEvent e){ // e is the name of the keyevent for keypressed
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            xSpeed = 4;

            
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            xSpeed = -4;

        }

        /**
         * depending on the key that is being pressed, the speed will be changed accordingly
         *  */
        }
    public Rectangle getBounds(){ // this function will return the bounds of the paddle, which is the rectangle
        return new Rectangle(xpos,ypos,WIDTH,HEIGHT);

    }
    public void setBounds(int x, int y, int width, int height){
        xpos = x;
        ypos = y;
        WIDTH = width;
        HEIGHT = height;
    }
    public boolean collision(){ // this.getbounds gets the bounds of the paddle rectangle, then this function checks to see if it 
        // has intersected with the ball rectangle from the ball class.
        return this.getBounds().intersects(out.getBall().getBounds());
        /**
         * out.getBall() gets the ball object from the breakout class, then gets the bounds of that object, then checks
         * to see if paddle has intersected with the ball 
         */
    }
    public void stop_movement(){ // this function will stop the paddle from moving
        xSpeed = 0;
    }
    public void setXSpeed(int x){
        xSpeed =x;
    }
    public int getXSpeed(){
        return xSpeed;
    }
    public int getxpos(){
        return xpos;
    
    }
    
    public int getypos(){
        return ypos;
    }
}




    //methods

