package vo;

public class goodsDTO {
	String title,category,summernote,mainpic,userid;
	int num,price;

	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title == null ? "" : title.trim();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category == null ? "" : category.trim();
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSummernote() {
		return summernote == null ? "" : summernote.trim();
	}

	public void setSummernote(String summernote) {
		this.summernote = summernote;
	}

	public String getMainpic() {
		return mainpic == null ? "" : mainpic.trim();
	}

	public void setMainpic(String mainpic) {
		this.mainpic = mainpic;
	}
}
