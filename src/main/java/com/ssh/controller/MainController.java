package com.ssh.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pb.entity.Person;
import com.pb.entity.User1;
import com.ssh.service.TestService;

@Controller
public class MainController {
	
//	@Autowired
//	@Qualifier("ts")
	@Resource(name = "ts")
	private TestService testService;
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/testservice")
	public String testService() {
		return testService.test();
	}
	
	@RequestMapping("/getpersonjson")
	@ResponseBody
	public Person getPerson() {
		Person p = new Person();
		p.setName("ceshi");
		p.setAge(18);
		return p;
	}
	
	/**
	 * 使用@RequestBody来接收前端传过来的json数据，并转换为对应的Person类 对象
	 * -@ResponseBoby又会将person对象通过对应的转换器转换为json、数据返回到前端
	 * @param p 转换成person对象的前端数据
	 * @return
	 */
	@RequestMapping(value="/testrequestbody", method=RequestMethod.POST)
	@ResponseBody
	public Person testRequestBody(@RequestBody Person p) {
		System.out.println("asdsad---" + p);
		return p;
	}
	
	/**
	 * ---@PathVariable将映射地址里面的动态参数赋值给指定参数
	 * @param variable
	 * @param mdv
	 * @return
	 */
	@RequestMapping("/showview/{variable}")
	public ModelAndView showView(@PathVariable(value="variable") String variable, ModelAndView mdv) {
		mdv.setViewName("success");
		mdv.addObject("message", variable);
		return mdv;
	}
	
	/**
	 * ---@ModelAttribute没有定义value时，会将返回类型的首写字母小写作为保存的名保存在model中
	 * @return
	 */
	@ModelAttribute
	public User1 getUser() {
		return new User1(1, "haha", 18);
	}
	/**
	 * 
	 * @param user1 此参数名在model中保存有相同的参数，所有会取得model中的此名的参数值
	 * @param writer
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/sayHello")
	public void sayHello(User1 user1, Writer writer, HttpSession session) throws IOException {
		System.out.println(user1);
		writer.write(user1.getName());
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			writer.write(names.nextElement());
		}
	}
	
	/**
	 * ---@ModelAttribute若没有则将URI template中的值按对应的名称绑定到Pet对象的各属性上
	 */
	
	/**
	 * 重定向
	 */
	@RequestMapping("/redirectTest")
	public String redirectTest() {
		System.out.println("redirectTest....");
		return "redirect:/index.jsp";
	}

}
