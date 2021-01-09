package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public abstract class EllipticShapes implements Shape {

	protected Color color;
	protected Color fill_color;
	protected Map<String, Double> prop;
	protected Point start_pos;
	protected Point end_pos;

	@Override
	public void setStartPosition(Point position) {
		// TODO Auto-generated method stub
		start_pos = position;
	}

	@Override
	public Point getStartPosition() {
		// TODO Auto-generated method stub
		return start_pos;
	}

	@Override
	public void setEndPosition(Point position) {
		// TODO Auto-generated method stub
		end_pos = position;
	}

	@Override
	public Point getEndPosition() {
		// TODO Auto-generated method stub
		return end_pos;
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
