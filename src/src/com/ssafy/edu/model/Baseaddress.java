package src.com.ssafy.edu.model;

//	`id` VARCHAR(50) NOT NULL,
//	  `name` VARCHAR(45) NOT NULL,
//	  `pass` VARCHAR(100) NOT NULL,
//	  `rec_id` VARCHAR(50) NULL,

// data transfer object = value object = 도메인 객체
// DTO 필통 -> List 가방 -> 데이터 전송의 편리성 제공
public class Baseaddress {
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;
	public Baseaddress() {
	}
	
	public Baseaddress(String sidoName, String gugunName, String dongName, String dongCode, String lat, String lng) {
		super();
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
	
	
	
}
