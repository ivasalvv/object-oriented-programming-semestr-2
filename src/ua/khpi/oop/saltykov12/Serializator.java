package ua.khpi.oop.saltykov12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator<E> {
	boolean Serelization(E container, String f_pathname) {
		boolean flag = false;
		File file = new File(f_pathname);
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			try {
				if (fos != null) {
					oos = new ObjectOutputStream(fos);
					oos.writeObject(container);
					flag = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public E Deseriaization(String f_pathname) {
		Object container = new Object();
		container = (E) container;
		File file = new File(f_pathname);
		FileInputStream fis;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			try {
				ois = new ObjectInputStream(fis);
				try {
					container = (E) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return (E) container;
	}
}