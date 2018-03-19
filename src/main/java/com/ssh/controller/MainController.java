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
	 * ʹ��@RequestBody������ǰ�˴�������json���ݣ���ת��Ϊ��Ӧ��Person�� ����
	 * -@ResponseBoby�ֻὫperson����ͨ����Ӧ��ת����ת��Ϊjson�����ݷ��ص�ǰ��
	 * @param p ת����person�����ǰ������
	 * @return
	 */
	@RequestMapping(value="/testrequestbody", method=RequestMethod.POST)
	@ResponseBody
	public Person testRequestBody(@RequestBody Person p) {
		System.out.println("asdsad---" + p);
		return p;
	}
	
	/**
	 * ---@PathVariable��ӳ���ַ����Ķ�̬������ֵ��ָ������
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
	 * ---@ModelAttributeû�ж���valueʱ���Ὣ�������͵���д��ĸСд��Ϊ�������������model��
	 * @return
	 */
	@ModelAttribute
	public User1 getUser() {
		return new User1(1, "haha", 18);
	}
	/**
	 * 
	 * @param user1 �˲�������model�б�������ͬ�Ĳ��������л�ȡ��model�еĴ����Ĳ���ֵ
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
	 * ---@ModelAttribute��û����URI template�е�ֵ����Ӧ�����ư󶨵�Pet����ĸ�������
	 */
	
	/**
	 * �ض���
	 */
	@RequestMapping("/redirectTest")
	public String redirectTest() {
		System.out.println("redirectTest....");
		return "redirect:/index.jsp";
	}

}
