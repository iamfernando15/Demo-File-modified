package bll;

import java.util.Scanner;

import dal.PersonDal;
import dal.StudentDal;
import ui.PersonForm;
import ui.StudentForm;

public class Application {

	private Scanner scan;
	public Application() {
		 scan = new Scanner(System.in);
	}
	public void displayOptions() {
		System.out.println("Gestionar personas");
		System.out.println("1. Agregar");
		System.out.println("2. Mostrar");
		System.out.println("3. Volver");
		
	}

	public void show() {
		short option = 0;
		
		do {
			System.out.println();
			displayOptions();
			System.out.println();
			option = scan.nextShort();
			switch (option) {
				case 1:
					save();
					break;
				case 2:
					open();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Opción no válida.");
					break;
			}
		}while(option!=3);
		
	}
	public void save() {
		PersonForm pf = new PersonForm(scan);
		PersonDal pd = new PersonDal();
		pd.setPerson(pf.catchPerson());
		
		StudentForm sf = new StudentForm(scan);
		StudentDal sd = new StudentDal();
		sd.setStudent(sf.catchStudent());
		
		System.out.println("Por favor indica la ruta para guardar el archivo: ");
		String filePath = scan.next();
		System.out.println("Por favor indica el nombre del archivo: ");
		String fileName = scan.next();
		
		pd.setFilePath(filePath);
		pd.setFileName(fileName);
		pd.save();
		
		sd.setFilePath(filePath);
		sd.setFileName(fileName);
		sd.save();
	}
	
	public void open() {
	
			
		System.out.println("Por favor indica la ruta del archivo a abrir");
		String filePath = scan.next();
		PersonDal pd = new PersonDal();
		StudentDal sd = new StudentDal();
		pd.setFilePath(filePath);
		sd.setFilePath(filePath);
		PersonForm pf = new PersonForm(pd.open());
		StudentForm sf = new StudentForm(sd.open());
		pf.showPerson();
		sf.showStudent();
		
		
		
		
		
	}
}
