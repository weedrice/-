package reminder2;

public class ReceiveListIterator implements Iterator{
	private ReceiveList receive_list;
	private int index = 0;
	
	public ReceiveListIterator(ReceiveList receive_list){
		this.receive_list = receive_list;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index < receive_list.n_receive_list)
			return true;
		else
			return false;
	}

	@Override
	public PrintList next() {
		// TODO Auto-generated method stub
		PrintList lst = receive_list.getList(index);
		index++;
		return lst;
	}
}
