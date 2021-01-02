package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

public class Circle extends EllipticShapes{
	
	public Circle(double radius, Color c, Color fill) {
		pos = new Point();
		prop = new HashMap<String, Double>();
		prop.put("radius", radius);
		color = c; 
        fill_color = fill;
	}
	
	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		canvas.setColor(color);
		canvas.drawOval(pos.x, pos.y, prop.get("radius").intValue(), prop.get("radius").intValue());
		canvas.setColor(fill_color);
		canvas.fillOval(pos.x, pos.y, prop.get("radius").intValue(), prop.get("radius").intValue());
	}
}