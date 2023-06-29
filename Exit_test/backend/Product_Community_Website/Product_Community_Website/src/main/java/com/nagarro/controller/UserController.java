package com.nagarro.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.User;
import com.nagarro.repository.UserRepository;
import com.nagarro.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("/getUsersCount")
	public int getAllData() {
		return userservice.getUserount();
	}
    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserDetails() {
        List<User> userList = userservice.getAllUserDetails();
        return userList;
    }

    @GetMapping("/getonlineuser")
    public Long getOnlineUser() {
    	return userrepo.getonlinuser();
    }
    
	@PostMapping("/login")
    @ResponseBody
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPass = user.getPassword();
        User userObj = null;
        if(tempEmail != null && tempPass != null){
            userObj = userservice.fetchUserByEmailAndPassword(tempEmail,tempPass);
            userrepo.setonline(userObj.getUserid());
        }
        if(userObj == null){
            throw new Exception("User does not exist");
        }
        return userObj;
    }
	
    
	
	@PostMapping("/logout")
	public String logOut( @RequestBody String id) {
		userrepo.setoffline(Long.parseLong(id));
		return "done";
	}
	
    @PostMapping("/registeruser")
    @ResponseBody
    public User User(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            User userobj = userservice.fetchUserByEmailId(tempEmailId);
            if (userobj != null) {
                throw new Exception("User with " + tempEmailId + " is already exist");
            }
        }
        User userObj = null;
        userObj = userservice.saveUser(user);
        return userObj;
    }
	
	

	
}
