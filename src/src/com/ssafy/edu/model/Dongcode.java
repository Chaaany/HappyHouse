package src.com.ssafy.edu.model;

//	`id` VARCHAR(50) NOT NULL,
//	  `name` VARCHAR(45) NOT NULL,
//	  `pass` VARCHAR(100) NOT NULL,
//	  `rec_id` VARCHAR(50) NULL,

// data transfer object = value object = 도메인 객체
// DTO 필통 -> List 가방 -> 데이터 전송의 편리성 제공
public class Dongcode {
	private String dongCode;
	private String sidoName;
	private String gugunName;
	private String dongName;
	
	public Dongcode() {
	}
	public Dongcode(String dongCode, String sidoName, String gugunName, String dongName) {
		super();
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
	
	
	
	
}
