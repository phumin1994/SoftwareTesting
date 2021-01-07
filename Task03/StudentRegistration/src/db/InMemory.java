package db;

import java.util.ArrayList;
import java.util.List;

import bean.StudentRegistration;

public class InMemory {

	public static List<StudentRegistration> studentRegistrationDb = new ArrayList<StudentRegistration>();

	public static List<StudentRegistration> getStudentRegistrationDb() {
		return studentRegistrationDb;
	}

	public static void setStudentRegistrationDb(List<StudentRegistration> studentRegistrationDb) {
		InMemory.studentRegistrationDb = studentRegistrationDb;
	}

}
