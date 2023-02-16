package com.springbook.biz.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookReplyDaoImpl implements BookReplyDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<BookReplyVo> selectAll(BookReplyVo vo) {
		
		return mybatis.selectList("BOOKREPLY.select",vo);
	}

	@Override
	public void insert(BookReplyVo vo) {
		System.out.println("dao : "+vo);
		mybatis.insert("BOOKREPLY.insert",vo);
	}

	@Override
	public void delete(BookReplyVo vo) {
		mybatis.delete("BOOKREPLY.delete",vo);
	}

	@Override
	public void update(BookReplyVo vo) {
		mybatis.update("BOOKREPLY.update",vo);
	}

	@Override
	public BookReplyVo edit(BookReplyVo vo) {
		System.out.println("dao  "+vo);
		return mybatis.selectOne("BOOKREPLY.edit",vo);
	}

	@Override
	public BookReplyVo idxedit(BookReplyVo vo) {
		
		return mybatis.selectOne("BOOKREPLY.idxedit",vo);
	}

}
