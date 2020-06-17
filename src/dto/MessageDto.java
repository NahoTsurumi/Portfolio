package dto;

import java.sql.Timestamp;

public class MessageDto {

	 String content;
	 private Timestamp time;
	 
	 public String getContent() {
		 return content;
	 }
	 
	 public void setContent(String content) {
		 this.content = content;
	 }
	 
	 public Timestamp getTime() {
		 return time;
	 }
	 
	 public void setTime(Timestamp time) {
		 this.time =time;
	 }
}
