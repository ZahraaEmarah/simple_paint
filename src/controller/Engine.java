package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import model.Shape;

public class Engine implements DrawingEngine {

	ArrayList<Shape> my_shapes;

	public Engine() {
		my_shapes = new ArrayList<Shape>();
	}

	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		for (Shape s : my_shapes)
			s.draw(canvas);
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		my_shapes.add(shape);
		
		for (Shape s: my_shapes)
		    System.out.println(s.getPosition());
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		int index = my_shapes.indexOf(shape);
		my_shapes.remove(index);
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		int index = my_shapes.indexOf(oldShape);
		if (oldShape != null && newShape != null) {
			my_shapes.remove(index);
			my_shapes.add(index, newShape);
		}
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		if (my_shapes.size() == 0) {
            return new Shape[] {};
        }
        Shape[] shapesArray = my_shapes.toArray(new Shape[my_shapes.size()]);
        return shapesArray;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void installPluginShape(String jarPath) {
		// TODO Auto-generated method stub

	}

}
