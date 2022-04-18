package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import src.com.ssafy.edu.model.HouseInfoDto;
import src.com.ssafy.edu.util.DBUtil;

//data transfer object = vlaue object = 도메인 객체
public class HouseinfoDao {
	private DBUtil db;

	private static HouseinfoDao dao = new HouseinfoDao();

	public static HouseinfoDao getInstance() {
		return dao;
	}

	public HouseinfoDao() {
		db = DBUtil.getInstance();
	}
	
	public List<Integer> getHouseNameList(String aptName) {
		String sql = " select aptCode from houseinfo where aptName like concat('%', ?, '%') ";
		List<Integer> houseinfoList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			System.out.println("getHouseInfo 2/6");

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, aptName);
			System.out.println("getHouseInfo 3/6");
			rs = psmt.executeQuery();
			System.out.println("getHouseInfo 4/6");
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				int tempAptCode = rs.getInt(1);
				if(houseinfoList.contains(tempAptCode)) continue;
				houseinfoList.add(tempAptCode);
			}

		} catch (SQLException e) {
			System.out.println("getHouseInfo fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("getHouseInfo 6/6");
		}

		return houseinfoList;
	}
	
	
	public HouseInfoDto getHouseInfo(int aptCode) {
		String sql = " select * from houseinfo " + " where aptCode=?";
		HouseInfoDto houseinfo = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			System.out.println("get 2/6");

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, aptCode);
			System.out.println("get 3/6");
			rs = psmt.executeQuery();
			System.out.println("get 4/6");
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				int i = 1;
				houseinfo = new HouseInfoDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}

		} catch (SQLException e) {
			System.out.println("get fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("get 6/6");
		}

		return houseinfo;
	}

	public List<HouseInfoDto> getAptListByDong(String dongName) {
		String sql = " select * from houseinfo where dongName like ? ";
		List<HouseInfoDto> houseInfoList = new ArrayList<HouseInfoDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			psmt = conn.prepareStatement(sql);
			int i = 0;
			psmt.setString(1, "%" + dongName + "%");
			rs = psmt.executeQuery();
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				i = 1;
				HouseInfoDto dto = new HouseInfoDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++));
				houseInfoList.add(dto); // dto를 리스트에 넣기
			}

		} catch (SQLException e) {
			System.out.println("addUser fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("addUser 6/6");
		}

		return houseInfoList;
	}
	
	public List<HouseInfoDto> getAptListByDongCode(String dongCode) {
		String sql = " select * from houseinfo where dongCode like ? ";
		List<HouseInfoDto> houseInfoList = new ArrayList<HouseInfoDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			psmt = conn.prepareStatement(sql);
			int i = 0;
			psmt.setString(1, "%" + dongCode + "%");
			rs = psmt.executeQuery();
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				i = 1;
				HouseInfoDto dto = new HouseInfoDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++));
				houseInfoList.add(dto); // dto를 리스트에 넣기
			}

		} catch (SQLException e) {
			System.out.println("addUser fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("addUser 6/6");
		}

		return houseInfoList;
	}
	

	public List<String> getListDong() {
		String sql = " select dongName from houseifno";
		List<String> dongList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int i = 1;
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				i = 1;
				String tempDongName = rs.getString(i);
				if(dongList.contains(tempDongName)) continue;
				dongList.add(tempDongName);
			}

		} catch (SQLException e) {
			System.out.println("addUser fail!ss " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
		}

		return dongList;
	}
}
