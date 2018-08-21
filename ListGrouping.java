package reminder2;

import java.util.Scanner;

public class ListGrouping implements List{

	Scanner sc = new Scanner(System.in);
	public int n_group = 0;
	public String[] R_GroupName = new String[100];
	public int[][] R_GroupNum = new int[100][100];
	
	public void makegroup(){
		ReceiveList R_list = new ReceiveList();
		System.out.println("받을 사람 그룹 이름을 설정하시오");
		String groupname = sc.nextLine();
		R_GroupName[n_group] = groupname;
		while(true){
			int p = 0;
			System.out.println("그룹에 추가할 사람 번호를 입력하시오./종료:0입력");
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
					System.out.println("그런 사람 없습니다.");
				}
			}
		}
		System.out.println("그룹 생성이 완료되었습니다.");
		n_group++;
	}
	public void removegroup(){
		System.out.println("삭제하실 그룹 이름을 입력하십시오.");
		String groupname = sc.nextLine();
		for(int i = 0; i <n_group ;i++){
			if(R_GroupName[i].equals(groupname)){
				R_GroupName[i]=R_GroupName[n_group-1];
				for(int j = 0; j<100;j++){
					R_GroupNum[i][j] = R_GroupNum[n_group-1][j];
				}
			}
			else{
				System.out.println("그런 그룹 없습니다.");
			}
		}
		System.out.println("그룹이 삭제되었습니다.");
		n_group--;
	}
	public void showingGroup(){
		
		System.out.println("저장된 그룹입니다.");
		for(int i = 0; i<n_group;i++){
			System.out.println(""+R_GroupName[i]);
		}
	}
	public void showingGroupMember(){
		int k=0;
		System.out.println("열람하고 싶은 그룹을 입력하세요.");
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
			System.out.println("그런 그룹 없습니다.");
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
