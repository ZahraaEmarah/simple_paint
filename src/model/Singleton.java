package model;

import view.Canvas;

public class Singleton {
    
	private static Singleton instance;
    
	private Singleton(Canvas c) {
		c = new Canvas();
	}
    
	public static Singleton getInstance(Canvas c) {
		if (instance==null)
			instance = new Singleton(c);
		return instance;
	}
}

// 	how to call singleton: Singleton shape = Singleton.getInstance(chosenBtn);
