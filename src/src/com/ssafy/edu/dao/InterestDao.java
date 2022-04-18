package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class InterestDao {

	private DBUtil db;
	
	private static InterestDao dao = new InterestDao();

	public static InterestDao getInstance() {
		return dao;
	}
	
	public InterestDao() {
		db=DBUtil.getInstance();
	}
	
	public boolean addInterest(InterestDto interest) {
		int count=0;
		String sql = "insert into interest values(?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, interest.getCode());
			psmt.setString(i++, interest.getId());
			psmt.setString(i++, interest.getSidoName());
			psmt.setString(i++, interest.getGugunName());
			psmt.setString(i++, interest.getDongName());
			System.out.println("3/6 addInterest Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addInterest Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addInterest Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addInterest Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<InterestDto> interestList() {
		String sql = "select no,id,code,sidoName,gugunName,dongName from interest order by no";
		List<InterestDto> interests = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 interestList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 interestList Success!");
			while(rs.next()) {
				int i=1;
				InterestDto dto = new InterestDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				interests.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 interestList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 interestList Success!");
		}
		
		return interests;
	}
	
	public boolean deleteInterest(int no) {
		int count=0;
		String sql = "delete from interest where no=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("3/6 deleteInterest Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteInterest Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteInterest Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteInterest Success!");
		}
		
		return count>0? true:false;
	}
	
	public InterestDto getInterest(int no) {
		String sql= " select no,id,code,sidoName,gugunName,dongName from interest"
				+ " where no=? ";
		InterestDto interest=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getInterest 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println("getInterest 3/6");
			rs=psmt.executeQuery();
			System.out.println("getInterest 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				interest=new InterestDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
			System.out.println("getInterest 5/6");
		} catch (SQLException e) {
			System.out.println("getInterest fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getInterest 6/6");
		}
		
		return interest;
	}
}
