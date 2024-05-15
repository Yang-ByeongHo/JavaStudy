package com.example.service;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    UserRepository userRepo;

    public void Join(DTOUser user) {

        System.out.println(user.UserName);
        System.out.println(user.UserAge);
        userRepo.save(user.ToEntity());
    }

    public boolean Login(DTOUser user, HttpSession session) {
        System.out.println(user.UserName);
        System.out.println(user.UserAge);

        List<EntityUser> list = userRepo.findByUsernameAndUserage(user.UserName, user.UserAge);

        if (list.size() == 0) {
            return false;
        }else {
        	session.setAttribute("LokinOK", list.get(0));
            return true;
        }
    }

//    public void userWrite() {
//    	return;
//    }

    
//    public boolean UpdatePWD(DTOUser user,String newPwd) {
//
//        System.out.println("--------Run ServiceUser/UPDATE_PWD--------");
//        //userRepository의 update를 실행
//        //int로 업데이트된 구문의 행수를 표출함.
//        //updatingCount는 업데이트된 행의 수
//        int updatingCount = userRepo.updateUserPass(user.UserName, user.UserAge, newPwd);
//
//        System.out.println("UPDATING COUNT: " + updatingCount);
//
//        //업데이트에 성공한 행의 수가 0개 이상이라면,
//        if (updatingCount > 0) {
//            //업데이트에 성공했어도 실제로 바뀐 패스워드가 적용되어 검색이 되는 지 확인
//            List<EntityUser> list = userRepo.findByUsernameAndUserage(user.UserName, newPwd);
//            //list의 검색 성공, 실패에 따른 반환값 설정
//
//            System.out.println("list is NOT Empty?? : "+ !list.isEmpty());
//            return !list.isEmpty();
//
//        }else {
//            //업데이트 행의 수가 0개일 경우
//            return false;
//        }
//
//    }

    
    //Update
    public boolean UpdatePWD(DTOUser user, String newPwd) {
    	//UserName, UserAge, newPwd를 받았다면 count 증가
    	int count = userRepo.updateUserPass(user.UserName, user.UserAge, newPwd);
    
    	if(count>0) {
//    		System.out.println(count);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
//    public void RePass(String id, String pass, String rePass) {
//    	List<EntityUser> list = userRepo.findByUsernameAndUserage(id,pass);
//    	
//    	if(list.size() > 0) {
//    		list.get(0).setUserAge(rePass);
//    		userRepo.save(list.get(0));
//    	}
//    }
    
    
    	//Delete
    public boolean UserDelete(DTOUser user) {
    	int count = userRepo.deleteUserByNameAndAge(user.UserName, user.UserAge);
    
    	if(count>0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    

    
    
    //데이터베이스에서 모두 호출
    public Iterable<EntityUser> GetAllUser(){
    	return userRepo.findAll();
    }

    
}
