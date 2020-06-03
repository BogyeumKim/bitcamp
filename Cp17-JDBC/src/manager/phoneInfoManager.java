package manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import phonebook.PhoneInfo_basicDao;
import phonebook.phoneInfo_basic;

public class phoneInfoManager {

	
	PhoneInfo_basicDao dao = new PhoneInfo_basicDao();
	
	Scanner sc = new Scanner(System.in);
	
	
	public void InfoManager() {
		
		
		System.out.println("PhoneInfo_basic Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		
		int select = sc.nextInt();
		
		switch(select) {
		
		case 1:
			System.out.println("전체 리스트 출력");
			basicList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			basicInsert(); // 사용자의 입력데이터 dept 객체에 담아서 dao insert 메서드로 전달
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			baiscSearch(); // 사용자가 입력한 이름을 dao search 전달
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");
			basicDelete(); // 이름 또는 부서번호 dao delete 전달
			break;
		case 5:
			System.out.println("부서 정보를 수정합니다.");
			basicEdit(); // 1. 수정ㅎ고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달
			break;
		
		}
		
		
		
		
	}






	public void basicList() {
		
		Connection conn = null;
		
		List<phoneInfo_basic> basicList = dao.basicList(conn);
		
		if( basicList!=null && !basicList.isEmpty()) {
			
			for(int i=0; i<basicList.size(); i++) {
				System.out.printf("%10s", basicList.get(i).getIdx() + "\t");
				System.out.printf("%12s",  basicList.get(i).getFr_name()+ "\t");
				System.out.printf("%20s", basicList.get(i).getFr_phonenumber() + "\t");
				System.out.printf("%20s", basicList.get(i).getFr_email() + "\t");
				System.out.printf("%20s", basicList.get(i).getFr_address() + "\t");
				System.out.printf("%20s", basicList.get(i).getDate() + "\n");
			}
			
		} else {
			System.out.println("입력된 데이터가 없습니다");
		}
	}
	
	
	public void basicInsert() {
		
		Connection conn=null;
		
		System.out.println("idx :");
		int idx = sc.nextInt();
		System.out.println("이름 :");
		String name=sc.nextLine();
		System.out.println("이메일 :");
		String mail=sc.nextLine()
		System.out.println("휴대폰번호 :");
		String number = sc.nextLine();
		System.out.println("주소 :");
		String add = sc.nextLine();
		System.out.println("시간");
		String date = sc.nextLine();
		
		phoneInfo_basic basic = new phoneInfo_basic(idx, name, number, mail, add, date);
		
		int resultCnt = dao.basicInsert(basic, conn);
		
		if(resultCnt>0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}
		} // insert끝
		
	
	
	
	
	public void baiscSearch() {

		Connection conn=null;
		
		
		System.out.println("검색할 이름을 입력하세요 : ");
		String searchname = sc.nextLine();
		
		List<phoneInfo_basic> list = dao.basicSearch(searchname, conn);
		
		System.out.println("검색 결과");
		System.out.println("======================================");
		for (phoneInfo_basic d : list) {
			System.out.printf("%10s", d.getIdx() + "\t");
			System.out.printf("%12s", d.getFr_name() + "\t");
			System.out.printf("%20s", d.getFr_phonenumber() + "\t");
			System.out.printf("%20s", d.getFr_email() + "\t");
			System.out.printf("%20s", d.getFr_address() + "\n");
		}
		System.out.println("======================================");

		
		
	}
	public void basicDelete() {
		
		Connection conn = null;
		
		System.out.println("삭제하고자 하는 이름");
		
		String searchname = sc.nextLine();
		
		int resultCnt = dao.basicDelete(searchname, conn);
		
		if(resultCnt <1 ) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("=================================");

	}
		
		


	public void basicEdit() {
		
		Connection conn=null;
		try {
			conn.setAutoCommit(false);
			
		System.out.println("수정을 원하는 이름입력 :");
		String searchname=sc.nextLine();
		
		phoneInfo_basic basic2 = dao.basicSearchName(searchname, conn);
		
		if(basic2 ==null ) {
			System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
			return;
			
		}
		
		System.out.println(" 수정을 원하는 이름의 IDX는 "+basic2.getIdx()+"입니다.");
		
		System.out.println("수정할 이름 :");
		String name = sc.nextLine();
		
		System.out.println("수정할 휴대폰번호 :");
		String number = sc.nextLine();
		System.out.println("수정할 이메일 :");
		String mail=sc.nextLine();
		System.out.println("수정할 주소 :");
		String add = sc.nextLine();
		System.out.println("수정할 시간");
		String date = sc.nextLine();
		
		phoneInfo_basic basic = new phoneInfo_basic(basic2.getIdx(), name, number, mail, add, date);
		int resultCnt = dao.basicEdit(basic, conn);
		if (resultCnt > 0) {
			System.out.println("정상적으로 수정 되었습니다.");
			System.out.println(resultCnt + "행이 수정되었습니다.");
		} else {
			System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
		}

		
		
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
}
