package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai10_CreateMenu extends JFrame{
	public void GUI() {
		setTitle("Bài 10: Create Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        // File menu
        JMenu menuFile = new JMenu("File");
        
        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemExit = new JMenuItem("Exit");
        
        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.addSeparator();
        menuFile.add(itemExit);
        
        menuBar.add(menuFile);
        // Edit menu
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem itemCut = new JMenuItem("Cut");
        JMenuItem itemCopy = new JMenuItem("Copy");
        JMenuItem itemPaste = new JMenuItem("Paste");
        
        menuEdit.add(itemCut);
        menuEdit.add(itemCopy);
        menuEdit.add(itemPaste);
        // Option menu
        JMenu editOption = new JMenu("Option");
        JMenuItem itemFirst = new JMenuItem("First");
        JMenuItem itemSecond = new JMenuItem("Second");
        JMenuItem itemThird = new JMenuItem("Third");
        
        editOption.add(itemFirst);
        editOption.add(itemSecond);
        editOption.add(itemThird);
        
        menuEdit.addSeparator();
        menuEdit.add(editOption);
        menuEdit.addSeparator();
        
        JMenuItem itemProtected = new JMenuItem("Protected");
        menuEdit.add(itemProtected);
        // Add menu to menu bar
        menuBar.add(menuEdit);
        setJMenuBar(menuBar);
        
        setVisible(true);
        
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
	
	public Bai10_CreateMenu(String st) {
		super(st);
        GUI();
    }
	
	public static void main(String[] args) {
		new Bai10_CreateMenu("Create Menu");
	}
}
