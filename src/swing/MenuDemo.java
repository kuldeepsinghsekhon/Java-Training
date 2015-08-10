package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuDemo implements ActionListener {
	int rand1,rand2;
	public MenuDemo() {
		menu();
		   Random randomno = new Random();
		 rand1=randomno.nextInt(1000000);
		 rand2=randomno.nextInt(1000000);
	}
	JFrame window;
	
	JMenu operations, exit_menu;
	JMenuItem add, sub, multi, divison1,exit;
	JMenuBar menubar;
	JTextField num1_txt, num2_txt, res_txt;
	JLabel opr_lbl;
	

	public void menu() {
		menubar = new JMenuBar();
		operations = new JMenu("Operations");

		exit_menu = new JMenu("Exit");
		add = new JMenuItem("Addition");
		sub = new JMenuItem("Substraction");
		multi = new JMenuItem("Multiplication");
		divison1 = new JMenuItem("Divison");

		
		exit= new JMenuItem("Exit");
		exit.addActionListener(this);
		exit_menu.add(exit);
		add.addActionListener(this);
		sub.addActionListener(this);
		multi.addActionListener(this);
		divison1.addActionListener(this);

		operations.add(add);
		operations.add(sub);
		operations.add(divison1);
		operations.add(multi);

		menubar.add(operations);
		menubar.add(exit_menu);

	}

	void createWindow() {
		 window = new JFrame("Calculator");
		window.setDefaultCloseOperation(3);
		
		window.add(menubar, BorderLayout.BEFORE_FIRST_LINE);

		JPanel panel = new JPanel();
		num1_txt = new JTextField(rand1+"",15);
		num2_txt = new JTextField(rand2+"",15);
		res_txt = new JTextField(15);
		opr_lbl=new JLabel("operation");
		panel.add(num1_txt);
		panel.add(opr_lbl);
		panel.add(num2_txt);
		panel.add(res_txt);
		
		window.add(panel);
		window.setSize(450, 150);
		window.setResizable(false);
		window.setLocationRelativeTo(window);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		MenuDemo obj = new MenuDemo();
		obj.createWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			res_txt.setText((rand1+rand2)+"");
			opr_lbl.setText(add.getText());
			
		} else if (e.getSource() == sub) {
			res_txt.setText((rand1-rand2)+"");
			opr_lbl.setText(sub.getText());
		} else if (e.getSource() == multi) {
			res_txt.setText((rand1*rand2)+"");
			opr_lbl.setText(multi.getText());
		} else if (e.getSource() == divison1) {
			res_txt.setText((rand1/rand2)+"");
			opr_lbl.setText(divison1.getText());
		} else {
			System.exit(0);

		}

	}

}
