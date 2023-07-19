package com.example.CalLunch.app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
 
public class GetCoodinates{
	public static void main(String[] args) {
		TestWindow gw = new TestWindow("テストウィンドウ",1000,700);
		gw.setVisible(true);
	}
}
class TestWindow extends JFrame implements MouseListener{
	public TestWindow(String title, int width, int height) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		addMouseListener(this);
	}
 
	@Override
	public void mouseClicked(MouseEvent e) {
 
		System.out.println(e.getPoint());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}