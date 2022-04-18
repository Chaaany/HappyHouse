package src.com.ssafy.edu.util;

import java.util.List;

import src.com.ssafy.edu.dao.HouseDealDao;
import src.com.ssafy.edu.model.HouseDealDto;

public class AptTest {

	public static void main(String[] args) {
		// 동이름으로 거래리스트 조회
		HouseDealDao dao=new HouseDealDao();
		List<HouseDealDto> list = dao.getDealListByDong("내수동");
		System.out.println(list);
		for (HouseDealDto i : list) {
			System.out.println(i.toString());
		}
		System.out.println("----------");
		
		
		// 아파트코드로 거래리스트 조회
		list = dao.getdealListByAptCode(1);
		for (HouseDealDto i : list) {
			System.out.println(i.toString());
		}
	}

}
