package com.springbook.biz.login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(LoginVo vo) {
	
		mybatis.insert("LOGIN.insert",vo);

		
		
	}

	@Override
	public void update(LoginVo vo) {
		mybatis.update("LOGIN.update",vo);
		
	}

	@Override
	public void delete(LoginVo vo) {
		mybatis.delete("LOGIN.delete",vo);
		
	}

	@Override
	public LoginVo edit(LoginVo vo) {
		System.out.println("dao " +vo);
		return mybatis.selectOne("LOGIN.edit",vo);
	}

	@Override
	public List<LoginVo> select(LoginVo vo) {
		
		return mybatis.selectList("LOGIN.select",vo);
	}

	@Override
	public LoginVo login(LoginVo vo) {
		return mybatis.selectOne("LOGIN.login",vo);
	}

	@Override
	public LoginVo getBoard(LoginVo vo) {
		
		return mybatis.selectOne("LOGIN.getBoard",vo);
	}

}
