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
		//动态跳转页面
		return formName;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(description);
		//如果文件不为空。写入上传文件路劲
		if(!file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/image/");
			//上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			//判断文件路径是否存在，如果不存在就创建一个
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个文件当中
			file.transferTo(new File(path + File.separator + filename));
			return "success"; 
		} else {
			return "error";
		}
	}
	
}










