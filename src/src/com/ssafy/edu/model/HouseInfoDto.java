package src.com.ssafy.edu.model;

//	`id` VARCHAR(50) NOT NULL,
//	  `name` VARCHAR(45) NOT NULL,
//	  `pass` VARCHAR(100) NOT NULL,
//	  `rec_id` VARCHAR(50) NULL,

// data transfer object = value object = 도메인 객체
// DTO 필통 -> List 가방 -> 데이터 전송의 편리성 제공
public class HouseInfoDto {
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private int buildyear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;

	public HouseInfoDto() {

	}

	public HouseInfoDto(int aptCode, String aptName, String dongCode, String dongName, int buildyear, String jibun,
			String lat, String lng, String img) {
		super();
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.buildyear = buildyear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public int getBuildyear() {
		return buildyear;
	}

	public void setBuildyear(int buildyear) {
		this.buildyear = buildyear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
