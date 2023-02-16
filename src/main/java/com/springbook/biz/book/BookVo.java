package com.springbook.biz.book;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class BookVo {
	private String id ,writer , tag  , updatefilestr , bname;
	private Date regdate ;
	private int cnt , seq, idx;
	
	private MultipartFile updatefile;
}
	
	
	
