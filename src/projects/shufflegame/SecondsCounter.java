/*
 * SecondsCounter.java
 *
 * Created on March 17, 2008, 12:51 AM
 */


package projects.shufflegame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author  P.Sakthivel
 */
public class SecondsCounter implements ActionListener
{
    public Timer timer_ ;
    public StringBuffer text_ ;
    public int counter ;
    public JLabel secondsCounterLabel ;
    public SecondsCounter()
    {
        timer_ = new Timer( 1000 , this ) ;
        initCounter() ;
    }
    
    public void setLabel( JLabel label )
    {
        secondsCounterLabel = label ;
    }
    public void initCounter()
    {
        counter = 0 ;
    }
    public void reStart()
    {
        stop() ;
        start() ;
    }
    
    public void start()
    {
        initCounter() ;
        secondsCounterLabel.setText( ShuffleGame.INIT_TIME ) ;
        timer_.start() ;
    }
    
    public void pause()
    {
        timer_.stop() ;
    }
    
    public void enable()
    {
        timer_.start() ;
    }
    
    public void stop()
    {
        timer_.stop() ;
        initCounter() ;
    }
    public void actionPerformed( ActionEvent e )
    {
        secondsCounterLabel.setText( getMinitueString( ++counter ) ) ;
    }
    
    public int getTimeElapsedInSeconds()
    {
        return counter ;
    }
    
    public String getTimeElapsed()
    {
        int min = counter / 60 ;
        int sec = counter - ( min * 60 ) ;
        text_ = new StringBuffer() ;
        if( min < 1 )
            text_.append( 0 ) ;
        text_.append( min ) ;
        text_.append( " Minutes & ") ;
        if( sec < 10 )
            text_.append( 0 ) ;
        text_.append( sec ) ;
        text_.append( " Seconds " ) ;
        return text_.toString() ;
    }
    
    public String getMinitueString( int seconds )
    {
        int min = seconds / 60 ;
        int sec = seconds - ( min * 60 ) ;
        text_ = new StringBuffer() ;
        if( min < 1 )
            text_.append( 0 ) ;
        text_.append( min ) ;
        text_.append( " : ") ;
        if( sec < 10 )
            text_.append( 0 ) ;
        text_.append( sec ) ;
        return text_.toString() ;
    }
    
    public void finalize()
    {
        timer_ = null ;
    }
}
