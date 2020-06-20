package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Suppose you have a Serializable class Employee, and later one developer introduced another instance variable Department, which is not Serializable. Do you know what will happen? The Employee can not be serialized anymore.

//That's why I recommend putting Serialization alert in the source file of a Serializable classes, reminding them about not adding any variable which is not serializable or making it transient if they really need it.

public class Serialization {

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		Shoe whiteNikeShoe = new Shoe("Nike", 1000, 9, "WHITE", true);

		System.out.println("Before Serialization");

		whiteNikeShoe.print();

		// serializing shoe object
		writeShoe(whiteNikeShoe);

		// creating another Shoe with different brand
		Shoe blackAdidasShoe = new Shoe("Adidas", 2000, 8, "Black", true);

		// deserializing shoe object
		whiteNikeShoe = (Shoe) readShoe();

		System.out.println("After DeSerialization");

		whiteNikeShoe.print();
	}

	private static void writeShoe(Serializable shoe) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("shoe.ser")));
		oos.writeObject(shoe);
		oos.close();
	}

	private static Object readShoe() throws IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("shoe.ser")));
		Object obj = ois.readObject();
		return obj;
	}
}
