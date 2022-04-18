package src.com.ssafy.edu.model;

public class InterestDto {
	
	private int no;
	private String id;
	private String code;
	private String sidoName;
	private String gugunName;
	private String dongName;
	
	public InterestDto() {
		
	}

	public InterestDto(int no, String id, String code, String sidoName, String gugunName, String dongName) {
		super();
		this.no = no;
		this.id = id;
		this.code = code;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	
	@Override
	public String toString() {
		return "InterestDto [no=" + no + ", id=" + id + ", code=" + code + ", sidoName=" + sidoName + ", gugunName="
				+ gugunName + ", dongName=" + dongName + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
