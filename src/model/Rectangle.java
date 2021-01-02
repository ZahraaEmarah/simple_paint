package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

public class Rectangle extends Polygons {
	
	public Rectangle(double height, double width, Color c, Color fill) {
		pos = new Point();
		prop = new HashMap<String, Double>();
		prop.put("height", height);
		prop.put("width", width);
		color = c; 
        fill_color = fill;
	}
	
	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		canvas.setColor(color);
		canvas.drawRect(pos.x, pos.y, prop.get("weight").intValue(), prop.get("height").intValue());
		canvas.setColor(fill_color);
		canvas.fillRect(pos.x, pos.y, prop.get("weight").intValue(), prop.get("height").intValue());
	}

}
