package model;


public class Shapes_Factory {

    public Shape create_a_shape(String shape_name)
    {
        if (shape_name == null || shape_name.isEmpty())
            return null;
        if ("square".equals(shape_name)) {
            return new Square();
        }
        else if ("rectangle".equals(shape_name)) {
            return new Rectangle();
        }
        else if ("circle".equals(shape_name)) {
            return new Circle();
        }
        else if ("ellipse".equals(shape_name)) {
            return new Ellipse();
        }
        return null;
    }

}
