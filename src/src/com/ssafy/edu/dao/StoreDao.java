package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.model.*;
import src.com.ssafy.edu.util.*;

public class StoreDao {

	private DBUtil db;
	
	private static StoreDao dao = new StoreDao();

	public static StoreDao getInstance() {
		return dao;
	}
	
	public StoreDao() {
		db=DBUtil.getInstance();
	}
	
	public boolean addStore(StoreDto store) {
		int count=0;
		String sql = "insert into storeinfo values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, store.getStoreId());
			psmt.setString(i++, store.getStoreName());
			psmt.setString(i++, store.getCategory());
			psmt.setString(i++, store.getSidoName());
			psmt.setString(i++, store.getGugunName());
			psmt.setString(i++, store.getDongName());
			psmt.setInt(i++, store.getGibunmain());
			psmt.setInt(i++, store.getGibunsub());
			psmt.setDouble(i++, store.getLat());
			psmt.setDouble(i++, store.getLng());
			System.out.println("3/6 addStore Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 addStore Success!");
		} catch(SQLException e) {
			System.out.println("3/6 addStore Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 addStore Success!");
		}
		
		return count>0? true:false;
	}
	
	public List<StoreDto> storeList() {
		String sql = "select storeId, storeName, category, sidoName, gugunName, dongName, gibunmain, gibunsub, lat, lng from storeinfo order by storeId";
		List<StoreDto> stores = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			System.out.println("3/6 storeList Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 storeList Success!");
			while(rs.next()) {
				int i=1;
				StoreDto dto = new StoreDto(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getString(i++), rs.getString(i++),rs.getInt(i++),rs.getInt(i++),rs.getDouble(i++),rs.getDouble(i++));
				stores.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 storeList Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 storeList Success!");
		}
		
		return stores;
	}
	
	public List<StoreDto> search(String sido, String gugun, String dong) {
		String sql = "select storeId, storeName, category, sidoName, gugunName, dongName, gibunmain, gibunsub, lat, lng from storeinfo where sidoName=? and gugunName=? and dongName=? order by storeId";
		List<StoreDto> stores = new ArrayList<>();
		
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
			System.out.println("3/6 searchDong Success!");
			rs=psmt.executeQuery();
			System.out.println("4/6 searchDong Success!");
			while(rs.next()) {
				int i=1;
				StoreDto dto = new StoreDto(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getString(i++), rs.getString(i++),rs.getInt(i++),rs.getInt(i++),rs.getDouble(i++),rs.getDouble(i++));
				stores.add(dto);
			}
		} catch(SQLException e) {
			System.out.println("3/6 searchDong Fail! : "+e);
		} finally {
			db.close(rs,psmt,conn);
			System.out.println("6/6 searchDong Success!");
		}
		
		return stores;
	}
	
	public boolean deleteStore(String storeid) {
		int count=0;
		String sql = "delete from storeinfo where storeId=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("2/6 Success!");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, storeid);
			System.out.println("3/6 deleteStore Success!");
			count=psmt.executeUpdate();
			System.out.println("4/6 deleteStore Success!");
		} catch(SQLException e) {
			System.out.println("3/6 deleteStore Fail! : "+e);
		} finally {
			db.close(psmt,conn);
			System.out.println("6/6 deleteStore Success!");
		}
		
		return count>0? true:false;
	}
	
	public StoreDto getStore(String storeId) {
		String sql= "select storeId, storeName, category, sidoName, gugunName, dongName, gibunmain, gibunsub, lat, lng from storeinfo"
				+ " where storeId=? ";
		StoreDto store=null;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=db.getConnection();
			System.out.println("getStore 2/6");
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, storeId);
			System.out.println("getStore 3/6");
			rs=psmt.executeQuery();
			System.out.println("getStore 4/6");
			while(rs.next()) {
				int i=1;    // 조심
				store = new StoreDto(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getString(i++), rs.getString(i++),rs.getInt(i++),rs.getInt(i++),rs.getDouble(i++),rs.getDouble(i++));
			}
			System.out.println("getStore 5/6");
		} catch (SQLException e) {
			System.out.println("getStore fail! "+ e);
		}finally {
			db.close(rs, psmt,conn); 
			System.out.println("getStore 6/6");
		}
		
		return store;
	}
}
