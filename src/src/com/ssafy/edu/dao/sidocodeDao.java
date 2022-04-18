package src.com.ssafy.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.ssafy.edu.util.DBUtil;
import src.com.ssafy.edu.model.SidocodeDto;

public class sidocodeDao {
	private DBUtil db;
	
	private static sidocodeDao dao = new sidocodeDao();

	public static sidocodeDao getInstance() {
		return dao;
	}
	
	public sidocodeDao() {
		db = DBUtil.getInstance();
	}

	public List<SidocodeDto> sidoList() {
		int count = 0;
		String sql = " select sidoCode, sidoName from sidocode order by sidoName ";
		List<SidocodeDto> sidocodes = new ArrayList<SidocodeDto>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			System.out.println("getsidocodeList 2/6");

			psmt = conn.prepareStatement(sql);
			System.out.println("getsidocodeList 3/6");
			rs = psmt.executeQuery();
			System.out.println("getsidocodeList 4/6");
			int i = 1;
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				i = 1;
				SidocodeDto dto = new SidocodeDto(rs.getString(i++), rs.getString(i++));

				sidocodes.add(dto); // dto를 리스트에 넣기
			}

		} catch (SQLException e) {
			System.out.println("getsidocodeList fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("getsidocodeList 6/6");
		}

		return sidocodes;
	}

	public boolean addsidocode(SidocodeDto sidocode) { // 필통에서 뽑아서 db에 넣을 거임
		int count = 0;
		String sql = " insert into sidocode(sidoCode,sidoName) values(?,?) "; // 앞 뒤 띄어쓰기 해야함 SQL에러 방지
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = db.getConnection();
			System.out.println("addSidocode 2/6");

			psmt = conn.prepareStatement(sql);
			int i = 1; // db는 순서가 1번 째 부터.
			psmt.setString(i++, sidocode.getSidoCode());
			psmt.setString(i++, sidocode.getSidoName());
			System.out.println("addSidocode 3/6");

			count = psmt.executeUpdate(); // 성공한 갯수 리턴
			System.out.println("addSidocode 4/6");

		} catch (SQLException e) {
			System.out.println("addSidocode fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("addSidocode 6/6");
		}

		return count > 0;
	}
	
	
	public SidocodeDto getsidocode(String code) {
		String sql = " select sidoCode, sidoName from sidocode "
				+ " where sidoCode=?";
		SidocodeDto sidocode = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			System.out.println("getsidocode 2/6");

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code.trim());
			System.out.println("getsidocode 3/6");
			rs = psmt.executeQuery();
			System.out.println("getsidocode 4/6");
			while (rs.next()) {// 각 컬럼 데이터 dto에 저장
				int i = 1;
				sidocode = new SidocodeDto(rs.getString(i++), rs.getString(i++));
			}

		} catch (SQLException e) {
			System.out.println("getsidocode fail! " + e);
		} finally {
			db.close(psmt, conn); // 먼저 연 걸 나중에 닫음
			System.out.println("getsidocode 6/6");
		}

		return sidocode;
	}
	
	public boolean updatesidocodes(SidocodeDto sidocode) {
		int count=0;
		String sql= " update  sidocode set sidoName=? "
				+ "  where sidocode=? ";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=db.getConnection();
			System.out.println("updatesidocode 2/6");
			psmt=conn.prepareStatement(sql);
			int i=1;
			psmt.setString(i++, sidocode.getSidoCode());
			psmt.setString(i++, sidocode.getSidoName());
			System.out.println("updatesidocode 3/6");
			count=psmt.executeUpdate();
			System.out.println("updatesidocode 4/6");
		} catch (SQLException e) {
			System.out.println("updatesidocode fail! "+ e);
		}finally {
			db.close(psmt,conn); 
			System.out.println("updatesidocode 6/6");
		}
		return count>0 ?true:false;
	}

}
