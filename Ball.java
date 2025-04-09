import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Ball {
    // instance variables; for every instance variable it should be private, they are only declarations, not assignments
    private int xpos; // private variable for use within the class, as long as variables are the same type you can declare them as a list
    private int ypos;
    private int xSpeed;
    private int ySpeed;
    
    private Boolean powerupActive;
    private Color color; // remember color is a class so it can be a type
    private final int WIDTH = 10; // capitalized because it is a contant, final means it is a constant, does not change, must be assigned when it is defined
    private final int HEIGHT = 10; // also a constant variable
    
    private Breakout out; // declare Breakout type variable to access methods, causes paddle to not have a default constructor
    // out is a variable of a breakout object, local object of breakout

   
    /**
    *
    *  @param b this is a parameter that is passed into the ball method
    */

    //constructors, default constructor initializes all declared variables
    public Ball(Breakout b) { // b is the initial Breakout object, b is a variable that is holding an object that is type breakout
        out = b;
        xpos = 20; //set xpos to be near the bottom of the breakout, middle of the screen
        ypos = 300;// set ypos to the bottom of the screen
        xSpeed = ySpeed = 4;
        powerupActive = false;

        color = Color.GRAY;
    }
      // methods
    // no need to override because it is not a jframe or jpanel
    /**
     * 
     * @param g
     */
    public void paint(Graphics g){ // Graphics allows drawing on the panel, such as filling in the rectangle shape, g is a variable that is holding the object
        g.setColor(color); // local variable that is declared in the instance variables
        g.fillRect(xpos, ypos, WIDTH, HEIGHT); //
    }
    public void move() { 
        if (xpos +xSpeed<= 0){ // code will run if the xpos is within the gamewindow, it also checks to make sure
            // that when xpos is moved it does not exceed the screen limits
            // this checks when the ball is at the left side of the screen
            xSpeed = 4;

        
        } 
        if (xpos+xSpeed>=out.getWidth()-WIDTH){ // code will run if the xpos is within the gamewindow, it also checks to make sure
            // that when xpos is moved it does not exceed the screen limits
            // this checks when the ball is at the right side of the screen
            xSpeed = xSpeed*-1;
        
        } 

        if (ypos +ySpeed<= 0){ // code will run if the xpos is within the gamewindow, it also checks to make sure
            // that when xpos is moved it does not exceed the screen limits
            // this checks when the ball is at the left side of the screen
            ySpeed = 4;

        
        } 
        if (ypos+ySpeed>=out.getHeight()-HEIGHT){ // code will run if the xpos is within the gamewindow, it also checks to make sure
            // that when xpos is moved it does not exceed the screen limits
            // this checks when the ball is at the right side of the screen
            ySpeed = ySpeed*-1;
        
        } 
        xpos+=xSpeed;
        ypos+=ySpeed;
       
        /** 
         * Everytime the ball or paddle moves, it is checked to make sure that the ball or paddle does not go off the screen
         * it uses if statements to check if the ball or paddle is at the left or right side of the screen, if it is, then the xspeed is changed
         * checks using width and height
         */

    }
    public Rectangle getBounds(){ // this function will return the bounds of the shape, which is the rectangle
        return new Rectangle(xpos,ypos,WIDTH,HEIGHT);

    }
    // setter, a method that will reassign an instance variable, they are void and have a parameter
    // the parameter is the new value that will be assigned to the instance variable
    public void setYSpeed(int y) {
        ySpeed = y;
    }
    // getter, a method that will return the value of an instance variable
    public int getYSpeed() { // this method will return ySpeed
        return ySpeed;
    }
    public void stop_movement(){// this method will stop the ball from moving
        xSpeed = 0;
        ySpeed = 0;
    }
    public int getYpos(){ // this function returns the y position of the ball object, and is public for use in breakout
        return ypos;

    }
    public void setpowerupActive(Boolean c){
        powerupActive = c;
        
    
    }
    public Boolean getpowerupActive(){
        return powerupActive;
    }
}




    //methods