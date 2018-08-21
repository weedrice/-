package reminder2;

public class SendListIterator implements Iterator{
	private SendList send_list;
	private int index = 0;
	
	public SendListIterator(SendList send_list){
		this.send_list = send_list;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index<send_list.n_send_list)
			return true;
		else
			return false;
	}

	@Override
	public PrintList next() {
		// TODO Auto-generated method stub
		PrintList lst = send_list.getList(index);
		index++;
		return lst;
	}

}
