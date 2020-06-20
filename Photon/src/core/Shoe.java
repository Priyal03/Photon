package core;

import java.io.Serializable;
import java.util.logging.Logger;

class Shoe implements Serializable {
	
	// static final variable
	private static final long serialVersionUID = 40L;
	
	private static final Logger logger = Logger.getLogger(Shoe.class.getName());
	
	// static variable but not final
	private static String _brand;
	
	// instance variable
	private int _id;
	private int _size;
	private String _color;
	
	// transient variable
	private transient boolean _isRunningShoe;
	
	// non serializable field
	transient Thread _thread = new Thread();

	public Shoe(String brand, int id, int size, String color, boolean isRunningShoe) {
		System.out.println("Inside Constructor");
		_brand = brand;
		_id = id;
		_size = size;
		_color = color;
		_isRunningShoe = isRunningShoe;
	}

	public String brand() {
		return _brand;
	}

	public int id() {
		return _id;
	}

	public int size() {
		return _size;
	}

	public String color() {
		return _color;
	}

	public void print() {
		System.out.println("SerialVersionUID (final static field) : " + serialVersionUID);

		System.out.println("logger ((final static field) : " + logger);

		System.out.println("_brand (static field) : " + _brand);
		System.out.println("_id (instance variable) : " + _id);
		System.out.println("_size (instance variable) : " + _size);
		System.out.println("_color (instance variable) : " + _color);
		System.out.println("_isRunningShoed (transient variable) : " + _isRunningShoe);
		System.out.println("_thread (non-serializable field) : " + _thread);
	}
}
