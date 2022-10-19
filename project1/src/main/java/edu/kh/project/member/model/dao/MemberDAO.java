package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.member.model.vo.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();

			String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 Service
	 * @param conn
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public Member login(Connection conn, Member member) throws Exception {
		// 결과 저장용 변수 선언
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			
			rs = pstmt.executeQuery();
			
//			if(rs.next()) {
//				loginMember = new Member();
//			
//				int memberNo = rs.getInt("MEMBER_NO");
//				String memberEmail = rs.getString("MEMBER_EMAIL");
//				String memberNickname = rs.getString("MEMBER_NICKNAME");
//				String memberTel = rs.getString("MEMBER_TEL");
//				String memberAddress = rs.getString("MEMBER_ADDRESS");
//				String profileImage = rs.getString("PROFILE_IMG");
//				int authority = rs.getInt("AUTHORITY");
//				String enrollDate = rs.getString("ENROLL_DATE");
//			
//				loginMember.setMemberNo(memberNo);
//				loginMember.setMemberEmail(memberEmail);
//				loginMember.setMemberNickName(memberNickname);
//				loginMember.setMemberTel(memberTel);
//				loginMember.setMemberAddress(memberAddress);
//				loginMember.setProfileImage(profileImage);
//				loginMember.setAuthority(authority);
//				loginMember.setEnrollDate(enrollDate);
//			}
			
			if(rs.next()) {
			loginMember = new Member();
			
			loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
			loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			loginMember.setMemberNickName(rs.getString("MEMBER_NICKNAME"));
			loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
			loginMember.setMemberAddress(rs.getString("MEMBER_ADDRESS"));
			loginMember.setProfileImage(rs.getString("PROFILE_IMG"));
			loginMember.setAuthority(rs.getInt("AUTHORITY"));
			loginMember.setEnrollDate(rs.getString("ENROLL_DATE"));
		}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
	
	/** 회원가입
	 * @param conn
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickName());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
