package com.springbook.view;



import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.book.BookService;
import com.springbook.biz.book.BookVo;
import com.springbook.biz.login.LoginService;
import com.springbook.biz.login.LoginVo;
import com.springbook.biz.reply.BookReplyService;
import com.springbook.biz.reply.BookReplyVo;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private LoginService Loginservice;
	
	@Autowired
	private BookReplyService BookReplyservice;
	
	@Autowired
	private HttpServletRequest request;
	
	String path="";
	
	String timestr="";
	
	BookController(){
	 Long time1 =System.currentTimeMillis();
	 SimpleDateFormat date= new SimpleDateFormat("hhmmss");
	 timestr= date.format(time1);
	}
	

	@RequestMapping(value ="bookinsert.do")
	public String insert(BookVo vo) throws IllegalStateException, IOException{
		
		path= request.getSession().getServletContext().getRealPath("/book/files/");
		System.out.println(path);
		
		MultipartFile updatefile= vo.getUpdatefile();
		String fileName=updatefile.getOriginalFilename();
		File f = new File(path+fileName);
		
		if(!updatefile.isEmpty()) {
		if(f.exists()) {
			String fileN = fileName.substring(0,fileName.lastIndexOf("."));
			String extension=fileName.substring(fileName.lastIndexOf("."));
			fileName=fileN +"_"+ timestr+extension; 
			
			updatefile.transferTo(new File(path+fileName));
		}else {
			updatefile.transferTo(new File(path+fileName));
		}
		}else {
			fileName="space.jpg";
		}
		
		vo.setUpdatefilestr(fileName);
		service.insert(vo);
		
		return "index.jsp";
	
		
	}

	@RequestMapping(value ="bookselect.do")
	public String insert2(BookVo vo , Model model, BookReplyVo vo1){
		
		model.addAttribute("li", service.select(vo));
		
		return "book/select.jsp";
		
	}
	
	@RequestMapping(value ="bookedit.do")
	public String edit(BookVo vo , Model model ){
		model.addAttribute("m", service.edit(vo));
		return "book/edit.jsp";
		
	}
	@RequestMapping(value ="bookboard.do")
	public String board(BookVo vo , Model model , BookReplyVo vo1 ,HttpSession session ){

		model.addAttribute("m", service.board(vo));
		
		model.addAttribute("li", BookReplyservice.selectAll(vo1));
		
		BookVo m =service.getboard(vo);
		
		session.setAttribute("id1", m.getId());
		
		return "book/board.jsp";
		
	}

	@RequestMapping(value ="bookdelete.do")
	public void delete(BookVo vo , HttpServletResponse response , Model model) throws IOException{
	  path=request.getSession().getServletContext().getRealPath("/book/files/");
	  

	  vo= service.getboard(vo);
	 
	 
	  String delFile = vo.getUpdatefilestr();
	  
	  File f= new File(path +delFile);
	  
	  if(!delFile.equals("space.jpg")) {
		  if(f.exists()) {
			  f.delete();
		  }
	  }
	  service.delete(vo);
		

	  PrintWriter out=response.getWriter();
	  out.print("success");
	}
	
	@RequestMapping(value ="bookupdate.do")
	public String update(BookVo vo , Model model) throws IllegalStateException, IOException {
		path=request.getSession().getServletContext().getRealPath("/book/files/");
		
		MultipartFile updatefile=vo.getUpdatefile();
		String fileName =updatefile.getOriginalFilename();
		
		File f =new File(path+fileName);
		
		if(!updatefile.isEmpty()) {
			
			BookVo m =service.getboard(vo);
			File delfile=new File(path + m.getUpdatefilestr());
			if(!m.getUpdatefilestr().equals("space.jpg")) {
				if(delfile.exists()) {
					delfile.delete();
				}
			}
			
			if(f.exists()) {
				String Nfile=fileName.substring(0,fileName.lastIndexOf("."));
				String extension=fileName.substring(fileName.lastIndexOf("."));
				fileName=Nfile+"_"+timestr+extension;
				updatefile.transferTo(new File(path+fileName));
			}else {
				updatefile.transferTo(new File(path+fileName));
			}
		}else {
			if(updatefile.isEmpty()) {
				BookVo m =service.getboard(vo);
				fileName = m.getUpdatefilestr();
				
			}else {
			fileName="space.jpg";
			}
		}
		vo.setUpdatefilestr(fileName);
		service.update(vo);
		
		return "bookselect.do";
		
	}
	
	
}
