package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.Security_SHA256;


public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	ArrayList<MemberDTO> arr ;
	public static MemberDAO getInstance(){
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/board");
		return ds.getConnection();
	}
	public String idcheck(String id) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String check="ok";
			try {
				con = getConnection();
				st = con.createStatement();
				String sql = "select * from fmmember where userid='"+id+"'";
				rs = st.executeQuery(sql);
				if(rs.next()) {
					check="no";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con, st,rs);
			}
			System.out.println(check);
			return check.trim();
	}
	public void memberInsert(MemberDTO mb) {
		Connection con= null;
		PreparedStatement ps =  null;
			try {
				con = getConnection();
				String sql = "Insert into fmmember values (?,?,?,?,?,?,?,0,'white')";
				ps = con.prepareStatement(sql);
				ps.setString(1,mb.getUserid());
				ps.setString(2, mb.getPassword());
				ps.setString(3, mb.getName());
				ps.setString(4, mb.getAddr());
				ps.setString(5, mb.getZipcode());
				ps.setString(6, mb.getEmail());
				ps.setString(7, mb.getPhone());
				ps.executeUpdate();
				System.out.println("userid : " + mb.getUserid() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,ps);
			}
			
	}
	public void memberDelete(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "Delete from fmmember where userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeCon(con,ps);
		}
	}
	public void memberUpdate(MemberDTO mb) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "Update fmmember set phone=?,zipcode=?,addr=? where userid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mb.getPhone());
			ps.setString(2, mb.getZipcode());
			ps.setString(3, mb.getAddr());
			ps.setString(4, mb.getUserid());
			ps.executeUpdate();
			System.out.println(mb.getUserid()+"수정완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeCon(con,ps);
		}
	
	}
	public MemberDTO memberView(String userid) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO dto=null;
			try {
				con = getConnection();
				st = con.createStatement();
				String sql = "select * from fmmember where userid='"+userid+"'";
				rs = st.executeQuery(sql);
				if (rs.next()) {
					dto = new MemberDTO();
					dto.setUserid(rs.getString("userid"));
					dto.setName(rs.getString("name"));
					dto.setAddr(rs.getString("addr"));
					dto.setEmail(rs.getString("email"));
					dto.setZipcode(rs.getString("zipcode"));
					dto.setIncome(rs.getInt("income"));
					dto.setPhone(rs.getString("phone"));
					dto.setRank(rs.getString("rank"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con, st,rs);
			}
			return dto;
		}
	
	public boolean memberCheck(String userid) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		boolean flag =false;
			try {
				con = getConnection();
				st = con.createStatement();
				String sql = "select * from fmmember where userid='"+userid+"'";
				rs = st.executeQuery(sql);
				if (rs.next()) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con, st,rs);
			}
			return flag;
		}
	
	
	
	public ArrayList<MemberDTO> memberSearch(String selsch, String textsch){
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		arr = new ArrayList<>();
		try {
			con = getConnection();
			st = con.createStatement();
			String sql="";
			if(textsch=="1"||textsch=="2") {
				int num= Integer.parseInt(textsch);
					sql = "select * from fmmember where " +selsch+"="+num;
				}else {
					sql = "select * from fmmember where " +selsch+" like '%"+textsch+"%'";
				}
			rs = st.executeQuery(sql);
			while (rs.next()) {
				MemberDTO mb = new MemberDTO();
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setPassword(rs.getString("password"));
				mb.setEmail(rs.getString("email"));
				mb.setPhone(rs.getString("phone"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr(rs.getString("addr"));
				arr.add(mb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, st,rs);
		}
		return arr;
	}
	public ArrayList<MemberDTO> memberList(int startRow,int endRow){
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs =null;
		arr = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select * from(select rownum rn,aa.* from(select * from guestbook order by num desc)aa)"
	                 + "where rn >= ? and rn <= ? ";

			  ps = con.prepareStatement(sql);
	           ps.setInt(1, startRow);
	           ps.setInt(2, endRow);
	           
	           rs = ps.executeQuery();

			while (rs.next()) {
				MemberDTO mb = new MemberDTO();
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setPassword(rs.getString("password"));
				mb.setEmail(rs.getString("email"));
				mb.setPhone(rs.getString("phone"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr(rs.getString("addr"));
				arr.add(mb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, ps,rs);
		}
		return arr;
	}
	public ArrayList<MemberDTO> memberList(){
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs =null;
		arr = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select * from fmmember";
			ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

			while (rs.next()) {
				MemberDTO mb = new MemberDTO();
				mb.setName(rs.getString("name"));
				mb.setUserid(rs.getString("userid"));
				mb.setEmail(rs.getString("email"));
				mb.setPhone(rs.getString("phone"));
				mb.setZipcode(rs.getString("zipcode"));
				mb.setAddr(rs.getString("addr"));
				arr.add(mb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, ps,rs);
		}
		return arr;
	}
	//占쏙옙찾占쏙옙
	public ArrayList<ZipcodeDTO> zipSearch(String dong){
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		String sql="";
		ArrayList<ZipcodeDTO> arr = new ArrayList<ZipcodeDTO>();
		System.out.println(sql);
		try {
			con = getConnection();
			sql ="select * from  zipcode where dong like '%"+dong+"%'";
			 st = con.createStatement();
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	        	 ZipcodeDTO z = new ZipcodeDTO();
	        	 z.setZipcode(rs.getString("zipcode"));
	        	 z.setSido(rs.getString("sido"));
	        	 z.setGugun(rs.getString("gugun"));
	        	 z.setDong(rs.getString("dong"));
	        	 z.setBunji(rs.getString("bunji"));
	      
	        	 
	        	 arr.add(z);
	         }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, st, rs);
		}
		return arr;
	}
	public HashMap<String,String> gethm(){
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		HashMap<String, String> hm = new HashMap<String, String>();
		arr = new ArrayList<>();
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from fmmember";
			rs = st.executeQuery(sql);
			while (rs.next()) {	
				hm.put(rs.getString("userid"),rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCon(con, st,rs);
		}
		return hm;
	}
	public int AdminCheck(String userid) {
		int admin =0;
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		arr = new ArrayList<>();
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select admin from fmmember where userid='"+userid+"'";
			rs = st.executeQuery(sql);
			if (rs.next()) {	
				admin =rs.getInt("admin");
				System.out.println(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCon(con, st,rs);
		}
		return admin;
	}
	public int userCheck(String userid, String pwd) {
		int result = 0 ;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "select password from fmmember where userid= '"+userid+"'";
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getString("password").equals(pwd)) {
					result =  1;
				}
				else
					result = -1;
			}
			else
				result = -10;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, st, rs);
		}
		return result;
	}
	public String getName(String userid) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String name = null;
		
		try {
			String sql = "select name from fmmember where userid = ?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeCon(con, ps, rs);
		}
		finally {
			closeCon(con, ps, rs);
		}
		
		return name;
	}
	
	public String getID(String name, String email, String phone) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String id = null;
		
		try {
			String sql = "select userid from fmmember where name= ? and email= ? and phone= ?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("userid");
			}
			else 
				id= "-1";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeCon(con, ps, rs);
		}
		return id;
	}
	
	public int getPWD(String userid, String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result =0;
		
		try {
			String sql = "select password from fmmember where userid= ? and email= ?";
			con = getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			else {
				result =-1;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeCon(con, ps, rs);
		}
		return result;
	}
	public void updatePWD(String userid, String num) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("기존 인증번호(넘): " +num);
		Security_SHA256 sha = new Security_SHA256();
		num = sha.encriptSHA256(num);
		System.out.println("암호화 이후 : " + num);
		String sql = "update fmmember set password = ? where userid = ?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, userid);
			ps.executeQuery();
			System.out.println(userid +"비번 변경성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, ps);
		}
		
	}
	


			
	private void closeCon(Connection con, PreparedStatement ps){
		
		try {
			if(con!=null)con.close();
			if(ps!=null)ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
private void closeCon(Connection con,Statement st, ResultSet rs){
	
	try {
		if(con!=null)con.close();
		if(st!=null)st.close();
		if(rs!=null)rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void closeCon(Connection con,PreparedStatement ps, ResultSet rs){
	
	try {
		if(con!=null)con.close();
		if(ps!=null)ps.close();
		if(rs!=null)rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}





	

}
