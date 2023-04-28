package com.ds.moon.dsproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ds.moon.dsproject.service.DpService;
import com.ds.moon.dsproject.service.HbService;
import com.ds.moon.dsproject.service.RestTemplateService;


@Controller
// @RequestMapping("/api/client")
public class ApiController {

	// @Autowired
	// private UserService userService;
	// @Autowired
	// private DpService dpService;
	@Autowired
	private HbService hbService;
	// @Autowired
	// private UserHbService userHbService;
	// @Autowired
	// private RestTemplate restTemplate;

	private final DpService dpservice;

	

    public ApiController(
		DpService dpservice) {
		this.dpservice = dpservice;
    }

    // @GetMapping
    // public String getHello(){
	// 	restTemplateService.hello();
    //     return "/index";
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

	// @GetMapping(value = "/list")
	// public String UserList(Model model, String searchKeyword, String userId) {
	// 	List<User> userlist = userService.getListUser();
	// 	List<Dept> deptlist = deptService.getListDept();
	// 	List<Hb> hblist = hbService.getListHb();
	// 	List<UserHb> userHblist = userHbService.getList();

	// 	User user = new User();
	// 	// System.out.println("우ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ"+userId);
	// 	// System.out.println("우ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ"+searchKeyword);
	// 	//검색
	// 	if (searchKeyword == null) {
	// 		userlist = userService.getListUser();
	// 		if (userId == null) {
	// 			userId = "";
	// 		} else {
	// 			user = userService.getUserInfo(userId);
	// 		}
	// 	} else {
	// 		userlist = userService.getListUserNm(searchKeyword);
	// 		if (userId == null) {
	// 			userId = "";
	// 		} else {
	// 			user = userService.getUserInfo(userId);
	// 		}
	// 	}
	// 	//취미serchuserhblist
	// 	if(userId!=null){
	// 		List<UserHb> searchUserHbList = userHbService.selectUserIdByHb(userId);
	// 		model.addAttribute("serchuserhblist", searchUserHbList);
	// 		String hbList ="";
	// 		// userHbService.deleteUserHb(userId);

	// 		for(int i=0; i<searchUserHbList.size(); i++){
	// 			hbList += searchUserHbList.get(i).getHb().getHbCd();
	// 		}
	// 		model.addAttribute("hbList", hbList);
	// 	}
		

	// 	model.addAttribute("userhb", userHblist);
	// 	model.addAttribute("userinfo", user);
	// 	model.addAttribute("deptlist", deptlist);
	// 	model.addAttribute("hblist", hblist);
	// 	model.addAttribute("userlist", userlist);

	// 	return "userlist";
	// }

	

	// @PostMapping(value = "/user/sign")
	// public String user_sign_proc(UserDto userDto, HbDto hbDto) {
	// 	User user = User.createUser(userDto);
	// 	Hb hb = Hb.createDept(hbDto);

	// 	UserHbDto userHbDto = new UserHbDto();
	// 	userHbDto.setUserId(userDto.getUserId());
	// 	userHbDto.setUserHbCd(hbDto.getHbCd());

	// 	UserHb userHb = UserHb.createUserHb(userHbDto);

	// 	//유저 먼저 등록 (pk라 먼저해야됨)
	// 	userService.saveUser(user);
	// 	System.out.println("------------------"+userHb);
	// 	userHbService.delete(userHb);
	// 	//자르기
	// 	if(hb.getHbCd() !=null){
	// 		String[] hbList = hb.getHbCd().split(",");

	// 		for(int i=0; i<hbList.length; i++){
	// 			userHb.getHb().setHbCd(hbList[i]);// 취미 코드 넣기
	// 			userHb.getUser().setUserId(userDto.getUserId());//유저아이디 넣기
	
	// 			userHbService.saveUserHb(userHb);
	// 		}
	// 	}	

	// 	//취미 하나씩 잘라넣기
		
		
		

	// 	return "redirect:/list";
	// }

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