package kr.bit.model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemoDAO {//JDBC--->DBC<------myBatis(0)
   private Connection conn;
   private PreparedStatement ps;
   private ResultSet rs;
   
   public Connection getConnect(){
	   String url="jdbc:mysql://127.0.0.1:3306/mysql";
	   String user="root";
	   String password="!BitCom0228";
	   
	  try {
		  //                      DriverManager
		Class.forName("org.gjt.mm.mysql.Driver");
		 conn=DriverManager.getConnection(url,user,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return conn;
	   
   }
   //CRUD Method~~

public List<MemoVO> memoList() {
	String SQL="select*from memo order by mnum desc";
	conn=getConnect();
	List<MemoVO> list=new ArrayList<MemoVO>();
	try {
		ps=conn.prepareStatement(SQL);
		rs=ps.executeQuery();
		while(rs.next()){
		     int mnum=rs.getInt("mnum");
		     String mname=rs.getString("mname");
		     String mcontent=rs.getString("mcontent");
		     Date mday=rs.getDate("mday");
		     //vo(¹­°í)-->List(´ã°í)
		     MemoVO vo=new MemoVO(mnum,mname,mcontent,mday);
		     list.add(vo);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
	
}

public int memoInsert(MemoVO vo) {
	String SQL="insert into memo(mname,mcontent)values(?,?)";
	conn=getConnect();
	int cnt=0;
	try {
		ps=conn.prepareStatement(SQL);
		ps.setString(1,vo.getMname());
		ps.setString(2, vo.getMcontent());
		cnt=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cnt;
	
}

public MemoVO memoContent(int mnum) {
	String SQL="select*from memo where mnum=?";
	conn=getConnect();
	MemoVO vo=null;
	try {
		ps=conn.prepareStatement(SQL);
		ps.setInt(1, mnum);
		rs=ps.executeQuery();
		
		if(rs.next()){
			mnum=rs.getInt("mnum");
			String mname=rs.getString("mname");
			String mcontent=rs.getString("mcontent");
			Date mday=rs.getDate("mday");
			//vo·Î¹­°í
			vo=new MemoVO(mnum,mname,mcontent,mday);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return vo;
}
public  int memoDelete(int num){
	String SQL="delete from memo where mnum=?";
	conn=getConnect();
	int cnt=0;
	try {
		ps=conn.prepareStatement(SQL);
		ps.setInt(1,num);
		cnt=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cnt;
}

public int memoUpdate(MemoVO vo) {
	
	String SQL="update memo set mcontent=? where mnum=?";
    conn=getConnect();
    int cnt=0;
    try {
		 ps=conn.prepareStatement(SQL);
		 ps.setString(1, vo.getMcontent());
		 ps.setInt(2, vo.getMnum());
		 cnt=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cnt;
}

}
















