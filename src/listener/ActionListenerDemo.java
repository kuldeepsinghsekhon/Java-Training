import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionListenerDemo implements ActionListener{
	JFrame f;
	JButton btn;
	JTextField txtf;
	JLabel lbl;
	ActionListenerDemo() {
		f= new JFrame("Action Listener Demo");
		f.setSize(300,200);
		btn= new JButton("Click Me");
		lbl= new JLabel();
		txtf = new JTextField(10);
		f.setLayout(new FlowLayout());
		f.add(txtf);
		f.add(btn);
		f.add(lbl);
		btn.addActionListener(this);
		f.setDefaultCloseOperation(3);
		f.setVisible(true);
	}
	public static void main(String arg[]){
		new ActionListenerDemo();
}
	public void actionPerformed(ActionEvent e){
		String s=txtf.getText();
		lbl.setText(s);
	}
}