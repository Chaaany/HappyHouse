package src.com.ssafy.edu.util;

import java.util.List;

import src.com.ssafy.edu.dao.*;
import src.com.ssafy.edu.model.*;

public class EtcTest {

	public static void main(String[] args) {
		System.out.println("선별진료소");
		CovidClinicDao dao = new CovidClinicDao();
		List<CovidClinicDto> list = dao.search("서울특별시","종로구");
		for(CovidClinicDto i : list) {
			System.out.println(i);
		}
		
		System.out.println("국민안심병원");
		CovidHosDao dao2 = new CovidHosDao();
		List<CovidHosDto> list2 = dao2.search("서울특별시","종로구");
		for(CovidHosDto i : list2) {
			System.out.println(i);
		}
		
		StoreDao dao3 = new StoreDao();
		List<StoreDto> list3 = dao3.search("세종특별자치시","세종특별자치시","한솔동");
		for(StoreDto i : list3) {
			System.out.println(i);
		}
		
		EnvironDao dao4 = new EnvironDao();
		List<EnvironDto> list4 = dao4.search("서울특별시","종로구","무악동");
		for(EnvironDto i : list4) {
			System.out.println(i);
		}
	}
}
