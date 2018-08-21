package reminder2;

public class MessageFactory {
   public void createMessage(Client send_user, int money, int type, String phone_number){
      if(type == 0) // sending money
      {
    	 SendMessage s_msg = new SendMessage(send_user, money, phone_number);
         s_msg.send();
         
      }
      else if(type == 1) // receiving money
      {
    	  ReceiveMessage r_msg = new ReceiveMessage(send_user, money, phone_number);
          r_msg.send();
      }
      else if(type == 2) // delete send message
      {
         SendMessage s_msg = new SendMessage(send_user, phone_number);
         s_msg.send();
      }
      else if(type == 3) // delete receive message
      {
         ReceiveMessage r_msg = new ReceiveMessage(send_user, phone_number);
         r_msg.send();
      }
      else
      {
         System.out.println("Wrong access!");
      }
   }
   
}