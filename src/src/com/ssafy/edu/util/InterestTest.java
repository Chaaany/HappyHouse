package src.com.ssafy.edu.util;

import java.util.List;

import src.com.ssafy.edu.dao.InterestDao;
import src.com.ssafy.edu.model.InterestDto;

public class InterestTest {

	public static void main(String[] args) {
		InterestDao dao = new InterestDao();
		List<InterestDto> list = dao.interestList();
		for(InterestDto i : list) {
			System.out.println(i);
		}
	}

}
