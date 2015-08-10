package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;

public class Notepad {

	public static void main(String[] args) {
		
		JMenu file,format,edit,view,help;
		JMenuItem new_file,open,save,saveAs,print,exit;
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextPane name=new JTextPane();
		frame.getContentPane().add(name, BorderLayout.CENTER);				
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
		//Build the first menu.
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		view = new JMenu("View");
		help = new JMenu("Help");
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(view);
		menuBar.add(help);
		
		new_file =new JMenuItem("New");
		open=new JMenuItem("Open");
		
		save=new JMenuItem("Save");
		saveAs=new JMenuItem("SaveAs");
	
		print=new JMenuItem("Print");
		exit=new JMenuItem("Exit");
		
		file.add(new_file);
		file.add(open);
		file.addSeparator();
		file.add(save);
		file.add(saveAs);
		file.addSeparator();
		file.add(print);
		file.add(exit);
		JMenuItem  status_bar = new JRadioButtonMenuItem("Status Bar");
		 view.add(status_bar);
		frame.add(menuBar,BorderLayout.BEFORE_FIRST_LINE);
		
		
		
		
		frame.setSize(500, 300);
		//frame.pack();
		frame.setVisible(true);
	}

}
