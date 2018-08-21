package reminder2;

import java.util.Scanner;

public class Client extends User implements SetState{

	Scanner sc = new Scanner(System.in);
	
	protected String user_account;
	protected ReceiveList receive_list;
	protected SendList send_list;
	protected String[] send_msg_box;		//보낸 메시지함
	protected String[] receive_msg_box;		//받은 메시지함
	protected int n_th_member;			//몇 번째 member인지 저장
	
	private State state = SendState.getInstance();
	
	Client(){
		setUser();
		this.user_account = null;
		this.receive_list = new ReceiveList();
		this.send_list = new SendList();
		n_th_member = 0;
	}
	
	Client(String user_id, String user_name, String user_password, String user_contact, String user_account){
		setUser(user_id,user_name,user_password,user_contact);
		this.user_account = user_account;
		this.receive_list = new ReceiveList();
		this.send_list = new SendList();
		n_th_member = 0;
	}
	
	
	@Override
	public String get_id() {
		// TODO Auto-generated method stub
		return this.user_id;
	}

	@Override
	public String get_name() {
		// TODO Auto-generated method stub
		return this.user_name;
	}

	public List get_receive_list() {
		// TODO Auto-generated method stub
		return this.receive_list;
	}

	public List get_send_list() {
		// TODO Auto-generated method stub
		return this.send_list;
	}
	
	public void add_receive_list(Client add_man, int send_money, String phone_number){ // send message to member adding receive list
		//test
		state = SendState.getInstance();
		state.receive(this, null, send_money, phone_number, this);
	}

	public void add_send_list(Client add_man, int send_money, String phone_number){ // send message to member adding send list
		//test
		state = SendState.getInstance();
		state.send(this, add_man, send_money, phone_number, this);
	}
	
	public void receive_added_list(Client add_man, int send_money) { // add information to receive list
		state = ReceiveState.getInstance();
		state.receive(this, add_man, send_money, null, this); 
	}

	public void send_added_list(Client add_man, int send_money) { // add information to send list
		state = ReceiveState.getInstance();
		state.send(this, add_man, send_money, null, this);
	}
	
	public void receive_delete_list(Client delete_man, String phone_number) // send message to member deleting receive list
	{
		this.receive_list.remove_receive_msg(delete_man, phone_number);
	}
	
	public void send_delete_list(Client delete_man, String phone_number) // send message to member deleting send list
	{
		this.send_list.remove_receive_msg(delete_man, phone_number);
	}
	
	public void delete_receive_list(Client delete_man){ // delete information from receive list
		this.receive_list.remove_receive_member(delete_man);
	}

	public void delete_send_list(Client delete_man){ // delete information from send list
		this.send_list.remove_member(delete_man);
	}
	
	public void show_receive_list(){
		System.out.println("Receive List");
		//receive_list.showing_receive_list(this);
		Iterator iterator = receive_list.iterator();
		while(iterator.hasNext()){
			PrintList lst = iterator.next();
			System.out.println("Account: " + lst.account + "\nMoney: " + lst.money);
		}
	}
	
	public void show_send_list(){
		System.out.println("send List");
		//send_list.showing_send_list();
		Iterator iterator = send_list.iterator();
		while(iterator.hasNext()){
			PrintList lst = iterator.next();
			System.out.println("Account: "+ lst.account + "\nMoney: " + lst.money);
		}
	}

	@Override
	public void ChangeState(State state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	
	
	
}
