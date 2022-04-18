package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.util.DBUtil;
import src.com.ssafy.edu.model.HouseInfoDto;
import src.com.ssafy.edu.model.HouseDealDto;


//data transfer object = vlaue object = 도메인 객체
public class HouseDealDao {
	private DBUtil db;
	
	private static HouseDealDao dao = new HouseDealDao();

	public static HouseDealDao getInstance() {
		return dao;
	}

	public HouseDealDao() {
		db = DBUtil.getInstance();
	}
	
	public List<HouseDealDto> getdealListByAptCode(int aptCode) {
		String sql = " select * from housedeal where aptCode = ? ";
		List<HouseDealDto> dealList = new ArrayList<HouseDealDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, aptCode);
			rs = psmt.executeQuery();
			int i = 1;
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				i = 1;
				HouseDealDto dto = new HouseDealDto(rs.getInt(i++), rs.getInt(i++), rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				dealList.add(dto); // dto를 리스트에 넣기
			}

		} catch (SQLException e) {
			System.out.println("addUser fail!ss " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
		}

		return dealList;
	}
	
	
	public List<HouseDealDto> getDealListByDong(String dongName) {
		HouseinfoDao houseinfo = new HouseinfoDao();
		HouseDealDao housedeal = new HouseDealDao();
		List<HouseInfoDto> houseList = houseinfo.getAptListByDong(dongName); 
		List<HouseDealDto> dealList = new ArrayList<HouseDealDto>();
		for (int i = 0; i < houseList.size(); i++) {
			List<HouseDealDto> tempList = housedeal.getdealListByAptCode(houseList.get(i).getAptCode());
			for (int j = 0; j < tempList.size(); j++) {
				dealList.add(tempList.get(j));
			}
		}
		return dealList;
	}
	
	
}
