package vo;

public class MSGVO {
	private String userid;
	private String sendid;
	private String content;
	private int read;
	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSendid() {
		return sendid == null ? "" : sendid.trim();
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	
	
	
}
