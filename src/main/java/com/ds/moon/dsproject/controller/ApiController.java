package com.ds.moon.dsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.moon.dsproject.dto.HbDto;
import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.dto.UserHbDto;
import com.ds.moon.dsproject.entity.User;
import com.ds.moon.dsproject.entity.UserHb;
import com.ds.moon.dsproject.service.DpService;
import com.ds.moon.dsproject.service.HbService;
import com.ds.moon.dsproject.service.RestTemplateService;
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


    // public ApiController(
	// 	DpService dpservice) {
	// 	this.dpservice = dpservice;
    // }


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

		System.out.println("부서"+dpservice.getListDept());
		System.out.println("취미"+hbService.getListHb());
		System.out.println("회원"+userService.getListUser(searchKeyword));

		model.addAttribute("deptlist", dpservice.getListDept());
		model.addAttribute("hblist", hbService.getListHb());
		model.addAttribute("userlist", userService.getListUser(searchKeyword));
		model.addAttribute("userinfo", userService.getUserInfo(userId));



		// List<User> userlist = userService.getListUser();
		// List<Dept> deptlist = deptService.getListDept();
		// List<Hb> hblist = hbService.getListHb();
		// List<UserHb> userHblist = userHbService.getList();

		// User user = new User();
		// if (searchKeyword == null) {
		// 	userlist = userService.getListUser();
		// 	if (userId == null) {
		// 		userId = "";
		// 	} else {
		// 		user = userService.getUserInfo(userId);
		// 	}
		// } else {
		// 	userlist = userService.getListUserNm(searchKeyword);
		// 	if (userId == null) {
		// 		userId = "";
		// 	} else {
		// 		user = userService.getUserInfo(userId);
		// 	}
		// }
		// //취미serchuserhblist
		// if(userId!=null){
		// 	List<UserHb> searchUserHbList = userHbService.selectUserIdByHb(userId);
		// 	model.addAttribute("serchuserhblist", searchUserHbList);
		// 	String hbList ="";
		// 	// userHbService.deleteUserHb(userId);

		// 	for(int i=0; i<searchUserHbList.size(); i++){
		// 		hbList += searchUserHbList.get(i).getHb().getHbCd();
		// 	}
		// 	model.addAttribute("hbList", hbList);
		// }
		

		// model.addAttribute("userhb", userHbService.getList());
		// model.addAttribute("userinfo", user);
		// model.addAttribute("deptlist", deptService.getListDept());
		// model.addAttribute("hblist", hbService.getListHb());
		

		return "userlist";
	}


	// @PostMapping(value ="/user/delete")
	// public String user_delete_proc(User user, UserHb userHb){
	// 	userHb.setUser(user);
	// 	System.out.println("삭제"+userHb);
	// 	userHbService.delete(userHb);
		
	// 	userService.deleteUserId(user);

	// 	return "redirect:/list";
	// }

	
	// @PostMapping(value ="/user/modify")
	// public String user_modify_proc(UserDto userDto){
	// 	User user = User.createUser(userDto);
	// 	userService.saveUser(user);

	// 	return "redirect:/list";
	// }

}