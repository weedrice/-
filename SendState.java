package reminder2;

public class SendState implements State{
	
	private static SendState m_state = new SendState();
	
	private SendState() {
		
	}
	
	public static State getInstance() {
		return m_state;
	}

	@Override
	public void send(Client user1, Client user2, int send_money, String phone_number, SetState state)
	{
		// TODO Auto-generated method stub
		state.ChangeState(ReceiveState.getInstance());
		user1.send_list.add_send_msg(user2, send_money, phone_number);
	}

	@Override
	public void receive(Client user1, Client user2, int send_money, String phone_number, SetState state) {
		// TODO Auto-generated method stub
		state.ChangeState(ReceiveState.getInstance());
		user1.receive_list.add_receive_msg(user1, send_money, phone_number);
		
	}
}