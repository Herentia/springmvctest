package com.pb.controllerTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pb.entity.User1;
import com.pb.entity.Users;

@Controller
public class FastJsonTest {
	
//	@RequestMapping(value="/{formName}")
//	public String loginForm(@PathVariable String formName) {
//		//��̬��תҳ��
//		return formName;
//	}
	
	@RequestMapping(value="/getjson")
    @ResponseBody
    //����ѷ���ֵ ת��Ϊjson����
    public List<User1> json(){
        List<User1> list = new ArrayList<User1>();
        list.add(new User1(1,"zhansan",22));
        list.add(new User1(2,"wangwu",21));
        list.add(new User1(3,"zhaosi",33));
        list.add(new User1(4,"wangdana",14));
        return list;
    }
	
	@RequestMapping("/getjsonmap")
	@ResponseBody
	public Map<String, Object> getJsonMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ceshi1", new User1(1,"zhansan",22));
		map.put("ceshi2", new User1(2,"lisi",19));
		return map;
	}
	
	/**
	 * ����map���͵�ֵ
	 * @param map ����ֵ
	 * @return
	 */
	@RequestMapping("/maptest")
	public String mapTest(Map<String, Object> map) {
		map.put("names", Arrays.asList("tom", "jerry"));
		return "success";
	}
	
	@RequestMapping(value="/testpojo", method=RequestMethod.POST)
	public String testPojo(Users users) {
		System.out.println(users);
		return "success";
	}
	
	@RequestMapping("/ceshi")
	public String ceshi() {
		return "success";
	}

}
