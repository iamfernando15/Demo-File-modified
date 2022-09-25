package ui;

import java.util.Date;
import java.util.Scanner;

import dol.Student;
import misc.DateUtil;

public class StudentForm{
	Scanner scan;
	Student student;

	public StudentForm(Scanner scanner) {
		scan = scanner;
	}
	
	public StudentForm(Student s) {
		student = s;
	}

	

	public Student catchStudent() {
		Student s = new Student();
		
		System.out.println("Carnet: ");
		s.setCarnet(scan.next());
		
		Date inscriptiondate = DateUtil.catchValidDate(scan, "Fecha de inscripcion (dd/MM/yyyy): ");
		s.setInscriptionDate(inscriptiondate);
			
		return s;
	}
	
	public void showStudent() {
		System.out.printf("Carnet: %s\n", student.getCarnet());
		System.out.printf("Fecha de inscripcion: %s\n", DateUtil.dateToString(student.getInscriptionDate(), "dd/MM/yyyy"));
		
	}
}
