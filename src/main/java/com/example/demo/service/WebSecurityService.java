package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
/**
 * 
 * @author HPP
 *
 */
@Service
public class WebSecurityService {
	
	@Secured("ROLE_ADMIN")
	public String roleAdmin() {
		String role = "我是一个admin";
		return role;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN' )and #num>5")
	public void test1(int num) {
		System.out.println("拥有权限并且数字大于5");
	}

	@PostAuthorize("returnObjict == 'abc'")
	public String test2() {
		System.out.println("执行方法并且返回一个字符对象");
		return "abcd";
	}

	@PreAuthorize("hasAnyRole({'ROLE_ADMIN','ROLE_USER'})")
	@PostFilter("hasRole('ROLE_ADMIN') || " + "filterObject.username == principal.username")
	public List<User> test3() {
		User u1 = new User("u1", "u1", 19, 0);
		User u2 = new User("u2", "u3", 19, 0);
		User u3 = new User("u2", "u3", 19, 0);
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}

	@PreAuthorize("hasAnyRole({'ROLE_ADMIN','ROLE_USER'})")
	@PostFilter("hasRole('ROLE_ADMIN') || " + "filterObject.username == principal.username")
	public void test4(List<User> users) {
		for (User user : users) {
			System.out.println(user.getLoginName());
		}
	}

	List<User> list = new ArrayList<>();
	
	
	@PreAuthorize("hasAnyRole({'ROLE_ADMIN','ROLE_USER'})")
	@PostFilter("hasRole('ROLE_ADMIN') || " + "filterObject.username == principal.username")
	public List<User> userForm() {
		User u1 = new User("admin", "admin", 23, 0);
		User u2 = new User("易群", "123", 23, 0);
		User u3 = new User("covey", "111", 23, 0);
		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}

}
