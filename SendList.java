package reminder2;

public class SendList implements List, Aggregate{
	
	int n_send_list = 0;

	public String[] send_list_name = new String[100]; //���� ���� ��� ���
	public int[] send_list_money = new int[100];
	public String[] send_list_account = new String[100];

	public void search_send(String name)
	{
		for(int i = 0; i < n_send_list ;i++){
			if(send_list_name[i].equals(name)){
				System.out.println(send_list_name[i]);
				System.out.println(send_list_money[i]);
			}
		}
	}

	public void showing_send_list() // ���� ������ �ϴ� ������� ��� ������
	{
		int i;
		
		for(i = 0; i<n_send_list; i++)
		{
			System.out.println(send_list_name[i] + "/" + send_list_money[i]);
		}
		if(i==0)
			System.out.println("No one to send");

	}
	
	//5.16����
	public void add_send_msg(Client current_user,int sendMoney, String contact)		// ������ ���� ���ƾ� �ϴ� ��� �߰�
	{
		MessageFactory m1 = new MessageFactory();
		m1.createMessage(current_user, sendMoney, 0, contact);
	}
	
	public void add_send_list(Client user, int n_money) //����Ʈ�� Client�� money �߰�
	{
		send_list_name[n_send_list] = user.user_name;
		send_list_money[n_send_list] = n_money;
		send_list_account[n_send_list++] = user.user_account;
		
		System.out.println("new send list is added");
	}
	
	public void remove_receive_msg(Client current_user, String contact) //���� �޾ƾ� �ϴ� ������� ��Ͽ��� ����
	{
		if(n_send_list > 0)
		{
			MessageFactory m1 = new MessageFactory();
			m1.createMessage(current_user, 0, 2, contact);
		}
		else
		{
			System.out.println("There is no list to remove");
		}
	}
	
	public void remove_member(Client delete_man) //���� �޾ƾ� �ϴ� ������� ��Ͽ��� ����
	{
		boolean check = false;
		for(int i=0;i<n_send_list;i++)
		{
			if(send_list_name[i].equals(delete_man.user_name))
			{
				System.out.println(send_list_name[i] + " is removed from list");
				send_list_name[i] = send_list_name[n_send_list-1];
				send_list_account[i] = send_list_account[n_send_list-1];
				send_list_money[i] = send_list_money[n_send_list-1];
				n_send_list--;
				check = true;
				break;
			}
		}
		if(check == false)
		{
			System.out.println("There is no " + delete_man.user_name +" in the list");
		}
	}
	public void addMoney(int n_money){}
	public void removeMember(String n_name){}
	
	public void Search(String name){}
	public void ShowingList(){}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new SendListIterator(this);
	}

	public PrintList getList(int index) {
		// TODO Auto-generated method stub
		return new PrintList(send_list_name[index], send_list_account[index], send_list_money[index]);
	}

	@Override
	public void makegroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removegroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showingGroup() {
		// TODO Auto-generated method stub
		
	}

}
