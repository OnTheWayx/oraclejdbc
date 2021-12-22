package po;

import java.util.Date;

public class User {
	private String uname;
	private String tel;
	private int age;
	private String email;
	private String address;
	private String yesorno;
	private String password;
	private Date birth;

	public User() {

	}

	public User(String uname, String tel, int age, String email, String address, String yesorno, String password,
			Date birth) {
		super();
		this.uname = uname;
		this.tel = tel;
		this.age = age;
		this.email = email;
		this.address = address;
		this.yesorno = yesorno;
		this.password = password;
		this.birth = birth;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getYesorno() {
		return yesorno;
	}

	public void setYesorno(String yesorno) {
		this.yesorno = yesorno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", tel=" + tel + ", age=" + age + ", email=" + email + ", address=" + address
				+ ", yesorno=" + yesorno + ", password=" + password + ", birth=" + birth + "]";
	}

}
