package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest2")
public class TestController2 {

//http://localhost:8080/mvc/rest2/test1/ : 이제는 @ResponseBody가 붙어있는 거랑 똑같으니.
	@GetMapping("/test1")
	public String test1() {
		return "hi rest";

	}

//http://localhost:8080/mvc/rest2/test2/ : 
	@GetMapping("/test2")
	public String test2() {
		return "hi rest";

	}

	// http://localhost:8080/mvc/rest2/test3/
	@GetMapping("/test3")
	public Map<String, String> test3() {
		// 키 밸류 형태를 가지고 있는 맵을 반환
		Map<String, String> data = new HashMap<String, String>();

		data.put("id", "ssafy");
		data.put("password", "1234");
		data.put("name", "양띵균");

		return data; // jackson-databind 을 추가해주었더니 map을 알아서 json으로 바꿔서 주더라.

	}

	// http://localhost:8080/mvc/rest2/test4/ : 짹슨이 dto 도 알아서 json으로 바꿔서 보내주는군 굳
	@GetMapping("/test4")
	public User test4() {
		User user = new User("ssafy", "1234", "양띵균");
		return user;
	}

	// http://localhost:8080/mvc/rest2/test5/ : list도 반환해주나? 응 그러하다
	@GetMapping("/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy", "1234", "양띵균"));
		list.add(new User("ssafy", "0727", "이수민"));
		list.add(new User("judy", "3504", "이수민3"));
		list.add(new User("safy", "0727", "이수민4"));
		return list;
	}
	
	
	
	
	
	
	
	
	

}