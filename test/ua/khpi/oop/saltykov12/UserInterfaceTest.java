package ua.khpi.oop.saltykov12;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {

	private final PrintStream originalSystemOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

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
	public void tearDown() {
		System.setOut(originalSystemOut);
	}

	@Test
	void test1() {
		CustomLinkedList<Citizen> linkedList = new CustomLinkedList<>();
		String expectedOutput = "Citizen name: Иван Ярмаков\n" + "Citizen Birthday: 10/12/00 \n"
				+ "#1 Crimerecord: 11/07/08\n" + "Last time inprisoned: 11/07/08\n" + "Last time set free: 11/07/08\n"
				+ "\n" + "Akash\n" + "Citizen name: Akash\n" + "Citizen Birthday: 10/12/00 \n"
				+ "#1 Crimerecord: 11/07/08\n" + "Last time inprisoned: 11/07/08\n" + "Last time set free: 11/07/08\n"
				+ "\n" + "Total amout of citizens fit : 2";
		UserInterface UI = new UserInterface();
		Date fitDate = getDateFromString("10/12/2000");
		Date dontFitDate = getDateFromString("11/07/2008");
		Citizen c1 = new Citizen();
		c1.setBirthDate(fitDate);
		c1.setCrimerecord(null);
		c1.setLastFree(dontFitDate);
		c1.setLastinmate(dontFitDate);
		c1.setName("Иван Ярмаков");
		Citizen c2 = new Citizen();
		c2.setBirthDate(fitDate);
		c2.setCrimerecord(null);
		c2.setLastFree(dontFitDate);
		c2.setLastinmate(dontFitDate);
		c2.setName("Вася Пупкин");
		Citizen c3 = new Citizen();
		c3.setBirthDate(dontFitDate);
		c3.setCrimerecord(null);
		c3.setLastFree(dontFitDate);
		c3.setLastinmate(dontFitDate);
		c3.setName("Akash1");
		Citizen c4 = new Citizen();
		c4.setBirthDate(fitDate);
		c4.setCrimerecord(null);
		c4.setLastFree(dontFitDate);
		c4.setLastinmate(dontFitDate);
		c4.setName("Akash");
		Citizen c5 = new Citizen();
		c5.setBirthDate(fitDate);
		c5.setCrimerecord(null);
		c5.setLastFree(dontFitDate);
		c5.setLastinmate(dontFitDate);
		c5.setName("Bla Akash");
		linkedList.insert(c1);
		linkedList.insert(c2);
		linkedList.insert(c3);
		linkedList.insert(c4);
		linkedList.insert(c5);
		UI.citizenFinder(linkedList);
		System.setOut(originalSystemOut);
		assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
	}

}
