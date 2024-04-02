package BaiThucHanhso2;

import 	java.applet.*;
import	java.awt.*;
import 	javax.swing.JFrame;

// <applet code = GridLayoutApplet width = 300 height = 100> </applet>
public class GridLayoutDemo extends JFrame {
	public void init() {
		//Create a list of colors
		Label xLabel = new Label("X coordinate: ");
		Label yLabel = new Label("Y coordinate: ");
		
		TextField xInput = new TextField(5);
		TextField yInput = new TextField(5);
		
		setLayout(new GridLayout(2,2));
		add(xLabel); add(xInput);
		add(yLabel); add(yInput);
		
		setTitle("GridLayout Demo");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		GridLayoutDemo gl = new GridLayoutDemo();
		gl.init();
	}
}
