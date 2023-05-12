package com.ds.moon.dsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ds.moon.dsproject.dto.HbDto;
import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.dto.UserHbDto;
import com.ds.moon.dsproject.service.DpService;
import com.ds.moon.dsproject.service.HbService;
import com.ds.moon.dsproject.service.UserHbService;
import com.ds.moon.dsproject.service.UserService;


@Controller
public class ApiPTController {

	
	@Autowired
	private HbService hbService;
	@Autowired
	private UserHbService userHbService;
	@Autowired
	private UserService userService;
	@Autowired
	private DpService dpservice;

	@GetMapping(value = "/")
	public String index() {
		return "/main";
	}

	//가입 페이지
	@GetMapping(value = "/sign")
	public String UserSign(Model model) {
		
		model.addAttribute("deptlist", dpservice.getListDept());
		model.addAttribute("hblist", hbService.getListHb());
		return "usersign";
	}

	//가입&수정 프로세스
	@PostMapping(value = "/sign/proc")
	public String user_sign_proc(UserDto userDto, HbDto hbDto) {
		
		userService.saveUser(userDto);
		userHbService.saveUserHb(userDto,hbDto);
		
		return "redirect:/list?searchKeyword=";
	}


	//회원 리스트 출력
	@GetMapping(value = "/list")
	public String UserList(Model model, String searchKeyword, String userId) {
		if(searchKeyword==null){
			searchKeyword="";
		}
		model.addAttribute("deptlist", dpservice.getListDept());
		model.addAttribute("hblist", hbService.getListHb());
		model.addAttribute("userlist", userService.getListUser(searchKeyword));
		model.addAttribute("userinfo", userService.getUserInfo(userId));
		model.addAttribute("userhblist", userHbService.selectUserIdByHb(userId));
		model.addAttribute("searchKeyword",searchKeyword);

		return "userlist";
	}

	//회원 삭제
	@PostMapping(value ="/user/delete")
	public String user_delete_proc(UserDto userDto, UserHbDto userHbDto){
		userHbService.delete(userHbDto);
		
		userService.deleteUserId(userDto);

		return "redirect:/list?searchKeyword=";
	}

	
	

}