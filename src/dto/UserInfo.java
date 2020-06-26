package dto;

public class UserInfo {

	public String userId;
	//パスワード
	public String password;
	
	// ユーザーが所有する権限のString配列
	public String[] roles;
	
	// コンストラクタ
	public UserInfo() {
		password = null;
		roles =null;
	}
	
	
	// 引数に指定した権限をこのユーザーが持っているかどうかを確認
	public boolean isInRole(String role) {
		for(int i = 0; i < roles.length; i++) {
			if (roles[i].equals(role)) {
				return true;
			}
		}
		return false;
	}
	
}
