/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author kuldeep
 */

public class MenuShortcut extends JFrame implements ActionListener{
  private JMenuBar menuBar = new JMenuBar(); // Window menu bar
  private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
  private JRadioButtonMenuItem lineItem, rectangleItem, circleItem;
  private JCheckBoxMenuItem redItem, yellowItem;
  public MenuShortcut(String title) {
    JMenu fileMenu = new JMenu("File"); // Create File menu
    JMenu elementMenu = new JMenu("Elements"); // Create Elements menu
    fileMenu.setMnemonic('F'); // Create shortcut
    elementMenu.setMnemonic('E'); // Create shortcut
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setJMenuBar(menuBar);
    newItem =new JMenuItem("New File", new ImageIcon("img.png"));
    fileMenu.add(newItem);
    //newItem = fileMenu.add("New");
    newItem.addActionListener(this);
    openItem = fileMenu.add("Open");
    openItem.addActionListener(this);
    closeItem = fileMenu.add("Close");
    closeItem.addActionListener(this);
    fileMenu.addSeparator();
    saveItem = fileMenu.add("Save");
    saveAsItem = fileMenu.add("Save As...");
    fileMenu.addSeparator();
    printItem = fileMenu.add("Print");
    elementMenu.add(lineItem = new JRadioButtonMenuItem("Line", true));
    elementMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", false));
    elementMenu.add(circleItem = new JRadioButtonMenuItem("Circle", false));
    ButtonGroup types = new ButtonGroup();
    types.add(lineItem);
    types.add(rectangleItem);
    types.add(circleItem);
    elementMenu.addSeparator();
    elementMenu.add(redItem = new JCheckBoxMenuItem("Red", false));
    elementMenu.add(yellowItem = new JCheckBoxMenuItem("Yellow", false));
    menuBar.add(fileMenu);
    menuBar.add(elementMenu);
    newItem.setAccelerator(KeyStroke.getKeyStroke('N',CTRL_DOWN_MASK));
    openItem.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
    saveItem.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
    printItem.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));
    lineItem.setAccelerator(KeyStroke.getKeyStroke('L', CTRL_DOWN_MASK));
    rectangleItem.setAccelerator(KeyStroke.getKeyStroke('E', CTRL_DOWN_MASK));
    circleItem.setAccelerator(KeyStroke.getKeyStroke('I', CTRL_DOWN_MASK));
    elementMenu.addSeparator();
    redItem.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));
    yellowItem.setAccelerator(KeyStroke.getKeyStroke('Y', CTRL_DOWN_MASK));
    menuBar.add(fileMenu);
    menuBar.add(elementMenu);
  }
  public static void main(String[] a) {
    MenuShortcut window = new MenuShortcut("");
    window.setBounds(30, 30, 300, 300);
    window.setVisible(true);
  }
  public void showMessage(String msg){
      
  }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource()==newItem){
       JOptionPane.showMessageDialog(this,"You clicked New File Menu","Title New File", JOptionPane.WARNING_MESSAGE);
   }else if(e.getSource()==openItem){
       //Create a file chooser
final JFileChooser fc = new JFileChooser();
int returnVal = fc.showOpenDialog(this);
if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
    try {
        FileReader in =  new FileReader(file);
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MenuShortcut.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    }else if(e.getSource()==closeItem){
     
    }
}
}
