package ua.khpi.oop.saltykov14;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Citizen implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Name;
	private Date BirthDate;
	private Date[] Crimerecord;
	private Date Lastinmate;
	private Date LastFree;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/YY");

	public void setName(String name) {
		this.Name = name;
	}

	public String getName() {
		return this.Name;
	}

	public void setBirthDate(Date BirthDate) {
		this.BirthDate = BirthDate;
	}

	public Date getBirthDate() {
		return this.BirthDate;
	}

	public void setCrimerecord(Date[] Crimerecord) {
		if (Crimerecord == null) return;
		this.Crimerecord = Crimerecord;
	}

	public Date[] getCrimerecord() {
		return this.Crimerecord;
	}

	public void setLastinmate(Date Lastinmate) {
		this.Lastinmate = Lastinmate;
		if (this.Crimerecord == null)
		{
		Date[] crimerecord = {Lastinmate};
		this.Crimerecord = crimerecord;	
		}
	}

	public Date getLastinmate() {
		return this.Lastinmate;
	}

	public void setLastFree(Date LastFree) {
		this.LastFree = LastFree;
	}

	public Date getLastFree() {
		return this.LastFree;
	}

	public String toString() {
		String crimerecord = "";
		if (this.Crimerecord == null)
			crimerecord = crimerecord.concat(System.lineSeparator() + "#1 Crimerecord: " + SDF.format(this.Lastinmate));
		else {
			for (int i = 0; i < this.Crimerecord.length; i++) {
				crimerecord = crimerecord.concat(System.lineSeparator());
				crimerecord = crimerecord.concat((i + 1) + "# Crimerecord: ");
				crimerecord = crimerecord.concat(SDF.format(this.Crimerecord[i]));
				crimerecord = crimerecord.concat(" ");
			}
		}
		return "Citizen name: " + Name + System.lineSeparator() + "Citizen Birthday: " + SDF.format(this.BirthDate)
				+ " " + crimerecord + System.lineSeparator() + "Last time inprisoned: " + SDF.format(this.Lastinmate)
				+ System.lineSeparator() + "Last time set free: " + SDF.format(this.LastFree) + System.lineSeparator();
	}
}
