package com.springbook.biz.book;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public BookVo edit(BookVo vo) {
		
		return mybatis.selectOne("BOOK.edit",vo);
	}

	@Override
	public void insert(BookVo vo) {
		mybatis.insert("BOOK.insert",vo);
	}

	@Override
	public void delete(BookVo vo) {
		mybatis.delete("BOOK.delete",vo);
		
	}

	@Override
	public void update(BookVo vo) {
		System.out.println("dao : " +vo);
		mybatis.update("BOOK.update",vo);
		
	}

	@Override
	public List<BookVo> select(BookVo vo) {
		
		return mybatis.selectList("BOOK.select",vo);
	}

	@Override
	public BookVo board(BookVo vo) {
		
		return mybatis.selectOne("BOOK.board",vo);
	}

	@Override
	public BookVo getboard(BookVo vo) {
	
		return mybatis.selectOne("BOOK.getboard",vo);
	}

}
