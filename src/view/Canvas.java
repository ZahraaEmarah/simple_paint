package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import model.Circle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Canvas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Canvas window = new Canvas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Canvas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setBounds(100, 100, 700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Paint");
        
        JButton btnDrawCircle = new JButton("Draw circle");
        btnDrawCircle.setBounds(466, 48, 155, 23);
        frame.getContentPane().add(btnDrawCircle);
        
        JButton btnDrawSquare = new JButton("Draw Square");
        btnDrawSquare.setBounds(466, 82, 155, 23);
        frame.getContentPane().add(btnDrawSquare);
        
        JButton btnDrawTriangle = new JButton("Draw triangle");
        btnDrawTriangle.setBounds(466, 116, 155, 23);
        frame.getContentPane().add(btnDrawTriangle);
        
        JButton btnDrawLine = new JButton("Draw line");
        btnDrawLine.setBounds(466, 150, 155, 23);
        frame.getContentPane().add(btnDrawLine);

	}
}
