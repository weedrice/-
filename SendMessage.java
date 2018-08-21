package reminder2;

public class SendMessage extends Message {

   SendMessage(Client t_send_user, int t_money, String t_phone_number) { // when add
      super(t_send_user, t_phone_number);
      // TODO Auto-generated constructor stub
      super.money = t_money;
   }
   
   SendMessage(Client t_send_user, String t_phone_number) { // when delete
	   super(t_send_user, t_phone_number);
   }
   
   public void send(){
      System.out.println("send message created");
      Buffer.send_s_msg(this);
   }
   
   @Override
	public void show_msg() {
	   if(money != 0)
	   {
		   System.out.println(send_user.user_name + "으로부터 "+ money +"의 받을 돈이 추가되었습니다.");		   
	   }
	   else
	   {
		   System.out.println(send_user.user_name + "이 돈을 갚았습니다.");
	   }
	}

}