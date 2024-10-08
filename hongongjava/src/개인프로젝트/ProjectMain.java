package 개인프로젝트;

import java.util.Scanner;

public class ProjectMain {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
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
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("				[로그인 화면]");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.print("아이디 입력 : ");
				
			case 2 :
				
			case 3 : System.out.println("다음에 다시 방문하여 주세요.");
					 return;
			default : System.out.println("1번부터 3번 사이에 번호를 눌러 주세요.");
					  break;
			}//end switch
			
		}//end while
		

	}//end main

}//end class
