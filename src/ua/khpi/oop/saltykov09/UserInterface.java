package ua.khpi.oop.saltykov09;

import java.util.Comparator;

public class UserInterface {

	class CitizenNameComparator implements Comparator<Citizen>
	{
		public int compare(Citizen a, Citizen b) {
			return a.getName().compareTo(b.getName());
		}
	}

	class CitizenBirthDateComparator implements Comparator<Citizen>
	{
		public int compare(Citizen a, Citizen b) {
			return a.getBirthDate().compareTo(b.getBirthDate());
		}
	}

	class CitizenCrimerecordComparator implements Comparator<Citizen>
	{
		public int compare(Citizen a, Citizen b) {
			if ((a.getCrimerecord().length == 0) && (b.getCrimerecord().length == 0)) return 0;
			if (a.getCrimerecord().length == 0) return -1;
			if (b.getCrimerecord().length == 0) return 1;
			return a.getCrimerecord()[a.getCrimerecord().length - 1].compareTo(b.getCrimerecord()[b.getCrimerecord().length - 1]);
		}
	}

	class CitizenLastinmateComparator implements Comparator<Citizen>
	{
		public int compare(Citizen a, Citizen b) {
			return a.getLastinmate().compareTo(b.getLastinmate());
		}
	}

	class CitizenLastFreeComparator implements Comparator<Citizen>
	{
		public int compare(Citizen a, Citizen b) {
			return a.getLastFree().compareTo(b.getLastFree());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
