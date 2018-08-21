package reminder2;

public class Buffer {
	private static Buffer buf = new Buffer();
	public String message;
		
	private Buffer() 
	{}
	
	public static void send_s_msg(Message msg)
	{
		System.out.println("send message confirmed");
		Member.get_send_msg(msg);
	}
	
	public static void send_r_msg(Message msg)
	{
		System.out.println("receive message confirmed");
		Member.get_receive_msg(msg);
	}
	
}