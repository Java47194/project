package com.springbook.biz.login;

import java.util.List;

public interface LoginDao {
void insert(LoginVo vo);
void update(LoginVo vo);
void delete(LoginVo vo);

LoginVo edit(LoginVo vo);
LoginVo getBoard(LoginVo vo);
LoginVo login(LoginVo vo);
List<LoginVo> select(LoginVo vo);


}
