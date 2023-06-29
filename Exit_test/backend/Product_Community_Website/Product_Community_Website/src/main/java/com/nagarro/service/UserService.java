package com.nagarro.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.User;
import com.nagarro.repository.UserRepository;







@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
    public List<User> getAllUserDetails() {
        List<User> userList = (List<User>) userrepository.findAll();
        return userList;
    }
//	public User login(String email , String pass) {
//        User user = userrepository.getuserbyemail(email);
//        if(user == null) {
//            throw new RuntimeException("User does not exist.");
//        }
//        if(!user.getPassword().equals(pass)){
//            throw new RuntimeException("Password mismatch.");
//        }
//        return user ;
//
////    }
    public int getUserount(){
    	return userrepository.findAll().size();
    }


public User login(User user)throws Exception {
	 String tempEmail = user.getEmail();
     String tempPass = user.getPassword();
     User userObj = null;
     if(tempEmail != null && tempPass != null){
         userObj = fetchUserByEmailAndPassword(tempEmail,tempPass);
         userObj.setActiveUser(true);
         userrepository.save(userObj);
         
     }
     if(userObj == null){
         throw new Exception("User does not exist");
     }
     
     return userObj;
}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
        return  userrepository.findByEmailAndPassword(email,password);
    }
    public User saveUser(User user){
        return userrepository.save(user);
    }

    public User fetchUserByEmailId(String email) {
        return  userrepository.getuserbyemail(email);
    }
	
	
	public String registeruser(User newUser){
		
		List<User> users = userrepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.getRole());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return "USER_ALREADY_EXISTS";
            }
	}
        userrepository.save(newUser);
        
        return "SUCCESS";
	}

}

