package reminder2;

public abstract class Message {
	Client send_user;
	String phone_number;
	int money;
	
	Message(Client t_send_user, String t_phone_number)
	{
		send_user = t_send_user;
		phone_number = t_phone_number;
	}
	
	public abstract void show_msg();
}
