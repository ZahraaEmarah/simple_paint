package model;

import java.awt.Color;
import java.util.Map;

public class Shapes_Factory {

    public Shape create_a_shape(String shape_name, int height, int width, Color color, Color fill)
    {
        if (shape_name == null || shape_name.isEmpty())
            return null;
        if ("square".equals(shape_name)) {
            return new Square(height, color, fill);
        }
        else if ("rectangle".equals(shape_name)) {
            return new Rectangle(height, width, color, fill);
        }
        else if ("circle".equals(shape_name)) {
            return new Circle(height, color, fill);
        }
        else if ("ellipse".equals(shape_name)) {
            return new Ellipse(height, width, color, fill);
        }
        return null;
    }

}
