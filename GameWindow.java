import javax.swing.JFrame;
public class GameWindow extends JFrame{

    // instance variables 
    private Breakout out;
    private Score scr;
    private boolean isRunning;
    public GameWindow(){  // default constructor
        setSize(600,600); // sets window size
        setTitle("Breakout - Baig");
        setLayout(null); // This tells that there is no layout, which defaults it to absolute layout
        setLocationRelativeTo(null); // centers window on screen, null is a placeholder, and the object has not been made yet
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // all caps means that it is a constant, value cannot be reassigned, EXIT_ON_CLOSE means that the window will close when the user clicks the close button
        //anonymous object has no name, it is called an anonymous object because it is not declared in a class, it is declared in the method, and it is called in the add method
        setResizable(false); // makes it so that the window size is not able to be adjusted
        out = new Breakout(this); // creates the breakout object
        scr = new Score(this);
        isRunning = true;
        add(out); // the out object is added to the jframe
        add(scr);
        setVisible(true); // makes window visible
        playGame(); // calls the playGame method

    }
    public void playGame(){ // it will be a game loop that constantly moves the items., game loop
        while (isRunning){
            out.repaint(); // this updates the screen when the xpos is updated
            out.move(); // calls the move function in breakout
            scr.repaint();

            try { // this try/catch method causes the paddle to move slower across the screen
                Thread.sleep(30); // this is a thread, and it is a loop, it will keep looping until the game is over
                // Thread is pre loaded, it is loaded in milliseconds, which causes the program to sleep for 30 ms.
                // slows down the repainitng and moving mechanism
            } catch(InterruptedException e){// parantheses is what you are trying to catch for, if the try is not true, then catch will run
                e.printStackTrace(); // catch checks to make sure the try is running correctly

            }

    
        }


    }
    public void gameOver(){
        isRunning = false; // this function, when called, will set the while loop to false and end the game
        System.out.println("game over");
        
    }
    /** playGame is called when the gamedinwo is function is called, and while the gaeme is running, the components are constantly being repainted and moved, 
     * and the try and catch method is used to slow down the program so it doesn't crash when it is running too fast.
     */

    



    public Score getScore(){
        return scr; // returns the score object, which is a local object of the class score
    }
}

// Extends borrows/inherits from another class GameWindow is a jframe
// GameWindow constructer creates the class, specifiying the size, title, 
// location, sets it so it is visible, and assigns a closing operation using a constant
// The constructor is called automatically when the class is called, and the class inherits the JFrame class
// this is similar to self in python, which refers to the object that is being created