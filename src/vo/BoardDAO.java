package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.BoardVO;
import vo.CommentVO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/board");
		return ds.getConnection();
	}
	//updateboard
	   public void updateBoard(int BOARD_NUM,String BOARD_PASS,String BOARD_SUBJECT,String BOARD_CONTENT) {
	      Connection con =null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Statement st = null;
	      String sql="";
	      boolean b=false;
	         try {
		            if(rs.getString("BOARD_PASS").equals(BOARD_PASS)) {
		         		sql = "update fmboard set BOARD_SUBJECT='"+BOARD_SUBJECT+"',BOARD_CONTENT='"+BOARD_CONTENT+"' where BOARD_NUM="+BOARD_NUM;
		         		st = con.createStatement();
		                 st.executeQuery(sql);
			         	b = true;
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            closeCon(con,ps,rs);
	         }
		
	   }
	//delboard
	public void delBoard(int BOARD_NUM,String BOARD_PASS) {
	      Connection con =null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql="";
	      boolean b=false;
	         try {
	        	 		con=getConnection();
	            		sql = "delete from fmboard where BOARD_NUM=?";
		            	 PreparedStatement ps1 =con.prepareStatement(sql); 
		            	 ps1.setInt(1, BOARD_NUM);
		            	 ps1.executeUpdate();
		            	 b = true;
	        
	         } catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            closeCon(con,ps,rs);
	         }
	   }
//read count
	   public void updateReadCount(int board_num){
		    Connection con= null;
			PreparedStatement ps = null;
			int updateCount = 0;
			String sql="update fmboard set BOARD_READCOUNT = "+
					"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;
			try{
				con = getConnection();
				ps=con.prepareStatement(sql);
				updateCount = ps.executeUpdate();
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			finally{
				closeCon(ps);
			}
		}
	//board count
	public int boardCount() {
		int count = 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select count(*) from fmboard";
			rs = st.executeQuery(sql);
			if(rs.next())
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCon(con, st, rs);
		}
		return count;
	}
	//reply
	public void boardReply(BoardVO bv,int num) {
		Connection con= null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        String sql="";
        int number=1;
           try {
					con = getConnection();
					ps=con.prepareStatement("select max(board_re_seq) from fmboard where board_re_ref="+bv.getBOARD_RE_REF());
					rs=ps.executeQuery();
					if(rs.next()) {
						number =rs.getInt(1)+1;
					}
					int ref = bv.getBOARD_RE_REF();
					int re_seq = bv.getBOARD_RE_SEQ();
					int re_level= bv.getBOARD_RE_LEV();
						re_seq=re_seq+1;
						re_level=re_level+1;
					    //insert
						sql = "insert into fmboard values(board_seq.nextval,?,?,?,?,?,?,?,?,0,sysdate)";
			            ps = con.prepareStatement(sql);
			              System.out.println(sql);
			              ps.setString(1, bv.getBOARD_NAME());
			              ps.setString(2, bv.getBOARD_PASS());
			              ps.setString(3, bv.getBOARD_SUBJECT());
			              ps.setString(4, bv.getBOARD_CONTENT());
			              ps.setString(5, bv.getBOARD_OPEN());
			              ps.setInt(6,bv.getBOARD_RE_REF());
			              ps.setInt(7,re_level);
			              ps.setInt(8, number);
			              ps.executeQuery();
			           } catch (Exception e) {
			              // TODO Auto-generated catch block
			              e.printStackTrace();
			           }finally {
			              closeCon(con,ps,rs);
			           }    
				}
	//board insert function
	public void boardInsert(BoardVO bv) {
        Connection con= null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        String sql="";
           try {
              con = getConnection();
              sql = "insert into fmboard values(board_seq.nextval,?,?,?,?,?,board_seq.nextval,0,0,0,sysdate)";
              ps = con.prepareStatement(sql);
              System.out.println(sql);
              ps.setString(1, bv.getBOARD_NAME());
              ps.setString(2, bv.getBOARD_PASS());
              ps.setString(3, bv.getBOARD_SUBJECT());
              ps.setString(4, bv.getBOARD_CONTENT());
              ps.setString(5, bv.getBOARD_OPEN());
              ps.executeQuery();
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }finally {
              closeCon(con,ps,rs);
           }    
     }
	//boardList check
	public ArrayList<BoardVO> boardList(int startRow, int endRow) {
	   Connection con= null;
	   Statement st = null;
	   ResultSet rs = null; 
	   ArrayList<BoardVO> arr = new ArrayList<>();
	   String sql="";
	   try {
	     con = getConnection();
	     sql = "select * from (select rownum rn,aa.* from (select * from fmboard order by board_re_ref desc,board_re_seq asc)aa) where rn>="+startRow+" and rn<="+endRow+" and board_pass!='master'";
		 st = con.createStatement();
		 rs = st.executeQuery(sql);
		 while(rs.next()) {
			 BoardVO b = new BoardVO();
			 b.setBOARD_NUM(rs.getInt("BOARD_NUM"));
			 b.setBOARD_NAME(rs.getString("BOARD_NAME"));
			 b.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
			 b.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			 b.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT")); 
			 b.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
			 b.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
			 b.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
			 b.setBOARD_OPEN(rs.getString("BOARD_OPEN"));
			 arr.add(b);
	     }
	  } catch (Exception e) {
	    e.printStackTrace();
	  }finally {
	     closeCon(con,st,rs);
	  }
	  return arr;
	}
	//noticelist
	public ArrayList<BoardVO> noticeList() {
		   Connection con= null;
		   Statement st = null;
		   ResultSet rs = null; 
		   ArrayList<BoardVO> arr = new ArrayList<>();
		   String sql="";
		   try {
		     con = getConnection();
		     sql = "select * from fmboard where board_pass='master'";
			 st = con.createStatement();
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				 BoardVO b = new BoardVO();
				 b.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				 b.setBOARD_NAME(rs.getString("BOARD_NAME"));
				 b.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				 b.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				 b.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT")); 
				 b.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				 b.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				 b.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				 b.setBOARD_OPEN(rs.getString("BOARD_OPEN"));
				 arr.add(b);
		     }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }finally {
		     closeCon(con,st,rs);
		  }
		  return arr;
		}
	//board view
	public BoardVO boardView(int num) {
		   Connection con= null;
		   Statement st = null;
		   ResultSet rs = null;
		   BoardVO b = null;
		   String sql="";
		   try {
		     con = getConnection();
		     sql = "select * from fmboard where BOARD_NUM="+num;
			 st = con.createStatement();
			 rs = st.executeQuery(sql);
			 if(rs.next()) {
				 b = new BoardVO();
				 b.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				 b.setBOARD_NAME(rs.getString("BOARD_NAME"));
				 b.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				 b.setBOARD_PASS(rs.getString("BOARD_PASS")); 
				 b.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				 b.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				 b.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				 b.setBOARD_OPEN(rs.getString("BOARD_OPEN"));
				 b.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				 b.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				 b.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				 b.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
		     }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }finally {
		     closeCon(con,st,rs);
		  }
		  return b;
		}
	//comment insert
	   public void commentInsert(CommentVO cb) {
	       Connection con= null;
	       PreparedStatement ps =  null;
	       ResultSet rs = null;
	       String sql="";
	          try {
	             con = getConnection();
	             sql = "insert into fmcommentboard (cnum,userid,regdate,msg,bnum) values(commentboard_seq.nextval,?,sysdate,?,?)";
	             System.out.println(sql);
	             ps = con.prepareStatement(sql);
	             ps.setString(1, "ID");
	             ps.setString(2, cb.getMsg());
	             ps.setInt(3, cb.getBnum());
	             ps.executeUpdate();
	          } catch (Exception e) {
	            e.printStackTrace();
	          }finally {
	             closeCon(con,ps,rs);
	          }
	    }
	   //commentList return
	  public ArrayList<CommentVO> commentList(int bnum){
		  Connection con= null;
		   Statement st = null;
		   ResultSet rs = null; 
		   ArrayList<CommentVO> arr = new ArrayList<>();
		   String sql="";
		   try {
		     con = getConnection();
		     sql = "select * from fmcommentboard where bnum="+bnum;
		     System.out.println(sql);
			 st = con.createStatement();
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				CommentVO c = new CommentVO();
				c.setCnum(rs.getInt("cnum"));
				c.setBnum(rs.getInt("bnum"));
				c.setMsg(rs.getString("msg"));
				c.setRegdate(rs.getString("regdate"));
				c.setUserid("ID");
				 arr.add(c);
		     }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }finally {
		     closeCon(con,st,rs);
		  }
		  return arr;
	  }
	//
	private void closeCon(Connection con, PreparedStatement ps){
	      try {
	         if(con!=null)con.close();
	         if(ps!=null)ps.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	}
	private void closeCon(PreparedStatement ps){
	      
	      try {
	         if(ps!=null)ps.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	}
	private void closeCon(Connection con,Statement st, ResultSet rs){  
	   try {
	      if(con!=null)con.close();
	      if(st!=null)st.close();
	      if(rs!=null)rs.close();
	   } catch (SQLException e) {
	      e.printStackTrace();
	   }
	}
}
