package adapter;
import javax.swing.*;
import java.awt.event.*;
public class WindowAdapterDemo{
	JFrame f;
	WindowAdapterDemo(){
		f= new JFrame("Window Adapter");
		f.setSize(300,200);
		f.addWindowListener(new WindowAdapter(){  
                public void windowClosing(WindowEvent e) {  
                    f.dispose();  
                }  
            });
		f.setVisible(true);
	}
	public static void main(String arg[]){
		new WindowAdapterDemo();
	}
}