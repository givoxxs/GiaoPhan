package BaiThucHanhso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.io.*;

public class Bai9_MouseEvent extends JFrame {

    public void GUI() {       
    	setTitle("Bài 9: Mouse Event");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("You press the mouse at " + x + " " + y);
            }
            
            public void mouseEntered(MouseEvent e) {
                System.out.println("You enter the window at " + e.getX() + " " + e.getY());
            }
            
            public void mouseExited(MouseEvent e) {
                System.out.println("You exit the window at " + e.getX() + " " + e.getY());
            }
        });
    }
    
	public Bai9_MouseEvent(String st) {
		super(st);
		GUI();
	}
	
	public static void main(String[] args) {
		new Bai9_MouseEvent("");
	}
}
