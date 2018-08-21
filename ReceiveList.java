package reminder2;

public class ReceiveList implements List, Aggregate{
	int n_receive_list = 0;	//���� �޾ƾ� �ϴ� ����� ��
	public int flag;
	
	public String[] receive_list_account= new String[100]; // ���� �޾ƾ��ϴ� ����� ���¹�ȣ
	public int[] receive_list_money = new int[100];
	public int[] receive_date = new int[100];
	
	public String[] receive_list_name = new String[100]; // ���� �޾ƾ� �ϴ� ��� ���
	public String user_account; // ������ ���¹�ȣ
	public String text_context;
	public String[] receive_phonenum = new String[100]; 
	
	private int index = 0;
	
	public void search_receive(String name)
	{
		for(int i = 0; i < n_receive_list ;i++){
			if(receive_list_name[i].equals(name)){
				System.out.println(receive_list_name[i]);
				System.out.println(receive_list_money[i]);
			}
		}
	}
	
	public void showing_receive_list(Client current_user) // ���� �޾ƾ� �ϴ� ������� ��� ������
	{

		int i;

		for(i=0;i<n_receive_list;i++)
		{
			System.out.println(receive_list_name[i] + "/" + receive_list_account[i] + " " + receive_list_money[i]);
		}
		
		
		if(i==0)
			System.out.println("No one to send");
		
	}
	
	public void add_receive_msg(Client current_user, int receive_money, String contact) // ������ ���� �޾ƾ� �ϴ� ��� �߰�
	{
		MessageFactory m1 = new MessageFactory();
		m1.createMessage(current_user, receive_money, 1, contact);
	}
	
	public void add_receive_list(Client user, int receive_money)
	{
		receive_list_name[n_receive_list] = user.user_name;
		receive_list_money[n_receive_list] = receive_money;
		receive_list_account[n_receive_list++] = user.user_account;
		
		System.out.println("new receive list is added");
	}
	
	public void remove_receive_msg(Client current_user, String contact) //���� �޾ƾ� �ϴ� ������� ��Ͽ��� ����
	{
		if(n_receive_list > 0)
		{
			MessageFactory m1 = new MessageFactory();
			m1.createMessage(current_user, 0, 3, contact);
		}
		else
		{
			System.out.println("There is no list to remove");
		}
		
	}
	
	public void remove_receive_member(Client delete_man) //���� �޾ƾ� �ϴ� ������� ��Ͽ��� ����
	{
		boolean check = false;
		for(int i=0;i<n_receive_list;i++)
		{
			if(receive_list_name[i].equals(delete_man.user_name))
			{
				System.out.println(receive_list_name[i] + " is removed from list");
				receive_list_name[i] = receive_list_name[n_receive_list-1];
				receive_list_account[i] = receive_list_account[n_receive_list-1];
				receive_list_money[i] = receive_list_money[n_receive_list-1];
				n_receive_list--;
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
		return new ReceiveListIterator(this);
	}

	public PrintList getList(int index) {
		// TODO Auto-generated method stub
		return new PrintList(receive_list_name[index], receive_list_account[index], receive_list_money[index]);
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