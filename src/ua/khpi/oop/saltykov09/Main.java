package ua.khpi.oop.saltykov09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	private static final Date getDateFromString(String spec) {
		try {
			return SDF.parse(spec);
		} catch (ParseException dfe) {
			System.out.println("Wrong date!");
		}
		return null;
	}

	public static void main(String[] args) {

//		System.out.println(container.toString());
//      LIKEDLIST INTEGER TEST
//		CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
//		list.insert(1);
//		list.insert(2);
//		list.insert(3);
//		list.insert(4);
//		list.insert(5);
//		list.insert(6);
//		list.insert(7);
//		list.insert(8);
//		list.printList(list);
//		list.deleteAtPosition(0);
//		list.printList(list);
//		list.deleteAtPosition(2);
//		list.printList(list);
//		list.deleteAtPosition(10);
//		list.printList(list);
//		list.insertAtPosition(1, 11);
//		list.printList(list);
//		System.out.println(list.size());
//		Object[] Array1 = list.toArray();
//		list.printList(list);
//		System.out.println(Arrays.toString(Array1));
//		System.out.println(list.isExist(list, 11));
//		list.printList(list);
//		for (Object i : list) {
//			System.out.println((Integer) i);
//		}
//		System.out.println("--------------2--------------------");
//		System.out.println(list.toString());
//		System.out.println("--------------3--------------------");

		Citizen c1 = new Citizen();
		c1.setBirthDate(getDateFromString("10/11/2002"));
		c1.setName("Петя");
		c1.setLastFree(getDateFromString("20/13/1998"));
		c1.setLastinmate(getDateFromString("12/21/1972"));
		Citizen c2 = new Citizen();
		c2.setBirthDate(getDateFromString("10/11/2002"));
		c2.setName("Vasya");
		c2.setLastFree(getDateFromString("20/13/1998"));
		c2.setLastinmate(getDateFromString("12/21/1972"));
		Date[] crimerecord1 = { getDateFromString("25/11/2009"), getDateFromString("24/12/2009") };
		Date[] crimerecord2 = { getDateFromString("25/11/2019"), getDateFromString("24/12/2239") };
		c1.setCrimerecord(crimerecord1);
		c2.setCrimerecord(crimerecord2);
		System.out.println(c1.toString());
		CustomLinkedList<Citizen> container = new CustomLinkedList<>();
		container.insert(c1);
		container.insert(c2);
		container.insert(c1);
		System.out.println(container.toString());
		container.deleteAtPosition(2);
		System.out.println("-----------------------------------");
		System.out.println(container.toString());
		Serializator<CustomLinkedList<Citizen>> sr = new Serializator<>();
		sr.Serelization(container, "/home/babaka/Desktop/test.txt");
		container.clear();
		System.out.println("--------------2--------------------");
		System.out.println(container.toString());
		System.out.println("--------------3--------------------");
		container = sr.Deseriaization("/home/babaka/Desktop/test.txt");
		System.out.println(container.toString());
		XMLSaver<CustomLinkedList<Citizen>> xmls = new XMLSaver<>();
		xmls.Encode(container, "/home/babaka/Desktop/test.xml");
		container.clear();
		System.out.println("--------------4--------------------");
		System.out.println(container.toString());
		System.out.println("--------------5--------------------");
		container = xmls.Decode("/home/babaka/Desktop/test.xml");
		System.out.println(container.toString());
		System.out.println("--------------5--------------------");
		container.printList(container);
		System.out.println(container.toArray()[0]);
		Node<Citizen> n1 = new Node<>();
		n1.data = c1;
		Node<Citizen> n2 = new Node<>();
		n2.data = c2;
		Node<Citizen> n3 = new Node<>();
		n3.data = c1;
		n2.next = n2;
		n3.next = n2;
		n1.next = n2;
		Node<String> n4 = new Node<>();
		Node<String> n5 = new Node<>();
		System.out.println(n3.equals(n1));
		n1.next = n1;
		n3.next = n3;
		System.out.println(n1.equals(n3));
	}
}
