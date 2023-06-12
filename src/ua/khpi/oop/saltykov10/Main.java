package ua.khpi.oop.saltykov10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//class CitizenNameComparator implements Comparator<Citizen>
//{
//	public int compare(Citizen a, Citizen b) {
//		return a.getName().compareTo(b.getName());
//	}
//}
//
//class CitizenBirthDateComparator implements Comparator<Citizen>
//{
//	public int compare(Citizen a, Citizen b) {
//		return a.getBirthDate().compareTo(b.getBirthDate());
//	}
//}
//
//class CitizenCrimerecordComparator implements Comparator<Citizen>
//{
//	public int compare(Citizen a, Citizen b) {
//		if ((a.getCrimerecord().length == 0) && (b.getCrimerecord().length == 0)) return 0;
//		if (a.getCrimerecord().length == 0) return -1;
//		if (b.getCrimerecord().length == 0) return 1;
//		return a.getCrimerecord()[a.getCrimerecord().length - 1].compareTo(b.getCrimerecord()[b.getCrimerecord().length - 1]);
//	}
//}
//
//class CitizenLastinmateComparator implements Comparator<Citizen>
//{
//	public int compare(Citizen a, Citizen b) {
//		return a.getLastinmate().compareTo(b.getLastinmate());
//	}
//}
//
//class CitizenLastFreeComparator implements Comparator<Citizen>
//{
//	public int compare(Citizen a, Citizen b) {
//		return a.getLastFree().compareTo(b.getLastFree());
//	}
//}

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
//Date d1 = getDateFromString("12/11/1973");
//Date d2 = getDateFromString("09/11/1974");
//System.out.println(d1.compareTo(d2));
//Integer in1 = 2;


		Citizen c1 = new Citizen();
		c1.setBirthDate(getDateFromString("10/11/2002"));
		c1.setName("Alan");
		c1.setLastFree(getDateFromString("20/10/1998"));
		c1.setLastinmate(getDateFromString("12/12/1972"));
		Citizen c2 = new Citizen();
		c2.setBirthDate(getDateFromString("10/11/2002"));
		c2.setName("Vasya");
		c2.setLastFree(getDateFromString("20/13/1998"));
		c2.setLastinmate(getDateFromString("12/21/1972"));
		Date[] crimerecord1 = { getDateFromString("25/11/2009"), getDateFromString("24/12/2009") };
		Date[] crimerecord2 = { getDateFromString("25/11/2019"), getDateFromString("24/12/2239") };
		c1.setCrimerecord(crimerecord1);
		c2.setCrimerecord(crimerecord2);
		Citizen c3 = new Citizen();
		c3.setBirthDate(getDateFromString("10/11/2000"));
		c3.setName("Mark");
		c3.setLastFree(getDateFromString("20/10/2018"));
		c3.setLastinmate(getDateFromString("12/12/2020"));
		Date[] crimerecord3 = {getDateFromString("25/11/2010"), getDateFromString("01/12/2005")};
		c3.setCrimerecord(crimerecord3);
		CitizenNameComparator cnc = new CitizenNameComparator();
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		System.out.println(cnc.compare(c1, c2));
		CustomLinkedList<Citizen> container = new CustomLinkedList<>();
		container.insert(c1);
		container.insert(c2);
		container.insert(c1);
		container.insert(c3);
		container.insert(c2);
		
		System.out.println(container.toString());
		System.out.println("---------NAME-------------");
//		container.setHead(container.sortList(container.head, new CitizenNameComparator()));
		CustomLinkedList<Citizen> container2 = new CustomLinkedList<>();
		container2.head = container.sortList(container.head, new CitizenNameComparator()); 
		System.out.println(container2.toString());
		System.out.println("---------INMATEDATE-------------");
		container2.head = container.sortList(container.head, new CitizenLastFreeComparator()); 
		System.out.println(container2.toString());
		System.out.println("---------BIRTHDATE-------------");
		container2.head = container.sortList(container.head, new CitizenBirthDateComparator()); 	
		System.out.println(container2.toString());

		
//		container.deleteAtPosition(2);
//		System.out.println("-----------------------------------");
//		System.out.println(container.toString());
//		Serializator<CustomLinkedList<Citizen>> sr = new Serializator<>();
//		sr.Serelization(container, "/home/babaka/Desktop/test.txt");
//		container.clear();
//		System.out.println("--------------2--------------------");
//		System.out.println(container.toString());
//		System.out.println("--------------3--------------------");
//		container = sr.Deseriaization("/home/babaka/Desktop/test.txt");
//		System.out.println(container.toString());
//		XMLSaver<CustomLinkedList<Citizen>> xmls = new XMLSaver<>();
//		xmls.Encode(container, "/home/babaka/Desktop/test.xml");
//		container.clear();
//		System.out.println("--------------4--------------------");
//		System.out.println(container.toString());
//		System.out.println("--------------5--------------------");
//		container = xmls.Decode("/home/babaka/Desktop/test.xml");
//		System.out.println(container.toString());
	}
}
