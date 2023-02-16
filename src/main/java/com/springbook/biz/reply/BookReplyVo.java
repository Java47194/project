package com.springbook.biz.reply;

import java.util.Date;

import lombok.Data;

@Data
public class BookReplyVo {
	 int seq ,idx , ceq,ref ,ref_level ,ref_step; 
	String  id ,tag;
	 Date replydate;
}
