package com.springbook.view;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.login.LoginService;
import com.springbook.biz.login.LoginVo;
import com.springbook.biz.reply.BookReplyService;
import com.springbook.biz.reply.BookReplyVo;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	private BookReplyService service1;
	
	@RequestMapping(value = "insertLogin.do")
	String Login(LoginVo vo , Model model) {
		
		String addr = vo.getPostcode() + ":" +vo.getRoadAddress() + vo.getDetailAddress();
		vo.setAddress(addr);
		
		service.insert(vo);
		
		
	
		return "index.jsp";	
	}
	
	@RequestMapping(value = "idcheck.do")
	public void idcheck(LoginVo vo ,HttpServletResponse response) throws Exception {
		LoginVo m=service.edit(vo);
		int i;
		if(m==null) {
			i=0; //사용 가능 아이디
		}else {
			i=1;// 중복 아이디
		}
		PrintWriter out=response.getWriter();
		out.print(i);
		
	}
	@RequestMapping(value = "Login.do")
	public void Login(LoginVo vo, HttpServletResponse response , HttpSession session) throws Exception {
		
		LoginVo m=service.login(vo);
	
		int i;
		if(m==null) {
			i=0; //아이디 및 비번 틀림
		}else {
			i=1;// 로그인 성공
			session.setAttribute("id", vo.getId());
		}
		PrintWriter out=response.getWriter();
		out.print(i);
		
		
	}
	
	@RequestMapping(value = "edit.do")
	String edit(LoginVo vo , Model model) {
		System.out.println("controller " +vo);
		LoginVo m=service.getBoard(vo);
		String str[] = m.getAddress().split(":");
		m.setAddress1(str[0]);
		m.setAddress2(str[1]);
		
		model.addAttribute("m", m); 
		
		return "Login/edit.jsp";	
	}
	
	@RequestMapping(value = "update.do")
	String update(LoginVo vo) {
		String addr = vo.getPostcode() + ":" +vo.getRoadAddress() + vo.getDetailAddress();
		vo.setAddress(addr);
	 service.update(vo);
		
		return "index.jsp";	
	}
	@RequestMapping(value = "delete.do")
	public void Login(LoginVo vo, HttpServletResponse response ) throws Exception {
		service.delete(vo);
		PrintWriter out=response.getWriter();
		out.print("success");
		
		
	}
	@RequestMapping(value = "logout.do")
	public String Logout(HttpSession session ) {
		session.invalidate();
		return "index.jsp";
		
	}
	
	  
}
