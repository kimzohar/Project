package Workers;

import WorkerProgram.Department;
import WorkerProgram.Gender;

public class Developer extends Worker {
	
	public Department department;
	
	private double Bonus;
	 	
	public Developer(String Id, String Firstname, String Lastname, String CellNum, String Mail, Gender Gender, double Wage,double Bonus) {
		super(Id, Firstname, Lastname, CellNum, Mail, Gender, Wage);
		setBonus(Bonus);
		

	}

	public double getBonus() {
		return Bonus;
	}

	public void setBonus(double bonus) {
		if (bonus > 0)
			this.Bonus = Bonus;
	}
	
	public Department getdepartment() {
		return this.department;
	}

	public void setDepe(Department department) {
		this.department = department;
	}

	public double getFinalWage() {
		return (getWage() + this.Bonus);
	}

	public String toString() {
		return "Department: Developer" + super.toString() + "Bonus = " + this.Bonus + "Final Wage = " + getFinalWage() ;
	}
}

