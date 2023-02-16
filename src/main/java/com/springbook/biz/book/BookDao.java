package com.springbook.biz.book;

import java.util.List;

public interface BookDao  {
	BookVo edit(BookVo vo);
	void insert(BookVo vo);
	void delete(BookVo vo);
	void update(BookVo vo);
	List<BookVo >select(BookVo vo);
	BookVo board(BookVo vo);
	BookVo getboard(BookVo vo);

}
