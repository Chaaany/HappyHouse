package src.com.ssafy.edu.model;

public class StoreDto {
	
	private String storeId;
	private String storeName;
	private String category;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private int gibunmain;
	private int gibunsub;
	private double lat;
	private double lng;

	public StoreDto() {
		
	}

	public StoreDto(String storeId, String storeName, String category, String sidoName, String gugunName,
			String dongName, int gibunmain, int gibunsub, double lat, double lng) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.category = category;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.gibunmain = gibunmain;
		this.gibunsub = gibunsub;
		this.lat = lat;
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "StoreDto [storeId=" + storeId + ", storeName=" + storeName + ", category=" + category + ", sidoName="
				+ sidoName + ", gugunName=" + gugunName + ", dongName=" + dongName + ", gibunmain=" + gibunmain
				+ ", gibunsub=" + gibunsub + ", lat=" + lat + ", lng=" + lng + "]";
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getGibunmain() {
		return gibunmain;
	}

	public void setGibunmain(int gibunmain) {
		this.gibunmain = gibunmain;
	}

	public int getGibunsub() {
		return gibunsub;
	}

	public void setGibunsub(int gibunsub) {
		this.gibunsub = gibunsub;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	
	
}
