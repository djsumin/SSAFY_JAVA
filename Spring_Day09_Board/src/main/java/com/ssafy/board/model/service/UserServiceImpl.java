package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}


	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}


	@Override
	public User login(User user) {
		//DB에 해당 ID만 넘겨서 데이터를 가져오고 가지고온 USER 데이터와 내가 현재 가지고 있는 USER의 비밀번호를 확인하면
		User tmp = userDao.selectOne(user.getId());
		//tmp가 실제 user정보일수동 잇고, null이 넘어왔다.
		if(tmp != null && tmp.getPassword().equals(user.getPassword()))
			return tmp;
		return null;
	}
	
}
