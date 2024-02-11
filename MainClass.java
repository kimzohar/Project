package WorkerProgram;
	import java.util.ArrayList;
	import java.util.Scanner;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;

	import Workers.*;
	import Staff.*;

	public class MainClass {

		private static HR data = null;
		static ArrayList<Worker>workerList= new ArrayList<Worker>();
		
		public static void main(String[] args) throws Exception {
			System.out.println("Welcome!");
			data = new HR (workerList);
			readfile();
			menu();
		}

		public static void menu() throws Exception{
			int choose = 0;
			try {
			System.out.println("\nPlease Choose an option from the menu(1-5 only)");
			System.out.println("1.Add New Worker");
			System.out.println("2.Worker Details");
			System.out.println("3.Remove Worker");
			System.out.println("4.Worker Report");
			System.out.println("5.Exit And Save");
			Scanner num = new Scanner(System.in);
			choose = num.nextInt();
			}catch (Exception e) {
				System.out.println("1-5 only. You can try again :) ");
				menu();
			}
			
			switch(choose) {
			case 1:
				AddNewWorker();
				menu();	
				break;
			case 2:
				Worker_Details();
				menu();	
				break;
			case 3:
				Deleting_an_employee();
				menu();	
				break;
			case 4:
				worker_report();
				menu();
				break;
			case 5:
				Exit();
				break;
			default:
				System.out.println("Enter only numbers between 1-5. Please try again  ");
				menu();		
				}
		}

		private static void AddNewWorker() throws Exception {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please input Worker's ID number");
			String ID =scan.next(); 
			while (ID.length()!= 9) {
				System.out.println("ID has only 9 digits , You can try again :) ");
				ID =scan.next();
			}

			
			System.out.println("Worker's First name? ");
			String FirstName =scan.next();
			while(FirstName.equals("")) {
				System.out.println("Worker's First name cannot be null. You can try again :)");
				FirstName=scan.nextLine();
			}
			System.out.println("Worker's Last name  ");
			String LastName= scan.next();
			while(LastName.equals("")) {
				System.out.println("Worker's First name cannot be null. You can try again :)");
				LastName=scan.nextLine();
			}
			
			System.out.println("Worker's Cell number?");
			Scanner input = new Scanner(System.in);
			String CellNum=input.next();
			while(CellNum.length()<7 && CellNum.length()>10 ) {
				System.out.println("Note - you can enter a cell phone number or a home phone number");
				CellNum=input.next();
			}
			
			System.out.println("Worker's email? ");
			String mail=scan.next();
			while(mail.equals("")) {
				System.out.println("Worker's email cannot be null. You can try again :)");
				mail=scan.next();
			}
			
			Gender gender=Gender.None;
			try {
			System.out.println("Worker's gender? ");
			System.out.println("1.Male");
			System.out.println("2.Female");
					
			int GenderChoose = scan.nextInt();
			gender = Gender.values()[GenderChoose];
			}catch(Exception e) {
				System.out.println("There are only 2 options : 1 or 2 ?");
			}
			double wage=0;
			try {
			System.out.println("Worker's Wage? ");
			wage=scan.nextDouble();
			}catch(Exception e) {
				System.out.println("Note - Wage can be a number only.");
			}
			
			

			int Dchoose =0;
			try {
				System.out.println("Please choose the correct department that the worker belong's to:");
				System.out.println("1.Administrativ ");
				System.out.println("2.Developer");
				System.out.println("3.Algorithmists");
				Dchoose = scan.nextInt();
			}catch (Exception e) {
				System.out.println("Wrong Input. 1-3 only.");
				menu();
			}
			
			switch(Dchoose) {
			case 1:
				System.out.println("Please Enter a working type");
				String working_type= scan.next();
				Worker i= new Administrative (ID, FirstName, LastName, CellNum, mail, gender , wage, working_type);
				try {
					data.AddWorker(i);	
				}catch(AddWorkerExp er) {
					System.out.println(er.getMessage());
					menu();
				}
				break;
			case 2:
				double bonus=0;
			try {
				System.out.println("Please enter Bonus: ");
				bonus=scan.nextDouble();
				Worker W1= new Developer (ID, FirstName,  LastName,  CellNum,  mail, gender , wage, bonus);
				data.AddWorker(W1);
			}catch(AddWorkerExp er) {
				System.out.println(er.getMessage());
				menu();
			}catch(Exception e) {
				System.out.println("Bonus can only be in numbers");
				menu();
			}
				break;	
			case 3:
				
				double secondbonus=0;
				System.out.println("Input Bonus amount: ");
				bonus =scan.nextDouble();
				System.out.println("Please input secend Bonus amount: ");
				secondbonus=scan.nextDouble();
				Worker W2= new Algorithmists (ID, FirstName, LastName, CellNum, mail, gender, wage, bonus, secondbonus);
				data.AddWorker(W2);	
				break;	
			default:
				System.out.println("Your choice doesn't exist");
				menu();
			}
			}	
				
		private static void Worker_Details() throws Exception {
			System.out.println("Please Enter the ID number");
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			System.out.println(data.findworker(id));
			menu();
			}
				
		private static void Deleting_an_employee() throws Exception {
			System.out.println("Please input ID Worker's: ");
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			data.removeworker(id);
			menu();				
			}
		
		private static void worker_report() {

			System.out.println(data.toString());
		}
		
		private static void Exit()throws IOException {
			try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Worker_file.dat"));
			out.writeObject(data);
			out.close();
			System.out.println("See you :)");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void readfile() throws IOException {
			try {
			ObjectInputStream in = new ObjectInputStream (new FileInputStream("Worker_file.dat"));
			data = (HR) in.readObject();
			in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}

	}


