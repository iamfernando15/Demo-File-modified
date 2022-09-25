package dol;

import java.util.Date;

import misc.DateUtil;

public class Student extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3228190356941892266L;
	private String Carnet;
	private Date inscriptionDate;
	
	public Student() {
	
	}
	public Student(String firstName, String middleName, String surName, String secondSurname, String gender,
			Date birthDate, String Carnet, Date inscriptionDate) {
		super(firstName, middleName, surName, secondSurname, gender, birthDate);
		this.Carnet= Carnet;
		this.inscriptionDate= inscriptionDate;
		
	}
	public String getCarnet() {
		return Carnet;
	}
	public void setCarnet(String carnet) {
		Carnet = carnet;
	}
	public Date getInscriptionDate() {
		return inscriptionDate;
	}
	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public int getAge() {
		return DateUtil.getAge(inscriptionDate);
	}
}
