package src.com.ssafy.edu.model;

public class CovidClinicDto {
	
	private int no;
	private String sidoName;
	private String gugunName;
	private String clinicName;
	private String address;
	private String phoneNum;
	
	public CovidClinicDto() {
		
	}

	public CovidClinicDto(int no, String sidoName, String gugunName, String clinicName, String address, String phoneNum) {
		super();
		this.no = no;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.clinicName = clinicName;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "CovidClinicDto [no=" + no + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", clinicName="
				+ clinicName + ", address=" + address + ", phoneNum=" + phoneNum + "]";
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

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
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
