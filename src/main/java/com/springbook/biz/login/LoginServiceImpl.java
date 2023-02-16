package com.springbook.biz.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;
	
	@Override
	public void insert(LoginVo vo) {
		System.out.println("service : "+vo);
		dao.insert(vo);
		
	}

	@Override
	public void update(LoginVo vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(LoginVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public LoginVo edit(LoginVo vo) {
		System.out.println("service " +vo);
		return dao.edit(vo);
	}

	@Override
	public List<LoginVo> select(LoginVo vo) {
		
		return dao.select(vo);
	}

	@Override
	public LoginVo login(LoginVo vo) {
		
		return dao.login(vo);
	}

	@Override
	public LoginVo getBoard(LoginVo vo) {
		
		return dao.getBoard(vo);
	}

}
