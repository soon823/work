package 개인프로젝트;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RogDao extends Dao {
	
	private static RogDao instance = new RogDao();
	private RogDao() {}
	public static RogDao getInstance() {
		return instance;
	}
	
	//아이디와 비밀번호 확인
	Rog checkRog(String id, String pw) {
		getOpen();
		String sql = "select mname, responsibility from Rog "
					+"where mid = ? and mpw = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				Rog rog = new Rog();
				rog.setMname(rs.getString("mname"));
				rog.setResponsibility(rs.getString("responsibility"));
				
				return rog;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getClose();
		return null;
	}//end checkRog

	
	
	//목록조회
	List<Rog> RogList(){
		String sql = "Select mid"
					+"		,mpw"
					+"		,mname"
					+"		,tell"
					+"		,responsibility "
					+"from Rog";
		List<Rog> result = new ArrayList<>();
		getOpen();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Rog rog = new Rog();
				rog.setMid(rs.getString("mid"));
				rog.setMpw(rs.getString("mpw"));
				rog.setMname(rs.getString("Mname"));
				rog.setTell(rs.getString("tell"));
				rog.setResponsibility(rs.getString("responsibility"));
				
				result.add(rog);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getClose();
		return result;
	}//end RogList
	
	//회원삭제
	public int delete(Rog rog) {
		getOpen();
		
		String sql = ""
					+"delete "
					+"from rog "
					+"where mname = ? ";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rog.getMname());
			
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getClose();
		return 0;
	}//end delete
	
	//레시피삭제
			public int delete(Bread bread, String bname) {
				getOpen();
				
				String sql1 = ""
							 +"select * from bread ";
				
				String sql = ""
							+"delete "
							+"from bread "
							+"where bname = ? ";
				try {
					
					pstm = conn.prepareStatement(sql1);
					
					rs = pstm.executeQuery();
					while(rs.next()) {
						bread.setBname(rs.getString("bname"));
						bread.setStuff(rs.getString("stuff"));
						bread.setRecipe(rs.getString("recipe"));
						System.out.println(bread);
					}				
								
					System.out.println(bread.getBname());
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, bname);					
					
					int rows = pstm.executeUpdate();
					
					if(rows == 1) {
						System.out.println("삭제");
					}else {
						System.out.println("다시확인");
					}
					
					return rows;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				getClose();
				return 0;
			}//end delete
	
}//end Class
