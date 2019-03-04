package vo;

public class MemberDTO {
	
	private String userid;
	private String password;
	private String name;
	private String addr;
	private String zipcode;
	private String email;
	private String phone;
	private int income;
	private String rank;
	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password == null ? "" : password.trim();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr == null ? "" : addr.trim();
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getZipcode() {
		return zipcode == null ? "" : zipcode.trim();
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getRank() {
		return rank == null ? "" : rank.trim();
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	

}
