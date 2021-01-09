package model;

public class Singleton {
    
	private static Singleton instance;
	private static Shapes_Factory shapeFactory;
	public static Shape shape;
    
	private Singleton(String name) {
		shapeFactory = new Shapes_Factory();
		shape = shapeFactory.create_a_shape(name);
	}
    
	public static Singleton getInstance(String n) {
		if (instance==null)
			instance = new Singleton(n);
		return instance;
	}
}

// 	how to call singleton: Singleton shape = Singleton.getInstance(chosenBtn);
