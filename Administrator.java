package reminder2;


public class Administrator extends User{
	private Client[] client_list;
	
	Administrator(){
		setUser();
	}
	
	Administrator(String user_id, String user_name, String user_password,String user_number, String user_contact){
		setUser(user_id,user_name,user_password,user_number);
		this.user_contact = user_contact;
	}
	
	@Override
	public String get_id() {
		// TODO Auto-generated method stub
		return user_id;
	}

	@Override
	public String get_name() {
		// TODO Auto-generated method stub
		return this.user_name;
	}
	
	public Client[] get_client(){
		return (Client[]) Member.get_clinet_list();
	}
	
	public Client search_client(String search_name){
		this.client_list = this.get_client();
		for(int i=0;i<client_list.length;i++){
			if(search_name.equals(client_list[i].get_name()))
				return client_list[i];
		}
		return null;
	}
}
