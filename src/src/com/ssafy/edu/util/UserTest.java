package src.com.ssafy.edu.util;

import java.util.List;

import src.com.ssafy.edu.dao.UserDao;
import src.com.ssafy.edu.model.UserDto;

public class UserTest {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		List<UserDto> list = dao.userList();
		for(UserDto i : list) {
			System.out.println(i);
		}
	}

}
