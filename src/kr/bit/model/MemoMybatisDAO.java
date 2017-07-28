package kr.bit.model;
//JDBC(X)-->Mybatis: API

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemoMybatisDAO {
	private static SqlSessionFactory sqlFactory;
	static {
		try {
			String resource = "kr/bit/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
		 sqlFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}
//----------------------------------------------------------------
	public List<MemoVO> memoList(){
		//SqlSession =>Connection+Statement
		SqlSession session=sqlFactory.openSession();
		List<MemoVO> list=session.selectList("memoList");//id="memoList"-->SQL
		session.close();//¹Ý³³ Connection Pool±â¹ý
		return list;
		
		
	}
	public int memoInsert(MemoVO vo) {
		SqlSession session=sqlFactory.openSession();
		int cnt=session.insert("memoInsert",vo);
		session.commit();
		session.close();
		return cnt;
}
	public MemoVO memoContent(int mnum){
		SqlSession session=sqlFactory.openSession();
		MemoVO vo=session.selectOne("memoContent",mnum);
		session.close();
		return vo;
	}
	public  int memoDelete(int mnum){
		SqlSession session=sqlFactory.openSession();
		int cnt=session.delete("memoDelete",mnum);
		session.commit();
		session.close();
		return cnt;
	}
	public int memoUpdate(MemoVO vo) {
		SqlSession session=sqlFactory.openSession();
		int cnt=session.update("memoUpdate",vo);
		session.commit();
		session.close();
		return cnt;
	}
}
