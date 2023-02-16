package com.springbook.biz.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;
	
	@Override
	public BookVo edit(BookVo vo) {
		
		return dao.edit(vo);
	}

	@Override
	public void insert(BookVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(BookVo vo) {
		dao.delete(vo);
	}

	@Override
	public void update(BookVo vo) {
		System.out.println("service : " +vo);
		dao.update(vo);
		
	}

	@Override
	public List<BookVo> select(BookVo vo) {
		
		return dao.select(vo);
	}

	@Override
	public BookVo board(BookVo vo) {
		
		return dao.board(vo);
	}

	@Override
	public BookVo getboard(BookVo vo) {
		
		return dao.getboard(vo);
	}

}
