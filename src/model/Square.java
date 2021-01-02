package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

public class Square extends Polygons{
	
	public Square(double side, Color c, Color fill) {
		// TODO Auto-generated constructor stub
		pos = new Point();
		prop = new HashMap<String, Double>();
		prop.put("side", side);
		color = c; 
        fill_color = fill;
	}
	
	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		canvas.setColor(color);
		canvas.drawRect(pos.x, pos.y, prop.get("side").intValue(), prop.get("side").intValue());
		canvas.setColor(fill_color);
		canvas.fillRect(pos.x, pos.y, prop.get("side").intValue(), prop.get("side").intValue());
	}

}
