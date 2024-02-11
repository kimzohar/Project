package Workers;

import java.io.Serializable;
import WorkerProgram.Gender;

public abstract class Worker implements Comparable<Worker> ,Serializable{
	
	
	private static final long serialVersionUID = 1L;
	public final static double MIN_WAGE=5500.0;
	
	private String Id;
	private String Firstname;
	private String Lastname;
	private String CellNum;
	private String Mail;
	private Gender Gender; 
	private double Wage;
	
	
	public Worker (String Id, String Firstname, String Lastname, String CellNum, String Mail, Gender Gender, double Wage) {
		setId(Id);
		setFirstName(Firstname);
		setLastName(Lastname);
		setCellNum(CellNum);
		setMail(Mail);
		setGender(Gender);
		setwage(Wage);
	}

	public Worker (String Id, String Firstname, String Lastname, String CellNum, Gender Gender ,double Wage) {
		setId(Id);
		setFirstName(Firstname);
		setLastName(Lastname);
		setCellNum(CellNum);
		setMail("No Mail");
		setGender(Gender);
		setwage(MIN_WAGE);
	}

	public Worker (String Id, String Firstname, String Lastname, String CellNum, String Mail, Gender gender) {
		setId(Id);
		setFirstName(Firstname);
		setLastName(Lastname);
		setCellNum(CellNum);
		setMail(Mail);
		setGender(gender);
		setwage(Wage);
	}
	
	
	public void setId(String id) {
		if (id.length() == 9 || !(id.matches("[0-9]+")))
			this.Id = id;
	}

	public void setFirstName(String firstName) {
		if(!firstName.equals(""))
			this.Firstname = firstName;
	}

	public void setLastName(String lastName) {
		if(!lastName.equals(""))
			this.Lastname = lastName;
	}

	public void setCellNum(String CellNum) {
		if(!CellNum.equals("") || !(CellNum.matches("[0-9]+")))
			this.CellNum = CellNum;
	}

	
	public void setMail(String mail) {
		if(!mail.equals(mail))
			this.Mail = mail;
	}

	public void setGender(Gender gender) {
		this.Gender = gender;
	}

	public void setwage(double wage) {
		if (wage >= MIN_WAGE)
			this.Wage = wage;
		else
			this.Wage = MIN_WAGE;
	}

	public double getWage() {
		return Wage;
	}


	public String getId() {
		return Id;
	}

	public String getFistname() {
		return Firstname;
	}
		
	public String getLastname() {
		return Lastname;
	}

	public String getCellNum() {
		return CellNum;
	}

	public String getMail() {
		return Mail;
	}

	public Gender GetGender() {
		return (Gender) Gender;
	}

	@Override
	public String toString() {
		return  ", id = " + Id + ", FirstName = " + Firstname + ", LastName = " + Lastname + ", PhoneNum = " + CellNum
				+ ", Mail = " + Mail + ", Gender = " + Gender + ", Wage = " + Wage ;
	}
	
	
	@Override
	public int compareTo(Worker other) {
		String FullName = this.getLastname() + " " + this.getFistname();
		String FullNameother = other.getLastname() + " " + other.getFistname();
		return FullName.compareToIgnoreCase(FullNameother);
	}
	
	@Override
	public boolean equals(Object i) {
		return ((i instanceof Worker)&&((this.Id == ((Worker)i).getId())));
	}
	
}

