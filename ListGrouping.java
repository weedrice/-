package reminder2;

import java.util.Scanner;

public class ListGrouping implements List{

	Scanner sc = new Scanner(System.in);
	public int n_group = 0;
	public String[] R_GroupName = new String[100];
	public int[][] R_GroupNum = new int[100][100];
	
	public void makegroup(){
		ReceiveList R_list = new ReceiveList();
		System.out.println("���� ��� �׷� �̸��� �����Ͻÿ�");
		String groupname = sc.nextLine();
		R_GroupName[n_group] = groupname;
		while(true){
			int p = 0;
			System.out.println("�׷쿡 �߰��� ��� ��ȣ�� �Է��Ͻÿ�./����:0�Է�");
			int phone = sc.nextInt();
			if(phone == 0)
				break;
			for(int i = 0; i <R_list.n_receive_list ;i++){
				if(R_list.receive_phonenum[i].equals(phone)){
					p++;
					R_GroupNum[n_group][p] = phone;
					R_GroupNum[n_group][0] = p;
				}
				else{
					System.out.println("�׷� ��� �����ϴ�.");
				}
			}
		}
		System.out.println("�׷� ������ �Ϸ�Ǿ����ϴ�.");
		n_group++;
	}
	public void removegroup(){
		System.out.println("�����Ͻ� �׷� �̸��� �Է��Ͻʽÿ�.");
		String groupname = sc.nextLine();
		for(int i = 0; i <n_group ;i++){
			if(R_GroupName[i].equals(groupname)){
				R_GroupName[i]=R_GroupName[n_group-1];
				for(int j = 0; j<100;j++){
					R_GroupNum[i][j] = R_GroupNum[n_group-1][j];
				}
			}
			else{
				System.out.println("�׷� �׷� �����ϴ�.");
			}
		}
		System.out.println("�׷��� �����Ǿ����ϴ�.");
		n_group--;
	}
	public void showingGroup(){
		
		System.out.println("����� �׷��Դϴ�.");
		for(int i = 0; i<n_group;i++){
			System.out.println(""+R_GroupName[i]);
		}
	}
	public void showingGroupMember(){
		int k=0;
		System.out.println("�����ϰ� ���� �׷��� �Է��ϼ���.");
		String groupname = sc.nextLine();
		for(int i = 0; i <n_group ;i++){
			if(R_GroupName[i].equals(groupname)){
				for(int j = 0; j<R_GroupNum[i][0] + 1;j++){
					System.out.println(""+R_GroupNum[i][j]);
					k=1;
				}
			}
		}
		if(k==0)
			System.out.println("�׷� �׷� �����ϴ�.");
	}
	@Override
	public void addMoney(int n_money) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeMember(String n_name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Search(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ShowingList() {
		// TODO Auto-generated method stub
		
	}
}
