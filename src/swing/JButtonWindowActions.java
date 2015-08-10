package swing;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class JButtonWindowActions extends JFrame
{
JButton button1,button2,button3;
 public JButtonWindowActions()
 {
 setTitle("JButtonWindowActions Demo");
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLayout(new FlowLayout());
 setOpacity(0.7f);
 button1=new JButton("Maximize/Restore");
 button1.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae)
   {
    if(getExtendedState()==NORMAL)
    setExtendedState(MAXIMIZED_BOTH);
    else
    setExtendedState(NORMAL);
   }
  });
 button2=new JButton("Minimize");
 button2.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae)
   {
    setState(ICONIFIED);
   }
  });
 button3=new JButton("Close");
 button3.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent ae)
   {
   dispose();
   }
  });
  // add buttons to frame
 add(button1);
 add(button2);
 add(button3);
  // pack the frame
 pack();
 }
 public static void main(String args[])
 {
 new JButtonWindowActions();
 }
}