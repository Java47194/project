package com.springbook.view;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.reply.BookReplyService;
import com.springbook.biz.reply.BookReplyVo;

@Controller
public class BookReplyController {

	@Autowired
	private BookReplyService service;
	
	
	@RequestMapping(value = "bookreplyinsert.do")
	String insert(BookReplyVo vo ,HttpSession session){
		
		service.insert(vo);
		
		
		return "bookboard.do";
			
	}
	
	@RequestMapping(value = "bookreplydelete.do")
	void delete(BookReplyVo vo, HttpServletResponse response ) throws IOException{
		service.delete(vo);
		PrintWriter out =response.getWriter();
		out.print("success");
			
	}
	
}
