package ua.khpi.oop.saltykov13;

import java.sql.Date;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
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

		class RandomDate {
			private static int getMaxDayOfMonth(int year, int month) {
				Calendar calendar = new GregorianCalendar(year, month, 1);
				return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			}

			static public Date generate() {
				Random random = new Random();
				// Set a random year between 1970 and 2023
				int year = random.nextInt(54) + 1970;

				// Set a random month (0-11)
				int month = random.nextInt(12);

				// Set a random day (1-28/30/31) based on the selected month
				int day = random.nextInt(getMaxDayOfMonth(year, month)) + 1;

				// Set random hour, minute, and second
				int hour = random.nextInt(24);
				int minute = random.nextInt(60);
				int second = random.nextInt(60);
				// Return the Date object
				Calendar calendar = Calendar.getInstance();
				calendar.set(year, month, day);
				return new Date(calendar.getTime().getTime());
			}

		}
		class RandomCitizen {
			static private String names[] = {"Alice", "Bob", "Charlie", "Erika", "Emma", "Kate", "Oliver", "Sophia", "Akash", "Lily", "Noah", "Ava", "Benjamin", "Mia", "Jacob", "Olivia",
					"William", "Amelia", "James", "Harper", "Архипенко", "Ішкова", "Єрмаков", "Янковський"};
			static public Citizen generate() {
			Random random = new Random();
			Citizen retCitizen = new Citizen();
			retCitizen.setName(names[random.nextInt(0, names.length)]);
			retCitizen.setBirthDate(RandomDate.generate());
			retCitizen.setLastFree(RandomDate.generate());
			retCitizen.setLastinmate(RandomDate.generate());
//			retCitizen.setCrimerecord();
			return retCitizen;	
			}
		}
		class FindMaxInThread<E> implements Runnable {
			CustomLinkedList<E> linkedlist;
			Comparator<E> comperator;
			public FindMaxInThread(CustomLinkedList<E> linkedlist, Comparator<E> comperator) {
				super();
				this.linkedlist = linkedlist;
				this.comperator = comperator;
			}
			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				try {
			System.out.println(thread.getName() + " in progress...");
			E result = linkedlist.findMax(linkedlist, comperator);
			System.out.println(result);
				} catch (InterruptedException e) {
					System.out.println(thread.getName() + " has benn Interrupted...");
					e.printStackTrace();	
				}
				}
		}
		
		class FindMinInThread<E> implements Runnable {
			CustomLinkedList<E> linkedlist;
			Comparator<E> comperator;
			public FindMinInThread(CustomLinkedList<E> linkedlist, Comparator<E> comperator) {
				super();
				this.linkedlist = linkedlist;
				this.comperator = comperator;
			}
			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				try {
			System.out.println(thread.getName() + " in progress...");
			E result = linkedlist.findMin(linkedlist, comperator);
			System.out.println(result);
				} catch (InterruptedException e) {
					System.out.println(thread.getName() + " has benn Interrupted...");
					e.printStackTrace();	
				}
				}
		}
		
		// TODO Auto-generated method stub
		CustomLinkedList<Citizen> list = new CustomLinkedList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the timeout in seconds: ");
		int delay = sc.nextInt();
		sc.nextLine();
		delay *= 1000;
		System.out.println("Input the number of random Citizens in Array: ");
		int arraySize = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < arraySize; i++) {
			Citizen fillCitizen = RandomCitizen.generate();
			list.insert(fillCitizen);
		}
		
		list.printList();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(System.lineSeparator());
		Thread thread1 = new Thread (new FindMaxInThread<Citizen>(list, new CitizenBirthDateComparator()));
		Thread thread2 = new Thread (new FindMinInThread<Citizen>(list, new CitizenNameComparator()));
		thread1.start();
		thread2.start();
		Thread.sleep(delay);
		  if (thread1.isAlive()) {
              thread1.interrupt();
          }
          if (thread2.isAlive()) {
              thread2.interrupt();
          }
		System.out.println("-------------------");
		System.out.println(thread1.isAlive() + " " + thread2.isAlive());
		sc.close();
	}

}
