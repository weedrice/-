package reminder2;

public interface State {

	public abstract void send(Client User1, Client User2, int send_money, String phone_number, SetState state); // sending message
	public abstract void receive(Client User1, Client User2, int send_money, String phone_number, SetState state); //receiving message
}
