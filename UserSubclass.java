package reminder2;

import java.lang.String;

public abstract class UserSubclass {

	public void showing_send_List(){}
	public void showing_receive_list(){}
	public void set_user_value(String n_id, String n_name, int n_user_account){}
	public void add_send_money(int n_money){}
	public void add_send_list(String sendName,int sendMoney,int sendAccount){}		// ������ ���� ���ƾ� �ϴ� ��� �߰�
	public void add_receive_list(String receiveName,int receiveMoney,int receiveAccount){} // ������ ���� �޾ƾ� �ϴ� ��� �߰�
	public void remove_member(String n_name){}
}
