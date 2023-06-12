package ua.khpi.oop.saltykov15;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSaver<E> {
	public boolean Encode(E container, String f_pathname) {
		File file = new File(f_pathname);
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
			encoder.writeObject(container);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Some filepathname troubles.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public E Decode(String f_pathname) {
		File file = new File(f_pathname);
		Object object = null;
		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))) {
			object = decoder.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Some filepathname troubles.");
			e.printStackTrace();
			return null;
		}
		return (E) object;
	}
}
