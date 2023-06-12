package ua.khpi.oop.saltykov13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCustomLinkedList {
	
	private final PrintStream originalSystemOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	class CitizenNameComparator implements Comparator<Citizen> {
		public int compare(Citizen a, Citizen b) {
			return a.getName().compareTo(b.getName());
		}
	}
	
	private static final Date getDateFromString(String spec) {
		try {
			return SDF.parse(spec);
		} catch (ParseException dfe) {
			System.out.println("Wrong date!");
		}
		return null;
	}
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown(){
		System.setOut(originalSystemOut);	
	}
	
	@Test
	void test1() throws InterruptedException {
		String expectedresult = "Max value's position is: 2";
		CustomLinkedList<Citizen> linkedList = new CustomLinkedList<>();
		Citizen c1 = new Citizen();
		c1.setBirthDate(getDateFromString("10/11/2003"));
		c1.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c1.setLastFree(getDateFromString("11/10/2004"));
		c1.setLastinmate(getDateFromString("11/10/2004"));
		c1.setName("Иван Ярмаков");
		Citizen c2 = new Citizen();
		c2.setBirthDate(getDateFromString("10/11/2003"));
		c2.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c2.setLastFree(getDateFromString("11/10/2004"));
		c2.setLastinmate(getDateFromString("11/10/2004"));
		c2.setName("Вася");
		Citizen c3 = new Citizen();
		c3.setBirthDate(getDateFromString("10/11/2003"));
		c3.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c3.setLastFree(getDateFromString("11/10/2004"));
		c3.setLastinmate(getDateFromString("11/10/2004"));
		c3.setName("Петя");
		Citizen c4 = new Citizen();
		c4.setBirthDate(getDateFromString("10/11/2003"));
		c4.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c4.setLastFree(getDateFromString("11/10/2004"));
		c4.setLastinmate(getDateFromString("11/10/2004"));
		c4.setName("Валера");
		linkedList.insert(c1);
		linkedList.insert(c2);
		linkedList.insert(c3);
		linkedList.insert(c4);
		Citizen result = linkedList.findMax(linkedList, new CitizenNameComparator());
		assertEquals(expectedresult, outputStreamCaptor.toString().trim());
	}
	@Test
	void test2() throws InterruptedException {
		String expectedresult = "Min value's position is: 3"; 
		CustomLinkedList<Citizen> linkedList = new CustomLinkedList<>();
		Citizen c1 = new Citizen();
		c1.setBirthDate(getDateFromString("10/11/2003"));
		c1.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c1.setLastFree(getDateFromString("11/10/2004"));
		c1.setLastinmate(getDateFromString("11/10/2004"));
		c1.setName("Иван Ярмаков");
		Citizen c2 = new Citizen();
		c2.setBirthDate(getDateFromString("10/11/2003"));
		c2.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c2.setLastFree(getDateFromString("11/10/2004"));
		c2.setLastinmate(getDateFromString("11/10/2004"));
		c2.setName("Вася");
		Citizen c3 = new Citizen();
		c3.setBirthDate(getDateFromString("10/11/2003"));
		c3.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c3.setLastFree(getDateFromString("11/10/2004"));
		c3.setLastinmate(getDateFromString("11/10/2004"));
		c3.setName("Петя");
		Citizen c4 = new Citizen();
		c4.setBirthDate(getDateFromString("10/11/2003"));
		c4.setCrimerecord(new Date[] {getDateFromString("11/10/2004")});
		c4.setLastFree(getDateFromString("11/10/2004"));
		c4.setLastinmate(getDateFromString("11/10/2004"));
		c4.setName("Валера");
		linkedList.insert(c1);
		linkedList.insert(c2);
		linkedList.insert(c3);
		linkedList.insert(c4);
		Citizen result = linkedList.findMin(linkedList, new CitizenNameComparator());
		assertEquals(expectedresult, outputStreamCaptor.toString().trim());
	}
}
