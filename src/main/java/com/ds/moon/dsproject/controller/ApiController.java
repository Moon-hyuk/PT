package com.ds.moon.dsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.moon.dsproject.dto.HbDto;
import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.dto.UserHbDto;
import com.ds.moon.dsproject.service.DpService;
import com.ds.moon.dsproject.service.HbService;
import com.ds.moon.dsproject.service.UserHbService;
import com.ds.moon.dsproject.service.UserService;


@Controller
// @RequestMapping("/api/client")
public class ApiController {

	
	@Autowired
	private HbService hbService;
	@Autowired
	private UserHbService userHbService;
	@Autowired
	private UserService userService;
	@Autowired
	private DpService dpservice;

	@GetMapping(value = "/index")
	public String index() {
		return "/index";
	}

	//가입 페이지
	@GetMapping(value = "/sign")
	public String UserSign(Model model) {
		
		model.addAttribute("deptlist", dpservice.getListDept());
		model.addAttribute("hblist", hbService.getListHb());
		return "usersign";
	}

	

	@PostMapping(value = "/sign/proc")
	public String user_sign_proc(UserDto userDto, HbDto hbDto) {
		
		userService.saveUser(userDto);
		userHbService.saveUserHb(userDto,hbDto);
		
		return "redirect:/list";
	}

	@GetMapping(value = "/list")
	public String UserList(Model model, String searchKeyword, String userId) {
		System.out.println("키워드키워드키워드키워드키워드키워드키워드키워드"+searchKeyword);
		model.addAttribute("deptlist", dpservice.getListDept());
		model.addAttribute("hblist", hbService.getListHb());
		model.addAttribute("userlist", userService.getListUser(searchKeyword));
		model.addAttribute("userinfo", userService.getUserInfo(userId));

		model.addAttribute("userhblist", userHbService.selectUserIdByHb(userId));

		return "userlist";
	}


	@PostMapping(value ="/user/delete")
	public String user_delete_proc(UserDto userDto, UserHbDto userHbDto){
		userHbService.delete(userHbDto);
		
		userService.deleteUserId(userDto);

		return "redirect:/list";
	}

	
	

}