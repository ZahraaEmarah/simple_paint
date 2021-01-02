package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public abstract class EllipticShapes implements Shape {

	protected Color color;
	protected Color fill_color;
	protected Map<String, Double> prop;
	protected Point pos;

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		pos = position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		prop = properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return prop;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
        this.color = color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
       fill_color = color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return fill_color;
	}

	@Override
	public abstract void draw(Graphics canvas);

}
