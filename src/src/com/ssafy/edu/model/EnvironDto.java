package src.com.ssafy.edu.model;

public class EnvironDto {
	
	private int no;
	private String facName;
	private String category;
	private String checkDate;
	private String sidoName;
	private String gugunName;
	private String dongName;

	public EnvironDto() {
		
	}

	public EnvironDto(int no, String facName, String category, String checkDate, String sidoName, String gugunName,
			String dongName) {
		super();
		this.no = no;
		this.facName = facName;
		this.category = category;
		this.checkDate = checkDate;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

	@Override
	public String toString() {
		return "EnvironDto [no=" + no + ", facName=" + facName + ", category=" + category + ", checkDate=" + checkDate
				+ ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName=" + dongName + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
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
