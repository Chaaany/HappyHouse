package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class EnvironDao {

	private DBUtil db;
	
	private static EnvironDao dao = new EnvironDao();

	public static EnvironDao getInstance() {
		return dao;
	}
	
	public EnvironDao() {
		db=DBUtil.getInstance();
	}
	
	public boolean addEnviron(EnvironDto environ) {
		int count=0;
		String sql = "insert into environmentinfo values(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, environ.getFacName());
			psmt.setString(i++, environ.getCategory());
			psmt.setString(i++, environ.getCheckDate());
			psmt.setString(i++, environ.getSidoName());
			psmt.setString(i++, environ.getGugunName());
			psmt.setString(i++, environ.getDongName());
			System.out.println("3/6 addEnviron Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addEnviron Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addEnviron Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addEnviron Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<EnvironDto> environList() {
		String sql = "select no,facName,category,checkDate,sidoName,gugunName,dongName from environmentinfo order by no";
		List<EnvironDto> environs = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 environList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 environList Success!");
			while(rs.next()) {
				int i=1;
				EnvironDto dto = new EnvironDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				environs.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 environList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 environList Success!");
		}
		
		return environs;
	}
	
	public List<EnvironDto> search(String sido, String gugun, String dong) {
		String sql = "select no,facName,category,checkDate,sidoName,gugunName,dongName from environmentinfo where sidoName=? and gugunName=? and dongName=? order by no";
		List<EnvironDto> environs = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, sido);
			psmt.setString(2, gugun);
			psmt.setString(3, dong);
			System.out.println("3/6 search Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 search Success!");
			while(rs.next()) {
				int i=1;
				EnvironDto dto = new EnvironDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				environs.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 search Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 search Success!");
		}
		
		return environs;
	}
	
	public boolean deleteEnviron(int no) {
		int count=0;
		String sql = "delete from environmentinfo where no=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("3/6 deleteEnviron Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteEnviron Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteEnviron Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteEnviron Success!");
		}
		
		return count>0? true:false;
	}
	
	public EnvironDto getEnviron(int no) {
		String sql= " select no,facName,category,checkDate,sidoName,gugunName,dongNamefrom environmentinfo"
				+ " where no=? ";
		EnvironDto environ=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getEnviron 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("getEnviron 3/6");
			rs=psmt.executeQuery();
			System.out.println("getEnviron 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				environ = new EnvironDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
			System.out.println("getEnviron 5/6");
		} catch (SQLException e) {
			System.out.println("getEnviron fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getEnviron 6/6");
		}
		
		return environ;
	}
}
