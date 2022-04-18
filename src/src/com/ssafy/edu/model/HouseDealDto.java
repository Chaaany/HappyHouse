package src.com.ssafy.edu.model;

//	`id` VARCHAR(50) NOT NULL,
//	  `name` VARCHAR(45) NOT NULL,
//	  `pass` VARCHAR(100) NOT NULL,
//	  `rec_id` VARCHAR(50) NULL,

// data transfer object = value object = 도메인 객체
// DTO 필통 -> List 가방 -> 데이터 전송의 편리성 제공
public class HouseDealDto {
	private int no;
	private String aptName;
	private int aptCode;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private String area;
	private String floor;
	private String type;
	private String rentMoney;
	private String dongName;
	private String lat;
	private String lng;
	
	
	public HouseDealDto() {
	}
	
	

	public HouseDealDto(int no, String aptName, int aptCode, String dealAmount, int dealYear, int dealMonth,
			int dealDay, String area, String floor, String type, String rentMoney, String dongName, String lat,
			String lng) {
		this.no = no;
		this.aptName = aptName;
		this.aptCode = aptCode;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.rentMoney = rentMoney;
		this.dongName = dongName;
		this.lat = lat;
		this.lng = lng;
	}



	public String getAptName() {
		return aptName;
	}



	public void setAptName(String aptName) {
		this.aptName = aptName;
	}



	public String getDongName() {
		return dongName;
	}



	public void setDongName(String dongName) {
		this.dongName = dongName;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public HouseDealDto(int no, int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
			String floor, String type, String rentMoney) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.rentMoney = rentMoney;
	}
	public int getNo() {
		return aptCode;
	}
	public void setNo(int no) {
		this.aptCode = aptCode;
	}
	
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealDay() {
		return dealDay;
	}
	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}

	@Override
	public String toString() {
		return "HouseDealDto [no=" + no + ", aptCode=" + aptCode + ", dealAmount=" + dealAmount + ", dealYear="
				+ dealYear + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor
				+ ", type=" + type + ", rentMoney=" + rentMoney + "]";
	}
	
	
}
