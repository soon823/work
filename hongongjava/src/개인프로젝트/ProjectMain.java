package 개인프로젝트;

import java.util.List;
import java.util.Scanner;

public class ProjectMain {a
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		RogDao rdao = RogDao.getInstance();
		Rog rog = null;
		JoinDao dao = null;
		int cnt = 0;
		int rogincnt = 0;
		
		boolean run = true;
		
		while(run) {
			
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("				Bakery_Recipe");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("		1.로그인		2.회원가입	3.나가기");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("로그인 후 사용 가능합니다.(비회원 일시 회원가입하여 주세요)	| 선택 >> ");
			int check = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(check) {
			case 1 :
					while(true) {
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("				[로그인 화면]");
						System.out.println("-------------------------------------------------------------------------------");
						System.out.print("아이디 입력 : ");
						String id = sc.nextLine();
						System.out.print("비밀번호 입력 : ");
						String pw = sc.nextLine();
						
						rog = rdao.checkRog(id, pw);
						if(rog != null) {
							System.out.println();
							System.out.println(rog.getMname() + "님 환영합니다.");
							break;
						}
						
						rogincnt ++;
												
						if(rogincnt > 2) {
							System.out.println("연속 3번을 실패하여 강제 종료합니다.");
							return;
						}else {
							System.out.println("아이디와 비밀번호를 다시 확인해주세요");	
						}
					}//end while
					
					if(rog.getResponsibility().equals("User")){
						//User 권한시
						recipeManage();
					}else if(rog.getResponsibility().equals("Admin")) {
						//Admin 권한시
						memberManage();
					}
					
					break;
			case 2 :
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[회원가입 화면]");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.print("사용하실 아이디를 적어주세요. : ");
					String mid = sc.nextLine();
					System.out.print("사용하실 비밀번호를 적어주세요. : ");
					String mpw = sc.nextLine();
					System.out.print("이름을 적어주세요. : ");
					String mname = sc.nextLine();
					System.out.print("전화번호를 적어주세요. ex)010-000-0000 : ");
					String tell = sc.nextLine();
					
					Rog rg = new Rog(mid, mpw, mname, tell);
					dao = new JoinDao();
					cnt = dao.insert(rg);
					
					System.out.println();
					System.out.println("회원가입이 완료 되었습니다.");
					break;
			case 3 : System.out.println("다음에 다시 방문하여 주세요.");
					 return;
			default : System.out.println("1번부터 3번 사이에 번호를 눌러 주세요.");
					  break;
			}//end switch
			
		}//end while
		
	}//end main
	
	
	//User 권한 게시판
	static void recipeManage() {
		
		int dcnt = 0;
		
		while(true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("				[Recipe게시판]");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("	 1.게시글조회	 2.게시글등록	 3.게시글삭제	 4.로그아웃");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print(" 선택 >> ");
			int check = Integer.parseInt(sc.nextLine());
			
			switch(check) {
			case 1 :
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[Bakery_Recipe]");
					System.out.println("-------------------------------------------------------------------------------");
					
					break;
			case 2 :
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[게시글 등록]");
					System.out.println("-------------------------------------------------------------------------------");
					
					break;
			case 3 :
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[게시글 삭제]");
					System.out.println("-------------------------------------------------------------------------------");
					
					break;
			case 4 : System.out.println("로그아웃 하였습니다."); return;
			default : 
					dcnt ++;
					if(dcnt == 1) {System.out.println("1번부터 4번 사이에 번호를 제대로 눌러 주세요.");}
					if(dcnt == 2) {System.out.println("1번부터 4번 사이에 번호를 다시 제대로 눌러 주세요!");}
					if(dcnt == 3) {System.out.println("1번부터 4번 사이에 번호를 다시 제대로 눌러라!");}
					if(dcnt == 4) {System.out.println("1번부터 4번 사이에 번호를 제대로 누르라고!");}
					if(dcnt == 5) {System.out.println("1번부터 4번 사이에 번호를 눌러!");}
					if(dcnt == 6) {System.out.println("1번부터 4번 사이를 누르라고!");}
					if(dcnt == 7) {System.out.println("1번부터 4번 사이!");}
					if(dcnt == 8) {System.out.println("1~4!");}
					if(dcnt == 9) {System.out.println("아 안해 듣지마");}
					if(dcnt > 9 & dcnt < 20) {System.out.println("1-4");}
					if(dcnt == 20) {System.out.println("제정신이냐? 내가 포기한다.");}
					if(dcnt > 20) {System.out.println("1번부터 4번 사이에 번호를 제대로 눌러 주세요.");}
					
					break;					
			}//end switch
			
		}//end while
		
	}//end recipeManage
	
	
	//Admin 권한 회원관리
	static void memberManage() {
		
		RogDao rdao = RogDao.getInstance();
		Rog rog = null;
		
		while(true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("				[관리자 메뉴]");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("		1.회원조회	2.회원추방	3.로그아웃");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print(" 선택 >> ");
			int check = Integer.parseInt(sc.nextLine());
			
			switch(check) {
			case 1 :
					List<Rog> list = rdao.RogList();
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[회원목록]");
					System.out.println("-------------------------------------------------------------------------------");
					for(Rog rog1 : list) {
						System.out.println(rog1.toString());
					}
					break;
			case 2 :
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("			[추방할 회원에 이름을 적어주세요.]");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.print("이름 : ");
					String name = sc.nextLine();
					rog = new Rog();
					rog.setMname(name);
					if(rog.getMname().equals(name)) {
						rdao.delete(rog);
						System.out.println(name + " 쫓아냈습니다.");
					}else {
						System.out.println("이름을 다시 확인하세요.");
					}

					break;
			case 3 :System.out.println("메인으로 돌아갑니다."); return;
			
			default : System.out.println("다시 선택!"); break;
			}//end switch
			
		}//end while
		
	}//end memberManage

}//end class
