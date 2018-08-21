package reminder2;

public abstract class User {
	
	public abstract String get_id();
	public abstract String get_name();
	
	String user_id;
	String user_name;
	String user_password;
	String user_contact;			//유저의 연락처

	public void setUser(String user_id, String user_name, String user_password, String user_contact){
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_contact = user_contact;
	}

	public void setUser(){
		user_id = "0";
		user_name = "0";
		user_password = "0";
		user_contact = "0";
	}
}