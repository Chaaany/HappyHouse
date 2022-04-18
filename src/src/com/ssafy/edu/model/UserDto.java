package src.com.ssafy.edu.model;

/*
`id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(100) NOT NULL,
  `rec_id` VARCHAR(50) NULL,
 */

public class UserDto {
	
	private String id;
	private String pass;
	private String name;
	private String email;
	private String add_sido;
	private String add_gugun;
	private String add_dong;
	private String phone;
	
	public UserDto() {
		
	}

	public UserDto(String id, String pass, String name, String email, String add_sido, String add_gugun,
			String add_dong, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.add_sido = add_sido;
		this.add_gugun = add_gugun;
		this.add_dong = add_dong;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", add_sido=" + add_sido
				+ ", add_gugun=" + add_gugun + ", add_dong=" + add_dong + ", phone=" + phone + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdd_sido() {
		return add_sido;
	}

	public void setAdd_sido(String add_sido) {
		this.add_sido = add_sido;
	}

	public String getAdd_gugun() {
		return add_gugun;
	}

	public void setAdd_gugun(String add_gugun) {
		this.add_gugun = add_gugun;
	}

	public String getAdd_dong() {
		return add_dong;
	}

	public void setAdd_dong(String add_dong) {
		this.add_dong = add_dong;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
