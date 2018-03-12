package com.pb.controllerTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pb.entity.User1;

@Controller
public class FastJsonTest {
	
//	@RequestMapping(value="/{formName}")
//	public String loginForm(@PathVariable String formName) {
//		//动态跳转页面
//		return formName;
//	}
	
	@RequestMapping(value="/getjson", method=RequestMethod.POST)
    @ResponseBody
    //将会把返回值 转换为json对象
    public List<User1> json(){
        List<User1> list = new ArrayList<User1>();
        list.add(new User1(1,"zhansan",22));
        list.add(new User1(2,"wangwu",21));
        list.add(new User1(3,"zhaosi",33));
        list.add(new User1(4,"wangdana",14));
        System.out.println("进来了");
        return list;
    }
	
	@RequestMapping("/ceshi")
	public String ceshi() {
		return "success";
	}

}
