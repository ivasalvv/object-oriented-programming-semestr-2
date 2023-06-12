package ua.khpi.oop.saltykov11;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
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
		this.Crimerecord = Crimerecord;
	}

	public Date[] getCrimerecord() {
		return this.Crimerecord;
	}

	public void setLastinmate(Date Lastinmate) {
		this.Lastinmate = Lastinmate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Crimerecord);
		result = prime * result + Objects.hash(BirthDate, LastFree, Lastinmate, Name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (this.Name.compareTo(other.Name) != 0)
			return false;
		if (this.BirthDate.compareTo(other.BirthDate) != 0)
			return false;
		if (this.Lastinmate.compareTo(other.Lastinmate) != 0)
			return false;
		if (this.LastFree.compareTo(other.LastFree) != 0)
			return false;
		if (this.Crimerecord.length != other.Crimerecord.length)
			return false;
		for (int i = 0; i < this.Crimerecord.length; i++) {
			if (this.Crimerecord[i].compareTo(other.Crimerecord[i]) != 0)
				return false;
		}
		return true;
	}
}
