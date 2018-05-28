package com.welle.design.pattern.flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.welle.design.pattern.flyweight.ShapeFactory.ShapeType;

public class DrawingClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int WIDTH;
	private final int HEIGHT;

	public final JPanel panel;

	public DrawingClient(int width, int height) {

		this.WIDTH = width;
		this.HEIGHT = height;

		Container contentPane = getContentPane();

		panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void drawThings() {
		// drawing test objects
		Graphics g = panel.getGraphics();
		Shape shape = ShapeFactory.getShape(ShapeType.LINE);
		shape.draw(g, 50, 50, 5, 1, Color.BLACK);
		
		shape = ShapeFactory.getShape(ShapeType.LINE);
		shape.draw(g, 50, 150, 5, 1, Color.RED);
	}

}
