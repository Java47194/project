package com.springbook.biz.reply;

import java.util.List;

public interface BookReplyDao {
	List<BookReplyVo> selectAll(BookReplyVo vo);
	void insert(BookReplyVo vo);
	void delete(BookReplyVo vo);
	void update(BookReplyVo vo);
	BookReplyVo edit(BookReplyVo vo);
	BookReplyVo idxedit(BookReplyVo vo);
}
