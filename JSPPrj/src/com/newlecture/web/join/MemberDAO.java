package com.corin.dogHotel.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
     private static MemberDAO instance = new MemberDAO();
 	 private MemberDAO(){}
 	 public static MemberDAO getInstance(){
 		return instance;
 	}
 	   
    //회원가입
 	//데이터베이스 insert 로직
 	public void insert(Member data){
 		String driver = "oracle.jdbc.driver.OracleDriver";
 		String url = "jdbc:oracle:thin:@localhost:49161:xe";
 		Connection conn = null;
 		PreparedStatement ppst = null;
 	    String SQL = "insert into customers(id, pwd, name, birthday, phone, address, nickname) values (?,?,?,?,?,?,?)";
 	
 		try {
 			// JDBC Driver 로딩
 			Class.forName(driver);
 			// Connection 객체 생성 / DB 연결(접속)
 			conn = DriverManager.getConnection(url, "system", "qwe123");
 			// 수행할 쿼리 정의 / no 컬럼의 데이터는 시퀀스로 입력하고, reg_date는 오라클의 sysdate로 입력
 			ppst = conn.prepareStatement(SQL);
 			// 매개변수로 전달된 데이터를 쿼리문의 물음표에 값 매핑
 			ppst.setString(1, data.getId());
 			ppst.setString(2, data.getPwd());
 			ppst.setString(3, data.getName());
 			ppst.setInt(4, data.getBirthday());
 			ppst.setInt(5, data.getPhone());
 			ppst.setString(6, data.getAddress());
 			ppst.setString(7, data.getNickname());
 			
 			// 쿼리 수행
 			ppst.executeUpdate();
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				if(ppst != null) ppst.close();
 				if(conn != null) conn.close();
 			} catch (Exception e2) {
 				e2.getStackTrace();
 			}
 		}
 	}
 	public List<Member> getList(){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null; //데이터 베이스와 연결을 위해 필요한 객체
		PreparedStatement ppst = null; //한번만 준비후 캐시 재사용
		ResultSet rs = null;     //생성된 테이블 저장하는 객체
		List<Member> list = null; 
		try {
			// JDBC Driver 로딩
			Class.forName(driver);
			// Connection 객체 생성 / DB 연결(접속)
			conn = DriverManager.getConnection(url, "system", "qwe123");
			// 수행할 쿼리 정의 / 특정 데이터만 검색하고자 한다면 where 조건절과 매개변수 추가 필요
			ppst = conn.prepareStatement("select * from member");
			// 쿼리 수행
			rs = ppst.executeQuery();
			// 수행된 결과를 List<Member)에 저장
			if(rs.next()){
				list = new ArrayList<>(); // List 객체 생성
				do {
					// 반복문이 수행될 때 마다 MemberInfoDTO 생성(참조값이 다름)
					Member data = new Member();
					// 생성된 객체(data)에 수행된 쿼리의 값(해당 컬럼)을 순서대로 저장
					data.setId(rs.getString("id"));
					data.setPwd(rs.getString("pwd"));
					data.setName(rs.getString("phone"));
					data.setBirthday(rs.getInt("birthday"));
					data.setPhone(rs.getInt("phone"));
					data.setAddress(rs.getString("address"));
					data.setNickname(rs.getString("nickname"));
					
					// list에 0번 index부터 순서대로 data 객체의 참조값을 저장
					list.add(data);
					
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return list; // list 리턴
	}
 }

