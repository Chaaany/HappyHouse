package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class CovidHosDao {

	private DBUtil db;
	
	private static CovidHosDao dao = new CovidHosDao();

	public static CovidHosDao getInstance() {
		return dao;
	}
	
	public CovidHosDao() {
		db=DBUtil.getInstance();
	}
	
	public boolean addHospital(CovidHosDto hospital) {
		int count=0;
		String sql = "insert into hospitalinfo values(?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, hospital.getSidoName());
			psmt.setString(i++, hospital.getGugunName());
			psmt.setString(i++, hospital.getHosName());
			psmt.setString(i++, hospital.getAddress());
			psmt.setString(i++, hospital.getPhoneNum());
			System.out.println("3/6 addHospital Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addHospital Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addHospital Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addHospital Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<CovidHosDto> hospitalList() {
		String sql = "select no,sidoName,gugunName,hosName,address,phoneNum from hospitalinfo order by no";
		List<CovidHosDto> hospitals = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 hospitalList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 hospitalList Success!");
			while(rs.next()) {
				int i=1;
				CovidHosDto dto = new CovidHosDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				hospitals.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 hospitalList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 hospitalList Success!");
		}
		
		return hospitals;
	}
	
	public List<CovidHosDto> search(String sido, String gugun) {
		String sql = "select no,sidoName,gugunName, hosName, address,phoneNum from hospitalinfo where sidoName=? and gugunName=? order by no";
		List<CovidHosDto> hospital = new ArrayList<>();

		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, sido);
			psmt.setString(2, gugun);
			System.out.println("3/6 search Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 search Success!");
			while(rs.next()) {
				int i=1;
				CovidHosDto dto = new CovidHosDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				hospital.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 search Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 search Success!");
		}
		
		return hospital;
	}
	
	public boolean deleteHospital(int no) {
		int count=0;
		String sql = "delete from hospitalinfo where no=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("3/6 deleteHospital Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteHospital Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteHospital Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteHospital Success!");
		}
		
		return count>0? true:false;
	}
	
	public CovidHosDto getHospital(int no) {
		String sql= " select no,sidoName,gugunName,hosName,address,phoneNum from hospitalinfo"
				+ " where no=? ";
		CovidHosDto hospital=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getHospital 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("getHospital 3/6");
			rs=psmt.executeQuery();
			System.out.println("getHospital 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				hospital = new CovidHosDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
			System.out.println("getHospital 5/6");
		} catch (SQLException e) {
			System.out.println("getHospital fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getHospital 6/6");
		}
		
		return hospital;
	}
}
