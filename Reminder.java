package reminder2;

import java.util.Scanner;

public class Reminder {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Reminder에 오신것을 환영합니다.");
		
		int number = 0;
		ListGrouping LG = new ListGrouping();
		Login login = new Login();
		Client user = new Client();
		Client test1 = new Client();		
		//login하는 부분.
		//login이 되면, Login class에서 모든 user 정보를 받는다.
		try{
			user = login.setLogin();
			System.out.println("로그인 성공\n" + user.user_id + "님 환영합니다");
		}
		catch(NullPointerException e){
			System.out.println("재접속 하십시오.");
			System.exit(0);
		}
		
		while(number != 11)
	      {
			 int money;
			 String contact = new String();
			 
	         System.out.println("다음 중 선택하시오");
	         System.out.println("1. 보낼 명단 보기");
	         System.out.println("2. 받을 명단 보기");
	         System.out.println("3: 보낼 명단 추가");
	         System.out.println("4. 받을 명단 추가");
	         System.out.println("5. 보낼 명단 삭제");
	         System.out.println("6. 받을 명단 삭제");
	         System.out.println("7: 받을 명단 그룹 만들기");
	         System.out.println("8: 받을 명단 그룹 보기");
	         System.out.println("9: 받을 명단 그룹 맴버 보기");
	         System.out.println("10: 받을 명단 그룹 삭제");
	         System.out.println("11: 종료");
	         
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