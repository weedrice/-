package reminder2;

import java.util.Scanner;

public class Reminder {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Reminder�� ���Ű��� ȯ���մϴ�.");
		
		int number = 0;
		ListGrouping LG = new ListGrouping();
		Login login = new Login();
		Client user = new Client();
		Client test1 = new Client();		
		//login�ϴ� �κ�.
		//login�� �Ǹ�, Login class���� ��� user ������ �޴´�.
		try{
			user = login.setLogin();
			System.out.println("�α��� ����\n" + user.user_id + "�� ȯ���մϴ�");
		}
		catch(NullPointerException e){
			System.out.println("������ �Ͻʽÿ�.");
			System.exit(0);
		}
		
		while(number != 11)
	      {
			 int money;
			 String contact = new String();
			 
	         System.out.println("���� �� �����Ͻÿ�");
	         System.out.println("1. ���� ��� ����");
	         System.out.println("2. ���� ��� ����");
	         System.out.println("3: ���� ��� �߰�");
	         System.out.println("4. ���� ��� �߰�");
	         System.out.println("5. ���� ��� ����");
	         System.out.println("6. ���� ��� ����");
	         System.out.println("7: ���� ��� �׷� �����");
	         System.out.println("8: ���� ��� �׷� ����");
	         System.out.println("9: ���� ��� �׷� �ɹ� ����");
	         System.out.println("10: ���� ��� �׷� ����");
	         System.out.println("11: ����");
	         
	         number = sc.nextInt();
	         

	         switch(number){
	         case 1 : user.show_send_list();
	            break;
	         case 2 : user.show_receive_list();
	            break;
	         case 3 :
	         	System.out.println("Input the money");
	         	money = sc.nextInt();
	         	contact = sc.nextLine();
	         	System.out.println("Input the user contact");
	         	contact = sc.nextLine();
	         	user.add_send_list(user, money, contact);
	            break;
	         case 4 :
	        	 System.out.println("Input the money");
	        	 money = sc.nextInt();
	        	 contact = sc.nextLine();
	        	 System.out.println("Input the user contact");
	        	 contact = sc.nextLine();
	        	 user.add_receive_list(user, money, contact);
	             break;
	         case 5 :
	        	 contact = sc.nextLine();
	        	 System.out.println("Input the user contact to delete");
	        	 contact = sc.nextLine();
	        	 user.send_delete_list(user, contact);
	            break;
	         case 6 :
	        	 contact = sc.nextLine();
	        	 System.out.println("Input the user contact to delete");
	        	 contact = sc.nextLine();
	        	 user.receive_delete_list(user, contact);
	            break;
	         case 7 :
	        	 LG.makegroup();
	            break;
	         case 8 :
	        	 LG.showingGroup();
	        	 break;
	         case 9 :
	        	 LG.showingGroupMember();
	        	 break;
	         case 10 : 
	        	 LG.removegroup();
	        	 break;
	         case 11 : 
	        	 break;
	         }
	      
	      }
		
		}		
	}