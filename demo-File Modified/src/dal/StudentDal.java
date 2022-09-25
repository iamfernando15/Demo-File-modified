package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dol.Student;

public class StudentDal {
	private Student student;
	private String filePath;
	private String fileName;
	
	public StudentDal() {
		super();
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void save() {
		if(fileName.trim().length()==0) {
			fileName = student.getFirstName().trim() + student.getSurName().trim() + ".dat";
		}
		
		File file = new File(filePath + "\\" + fileName);

        ObjectOutputStream w;
		try {
			w = new ObjectOutputStream(new FileOutputStream(file));
	        w.writeObject(getStudent());
	        w.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public Student open() {
        try{
        	File file = new File(filePath);
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            return (Student)ois.readObject();
        }
        catch(FileNotFoundException e){
        	e.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
        	ex.printStackTrace();
        }
        return null;
	}	
}
