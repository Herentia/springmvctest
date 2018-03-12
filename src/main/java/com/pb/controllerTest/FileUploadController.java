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
public class FileUploadController {
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		//��̬��תҳ��
		return formName;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(description);
		//����ļ���Ϊ�ա�д���ϴ��ļ�·��
		if(!file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/image/");
			//�ϴ��ļ���
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			//�ж��ļ�·���Ƿ���ڣ���������ھʹ���һ��
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//���ϴ��ļ����浽һ���ļ�����
			file.transferTo(new File(path + File.separator + filename));
			return "success"; 
		} else {
			return "error";
		}
	}
	
}










