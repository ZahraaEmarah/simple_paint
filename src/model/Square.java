package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

public class Square extends Polygons{
	
	public Square() {
		// TODO Auto-generated constructor stub
		super();
		pos = new Point();
		prop = new HashMap<String, Double>();
	}
	
	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		canvas.setColor(color);
		canvas.drawRect(pos.x, pos.y, prop.get("N1").intValue(), prop.get("N1").intValue());
		canvas.setColor(fill_color);
		canvas.fillRect(pos.x, pos.y, prop.get("N1").intValue(), prop.get("N1").intValue());
	}

}
