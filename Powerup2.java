 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Powerup2 {
    private int xpos; // private variable for use within the class, as long as variables are the same type you can declare them as a list
    private int ypos;
    private Color color; // remember color is a class so it can be a type
    private final int WIDTH = 10; // capitalized because it is a contant, final means it is a constant, does not change, must be assigned when it is defined
    private final int HEIGHT = 10; // also a constant variable
    private Boolean active = false;
    
    private Breakout out; // declare Breakout type variable to access methods, causes paddle to not have a default constructor
    // out is a variable of a breakout object, local object of breakout

   
    /**
    *
    *  @param b // variable taht is passed in to the method that makes the brick
    */

    //constructors, default constructor initializes all declared variables
    public Powerup2(Breakout b, int x, int y, Color c) { // b is the initial Breakout object , extra parameters give the x, y, and color position
        // this lets the bricks become specialzed and have different appearances
        out = b; // initialize the Breakout object, setting the variable out to the 'this' passed in as Breakout b
        xpos = x; //set xpos to be near the bottom of the breakout, middle of the screen
        ypos = y;// set ypos to the top of the screen
        color = c;
        // value = value; // sets the value of the brick to the value passed in
    }
      // methods
    // no need to override because it is not a jframe or jpanel
    /**
     * 
     * @param g
     */
    public void paint(Graphics g){  // this method paints the shape of the onto the breakout panel
        g.setColor(color); // local variable that is declared in the instance variables
        g.fillRect(xpos, ypos, WIDTH, HEIGHT); //
        g.setColor(Color.black);
        g.drawRect(xpos, ypos, WIDTH, HEIGHT); // draws a border around the brick
    }
    public Rectangle getBounds(){ // this function will return the bounds of the paddle, which is the rectangle
        return new Rectangle(xpos,ypos,WIDTH,HEIGHT);


    }
    public boolean collision(){ // this.getbounds gets the bounds of the brick rectangle, then this function checks to see if it 
        // has intersected with the ball rectangle from the ball class.
        return this.getBounds().intersects(out.getBall().getBounds());
        /**
         * out.getBall() gets the ball object from the breakout class, then gets the bounds of that object, then checks
         * to see if paddle has intersected with the ball 
         */

}
    public void setActive(boolean a){
        active = a;

    }
    public Boolean getActive(){
        return active;
    }

 
}