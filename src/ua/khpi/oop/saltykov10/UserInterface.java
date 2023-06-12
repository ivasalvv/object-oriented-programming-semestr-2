package ua.khpi.oop.saltykov10;

import java.util.Scanner;

import java.io.File;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

class CitizenNameComparator implements Comparator<Citizen> {
	public int compare(Citizen a, Citizen b) {
		return a.getName().compareTo(b.getName());
	}
}

class CitizenBirthDateComparator implements Comparator<Citizen> {
	public int compare(Citizen a, Citizen b) {
		return a.getBirthDate().compareTo(b.getBirthDate());
	}
}

class CitizenCrimerecordComparator implements Comparator<Citizen> {
	public int compare(Citizen a, Citizen b) {
		if ((a.getCrimerecord().length == 0) && (b.getCrimerecord().length == 0))
			return 0;
		if (a.getCrimerecord().length == 0)
			return -1;
		if (b.getCrimerecord().length == 0)
			return 1;
		return a.getCrimerecord()[a.getCrimerecord().length - 1]
				.compareTo(b.getCrimerecord()[b.getCrimerecord().length - 1]);
	}
}

class CitizenLastinmateComparator implements Comparator<Citizen> {
	public int compare(Citizen a, Citizen b) {
		return a.getLastinmate().compareTo(b.getLastinmate());
	}
}

class CitizenLastFreeComparator implements Comparator<Citizen> {
	public int compare(Citizen a, Citizen b) {
		return a.getLastFree().compareTo(b.getLastFree());
	}
}

public class UserInterface {
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	private static final Date getDateFromString(String spec) {
		try {
			return SDF.parse(spec);
		} catch (ParseException dfe) {
			System.out.println("Wrong date!");
		}
		return null;
	}
	
	
	public static String lineSeparator = System.lineSeparator();
	
	static String menu = "Input option to execute:" + lineSeparator +
	"0 - Exit" + lineSeparator + "1 - Print current container" + lineSeparator
	+ "2 - Add data to Container" + lineSeparator + "3 - Remove data form the Container"
	+ lineSeparator + "4 - Save Container\\Decode Container" + lineSeparator + "5 - Sort Container" +
	lineSeparator + "6 - Clear Container" + lineSeparator + "Enter option to do: ";
	
	public void start () {
		
		Scanner sc = new Scanner(System.in);
		CustomLinkedList<Citizen> linkedList = new CustomLinkedList<>();
		int result;
		for(;;) {
		System.out.println(menu);
		result = sc.nextInt();
		if (result == 0) break;
		else if (result == 1) {
		linkedList.printList();
		}
		else if (result == 2) {
			DataAdder(linkedList, sc);
		}
		else if (result == 3) {
		System.out.println("Enter an index to remove: ");
		result = sc.nextInt();
		linkedList.deleteAtPosition(result);
		}
		else if (result == 5) {
		DataSorter(linkedList, sc);
		}
		else if (result == 4) {
		DataSaverOrDecode(linkedList, sc);
		}
		else if (result == 6)
		{
			linkedList.clear();
			System.out.println("List has been cleard!" + lineSeparator);
		}
		}
		sc.close();
	}
	public Citizen Citizenasker(Scanner sc)
	{
		Citizen cresult = new Citizen();
		String datagetter = "";
		while (datagetter == "")
		{
			System.out.println("Enter Citizen's name:");
			datagetter = sc.nextLine();
		}
		cresult.setName(datagetter);
		System.out.println("Enter citizen's birthdate: ");
		Date datetoget = Dateasker(sc);
		cresult.setBirthDate(datetoget);
		System.out.println("Enter citizen's last inprison date: ");
		datetoget = Dateasker(sc);
		cresult.setLastinmate(datetoget);
		System.out.println("Enter citizen's last free date: ");
		datetoget = Dateasker(sc);
		cresult.setLastFree(datetoget);
		int number = -1;
		while (number < 0) {
			System.out.println("Enter how many crimerecords does Citizen have: ");
			number = sc.nextInt();
			System.out.println(lineSeparator);
		}
		if (number == 0) cresult.setCrimerecord(null);
		else {
			Date[] datemas = new Date[number]; 
			for (int i = 0; i < number; i++)
			{
				System.out.println("Enter crimerecord # " + i + 1);
				datetoget = Dateasker(sc);
				datemas[i] = datetoget;
			}
			cresult.setCrimerecord(datemas);
		}
		return cresult;
	}
	
	public Date Dateasker(Scanner sc)
	{
		String date = "";
		int data = 0;
		while (data <= 0 || data > 31) {
		System.out.println("Enter day in dd format: ");
		data = sc.nextInt();
		}
		date = date.concat(Integer.toString(data) + "/");
		data = 0;
		while (data <= 0 || data > 12) {
			System.out.println("Enter mounth in MM format: ");
			data = sc.nextInt();
			}
		date = date.concat(Integer.toString(data) + "/");
		data = 0;
		while (data <= 1946 || data > 2030) {
			System.out.println("Enter year in yyyy format: ");
			data = sc.nextInt();
			}
		date = date.concat(Integer.toString(data));
		Date rdate = getDateFromString(date);
		return rdate;
	}
	
	public void DataAdder(CustomLinkedList<Citizen> linkedList, Scanner sc) {
		int answer;
		for (;;) {
		answer = -1;
		System.out.println("How do you wish to add data:" + lineSeparator +
		"0 - exit" + lineSeparator + "1 - at the end of list" + lineSeparator + "2 - at the index" + lineSeparator);
		answer = sc.nextInt();
		if(answer == 0) break;
		else if (answer == 1) {
		Citizen citizentoadd = Citizenasker(sc);
		linkedList.insert(citizentoadd);
		}
		else if (answer == 2) {
		System.out.println("Enter an index to add: ");
		answer = sc.nextInt();
		Citizen citizentoadd = Citizenasker(sc);
		linkedList.insertAtPosition(answer, citizentoadd);
		}
		else System.out.println("No such parameter! Try again!" + lineSeparator);
		}
	}
	
	public void DataSaverOrDecode (CustomLinkedList<Citizen> linkedList, Scanner sc)
	{
	String xmlpath = System.getProperty("user.dir") + File.separator + "lab10" + File.separator
	+ "saveddata.xml";
	String serpath = System.getProperty("user.dir") + File.separator + "lab10" + File.separator
	+ "saveddata.txt";	
	System.out.println("In witch way do you wish to save data:" + lineSeparator
	+ "0 - exit " + lineSeparator +  "1 - XML format" + lineSeparator + "2 - using serialization mechanism" + lineSeparator
	+ "3 - pull data from XML format" + lineSeparator + "4 - pull data using deserialization" + lineSeparator
	+ "Enter option: ");
	int answer;
	answer = sc.nextInt();
	if (answer == 0) return;
	else if (answer == 2){
	Serializator<CustomLinkedList<Citizen>> serializator = new Serializator<>();
	serializator.Serelization(linkedList, serpath);
	}
	else if (answer == 1){
	XMLSaver<CustomLinkedList<Citizen>> xmlsaver = new XMLSaver<>();
	xmlsaver.Encode(linkedList, xmlpath);
	}
	else if (answer == 3){
		File file = new File(xmlpath);
		if(file.exists()) {
			XMLSaver<CustomLinkedList<Citizen>> xmlsaver = new XMLSaver<>();
			linkedList.setHead(xmlsaver.Decode(xmlpath).head);
		} else {
		    System.out.println("File does not exist.");
		}
	}
	else if (answer == 4) {
		File file = new File(serpath);
		if(file.exists()) {
			Serializator<CustomLinkedList<Citizen>> serializator = new Serializator<>();
			linkedList.head = serializator.Deseriaization(serpath).head;
		} else {
		    System.out.println("File does not exist.");
		}
	}
	else {
	System.out.println("Wrong parameter!");
	}
	}
	
	public void DataSorter (CustomLinkedList<Citizen> linkedList, Scanner sc)
	{
		System.out.println("By witch field do you wish to sort data:" + lineSeparator
			+ "1 - Name" + lineSeparator + "2 - Birthdate" + lineSeparator + "3 - Last imation"
			+ lineSeparator + "4 - Last free" + lineSeparator + "Enter option:");
		int answer = sc.nextInt();
		if (answer == 1) {
		linkedList.setHead(linkedList.sortList(linkedList.head, new CitizenNameComparator()));
		}
		else if (answer == 2) {
		linkedList.setHead(linkedList.sortList(linkedList.head, new CitizenBirthDateComparator()));		
		}
		else if (answer == 3) {
		linkedList.setHead(linkedList.sortList(linkedList.head, new CitizenLastinmateComparator()));
		}
		else if (answer == 4) {
		linkedList.setHead(linkedList.sortList(linkedList.head, new CitizenLastFreeComparator()));
		}
		else {
			System.out.println("Wrong parameter!" + lineSeparator);
		}
	}
	public static void main(String[] args) {
		if ((args.length == 1 && args[0].equals("-auto") )) {
		System.out.println("Program is currently being executed in automatical mode" + lineSeparator);
		XMLSaver<CustomLinkedList<Citizen>> xmlsaver = new XMLSaver<>();
		String xmlpath = System.getProperty("user.dir") + File.separator + "lab10auto" + File.separator
		+ "saveddata.xml";
		CustomLinkedList<Citizen> Linkedlist = new CustomLinkedList<Citizen>();
		Linkedlist.head = xmlsaver.Decode(xmlpath).head;
		System.out.println(Linkedlist);
		System.out.println("Linked list will be sorted by name:");
		Linkedlist.setHead(Linkedlist.sortList(Linkedlist.head, new CitizenNameComparator()));
		System.out.print(Linkedlist);
		System.out.println("End of program...");
		}
		else {
		UserInterface UI = new UserInterface();
		UI.start();
		}
		}
	}

