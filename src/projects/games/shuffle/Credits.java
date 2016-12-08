/*
 * Credits.java
 *
 * Created on March 1, 2008, 10:55 PM
 */

package projects.games.shuffle;

import java.io.*;
import java.lang.*;

/**
 *
 * @author  P.Sakthivel
 */
public class Credits implements Comparable , Serializable
{
    
    /** Creates a new instance of Credits */
    private String player_ ;
    private int seconds_ ;
    private int moves_ ;
    private String timeString_ ;
    private int level_ ;
    public Credits( int seconds , int moves , int level )
    {
        seconds_ = seconds ;
        moves_ = moves ;
        level_ = level ;
        prepareTimeString() ;
    }
    
    public void prepareTimeString()
    {
        if( seconds_ != 0.0d )
        {
            int min = ( int ) ( seconds_ / 60.0f ) ;
            int seconds = ( int ) ( seconds_ % 60 ) ;
            StringBuffer timeString = new StringBuffer() ;
            timeString.append( min ) ;
            timeString.append( ':' ) ;
            timeString.append( seconds ) ;
            timeString_ = timeString.toString() ;
        }
    }
    
    public int getTimeInSeconds()
    {
        return seconds_ ;
    }
    public int getLevel()
    {
        return level_ ;
    }
    public String getPlayer()
    {
        return player_ == null ? "" : player_ ;
    }
    
    public void setPlayer( String player )
    {
        player_ = player ;
    }
    
    public String getTime()
    {
        return seconds_ != 0.0d ? timeString_ : "" ;
    }
    
    public int getMoves()
    {
        return moves_ ;
    }
    
    public int compareTo(Object o )
    {
        Credits c1 = ( Credits ) o ;
        int cmp = compare( seconds_ , c1.seconds_ ) ;
        if( cmp == 0 )
        {
            int cmp1 = compare( moves_ , c1.moves_ ) ;
            if( cmp1 == 0 )
            {
                return getPlayer().compareToIgnoreCase( c1.getPlayer() ) ;
            }
            return cmp1 ;
        }
        return cmp ;
    }
    
    public int compare( double d1 , double d2 )
    {
        return d1 > d2 ? 1 : ( ( d1 < d2 ) ? -1 : 0 ) ;
    }
    
    public int compare( int d1 , int d2 )
    {
        return d1 > d2 ? 1 : ( ( d1 < d2 ) ? -1 : 0 ) ;
    }
}
