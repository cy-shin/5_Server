package edu.kh.jsp.student.model.vo;

public class Student {
	private String studentNo; // 학번
	
	private String studentName; // 이름
	
	private String studentAddress; // 주소
	
	private String departmentName; // 학과명
	
	
	// 기본 생성자
	public Student() {}
	
	
	// 매개변수 생성자
	public Student(String studentNo, String studentName, String studentAddress, String departmentName) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.departmentName = departmentName;
	}

	
	// getter, setter
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getStudentNo() {
		return studentNo;
	}
	
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "StudentVO [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", departmentName=" + departmentName + "]";
	}
	
	
}
