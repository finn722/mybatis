package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.pojo.Poem;

public class PoemServiceTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
   
	@Test
    public void poemServiceQueryTest() throws IOException{
    	SqlSession session = sqlSessionFactory.openSession();
    	List<Poem> poems = session.selectList("findAllPoems");
    	System.out.println(poems);
    }
	@Test
	public void poemServiceQueryTest1() {
		String title = "满江红";
		SqlSession session = sqlSessionFactory.openSession();
		Poem poem = session.selectOne("findPoemByTitle", title);
		System.out.println(poem);
	}
	@Test
	public void poemServiceInsertTest() {
		String title ="行路难·其一";
		String content = "金樽清酒斗十千，玉盘珍羞直万钱。停杯投箸不能食，拔剑四顾心茫然。欲渡黄河冰塞川，将登太行雪满山。闲来垂钓碧溪上，忽复乘舟梦日边。行路难！行路难！多歧路，今安在？长风破浪会有时，直挂云帆济沧海。";
		Poem poem = new Poem();
		poem.setTitle(title);
		poem.setContent(content);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i = sqlSession.insert("insertPoem", poem);
		System.out.println("插入的行数： " + i);
		sqlSession.commit(); // 别忘了commit， 不commit 数据库时无法存储的
		sqlSession.close();
	}
	
	@Test
	public void poemServiceInsertTest1() {
		String title = "三五七言 / 秋风词";
		Poem poem = new Poem();
		poem.setTitle(title);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i = sqlSession.insert("insertPoem", poem);
		System.out.println("插入的行数： " + i);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Test
	public void poemServiceUpdateTest() {
		String content = "秋风清，秋月明，落叶聚还散，寒鸦栖复惊。相思相见知何日？此时此夜难为情！入我相思门，知我相思苦，长相思兮长相忆，短相思兮无穷极，早知如此绊人心，何如当初莫相识。";
		String title = "三五七言 / 秋风词";
		Poem poem = new Poem();
		poem.setTitle(title);
		poem.setContent(content);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i = sqlSession.update("updatePoemByTitle",poem);
		System.out.println("更新的行数： " + i);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	@Test
	public void poemServiceDeleteTest() {
		String title = "三五七言 / 秋风词";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i = sqlSession.delete("deletePoemByTitle",title);
		System.out.println("删除的行数： " + i);
		sqlSession.commit();
		sqlSession.close();
		
	}
	

}
