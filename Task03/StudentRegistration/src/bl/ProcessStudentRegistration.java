package bl;

import bean.StudentRegistration;
import db.InMemory;

public class ProcessStudentRegistration {
	
	public String processStudentRegistration(StudentRegistration studentRegistrationReq) {
		
		String resp = null;
		
		resp = validateRequest(studentRegistrationReq);
		
		if("ERROR".equalsIgnoreCase(resp) || "STUDENT REGISTERED ALREADY".equalsIgnoreCase(resp)) {
			return resp;
		}
		
		resp = registerStudent(studentRegistrationReq);

		return resp;
	}
	
	private String registerStudent(StudentRegistration studentRegistrationReq) {
		String resp = "STUDENT REGISTERED SUCCESSFULLY";
		InMemory.getStudentRegistrationDb().add(studentRegistrationReq);
		return resp;
	}
	
	
	private String validateRequest(StudentRegistration studentRegistrationReq) {

		String resp = null;

		resp = isStudentRegisteredAlready(studentRegistrationReq) ? "STUDENT REGISTERED ALREADY" :"OK";
		
		if("STUDENT REGISTERED ALREADY".equalsIgnoreCase(resp)) {
			return resp;
		}

		resp = isValidPersonalIdentificationNumber(studentRegistrationReq) ? "OK" :"ERROR";
		
		return resp;
	}
	
	private boolean isStudentRegisteredAlready(StudentRegistration studentRegistrationReq)
	{
		for(StudentRegistration sr : InMemory.getStudentRegistrationDb()) {
			if(sr.getPersonalIdentificationCode().equalsIgnoreCase(studentRegistrationReq.getPersonalIdentificationCode())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidPersonalIdentificationNumber(StudentRegistration studentRegistrationReq)
	{
		int checksum = 0;
		String regNim = studentRegistrationReq.getPersonalIdentificationCode();
		for(int i=0;i<studentRegistrationReq.getPersonalIdentificationCode().length();i++) {
			if(i==0) {
				checksum = 1* Character.getNumericValue(regNim.charAt(i));
			}else if(i==1) {
				checksum += 2* Character.getNumericValue(regNim.charAt(i));
			}else if(i==2) {
				checksum += 3* Character.getNumericValue(regNim.charAt(i));
			}else if(i==3) {
				checksum += 4* Character.getNumericValue(regNim.charAt(i));
			}else if(i==4) {
				checksum += 5* Character.getNumericValue(regNim.charAt(i));
			}else if(i==5) {
				checksum += 6* Character.getNumericValue(regNim.charAt(i));
			}else if(i==6) {
				checksum += 7* Character.getNumericValue(regNim.charAt(i));
			}else if(i==7) {
				checksum += 8* Character.getNumericValue(regNim.charAt(i));
			}else if(i==8) {
				checksum += 9* Character.getNumericValue(regNim.charAt(i));
			}else if(i==9) {
				checksum += 1* Character.getNumericValue(regNim.charAt(i));
			}
		}
		checksum = checksum % 11;
		
		if(checksum != 10) {
			if(checksum == Character.getNumericValue(regNim.charAt(regNim.length()-1))){
				return true;
			}
		}
		else if(checksum == 10) {
			return secondFallBack(regNim);
		}
		
		return false;
	}

	private boolean secondFallBack(String studentRegistrationReq)
	{
		int checksum = 0;
		String regNim = studentRegistrationReq;
		for(int i=0;i<studentRegistrationReq.length();i++) {
			if(i==0) {
				checksum = 3* Character.getNumericValue(regNim.charAt(i));
			}else if(i==1) {
				checksum += 4* Character.getNumericValue(regNim.charAt(i));
			}else if(i==2) {
				checksum += 5* Character.getNumericValue(regNim.charAt(i));
			}else if(i==3) {
				checksum += 6* Character.getNumericValue(regNim.charAt(i));
			}else if(i==4) {
				checksum += 7* Character.getNumericValue(regNim.charAt(i));
			}else if(i==5) {
				checksum += 8* Character.getNumericValue(regNim.charAt(i));
			}else if(i==6) {
				checksum += 9* Character.getNumericValue(regNim.charAt(i));
			}else if(i==7) {
				checksum += 1* Character.getNumericValue(regNim.charAt(i));
			}else if(i==8) {
				checksum += 2* Character.getNumericValue(regNim.charAt(i));
			}else if(i==9) {
				checksum += 3* Character.getNumericValue(regNim.charAt(i));
			}
		}
		checksum = checksum % 11;
		
		if(checksum != 10) {
			if(checksum == Character.getNumericValue(regNim.charAt(regNim.length()-1))){
				return true;
			}
		}
		else if(checksum == 10) {
			checksum =0;
			if(checksum == Character.getNumericValue(regNim.charAt(regNim.length()-1))){
				return true;
			}
		}
		
		return false;
	}

}
