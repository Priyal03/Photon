package core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to demonstrate How ClassLoader works in Java, in particular
 * about visibility principle of ClassLoader.
 *
 * from internet
 */

public class ClassLoader {

	public static void main(String args[]) {
		try {
			
			isOddOrEven(7);
			// printing ClassLoader of this class
			System.out.println("F ClassLoaderTest.getClass().getClassLoader() : " + ClassLoader.class.getClassLoader());

			// trying to explicitly load this class again using Extension class loader
			Class.forName("test.ClassLoaderTest", true, ClassLoader.class.getClassLoader().getParent());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void isOddOrEven(int number) {
		if ((number & 1) == 0) {
			System.out.println("Using bitwise operator: " + number + " is Even number");
		} else {
			System.out.println("Using bitwise operator: " + number + " is Odd number");
		}
	}

}

//ClassLoader in Java is a powerful concept and used at many places. One of the popular example of ClassLoader is AppletClassLoader which is used to load class by Applet, since Applets are mostly loaded from internet rather than a local file system.
//
//By using separate ClassLoader you can also load the same class from multiple sources and they will be treated as different class in JVM. J2EE uses multiple class loaders to load class from different location like classes from WAR file will be loaded by Web-app ClassLoader while classes bundled in EJB-JAR is loaded by another class loader. 
//
//Some web server also supports hot deploy functionality which is implemented using ClassLoader. You can also use ClassLoader to load classes from database or any other persistent store.
