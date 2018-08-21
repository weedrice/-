package reminder2;

import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
		
	public Client setLogin(){
		System.out.println("Enter id\nIf you enter 'sign up', you can make an account");
		String id = sc.nextLine();
		Client user = null;
		Member.start_login();
		if(id.toLowerCase().equals("sign up")){
			Member.sign_up();
			user = setLogin();
		}
		else{
			System.out.println("Enter password");
			String password = sc.nextLine();
			user = new Client(id,"0",password,"0","0");
			if(Member.is_check_login(user)){
				user.n_th_member = Member.isThere(user);
				user = Member.get_client(user); // 실제로 저장된 데이터를 불러옴.
				return user;
			}
			else{
				System.out.println("아이디 또는 비밀번호가 존재하지 않습니다.");
				return null;
			}
		}
		return user;
	}
	
	//public boolean is_check_login(){
		//return Member.is_check_login();
	//}
	
}
