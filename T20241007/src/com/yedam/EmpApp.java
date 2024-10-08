package com.yedam;

import java.util.List;
import java.util.Scanner;


public class EmpApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		EmpDAO dao = null;
		int cnt = 0;
		
		
		while(run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.println("----------------------------------------------------");
			
			System.out.print("메뉴선택 : ");
			int check = Integer.parseInt(sc.nextLine());
			
			switch(check) {
			case 1 :System.out.println("[등록]");
					System.out.print("사번 입력 >> ");
					String member = sc.nextLine();
					System.out.print("이름 입력 >> ");
					String name = sc.nextLine();
					System.out.print("전화번호 입력 >> ");
					String phone = sc.nextLine();
					System.out.print("입사일 입력 >> ");
					String hire = sc.nextLine();
					System.out.print("급여 입력 >> ");
					int salary = Integer.parseInt(sc.nextLine());
					
					Employee emp = new Employee(member, name, phone, hire, salary);
					dao = new EmpDAO();
					cnt = dao.insert(emp);
					
					break;
			case 2 :System.out.println("[목록]");
					dao = new EmpDAO();
					List<Employee> eList = dao.empList();
					for(Employee li : eList) {
					System.out.println(li);
					}
					break;
			case 3 :
					break;
			case 4 :
					break;
			case 5 :
					break;
			case 6 :System.out.println("프로그램 종료");
					return;
			default :System.out.println("잘못 선택 하였습니다 다시 선택 해주세요. "); break;
			}
			
		}

	}//end main

}//end class
