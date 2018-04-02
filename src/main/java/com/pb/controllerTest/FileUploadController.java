package com.pb.controllerTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pb.entity.User;
import com.pb.entity.User1;

@Controller
public class FileUploadController {
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		//动态跳转页面
		System.out.println("测试");
		return formName;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(description);
		//如果文件不为空。写入上传文件路劲
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//		System.out.println(ctx.getBean(User.class));
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
	
	/**
	 * 使用user对象来接收上传文件
	 * @param request
	 * @param user
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadforuser")
	public String uploadforuser(HttpServletRequest request,
			@ModelAttribute User user, Model model) throws IllegalStateException, IOException {
		if(!user.getImage().isEmpty()) {
			//如果上传文件不为空写入上传文件路径
			String path = request.getServletContext().getRealPath("/image/");
			String filename = user.getImage().getOriginalFilename();
			File filepath = new File(path, filename);
			//判断路径是否存在，如果不存在就创建一个
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个文件当中
			user.getImage().transferTo(new File(path + File.separator + filename));
			//将用户添加到model
			model.addAttribute("user", user);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 文件下载
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam String filename) throws IOException {
		//下载文件路径
		String path = request.getServletContext().getRealPath("/image/");
		File file = new File(path + File.separator + filename);
//		byte[] body = null;
//	    InputStream is = new FileInputStream(file);
//	    body = new byte[is.available()];
//	    is.read(body);
		HttpHeaders httpHeaders = new HttpHeaders();
		//下载显示的文件，解决中文乱码问题
		String downloadFileName = new String(filename.getBytes("utf-8"), "iso-8859-1");
		//通知浏览器以attachment方式下载图片
		httpHeaders.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream ： 二进制流数据（最常见的文件下载）。
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
        		httpHeaders, HttpStatus.CREATED);
//		return new ResponseEntity<byte[]>(body,    
//        		httpHeaders, HttpStatus.CREATED);
	}
	
}









