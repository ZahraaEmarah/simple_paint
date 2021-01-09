package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import controller.Engine;
import model.Shape;
import model.Shapes_Factory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Canvas {

	private JFrame frame;
	Engine engine = new Engine();
	Color color;
	Color fill;
	Point start_point = new Point(0, 0);
	Point end_point = new Point(0, 0);
	Point current = new Point(0, 0);
	Point position;
	Shapes_Factory sh = new Shapes_Factory();
	String chosenBtn = "none";
	private Map<String, Double> properties ;
	Shape shape;

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 66, 557, 484);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				start_point = arg0.getPoint();
			}
			
			@Override
			public void mouseDragged(MouseEvent args) {
				current = args.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent arg1) {
				end_point = arg1.getPoint();

				int width = end_point.x - start_point.x;
				int height = end_point.y - start_point.y;

				if (!chosenBtn.equals("none")) {
					properties = new HashMap<String, Double>();			
					properties.put("N1", (double) height);
					properties.put("N2", (double) width);
									
					shape = sh.create_a_shape(chosenBtn);
					shape.setPosition(start_point);
					shape.setProperties(properties);
					shape.setColor(Color.BLUE);
					shape.setFillColor(Color.blue);
                     					
					engine.addShape(shape);
					engine.refresh(panel.getGraphics());
										
				}
			}
		});

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 684, 58);
		frame.getContentPane().add(toolBar);

		JButton btnDrawEllipse = new JButton("Draw Ellipse");
		btnDrawEllipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chosenBtn = "ellipse";
				System.out.println(chosenBtn);
			}
		});
		toolBar.add(btnDrawEllipse);

		JButton btnDrawCircle = new JButton("Draw circle");
		btnDrawCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "circle";
				System.out.println(chosenBtn);
			}
		});
		toolBar.add(btnDrawCircle);

		JButton btnDrawSquare = new JButton("Draw Square");
		btnDrawSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "square";
				System.out.println(chosenBtn);
			}
		});
		toolBar.add(btnDrawSquare);

		JButton btnDrawLine = new JButton("Draw line");
		btnDrawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "line";
				System.out.println(chosenBtn);
			}
		});
		toolBar.add(btnDrawLine);

		JButton btnDrawRectangle = new JButton("Draw rectangle");
		btnDrawRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "rectangle";
				System.out.println(chosenBtn);
			}
		});
		toolBar.add(btnDrawRectangle);

		JButton btnWhite = new JButton("Light mode");
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.getBackground() == Color.BLACK) {
					panel.setBackground(Color.WHITE);
					btnWhite.setText("Dark mode");
				} else {
					panel.setBackground(Color.BLACK);
					btnWhite.setText("Light mode");
				}
			}
		});
		btnWhite.setBounds(577, 66, 97, 23);
		frame.getContentPane().add(btnWhite);

	}
}
