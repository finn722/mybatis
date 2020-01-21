package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.pojo.Author;

public class AuthorServiceTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	/**
	 * 如果插入相同的记录程序应该如何处理
	 * 1） 是在插入之前先查一遍数据库
	 * 2） 遇到相同名字加生日的作者去做更新操作
	 */
	@Test
	public void authorServiceInsertTest() {
		Author author = Author.builder().name("杜甫").dynasty("唐").birth("公元712").briefDescription("杜甫（712年—770年），字子美，自号少陵野老，唐代伟大的现实主义诗人，与李白合称\"李杜\"。原籍湖北襄阳，后徙河南巩县。 [1-2]  为了与另两位诗人李商隐与杜牧即\"小李杜\"区别，杜甫与李白又合称\"大李杜\"，杜甫也常被称为\"老杜\"。 [1] \r\n" + 
				"杜甫少年时代曾先后游历吴越和齐赵，其间曾赴洛阳应举不第。三十五岁以后，先在长安应试，落第；后来向皇帝献赋，向贵人投赠。官场不得志，亲眼目睹了唐朝上层社会的奢靡与社会危机。天宝十四载（755年），安史之乱爆发，潼关失守，杜甫先后辗转多地。乾元二年（759年）杜甫弃官入川，虽然躲避了战乱，生活相对安定，但仍然心系苍生，胸怀国事。创作了《登高》《春望》《北征》以及\"三吏\"、\"三别\"等名作。虽然杜甫是个现实主义诗人，但他也有狂放不羁的一面，从其名作《饮中八仙歌》不难看出杜甫的豪气干云。\r\n" + 
				"杜甫的思想核心是仁政思想，他有\"致君尧舜上，再使风俗淳”的宏伟抱负。杜甫虽然在世时名声并不显赫，但后来声名远播，对中国文学和日本文学都产生了深远的影响。杜甫共有约1500首诗歌被保留了下来，大多集于《杜工部集》。 [3] \r\n" + 
				"大历五年（770年）冬，杜甫病逝，时年五十九岁。杜甫在中国古典诗歌中的影响非常深远，被后人称为\"诗圣\"，他的诗被称为\"诗史\"。后世称其杜拾遗、杜工部，也称他杜少陵、杜草堂。").build();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertAuthor",author);
		sqlSession.commit();
		sqlSession.close();
	}
	
//	@Test
//	public 
	
	
}
