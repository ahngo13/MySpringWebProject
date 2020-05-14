package myspring.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/insertUser.do")
	public String insertUser(UserVO user) {
		userService.insertUser(user);
		return "redirect:/userList.do";
	}
	
	@RequestMapping("/insertUserForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		session.setAttribute("gender", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		session.setAttribute("city", cityList);

		return "userInsert";
//		return new ModelAndView("userInsert", "map", map);
	}
	
	@RequestMapping("/deleteUser.do/{id}")
	public String deleteUser(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		//getUserList(); (x)
		
		return "redirect:/userList.do";
	}
	
	@RequestMapping("/getUser.do")
	public String getUser(@RequestParam("id") String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	@RequestMapping("/userList.do")
	public ModelAndView getUserList() {
		List<UserVO> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList);
	}
}
