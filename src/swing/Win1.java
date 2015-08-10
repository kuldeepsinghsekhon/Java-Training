package swing;
import javax.swing.JFrame;


public class Win1 {
	
	void showGUI(){
		JFrame fr =new JFrame();
		fr.setSize(500, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}

	public static void main(String[] args) {
	 Win1 ob =new Win1();
	 ob.showGUI();
	}

}
