package reminder2;

import java.util.Scanner;
import java.io.*;
import java.lang.String;

class Modify_list_msg{
	private static Get_message g_msg = new Get_message();
	private static Add_list a_list = new Add_list();
	private static Delete_list d_list = new Delete_list();
	
	
	public void add_send(Client user, Message msg){
		a_list.add_send_list(user,msg);
		g_msg.add_send_msg(user, msg);
	}
	public void delete_send(Client user, Message msg){
	         d_list.delete_send_list(user,msg);
	         g_msg.delete_send_msg(user, msg);
	}
	public void add_receive(Client user, Message msg){
	         a_list.add_receive_list(user,msg);
	         g_msg.add_receive_msg(user, msg);
	}
	public void delete_receive(Client user, Message msg){
	         d_list.delete_receive_list(user,msg);
	         g_msg.delete_receive_msg(user, msg);
	}
	
}

class Get_message {
	public void add_send_msg(Client user, Message msg) {
		msg.send_user.send_added_list(user, msg.money);
	}
	
	public void delete_send_msg(Client user, Message msg) {
		msg.send_user.delete_receive_list(user);
	}
	
	public void add_receive_msg(Client user, Message msg) {
		msg.send_user.receive_added_list(user, msg.money);
	}
	
	public void delete_receive_msg(Client user, Message msg) {
		msg.send_user.delete_send_list(user);
	}

}


class Add_list{
	public void add_send_list(Client user,Message msg){
		user.receive_added_list(msg.send_user,msg.money);
	}
	public void add_receive_list(Client user, Message msg){
		user.send_added_list(msg.send_user,msg.money);
	}
}

class Delete_list{
	public void delete_send_list(Client user, Message msg){
		user.delete_send_list(msg.send_user);
	}
	public void delete_receive_list(Client user, Message msg){
		user.delete_receive_list(msg.send_user);
	}
}



public class Member {
	public static Client[] client_list = new Client[100];
	private static Scanner sc = new Scanner(System.in);
	private static int i_th_client=0;
	private static Modify_list_msg m_list_msg = new Modify_list_msg();
	
	public static void get_send_msg(Message msg)
	{
		if(msg.money != 0) // add message
		{
			System.out.println("Member get adding message to send money");
			Client user = new Client();
		    if(isThere_contact(msg.phone_number)>=0)
		    {
		         user = client_list[isThere_contact(msg.phone_number)];
		         m_list_msg.add_send(user,msg);
		    }
		    else
		    {
		    	System.out.println("There is no user to receive message.");
		    }
		}
		else // delete message
		{
			System.out.println("Member get deleting message to send money");
			Client user = new Client();
		    if(isThere_contact(msg.phone_number)>=0)
		    {
		         user = client_list[isThere_contact(msg.phone_number)];
		         m_list_msg.delete_send(user,msg);
		    }
		    else
		    {
		    	System.out.println("There is no user to receive message.");
		    }
		}
		
			 
	}
	
	public static void get_receive_msg(Message msg)
	{
		if(msg.money != 0) // add message
		{
			System.out.println("Member get adding message to receive money");
			Client user = new Client();
		    if(isThere_contact(msg.phone_number)>=0)
		    {
		         user = client_list[isThere_contact(msg.phone_number)];
		         m_list_msg.add_receive(user,msg);	
		    }
		    else
		    {
		    	System.out.println("There is no user to receive.");
		    }	
		}
		else // delete message
		{
			System.out.println("Member get deleting message to receive money");
			Client user = new Client();
		    if(isThere_contact(msg.phone_number)>=0)
		    {
		        user = client_list[isThere_contact(msg.phone_number)];
			m_list_msg.delete_receive(user,msg);
		    }
		    else
		    {
		    	System.out.println("There is no user to receive.");
		    }	
		}
		    
	}
    
	public static int isThere_contact(String contact){
	    for(int i=0;i<i_th_client; i++){
	       if(contact.equals(client_list[i].user_contact))
	          return i;
	    }
	    return -1;   // It needs to make
	}
	
	
	public static Client search_user(String phonenumber)
	{
		int i;
		for(i=0;i<100;i++)
		{
			if(client_list[i].user_contact.equals(phonenumber));
				return client_list[i];
		}
		return null;
	}
	
	public static User[] get_clinet_list(){
		return client_list;
	}
	
	public static boolean is_check_login(Client user){
		for(int n_th=0; n_th < i_th_client; n_th++){
			if(user.user_id.equals(client_list[n_th].user_id)&&user.user_password.equals(client_list[n_th].user_password))
				return true;
		}
		return false;
	}
	
	public static void sign_up(){
		Client user = new Client();
		System.out.println("Enter id");
		String id = sc.nextLine();
		user.user_id = id;
		if(isThere(user) >= 0){
			System.out.println("This id is already exist");
			sign_up();
		}
		else{
			System.out.println("Enter password");
			String password = sc.nextLine();
			user.user_password = password;
			System.out.println("Enter contact");
			String contact = sc.nextLine();
			user.user_contact = contact;
			System.out.println("Enter account");
			String account = sc.nextLine();
			user.user_account = account;
			user.n_th_member = i_th_client;	
			client_list[i_th_client] = user;
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt",true));
				//System.out.println(user.user_id+user.user_password+user.user_contact+user.user_account);
				writer.write(user.user_id + "," + user.user_name + "," +user.user_password + "," + user.user_contact + "," + user.user_account + "," + user.n_th_member + "\n");
			    writer.close();
				i_th_client++;
			 }
			 catch(Exception e){
			 }
		}
	}
	
	public static void start_login(){
		 
		String[] user_values = null;

		 try{
		     BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		     while(true){
		        String line = reader.readLine();
		        if(line == null)break;
		        user_values = line.split(",");
		        Client ex_user = new Client(user_values[0],user_values[1],user_values[2],user_values[3],user_values[4]);
		        ex_user.n_th_member = Integer.parseInt(user_values[5]);
		        client_list[i_th_client] = ex_user;
		        i_th_client++;
		     }
		     reader.close();
		 }
		 catch(Exception e){
		       
		 }
	}
	
	
	/*
	public static void ex_sign_up(){
		Client user = new Client();
		System.out.println("Enter id");
		String id = sc.nextLine();
		user.user_id = id;
		if(isThere(user) >= 0){
			System.out.println("This id is already exist");
			sign_up();
		}
		else{
			System.out.println("Enter password");
			String password = sc.nextLine();
			user.user_password = password;
			System.out.println("Enter contact");
			String contact = sc.nextLine();
			user.user_contact = contact;
			System.out.println("Enter account");
			String account = sc.nextLine();
			user.user_account = account;
			user.n_th_member = i_th_client;
			client_list[i_th_client] = user;
			i_th_client++;
		}
	}
	
	
	public static void make_up(){
	 
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
		    writer.write("qwer,qwer,0000,0,0,0" + "\n");
		    writer.write("asdf,asdf,1111,1,1,1" + "\n");
		    writer.write("zxcv,zxcv,2222,2,2,2" + "\n");
		    writer.close();
		 }
		 catch(Exception e){
		        
		 }

		 String[] user_values = null;
		      
		 try{
		     BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
		     int i=0;
		     while(true){
		        String line = reader.readLine();
		        if(line == null)break;
		        user_values = line.split(",");
		        Client ex_user = new Client(user_values[0],user_values[1],user_values[2],user_values[3],user_values[4]);
		        ex_user.n_th_member = Integer.parseInt(user_values[5]);
		        client_list[i] = ex_user;
		        i++;
		        i_th_client++;
		     }
		     reader.close();
		 }
		 catch(Exception e){
		       
		 }      
	}
	*/
	
	//user라른 객체(몇번째 client인지만 담겨있으면 된다.)를 넘겨주면 user의 client 번호에 해당하는 client를 return 해준다.
	public static Client get_client(Client user){
		int n_th = user.n_th_member;
		return client_list[n_th]; //이게 진짜. 밑에건 임시로.
		//return client_list[0];
	}

	//user라는 객체(id값만 있어도 된다.)를 넘겨주면 그에 해당하는 client의 번호를 return한다.
	public static int isThere(Client user){
		for(int i=0;i<i_th_client; i++){
			if(user.user_id.equals(client_list[i].user_id))
				return i;
		}
		return -1;	// It needs to make
	}
	
	public static int get_i_th_client(){
		return i_th_client;
	}

}


