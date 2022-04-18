package src.com.ssafy.edu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.ssafy.edu.dao.CovidClinicDao;
import src.com.ssafy.edu.dao.CovidHosDao;
import src.com.ssafy.edu.dao.EnvironDao;
import src.com.ssafy.edu.dao.HouseDealDao;
import src.com.ssafy.edu.dao.HouseinfoDao;
import src.com.ssafy.edu.dao.InterestDao;
import src.com.ssafy.edu.dao.StoreDao;
import src.com.ssafy.edu.dao.UserDao;
import src.com.ssafy.edu.dao.sidocodeDao;
import src.com.ssafy.edu.model.HouseDealDto;
import src.com.ssafy.edu.model.HouseInfoDto;
import src.com.ssafy.edu.model.UserDto;

@WebServlet("/main")
public class HController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String root="";
	
	CovidClinicDao covidClinicdao= CovidClinicDao.getInstance();
	CovidHosDao covidHosdao = CovidHosDao.getInstance(); 
	EnvironDao environdao = EnvironDao.getInstance();
	HouseDealDao housedealdao = HouseDealDao.getInstance();
	HouseinfoDao houseinfodao = HouseinfoDao.getInstance();
	InterestDao interestdao = InterestDao.getInstance();
	sidocodeDao sidocodedao = sidocodeDao.getInstance();
	StoreDao storedao = StoreDao.getInstance();
	UserDao userdao = UserDao.getInstance();
  	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String path = "/index.jsp";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(action!=null && action.equals("searchByAptName")) {
			searchByAptName(request,response);
			dispatcher("./index.jsp", request, response);
		}else if (action!=null && action.equals("searchBydongCode")) {
			searchByDongCode(request,response);
			dispatcher("./index.jsp", request, response);
		}else if(action!=null && action.equalsIgnoreCase("register")) {
			response.sendRedirect("signUp.jsp");
		}else if(action!=null && action.equalsIgnoreCase("login")) {
			response.sendRedirect("login.jsp");
		}else if(action!=null && action.equalsIgnoreCase("logout")) {
			request.getSession().invalidate(); // 세션 제거
			response.sendRedirect("index.jsp");
		}else if(action!=null && action.equalsIgnoreCase("registeraf")) {
			registeraf(request, response);
		}else if(action!=null && action.equalsIgnoreCase("loginaf")) {
			loginaf(request,response);
		}else if(action!=null && action.equalsIgnoreCase("notice")){
			response.sendRedirect("notice.jsp");
		}
	}

	private void loginaf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto userDto;
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		try {
			userDto = new UserDto();
			userDto.setId(id);
			userDto.setPass(pass);
			userDto = userdao.login(userDto);
			System.out.println(userDto.toString());
			if(userDto != null) { // 로그인 성공
//				session setting
				HttpSession session = request.getSession();
				System.out.println(userDto.toString());
				session.setAttribute("userInfo", userDto);
			    dispatcher("index.jsp", request, response);
			} else { // 로그인 실패
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
			    dispatcher("message.jsp", request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 문제 발생!!");
		    dispatcher("message.jsp", request, response);
		}
	}

	private void registeraf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		UserDto userdto = new UserDto(id, pass, name, email, "", "", "", phone);
		System.out.println(id +" " + pass + "" + name + "" + email + " "+ phone);
		System.out.println(userdto.toString());
	    boolean isS=userdao.register(new UserDto(id, pass, name, email, "", "", "", phone));
	    if(isS){
	 	  request.setAttribute("mes", "회원가입에 성공하였습니다.");
	 	  request.setAttribute("con", "HOME.");
	 	  request.setAttribute("url", "login.jsp");
	    }else {
	    	request.setAttribute("mes", "회원가입에 실패하였습니다.");
		 	request.setAttribute("con", "HOME.");
		 	request.setAttribute("url", "signUp.jsp");
	    }
	    dispatcher("message.jsp", request, response);
	}

	private void searchByAptName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aptName = request.getParameter("aptName");
		
		List<Integer> aptCodeList = houseinfodao.getHouseNameList(aptName);
		List<HouseDealDto> dealList = new ArrayList<>();
		for (int i = 0; i < aptCodeList.size(); i++) {
			HouseInfoDto tempHouseinfo = houseinfodao.getHouseInfo(aptCodeList.get(i));
			List<HouseDealDto> tempDealList = housedealdao.getdealListByAptCode(aptCodeList.get(i));
			for (int j = 0; j < tempDealList.size(); j++) {
				HouseDealDto temp = tempDealList.get(j);
				HouseDealDto tempHouseDealDto = new HouseDealDto(temp.getNo(), tempHouseinfo.getAptName(), temp.getAptCode(), temp.getDealAmount(), temp.getDealYear(), temp.getDealMonth(), temp.getDealDay(), temp.getArea(), temp.getFloor(),temp.getType(), temp.getRentMoney(), tempHouseinfo.getDongName(), tempHouseinfo.getLat(), tempHouseinfo.getLng());
				dealList.add(tempHouseDealDto);
			}
		}
		
		request.setAttribute("aptInfoList", dealList);
	}
	
	private void searchByDongCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dongCode = request.getParameter("dongCode");
		System.out.println(dongCode+"2");
		List<HouseInfoDto> tempHouseInfoList = houseinfodao.getAptListByDongCode(dongCode);
		List<HouseDealDto> dealList = new ArrayList<>();
		for (int i = 0; i < tempHouseInfoList.size(); i++) {
			HouseInfoDto tempHouseinfo =tempHouseInfoList.get(i);
			List<HouseDealDto> tempDealList = housedealdao.getdealListByAptCode(tempHouseinfo.getAptCode());
			for (int j = 0; j < tempDealList.size(); j++) {
				HouseDealDto temp = tempDealList.get(j);
				HouseDealDto tempHouseDealDto = new HouseDealDto(temp.getNo(), tempHouseinfo.getAptName(), temp.getAptCode(), temp.getDealAmount(), temp.getDealYear(), temp.getDealMonth(), temp.getDealDay(), temp.getArea(), temp.getFloor(),temp.getType(), temp.getRentMoney(), tempHouseinfo.getDongName(), tempHouseinfo.getLat(), tempHouseinfo.getLng());
				dealList.add(tempHouseDealDto);
			}
		}
		
		request.setAttribute("aptInfoList", dealList);
	}


	private void dispatcher(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatch=request.getRequestDispatcher(url);
		//dispatch.forward(request, response);
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	


	
}
