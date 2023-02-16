package com.springbook.biz.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReplyServiceImpl implements BookReplyService {

	@Autowired
	BookReplyDao dao;
	
	@Override
	public List<BookReplyVo> selectAll(BookReplyVo vo) {
		
		return dao.selectAll(vo);
	}

	@Override
	public void insert(BookReplyVo vo) {
		System.out.println("ser : "+vo);
		dao.insert(vo);
		
	}

	@Override
	public void delete(BookReplyVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public void update(BookReplyVo vo) {
		dao.update(vo);
		
	}

	@Override
	public BookReplyVo edit(BookReplyVo vo) {
		System.out.println("ser  "+vo);
		return dao.edit(vo);
	}

	@Override
	public BookReplyVo idxedit(BookReplyVo vo) {
	
		return dao.idxedit(vo);
	}

}
