package src.com.ssafy.edu.model;

public class CovidHosDto {
	
	private int no;
	private String sidoName;
	private String gugunName;
	private String hosName;
	private String address;
	private String phoneNum;
	
	public CovidHosDto() {
		
	}

	public CovidHosDto(int no, String sidoName, String gugunName, String hosName, String address, String phoneNum) {
		super();
		this.no = no;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.hosName = hosName;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "CovidClinicDto [no=" + no + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", hosName="
				+ hosName + ", address=" + address + ", phoneNum=" + phoneNum + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
}
