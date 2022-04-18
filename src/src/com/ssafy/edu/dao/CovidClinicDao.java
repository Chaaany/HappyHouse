package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class CovidClinicDao {

	private DBUtil db;
	
	private static CovidClinicDao dao = new CovidClinicDao();

	public static CovidClinicDao getInstance() {
		return dao;
	}
	
	public CovidClinicDao() {
		db=DBUtil.getInstance();
	}
	
	public boolean addClinic(CovidClinicDto clinic) {
		int count=0;
		String sql = "insert into clinicinfo values(?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, clinic.getSidoName());
			psmt.setString(i++, clinic.getGugunName());
			psmt.setString(i++, clinic.getClinicName());
			psmt.setString(i++, clinic.getAddress());
			psmt.setString(i++, clinic.getPhoneNum());
			System.out.println("3/6 addClinic Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addClinic Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addClinic Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addClinic Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<CovidClinicDto> clinicList() {
		String sql = "select no,sidoName,gugunName,clinicName,address,phoneNum from clinicinfo order by no";
		List<CovidClinicDto> clinics = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 clinicList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 clinicList Success!");
			while(rs.next()) {
				int i=1;
				CovidClinicDto dto = new CovidClinicDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				clinics.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 clinicList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 clinicList Success!");
		}
		
		return clinics;
	}
	
	public List<CovidClinicDto> search(String sido, String gugun) {
		String sql = "select no,sidoName,gugunName,clinicName,address,phoneNum from clinicinfo where sidoName=? and gugunName=? order by no";
		List<CovidClinicDto> clinics = new ArrayList<>();

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
				CovidClinicDto dto = new CovidClinicDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				clinics.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 search Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 search Success!");
		}
		
		return clinics;
	}
	
	public boolean deleteClinic(int no) {
		int count=0;
		String sql = "delete from clinicinfo where no=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("3/6 deleteClinic Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteClinic Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteClinic Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteClinic Success!");
		}
		
		return count>0? true:false;
	}
	
	public CovidClinicDto getClinic(int no) {
		String sql= " select no,sidoName,gugunName,clinicName,address,phoneNum from clinicinfo"
				+ " where no=? ";
		CovidClinicDto clinic=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getClinic 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("getClinic 3/6");
			rs=psmt.executeQuery();
			System.out.println("getClinic 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				clinic = new CovidClinicDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
			System.out.println("getClinic 5/6");
		} catch (SQLException e) {
			System.out.println("getClinic fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getClinic 6/6");
		}
		
		return clinic;
	}
}
