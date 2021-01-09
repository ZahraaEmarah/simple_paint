package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

public class Circle extends EllipticShapes{
	
	public Circle() {
		super();
		start_pos = new Point();
		end_pos = new Point();
		prop = new HashMap<String, Double>();
	}
	
	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		canvas.setColor(color);
		canvas.drawOval(start_pos.x, start_pos.y, prop.get("N1").intValue(), prop.get("N1").intValue());
		canvas.setColor(fill_color);
		canvas.fillOval(start_pos.x, start_pos.y, prop.get("N1").intValue(), prop.get("N1").intValue());
	}
}