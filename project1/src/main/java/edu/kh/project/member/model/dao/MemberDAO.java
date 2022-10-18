package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.main.model.dao.MainDAO;
import edu.kh.project.member.model.vo.member.Member;


/** 회원 전용 기능 DAO
 * @author BDH
 *
 */
public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO() {
		
		try {
			
			prop = new Properties();
			 
            String filePath 
            	= MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
		
            prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param conn
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public Member login(Connection conn, Member member) throws Exception {
		
	
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,member.getMemberEmail());
			pstmt.setString(2,member.getMemberPW());
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberEmail(rs.getString(2));
				loginMember.setMemberNickname(rs.getString(3));
				loginMember.setMemberTel(rs.getString(4));
				loginMember.setMemberAddress(rs.getString(5));
				loginMember.setProfileImage(rs.getString(6));
				loginMember.setAutohrity(rs.getInt(7));
				loginMember.setEnrollDate(rs.getString(8));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}

}