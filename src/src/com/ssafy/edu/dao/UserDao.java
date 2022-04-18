package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class UserDao {

	private DBUtil db;
	
	private static UserDao dao = new UserDao();

	public static UserDao getInstance() {
		return dao;
	}
	public UserDao() {
		db=DBUtil.getInstance();
	}
	
	
	public boolean register(UserDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql=" insert into user values(?,?,?,?, '서울특별시', '강서구', '강서로',?); ";
		try {
			conn=db.getConnection();
			System.out.println("2/6 MemberDao regi S");
			System.out.println(dto.toString());
			psmt=conn.prepareStatement(sql);
			System.out.println(psmt.toString()+"1");
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhone());
			System.out.println(psmt.toString()+"2");
			
			System.out.println("3/6 MemberDao regi S");
			count=psmt.executeUpdate();
			System.out.println("4/6 MemberDao regi S");
		} catch (SQLException e) {
			System.out.println("MemberDao regi fail");
		}finally {
			db.close(psmt, conn);
			System.out.println("6/6 MemberDao regi S");
		}
		
		return count>0?true:false;
	}
	
	public boolean addUser(UserDto user) {
		int count=0;
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, user.getId());
			psmt.setString(i++, user.getPass());
			psmt.setString(i++, user.getName());
			psmt.setString(i++, user.getEmail());
			psmt.setString(i++, user.getAdd_sido());
			psmt.setString(i++, user.getAdd_gugun());
			psmt.setString(i++, user.getAdd_dong());
			psmt.setString(i++, user.getPhone());
			System.out.println("3/6 addUser Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addUser Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addUser Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addUser Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<UserDto> userList() {
		String sql = "select id,pass,name,email,add_sido,add_gugun,add_dong,phone from user order by id";
		List<UserDto> users = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 userList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 userList Success!");
			while(rs.next()) {
				int i=1;
				UserDto dto = new UserDto(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				users.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 userList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 userList Success!");
		}
		
		return users;
	}
	
	public boolean deleteUser(String userid) {
		int count=0;
		String sql = "delete from user where id=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, userid);
			System.out.println("3/6 deleteUser Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteUser Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteUser Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteUser Success!");
		}
		
		return count>0? true:false;
	}
	
	public UserDto getUser(String id) {
		String sql= " select id,name,pass,email,add_sido,add_gugun,add_dong,phone from user"
				+ " where id=? ";
		UserDto user=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getUser 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			System.out.println("getUser 3/6");
			rs=psmt.executeQuery();
			System.out.println("getUser 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				user=new UserDto(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
			System.out.println("getUser 5/6");
		} catch (SQLException e) {
			System.out.println("getUser fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getUser 6/6");
		}
		
		return user;
	}
	
	public UserDto login(UserDto dto) {
		String sql= " select id, name from user"
				+ " where id=? and pass=?";
		UserDto user=new UserDto();
		
		System.out.println(dto.toString());
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getUser 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			System.out.println("getUser 3/6");
			rs=psmt.executeQuery();
			System.out.println("getUser 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				user.setId(rs.getString(i++));
				user.setName(rs.getString(i++));
			}
			
			System.out.println("getUser 5/6");
		} catch (SQLException e) {
			System.out.println("getUser fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getUser 6/6");
		}
		
		return user;
	}
	
	public boolean updateUser(UserDto user) {
		int count=0;
		String sql= " update  user set pass=?,name=?, email=?, add_sido=?, add_gugun=?, add_dong=?, phone=?"
				+ "  where id=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("updateUser 2/6");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, user.getPass());
			psmt.setString(i++, user.getName());
			psmt.setString(i++, user.getEmail());
			psmt.setString(i++, user.getAdd_sido());
			psmt.setString(i++, user.getAdd_gugun());
			psmt.setString(i++, user.getAdd_dong());
			psmt.setString(i++, user.getPhone());
			psmt.setString(i++, user.getId());
			System.out.println("updateUser 3/6");
			count=psmt.executeUpdate();
			System.out.println("updateUser 4/6");
		} catch (SQLException e) {
			System.out.println("updateUser fail! "+ e);
		}finally {
			db.close(psmt,conn); 
			System.out.println("updateUser 6/6");
		}
		return count>0 ?true:false;
	}
}
