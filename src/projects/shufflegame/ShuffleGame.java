/*
 * ShuffleGame.java
 *
 * Created on February 27, 2008, 4:42 PM
 */


package projects.shufflegame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


/**
 *
 * @author  P.Sakthivel
 */
public class ShuffleGame extends JFrame implements ActionListener
{
    private static Random random ;
    static private int[] matrix ;
    
    private JButton[] buttonA ;
    
    private JPanel buttonPanel ;
    private JPanel footerPanel ;
    
    private JLabel emptyLabel ;
    private JLabel movesLabel ;
    private JLabel secondsCounterLabel ;
    
    private int blankPosition ;
    private int level ;
    private int noOfCells ;
    private int noOfMoves ;
    
    private SecondsCounter secondsCounter_ ;
    private GridLayout gridLayout ;
    
    private static final int TOP = 0 ;
    private static final int LEFT = 1 ;
    private static final int RIGHT = 2 ;
    private static final int BOTTOM = 3 ;
    
    private static final int DEFAULT_LEVEL = 4 ;
    
    public static final String INIT_TIME = "00 : 00" ;
    private static final String CLOSE = "CLOSE" ;
    private static final String PAUSE = "PAUSE" ;
    private static final String START = "START" ;
    private static final String NUMBER = "number" ;
    private static final String fileName = "Score.dat" ;
    
    private static final boolean RUNNING = true ;
    private static final boolean IDLE = false ;
    
    private boolean gameStatus = IDLE ;
    private JMenuItem reStartAction ;
    
    private static ShuffleGame shuffleGame_ ;
    
    /** Creates a new instance of ShuffleGame */
    public ShuffleGame( int levl )
    {
        super("ShuffleGame") ;
        random = new Random() ;
        level = levl ;
        init( level ) ;
        secondsCounter_ = new SecondsCounter() ;
        getContentPane().add( getTopComponent() , BorderLayout.NORTH  ) ;
        secondsCounter_.setLabel( secondsCounterLabel ) ;
        getContentPane().add( initilizeButtonPanel( level ) , BorderLayout.CENTER ) ;
        getContentPane().add( getFooterPanel() , BorderLayout.SOUTH ) ;
        
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
        //setSize(300,300);
        pack() ;
        setResizable( false ) ;
        setBounds( 300 , 300 , getWidth() , getHeight() ) ;
        setVisible( true ) ;
        
    }
    
    public static void run( int level )
    {
        if( shuffleGame_ != null )
        {
            shuffleGame_.dispose() ;
            shuffleGame_ = null ;
        }
        shuffleGame_ = new ShuffleGame( level ) ;
    }
    
    public JPanel getFooterPanel()
    {
        AnimatedJButton pauseButton = new AnimatedJButton( PAUSE , level+4 ) ;
        pauseButton.addActionListener( this ) ;
        pauseButton.setActionCommand( PAUSE ) ;
        footerPanel = new JPanel( new GridLayout(1,1)) ;
        footerPanel.add( pauseButton ) ;
        return footerPanel ;
    }
    
    public JSplitPane getTopComponent()
    {
        JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT ) ;
        splitPane.setDividerSize( 1 ) ;
        splitPane.setEnabled( false ) ;
        JMenuBar menuBar = new JMenuBar() ;
        menuBar.setBorder( new BevelBorder( BevelBorder.RAISED ) ) ;
        JMenu shuffleMenu = new JMenu("Shuffle") ;
        shuffleMenu.setMnemonic('S') ;
        JMenu helpMenu = new JMenu("Help") ;
        helpMenu.setMnemonic( 'H' ) ;
        
        reStartAction = new JMenuItem( "ReStart" ) ;
        reStartAction.setMnemonic( 'R' ) ;
        reStartAction.addActionListener( this ) ;
        JMenu levelMenu = new JMenu( "Level" ) ;
        levelMenu.setMnemonic( 'L' ) ;
        JMenuItem[] level = new JMenuItem[8] ;
        for( int i = 0 ; i < 8 ; i++ )
        {
            String title = String.valueOf( (i+3)).concat( " X " ).concat( String.valueOf( (i+3) ) ) ;
            level[i] = new JMenuItem( title ) ;
            level[i].setMnemonic( String.valueOf( (i+3) ).charAt(0) )  ;
            String ac = "level".concat( String.valueOf( (i) ) ) ;
            level[i].setActionCommand( ac ) ;
            level[i].addActionListener( this ) ;
            levelMenu.add( level[i] ) ;
        }
        
        JMenuItem scoreAction = new JMenuItem( "High Scores" ) ;
        scoreAction.setMnemonic( 'H' ) ;
        scoreAction.addActionListener( this ) ;
        JMenuItem closeAction = new JMenuItem( "Close" ) ;
        closeAction.setActionCommand( CLOSE ) ;
        closeAction.setMnemonic( 'C' ) ;
        closeAction.addActionListener( this ) ;
        
        shuffleMenu.add( reStartAction ) ;
        shuffleMenu.add( levelMenu ) ;
        shuffleMenu.add( scoreAction ) ;
        shuffleMenu.add( closeAction ) ;
        
        JMenuItem helpAction = new JMenuItem( "Instructions" ) ;
        helpAction.setMnemonic( 'I' ) ;
        helpAction.addActionListener( this ) ;
        JMenuItem aboutAction = new JMenuItem( "About Shuffle") ;
        aboutAction .setMnemonic( 'A' ) ;
        aboutAction.addActionListener( this ) ;
        helpMenu.add( helpAction ) ;
        helpMenu.add( aboutAction ) ;
        menuBar.add( shuffleMenu ) ;
        menuBar.add( helpMenu ) ;
        
        JPanel statusPanel = new JPanel( new GridLayout( 1 , 2 ) ) ;
        JPanel timePanel = new JPanel( new GridLayout( 1 , 2 ) ) ;
        JPanel movePanel = new JPanel( new GridLayout( 1 , 2 ) ) ;
        statusPanel.add( timePanel ) ;
        statusPanel.add( movePanel ) ;
        
        timePanel.setBorder( new TitledBorder("") ) ;
        movePanel.setBorder( new TitledBorder("") ) ;
        JLabel timeLabel = new JLabel( "Time ::" , JLabel.CENTER ) ;
        
        timePanel.add( timeLabel ) ;
        timePanel.add( secondsCounterLabel = new JLabel( INIT_TIME , JLabel.CENTER ) ) ;
        movePanel.add( new JLabel( "Moves ::" , JLabel.CENTER ) ) ;
        movePanel.add( movesLabel = new JLabel("0" , JLabel.CENTER ) ) ;
        
        splitPane.setTopComponent( menuBar ) ;
        splitPane.setBottomComponent( statusPanel ) ;
        return splitPane ;
    }
    
    public void init( int num )
    {
        level = num ;
        noOfCells = level * level ;
        gridLayout = new GridLayout( level , level ) ;
        buttonA = new JButton[ noOfCells ] ;
        buttonPanel = new JPanel() ;
        buttonPanel.setOpaque( true ) ;
        buttonPanel.setLayout(  gridLayout ) ;
        emptyLabel = new JLabel() ;
        emptyLabel.setBorder( new SoftBevelBorder( BevelBorder.LOWERED ) ) ;
    }
    
    public JPanel initilizeButtonPanel( int levl )
    {
        level = levl ;
        noOfMoves = 0 ;
        movesLabel.setText( "0" ) ;
        secondsCounterLabel.setText( INIT_TIME ) ;
        initMatrixToZero() ;
        buttonPanel.removeAll() ;
        int pivot = getNumberWithoutZero() ;
        for( int i = 0 ; i < noOfCells ; i++ )
        {
            if( i != pivot )
            {
                matrix[i] = getRandomNumber() ;
                buttonA[i] = new JButton( String.valueOf( ( matrix[i] ) ) ) ;
                buttonA[i].addActionListener( this ) ;
                buttonA[i].setActionCommand( NUMBER ) ;
                buttonPanel .add( buttonA[i] ) ;
            }
            else
            {
                buttonPanel.add( emptyLabel ) ;
                blankPosition = pivot ;
            }
        }
        repaintPanel() ;
        return  buttonPanel ;
    }
    
    public void initMatrixToZero()
    {
        matrix = new int[ noOfCells ] ;
        for( int i = 0 ; i < noOfCells ; i++ )
            matrix[i] = 0 ;
    }
    
    public int getRandomNumber()
    {
        int num = getNumberWithoutZero() ;
        return canAdd( num ) ? num : getRandomNumber() ;
    }
    
    public int getNumberWithoutZero()
    {
        int num = random.nextInt( noOfCells ) ;
        return num != 0 ? num : getNumberWithoutZero() ;
    }
    
    /* condition , to fill nos. without duplicate */
    public boolean canAdd( int num )
    {
        boolean canAdd = true ;
        for( int i = 0 ; i < noOfCells - 1 && canAdd ; i++ )
            canAdd = matrix[i] != num ;
        return canAdd ;
    }
    
    public static void main(String[] args)
    {
        ShuffleGame.run( 4 ) ;
    }
    
    public int getPosition( int btnNumber )
    {
        for( int i = 0 ; i < noOfCells ; i++ )
        {
            if( matrix[i] == btnNumber )
            {
                return i ;
            }
        }
        return 0 ;
    }
    
    public void repaintPanel()
    {
        pack();
    }
    
    public void startSecondsCounter()
    {
        secondsCounter_.start() ;
    }
    
    public void setGameStatus( boolean status )
    {
        gameStatus = status ;
    }
    
    /*Set Button stated enable and disable while pasuse*/
    public void changeButtonState( boolean state )
    {
        for( int i = 0 ; i < buttonA.length ; i++ )
        {
            if( buttonA[i] != null )
            {
                if( state )
                {
                    buttonA[i].setText( buttonA[i].getActionCommand() ) ;
                    buttonA[i].setActionCommand( NUMBER ) ;
                }
                else
                {
                    buttonA[i].setActionCommand( buttonA[i].getText() ) ;
                    buttonA[i].setText( "Zzzz...." ) ;
                }
                reStartAction.setEnabled( state ) ;
                buttonA[i].setEnabled( state ) ;
            }
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand() ;
        if ( actionCommand == PAUSE )
        {
            secondsCounter_.pause() ;
            changeButtonState( false ) ;
            AnimatedJButton btn = ( AnimatedJButton ) e.getSource() ;
            btn.setLabelName( START ) ;
            btn.setActionCommand( START ) ;
        }
        else if( actionCommand.equals( START ) )
        {
            secondsCounter_.enable() ;
            changeButtonState( true ) ;
            AnimatedJButton btn = ( AnimatedJButton ) e.getSource() ;
            setGameStatus( RUNNING ) ;
            btn.setLabelName( PAUSE ) ;
            btn.setActionCommand( PAUSE ) ;
        }
        else if( actionCommand.equals("ReStart") )
        {
            initilizeButtonPanel( level ) ;
            secondsCounter_.stop() ;
            setGameStatus( IDLE ) ;
            repaintPanel() ;
        }
        else if( actionCommand.equals( CLOSE ) )
        {
            secondsCounter_.stop() ;
            secondsCounter_.finalize() ;
            shuffleGame_.dispose() ;
        }
        else if ( actionCommand.substring(0,5).equals("level") )
        {
            /* eleminate int value from string for ex., 5 from "level5" */
            int _level = Integer.parseInt( actionCommand.substring(5,6) ) ;
            for( int i = 0 ; i <= 8 ; i++ ) /* Zero starts from level 3 */
            {
                if( _level == i )
                {
                    ShuffleGame.run( i+3 ) ;
                }
            }
        }
        else if ( actionCommand.equals( NUMBER ) )
        {
            JButton button = ( JButton ) e.getSource() ;
            int btnNumber = Integer.parseInt( button.getText() ) ;
            int pos = getPosition( btnNumber )  ;
            JButton btn = ( JButton ) buttonPanel.getComponent( pos ) ;
            JLabel label = getComponentIfPossibleToMove( pos ) ;
            if( label != null )
            {
                if( gameStatus == IDLE )
                {
                    setGameStatus( RUNNING ) ;
                    startSecondsCounter() ;
                }
                buttonPanel.add( label , pos ) ;
                buttonPanel.add( btn , blankPosition ) ;
                matrix[pos] = 0 ;
                matrix[ blankPosition ] = btnNumber ;
                blankPosition = pos ;
                noOfMoves += 1 ;
                movesLabel.setText( String.valueOf( noOfMoves ) ) ;
                repaintPanel() ;
                if( blankPosition == noOfCells - 1 )
                {
                    if( analyseResult() )
                    {
                        String etStr = secondsCounter_.getTimeElapsed() ;
                        int time = secondsCounter_.getTimeElapsedInSeconds() ;
                        secondsCounter_.stop() ;
                        gameStatus = IDLE ;
                        JOptionPane.showMessageDialog( ShuffleGame.this , "<html> <b color ='red'> WellDone...! you have finished <br> within ".concat( etStr ) ) ;
                        showScoreDialog( noOfMoves , time ) ;
                        initilizeButtonPanel( level ) ;
                    }
                }
                
            }
        }
        else if ( actionCommand.equals( "Instructions" ) )
        {
            showImageDialog( ".\\Image\\Help.png" , "Instructions" ) ;
        }
        else if ( actionCommand.equals( "About Shuffle" ) )
        {
            showImageDialog( ".\\Image\\About.png" , "Shuffle Game - Version 1.0" ) ;
        }
        else if( actionCommand.equals("High Scores") )
        {
            showHighScoreDialog() ;
        }
    }
    
    public void showHighScoreDialog()
    {
        try
        {
            File file = new File( fileName ) ;
            if ( file.isFile() )
            {
                FileInputStream fis = new FileInputStream( file ) ;
                ObjectInputStream ois = new ObjectInputStream( fis ) ;
                Object obj = ois.readObject() ;
                if( obj instanceof TreeMap )
                {
                    TreeMap map = ( TreeMap ) obj ;
                    Entry entry  ;
                    Iterator itr = map.entrySet().iterator() ;
                    Credits credits ;
                    JPanel scoreBoardPanel = new JPanel( new GridLayout( map.size()+1 , 4 ) ) ;
                    scoreBoardPanel.setEnabled( false ) ;
                    scoreBoardPanel.add( new JLabel( "Level" ) ) ;
                    scoreBoardPanel.add( new JLabel( "Player" ) ) ;
                    scoreBoardPanel.add( new JLabel( "Time" ) ) ;
                    scoreBoardPanel.add( new JLabel( "Moves" ) ) ;
                    JTextField tField = new JTextField () ;
                    tField.setEditable( false ) ;
                    while( itr.hasNext() )
                    {
                        entry = ( Entry ) itr.next() ;
                        Integer _level = ( Integer ) entry.getKey() ;
                        TreeSet levelSet = ( TreeSet ) entry.getValue() ;
                        credits = ( Credits ) levelSet .first() ;
                        scoreBoardPanel.add( tField = new JTextField ( String.valueOf( credits.getLevel() ) ) ) ;
                        tField.setEditable( false ) ;
                        scoreBoardPanel.add( tField = new JTextField ( credits.getPlayer() ) ) ;
                        tField.setEditable( false ) ;
                        scoreBoardPanel.add( tField = new JTextField ( credits.getTime() ) ) ;
                        tField.setEditable( false ) ;
                        scoreBoardPanel.add( tField = new JTextField ( String.valueOf( credits.getMoves() ) ) ) ;
                        tField.setEditable( false ) ;
                    }
                    JDialog highScoreDialog = new JDialog( ShuffleGame.this , "High Scores" , true ) ;
                    highScoreDialog.getContentPane().add( scoreBoardPanel , BorderLayout.CENTER ) ;
                    highScoreDialog.getContentPane().add(  getCloseButtonPanel( highScoreDialog ) , BorderLayout.SOUTH ) ;
                    highScoreDialog.pack() ;
                    highScoreDialog.setBounds( getX() , getY() , highScoreDialog.getWidth() ,  highScoreDialog.getHeight() ) ;
                    highScoreDialog.setVisible( true ) ;
                }
                else
                {
                    showWarrningDialog() ;
                }
            }
            else
            {
                JOptionPane.showMessageDialog( ShuffleGame.this , "Score board is empty" ) ;
            }
        }
        catch ( Exception e )
        {
            showWarrningDialog() ;
        }
    }
    
    public void showWarrningDialog()
    {
        JOptionPane.showMessageDialog( ShuffleGame.this , "Score data file is corrupted\nplease delete the Score.dat \n file and run the game" ) ;
    }
    
    public void showScoreDialog( int moves , int seconds )
    {
        TreeSet set = null ;
        TreeMap map = null ; /* Map = [ level , [ set = [ credit1,2,3..10 ] ] ] */
        try
        {
            File file = new File( fileName ) ;
            if ( file.isFile() )
            {
                FileInputStream fis = new FileInputStream( file ) ;
                ObjectInputStream ois = new ObjectInputStream( fis ) ;
                Object obj = ois.readObject() ;
                if( obj instanceof TreeMap )
                {
                    map = ( TreeMap ) obj ;
                    set = ( TreeSet ) map.get( new Integer( level ) ) ;
                    if( set != null )
                    {
                        Credits newCredits = new Credits( seconds , moves , level ) ;
                        if( set.size() < 10 )
                        {
                            set.add( newCredits ) ;
                        }
                        else
                        {
                            List list = new ArrayList( set ) ;
                            Credits c = ( Credits ) list.get( 9 ) ;
                            if( c.getTimeInSeconds() >= seconds )
                            {
                                if( c.getTimeInSeconds() > seconds || c.getMoves() > moves )
                                {
                                    list.remove( 9 ) ;
                                    list.add( newCredits ) ;
                                    set.clear() ;
                                    set.addAll( list ) ;
                                }
                            }
                        }
                    }
                    else
                    {
                        set = new TreeSet() ;
                        set.add( new Credits( seconds , moves , level ) ) ;
                        map.put( new Integer( level ) , set ) ;
                    }
                    
                    file.delete() ;
                    file = new File( fileName ) ;
                }
                else
                {
                    showWarrningDialog() ;
                }
                ois.close() ;
                fis.close() ;
            }
            else
            {
                set = new TreeSet() ;
                set.add( new Credits( seconds , moves , level ) ) ;
                map = new TreeMap() ;
                map.put( new Integer( level ) , set ) ;
                
            }
            
            showScoreDialog( set ) ;
            FileOutputStream fos = new FileOutputStream( file ) ;
            ObjectOutputStream ous = new ObjectOutputStream( fos ) ;
            ous.writeObject( map ) ;
            ous.close() ;
            fos.close() ;
            
        }
        catch( Exception e )
        {
            e.printStackTrace() ;
            showWarrningDialog() ;
        }
    }
    
    public void showScoreDialog( final TreeSet scoreSet )
    {
        final JDialog scoreDialog = new JDialog( ShuffleGame.this , "High Scores" , true ) ;
        if( scoreSet == null )
        {
            return ;
        }
        
        int size = scoreSet.size() ;
        JPanel panel = new JPanel( new GridLayout( size+1 , 4 ) ) ;
        final JTextField text[][] = new JTextField[ size ][4] ;
        panel.add( new JLabel( "Sr.No" ) ) ;
        panel.add( new JLabel( "Player" ) ) ;
        panel.add( new JLabel( "Time" ) ) ;
        panel.add( new JLabel( "No.of Moves" ) ) ;
        
        List list = new ArrayList( scoreSet ) ;
        int pos = -1 ;
        Credits c1 = null , c ;
        for ( int i = 0 ; i < size ; i++ )
        {
            c = ( Credits ) list.get(i) ;
            text[i][0] = new JTextField( String.valueOf( i+1) ) ;
            text[i][0] .setEditable( false ) ;
            text[i][1] = new JTextField( c.getPlayer() , 10 ) ;
            if( c.getPlayer().equals("") )
            {
                pos = i ;
                c1 = c ;
                String st = "Enter your Name";
                text[i][1].setText(st) ;
                text[i][1].select(0 , st.length() ) ;
                text[i][1].setEditable( true ) ;
            }
            else
            {
                text[i][1] .setEditable( false ) ;
            }
            text[i][2] = new JTextField( c.getTime() , 6 ) ;
            text[i][2] .setEditable( false ) ;
            text[i][3] = new JTextField( String.valueOf( c.getMoves() ) , 5 ) ;
            text[i][3] .setEditable( false ) ;
            
            panel.add( text[i][0] ) ;
            panel.add( text[i][1] ) ;
            panel.add( text[i][2] ) ;
            panel.add( text[i][3] ) ;
        }
        
        final JButton okButton = new JButton( "OK" ) ;
        okButton.setMnemonic('O') ;
        if( pos == -1 )
            return ;
        okButton.setNextFocusableComponent( text[pos][1] ) ;
        final Credits c2 = c1 ;
        final int ps = pos ;
        ActionListener scoreBoardListener = new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                Object source = e.getSource() ;
                if ( source instanceof JButton )
                {
                    String name = text[ps][1].getText() ;
                    if( ! name.equals( "" ) )
                    {
                        c2.setPlayer( name ) ;
                        scoreSet.add( c2 ) ;
                        scoreDialog.dispose() ;
                        return ;
                    }
                }
                else if ( source instanceof JTextField )
                {
                    JTextField tF = ( JTextField ) source ;
                    if( ! tF.getText().equals("") )
                    {
                        okButton.doClick() ;
                        return ;
                    }
                }
                JOptionPane.showMessageDialog( scoreDialog , "Null Name Not Allowed" ) ;
                text[ps][1].requestFocus() ;
                return ;
            }
        } ;
        
        okButton.addActionListener( scoreBoardListener ) ;
        
        JPanel closeButtonPanel = new JPanel() ;
        closeButtonPanel.add( okButton ) ;
        closeButtonPanel.setBorder( new BevelBorder( BevelBorder.RAISED )) ;
        
        scoreDialog.getContentPane().add( panel , BorderLayout.CENTER ) ;
        scoreDialog.getContentPane().add( closeButtonPanel , BorderLayout.SOUTH ) ;
        scoreDialog.pack();
        text[pos][1].addActionListener( scoreBoardListener ) ;
        text[pos][1].selectAll() ;
        text[pos][1].requestFocus() ;
        scoreDialog.setBounds( getX() , getY() , scoreDialog.getWidth() ,  scoreDialog.getHeight() ) ;
        scoreDialog.setVisible( true ) ;
    }
    
    public void showImageDialog( String imageName , String title )
    {
        final JDialog helpDialog = new JDialog( ShuffleGame.this , title , true ) ;
        ImageIcon icon = new ImageIcon( imageName ) ;
        JPanel iconPanel = new JPanel() ;
        JLabel label = new JLabel( icon , JLabel.CENTER ) ;
        iconPanel.add( label , BorderLayout.CENTER ) ;
        iconPanel.setBorder( new BevelBorder( BevelBorder.RAISED )) ;
       
        helpDialog.getContentPane().add(  iconPanel , BorderLayout.CENTER ) ;
        helpDialog.getContentPane().add( getCloseButtonPanel( helpDialog ) , BorderLayout.SOUTH ) ;
        helpDialog.pack() ;
        helpDialog.setVisible( true ) ;
    }
    
    public JPanel getCloseButtonPanel( final JDialog dialog )
    {
         JButton okButton = new JButton( "OK" ) ;
        okButton.setMnemonic('O') ;
        okButton.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                dialog.dispose() ;
            }
        } ) ;
        JPanel closeButtonPanel = new JPanel() ;
        closeButtonPanel.add( okButton ) ;
        closeButtonPanel.setBorder( new BevelBorder( BevelBorder.RAISED )) ;
        return closeButtonPanel ;
    }
    
    public boolean analyseResult()
    {
        boolean result = true ;
        for( int i = 0 ; i < noOfCells - 1 && result ; i++ )
        {
            if( matrix[i] != i+1 )
            {
                result = false ;
            }
        }
        return result ;
    }
    
    public JLabel getComponentIfPossibleToMove( int pos )
    {
        Component comp = null ;
        JLabel label = null ;
        for( int i = 0 ; i <= 3 && label == null ; i++ )
        {
            comp = getComponent( i , pos ) ;
            if( comp instanceof JLabel )
            {
                label = ( JLabel ) comp ;
            }
        }
        return label ;
    }
    
    public boolean isPositionNotLeft( int pos )
    {
        boolean guess = true ;
        for( int i = 0 ; i < level && guess ; i++ )
        {
            if( pos == ( i * level ) )
            {
                guess = false ;
            }
        }
        return guess ;
    }
    
    public boolean isPositionNotRight( int pos )
    {
        boolean guess = true ;
        for( int i = 0 ; i < level && guess ; i++ )
        {
            if( pos == ( ( i + 1 ) * level ) - 1 )
            {
                guess = false ;
            }
        }
        return guess ;
    }
    
    public boolean isPositionNotTop( int pos )
    {
        boolean guess = true ;
        for( int i = 0 ; i < level && guess ; i++ )
        {
            if( pos == i )
            {
                guess = false ;
            }
        }
        return guess ;
    }
    
    public boolean isPositionNotBottom( int pos )
    {
        boolean guess = true ;
        for( int i = 0 ; i < level && guess ; i++ )
        {
            if( pos == ( i + ( level * (level-1) ) ) )
            {
                guess = false ;
            }
        }
        return guess ;
    }
    
    public Component getComponent( int position , int cp )
    {
        Component component = null ;
        switch( position )
        {
            case LEFT :
            {
                if( isPositionNotLeft( cp ) )
                {
                    component = buttonPanel.getComponent( cp - 1 ) ;
                }
                break ;
            }
            case RIGHT :
            {
                if( isPositionNotRight( cp ) )
                {
                    component = buttonPanel.getComponent( cp + 1 ) ;
                }
                break ;
            }
            case TOP :
            {
                if( isPositionNotTop( cp ) )
                {
                    component = buttonPanel.getComponent( cp - level ) ;
                }
                break ;
            }
            case BOTTOM :
            {
                if( isPositionNotBottom( cp ) )
                {
                    component = buttonPanel.getComponent( cp + level ) ;
                }
                break ;
            }
        }
        return component ;
    }
}
