package bean;

import java.io.Serializable;


public class ProfileBean implements Serializable {

	
	private String name;
	
	private String pass;
	
	
	
	//入力されたユーザーネームを受け取る
	public String getName() {
		return name;
	}

	//入力されたユーザーネームを出力
	public void setName(String name) {
	this.name = name;
	}

	//入力されたパスワードを受け取る
	public String getPass() {
	return pass;
	}

	//入力されたパスワードを出力
	public void setPass(String pass) {
	this.pass = pass;
	// TODO 自動生成されたメソッド・スタブ
	
	}
}
