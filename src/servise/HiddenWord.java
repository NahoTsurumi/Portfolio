package servise;

public class HiddenWord{
	// TODO 自動生成されたメソッド・スタブ
	public static void main(String[] args) {
		
	String[] names = {"ばか", "バカ", "死ね", "しね", "殺す", "ブス", "ファック", "fuck"};
	
		

	for(String name: names) {

		System.out.println("^(?!.*names).+$");
	}
	
	
}
}