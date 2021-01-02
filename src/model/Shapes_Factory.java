package model;

public class Shapes_Factory {

    public Shape create_a_shape(String shape_namme)
    {
        if (shape_namme == null || shape_namme.isEmpty())
            return null;
        if ("square".equals(shape_namme)) {
            return new Square(0, null, null);
        }
        else if ("rectangle".equals(shape_namme)) {
            return new Rectangle(0, 0, null, null);
        }
        else if ("circle".equals(shape_namme)) {
            return new Circle(0, null, null);
        }
        else if ("ellipse".equals(shape_namme)) {
            return new Ellipse(0, 0, null, null);
        }
        return null;
    }

}
