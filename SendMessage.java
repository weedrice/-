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
		   System.out.println(send_user.user_name + "���κ��� "+ money +"�� ���� ���� �߰��Ǿ����ϴ�.");		   
	   }
	   else
	   {
		   System.out.println(send_user.user_name + "�� ���� ���ҽ��ϴ�.");
	   }
	}

}