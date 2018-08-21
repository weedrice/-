package reminder2;

public class ReceiveState implements State {
	
	private static ReceiveState m_state = new ReceiveState();
	
	private ReceiveState() {
		
	}
	
	public static State getInstance() {
		return m_state;
	}

	@Override
	public void send(Client user1, Client user2, int send_money, String phone_number, SetState state) {
		// TODO Auto-generated method stub
		state.ChangeState(SendState.getInstance());
		user1.send_list.add_send_list(user2, send_money);
	}

	@Override
	public void receive(Client user1, Client user2, int send_money, String phone_number, SetState state) {
		// TODO Auto-generated method stub
		state.ChangeState(SendState.getInstance());
		user1.receive_list.add_receive_list(user2, send_money);
	}

}
