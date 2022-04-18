package src.com.ssafy.edu.model;

//	`id` VARCHAR(50) NOT NULL,
//	  `name` VARCHAR(45) NOT NULL,
//	  `pass` VARCHAR(100) NOT NULL,
//	  `rec_id` VARCHAR(50) NULL,

// data transfer object = value object = 도메인 객체
// DTO 필통 -> List 가방 -> 데이터 전송의 편리성 제공
public class Guguncode {
	private String gugunCode;
	private String gugunName;
	
	public Guguncode() {
	}
	
	public Guguncode(String sidoCode, String sidoName) {
		super();
		this.gugunCode = sidoCode;
		this.gugunName = sidoName;
	}
	public String getSidoCode() {
		return gugunCode;
	}
	public void setSidoCode(String sidoCode) {
		this.gugunCode = sidoCode;
	}
	public String getSidoName() {
		return gugunName;
	}
	public void setSidoName(String sidoName) {
		this.gugunName = sidoName;
	}
	
	
	
}
