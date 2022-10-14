package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

// static 필드/메서드 호출 시 클래스명 생략
import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class StudentService {
	
	private StudentDAO dao = new StudentDAO();
	Connection conn;

	//	alt + shift + j : 클래스/메서드 설명용 주석(HTML 작성법)
	
	/** 학생 전체 조회 서비스
	 * @return
	 * @throws Exception
	 */
	public List<Student> selectAll() throws Exception {
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectAll(conn);
		
		close(conn);
		
		return stdList;
	}
	
	
	public List<Student> selectDepartment(String inputDept) throws Exception {
		Connection conn = getConnection();
		
		List<Student> deptList = dao.selectDepartment(conn, inputDept);
		
		close(conn);
		
		return deptList;
	}
	
	public List<Student> selectName(String inputName) throws Exception {
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectName(conn, inputName);
		
		close(conn);
		
		return stdList;
	}
	
}
