package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RestController
//@Controller + @ResponseBody
public class UserRestController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<UserVO> getUsers(){
		return userService.getUserList();
	}
	
	@GetMapping("/users/{id}")
	public UserVO getUser(@PathVariable("id") String userid) {
		return userService.getUser(userid);
	}
	
	@PostMapping("/users")
	public List<UserVO> insertUser(@RequestBody UserVO user){
		userService.insertUser(user);
		return userService.getUserList();
	}
	
	@PutMapping("/users")
	public List<UserVO> updateUser(@RequestBody UserVO user){
		userService.updateUser(user);
		return userService.getUserList();
	}
	
}
