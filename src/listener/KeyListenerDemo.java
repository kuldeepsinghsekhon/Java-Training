   import javax.swing.*;
   import java.awt.*;  
    import java.awt.event.*;  
    public class KeyListenerDemo implements KeyListener{  
        Label l,l2,l3;  
        TextArea area;  
        JFrame f;  
        KeyListenerDemo(){  
            f=new JFrame("Key Adapter");  
            l=new Label();
			l2=new Label(); 
			l3=new Label();
            l.setBounds(20,20,200,20); 
			l2.setBounds(20,40,200,20);	
			l3.setBounds(20,60,200,20);			
            area=new TextArea();  
            area.setBounds(0,80,300, 100);  
            area.addKeyListener(this);     
            f.add(l);
			f.add(l2);
			f.add(l3);
			f.add(area);  
			f.setDefaultCloseOperation(3);
            f.setSize(320,260);  
            f.setLayout(null);  
            f.setVisible(true);  
        }  
        public static void main(String[] args) {  
            new KeyListenerDemo();  
        }  
		 public void keyTyped(KeyEvent e) {		
				l3.setText("key Typed  code is "+(e.getKeyChar()));
      }
      public void keyPressed(KeyEvent e) {
        l2.setText("you Pressed "+(e.getKeyChar()));
      }  
		public void keyReleased(KeyEvent e) {  
            String text=area.getText();  
            String words[]=text.split("\\s");  
            l.setText("Words: "+words.length+" Characters:"+text.length());  
        }  	  
    }  