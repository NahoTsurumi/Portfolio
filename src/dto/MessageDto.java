package dto;

public class MessageDto {
	
	private int id;
	

	 String content;
	 private String time;
	 
	 public String getContent() {
		 return content;
	 }
	 
	 public void setContent(String content) {
		 this.content = content;
	 }
	 
	 public String getTime() {
		 return time;
	 }
	 
	 public void setTime(String time) {
		 this.time =time;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
