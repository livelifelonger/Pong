import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayField extends World
{
    public boolean startGame;
    
    private static Ball theBall;
    private static Score playerOneScore;
    private static Score playerTwoScore;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PlayField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        createBackground();
        initializelyingField();
    }
    
    private void createBackground()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect( 0, 0, getWidth(), getHeight() );
        
        getBackground().setColor(Color.GRAY);
        getBackground().fillRect( getWidth() / 2, 0, 5, getHeight() );
        
        showText ( "press Space to Start", 200 , 550 );
    }
    
    private void  initializelyingField()
    {
        theBall = new Ball();
        
        playerOneScore = new Score(true);
        playerTwoScore = new Score(false);
        
        addObject (theBall, getWidth()/2, getHeight()/2 );
        addObject (playerOneScore, 200 , 50 );
        addObject (playerTwoScore, 600 , 50 );
        addObject(new Paddle(true), 10, getHeight() / 2);
        addObject(new Paddle(false), getWidth() - 10, getHeight() / 2);
        
        // step 7 - c
    }
    
    public void act()
    {
        if( startGame == false)
        {
            checkKeyPressed();
            checkWin();
        }
    }
    
    private void checkKeyPressed()
    {
        if ( Greenfoot.isKeyDown("space"))
        {
            startGame = true;
            
            showText("", 200, 550);
            
            theBall.setVelocity(5);
        }
    }
    
    private void checkWin()
    {
        GreenfootImage player1Win = new GreenfootImage( "Player 1 Wins!", 45, (Color.RED), Color.BLACK );
        GreenfootImage player2Win = new GreenfootImage( "Player 2 Wins!", 45, (Color.BLUE), Color.BLACK );
        
        if( playerOneScore.getScore() >= 7 )
        {
             removeObjects( getObjects(null) );
             
             getBackground().setColor( Color.BLACK );
             getBackground().fillRect( 0, 0, getWidth(), getHeight() );
             getBackground().drawImage( player1Win, getWidth()/2, getHeight()/2);
        }
        
        if( playerTwoScore.getScore() >= 7 )
        {
             removeObjects( getObjects(null) );

             getBackground().setColor( Color.BLACK );
             getBackground().fillRect( 0, 0, getWidth(), getHeight() );
             getBackground().drawImage( player2Win, getWidth()/2, getHeight()/2);
        }
        
    }
    
    public boolean getStarted()
    {
        return startGame;
    }
    
    public void reset()
    {
        theBall.setLocation( getWidth()/2, getHeight()/2);
        
        showText ( "press Space to Start", 200 , 550 );
        startGame = false;
    }

}
