package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import model.Circle;
import model.Shape;
import model.Shapes_Factory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

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
        frame.setTitle("Paint");
        frame.getContentPane().setLayout(null);
        
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 684, 58);
        frame.getContentPane().add(toolBar);
        
        JButton btnDrawEllipse = new JButton("Draw Ellipse");
        btnDrawEllipse.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		// get color
        		// get fill color
        		// listen for mouse click
        		// ....
        	}
        });
        toolBar.add(btnDrawEllipse);
        
        JButton btnDrawCircle = new JButton("Draw circle");
        toolBar.add(btnDrawCircle);
        /** when clicked:
         *  - get color + fill color
            1. listen for the first click's position
            2. get the pointer's location position
            3. redraw as mouse moves
            **/
        
        JButton btnDrawSquare = new JButton("Draw Square");
        toolBar.add(btnDrawSquare);
        
        JButton btnDrawLine = new JButton("Draw line");
        toolBar.add(btnDrawLine);
        
        JButton btnDrawRectangle = new JButton("Draw rectangle");
        btnDrawRectangle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        toolBar.add(btnDrawRectangle);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 66, 557, 484);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        /** How to create a shape
        Shapes_Factory sh = new Shapes_Factory();
        Shape shape = sh.create_a_shape("square");
        shape.draw(g); **/

	}
}
