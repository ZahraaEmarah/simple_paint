package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import controller.Engine;
import model.Shape;
import model.Shapes_Factory;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Canvas {

	private JFrame frame;
	Engine engine = new Engine();
	Color color = Color.WHITE;
	Color fill = Color.WHITE;
	Point start_point = new Point(0, 0);
	Point end_point = new Point(0, 0);
	Point current = new Point(0, 0);
	Point position;
	Shapes_Factory sh = new Shapes_Factory();
	String chosenBtn = "none";
	private Map<String, Double> properties;
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
		panel.setBounds(10, 33, 557, 517);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				start_point = arg0.getPoint();
			}
			
			@Override
			public void mouseReleased(MouseEvent arg1) {
				end_point = arg1.getPoint();
				int width = end_point.x - start_point.x;
				int height = end_point.y - start_point.y;

				if (chosenBtn.equals("select")) {
					current = end_point;
					Shape selected_shape = select();
				}
				if (chosenBtn.equals("line")) {
					properties = new HashMap<String, Double>();
					properties.put("N1", (double) end_point.x);
					properties.put("N2", (double) end_point.y);
				} else {
					properties = new HashMap<String, Double>();
					properties.put("N1", (double) height);
					properties.put("N2", (double) width);
				}
				shape = sh.create_a_shape(chosenBtn);
				shape.setStartPosition(start_point);
				shape.setEndPosition(end_point);
				shape.setProperties(properties);
				shape.setColor(color);
				shape.setFillColor(color);

				engine.addShape(shape);
				engine.refresh(panel.getGraphics());

			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				System.out.println(arg0.getPoint());
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(567, 33, 117, 528);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnColor = new JButton("");
		btnColor.setBounds(66, 43, 41, 21);
		panel_1.add(btnColor);

		JButton btnWhite = new JButton("Light mode");
		btnWhite.setBounds(10, 11, 97, 21);
		panel_1.add(btnWhite);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.getBackground() == Color.BLACK) {
					panel.setBackground(Color.WHITE);
					btnWhite.setText("Dark mode");
					engine.refresh(panel.getGraphics());
				} else {
					panel.setBackground(Color.BLACK);
					btnWhite.setText("Light mode");
					engine.refresh(panel.getGraphics());
				}
			}
		});
		btnColor.setBackground(Color.WHITE);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 43, 46, 21);
		panel_1.add(lblColor);

		JButton btnDrawRectangle = new JButton(new ImageIcon("src/Rectangle.png"));
		btnDrawRectangle.setBounds(10, 75, 41, 21);
		panel_1.add(btnDrawRectangle);

		JButton btnDrawLine = new JButton(new ImageIcon("src/LineSegment.png"));
		btnDrawLine.setBounds(66, 75, 41, 21);
		panel_1.add(btnDrawLine);

		JButton btnDrawSquare = new JButton(new ImageIcon("src/Square.png"));
		btnDrawSquare.setBounds(10, 107, 41, 21);
		panel_1.add(btnDrawSquare);

		JButton btnDrawCircle = new JButton(new ImageIcon("src/Circle.png"));
		btnDrawCircle.setBounds(66, 107, 41, 21);
		panel_1.add(btnDrawCircle);

		JButton btnDrawEllipse = new JButton(new ImageIcon("src/Ellipse.png"));
		btnDrawEllipse.setBounds(10, 139, 41, 21);
		panel_1.add(btnDrawEllipse);

		JButton btnNewButton = new JButton(new ImageIcon("src/triangle.png"));
		btnNewButton.setBounds(66, 139, 41, 21);
		panel_1.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 181, 97, 2);
		panel_1.add(separator);

		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chosenBtn = "select";
			}
		});
		btnSelect.setBounds(10, 194, 97, 23);
		panel_1.add(btnSelect);

		JButton btnUndo = new JButton("undo");
		btnUndo.setBounds(10, 228, 97, 23);
		panel_1.add(btnUndo);

		JButton btnRedo = new JButton("redo");
		btnRedo.setBounds(10, 262, 97, 23);
		panel_1.add(btnRedo);

		JButton btnRemove = new JButton("remove");
		btnRemove.setBounds(10, 296, 97, 23);
		panel_1.add(btnRemove);

		JButton btnEdit = new JButton("edit");
		btnEdit.setBounds(10, 330, 97, 23);
		panel_1.add(btnEdit);
		btnDrawEllipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chosenBtn = "ellipse";
				System.out.println(chosenBtn);
			}
		});
		btnDrawCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "circle";
				System.out.println(chosenBtn);
			}
		});
		btnDrawSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "square";
				System.out.println(chosenBtn);
			}
		});
		btnDrawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "line";
				System.out.println(chosenBtn);
			}
		});
		btnDrawRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenBtn = "rectangle";
				System.out.println(chosenBtn);
			}
		});
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialcolor = Color.RED;
				color = JColorChooser.showDialog(panel_1, "Select a color", initialcolor);
				btnColor.setBackground(color);
			}
		});

	}

	private Shape select() {
		Shape[] s = engine.getShapes();
		Shape sh = null;
		for (Shape shape : s) {
			if (shape.getStartPosition().x < current.x && current.x < shape.getEndPosition().x) {
				if (shape.getStartPosition().y < current.y && current.y < shape.getEndPosition().y) {
					System.out.println(shape.getProperties() + " is selected");
					sh = shape;
				}
			}
		}

		return sh;
	}
}
