package ua.khpi.oop.saltykov11;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestUserInterface {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	public static String lineSeparator = System.lineSeparator();

	private static final Date getDateFromString(String spec) {
		try {
			return SDF.parse(spec);
		} catch (ParseException dfe) {
			System.out.println("Wrong date!");
		}
		return null;
	}

	@Test
	void test1() {
		Citizen expectedResult = new Citizen();
		expectedResult.setName("Alex");
		expectedResult.setBirthDate(getDateFromString("25/11/2009"));
		expectedResult.setLastFree(getDateFromString("11/07/2020"));
		expectedResult.setLastinmate(getDateFromString("10/12/2010"));
		expectedResult.setCrimerecord(new Date[] { getDateFromString("10/12/2010") });

		UserInterface UI = new UserInterface();
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		String input = lineSeparator + "Alex" + lineSeparator + "25/11/2009" + lineSeparator + "10/12/2010"
				+ lineSeparator + "11/07/2020" + lineSeparator + "1" + lineSeparator + "10/12/2010" + lineSeparator;
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		Citizen actualResult = UI.Citizenasker(sc);
		// optionally, reset System.in to its original
		System.setIn(sysInBackup);
		assertEquals(expectedResult, actualResult);
	}

}
