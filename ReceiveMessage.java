package reminder2;

public class ReceiveMessage extends Message {

   ReceiveMessage( Client t_send_user, int t_money, String t_phone_number) { // when add
      super(t_send_user, t_phone_number);
      // TODO Auto-generated constructor stub
      super.money = t_money;
   }
   
   ReceiveMessage(Client t_send_user, String t_phone_number) { // when delete
	   super(t_send_user, t_phone_number);
   }

   public void send(){
      System.out.println("receive message created");
      Buffer.send_r_msg(this);
   }

	@Override
	public void show_msg() {
		if(money != 0)
		   {
			   System.out.println(send_user.user_name + "으로부터 "+ money +"의 갚을 돈이 추가되었습니다.");		   
		   }
		   else
		   {
			   System.out.println(send_user.user_name + "이 돈을 받았습니다.");
		   }
	}
   
   
}