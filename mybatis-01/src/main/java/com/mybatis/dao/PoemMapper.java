package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.Poem;

public interface PoemMapper {
	
	List<Poem> findAllPoem();
	
	Poem findPoemByTitle(String title);
	
	int insertPoem(Poem poem);
	
	int updatePoemByTitle(Poem poem);
	
	int deletePoemByTitle(String title);

}
