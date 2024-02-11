package Workers;

import WorkerProgram.Gender;

public class Administrative extends Worker {
		
		private String worktype;

		public Administrative(String Id, String Firstname, String Lastname, String CellNum, String Mail, Gender Gender, double Wage, String worktype) {
			super(Id, Firstname, Lastname, CellNum, Mail, Gender, Wage);
			setworktype(worktype);
		}

		public String getWorking_type() {
			return worktype;
		}

		public void setworktype(String worktype) {
			
			this.worktype = worktype;
		}
		
		public double salary() {
			return getWage();
		
		}
		public boolean equals(Object other) {
			return(other instanceof Administrative)&&(super.equals(other));
		}
		


		public String toString() {
			return "Administrative Worker working type = " + worktype + super.toString();
		}
}



