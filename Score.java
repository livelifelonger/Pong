import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int playerScore;
    private boolean isLeft;
    private boolean scoreChanged;
    
    public Score( boolean left )
    {
        playerScore = 0;
        isLeft = left;
        
        displayScore();
    }

    public void displayScore()
    {
        GreenfootImage display;
        
        if ( isLeft == true)
        {
            display = new GreenfootImage( Integer.toString( playerScore ), 30, (Color.RED), Color.BLACK );
            setImage (display);
            scoreChanged = false;
        }
        else
        {
            display = new GreenfootImage( Integer.toString( playerScore ), 30, (Color.BLUE), Color.BLACK );
            setImage (display);
            scoreChanged = false;
        }
        
        
    }
    
    public void act() 
    {
        if ( scoreChanged == true )
        {
            displayScore();
        }
        
    }   
    
    public void countScore()
    {
        playerScore ++;
        scoreChanged = true;
        
    }
    
    public int getScore()
    {
        return playerScore;
    }
    
}
