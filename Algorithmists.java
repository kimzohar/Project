package Workers;


import WorkerProgram.Gender;

public class Algorithmists extends Developer {

		double SBonus;

		public Algorithmists(String Id, String Firstname, String Lastname, String CellNum, String Mail, Gender Gender, double Wage,double Bonus,double SBonus) {
			super(Id, Firstname, Lastname, CellNum, Mail, Gender, Wage,Bonus);
			setSecendBonus(SBonus);
		}

		public double getSBonus() {
			return SBonus;
		}

		public void setSecendBonus(double secondBonus) {
			this.SBonus = secondBonus;
		}
		
		public double getFinalWage() {
			return (getWage() + getSBonus() + this.SBonus);
	}
		
		public String toString() {
			return super.toString() + "secendBonus: " + SBonus ;
		}

		
		
		
	}

		
		
