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
		//��̬��תҳ��
		System.out.println("����");
		return formName;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(description);
		//����ļ���Ϊ�ա�д���ϴ��ļ�·��
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//		System.out.println(ctx.getBean(User.class));
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
	
	/**
	 * ʹ��user�����������ϴ��ļ�
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
			//����ϴ��ļ���Ϊ��д���ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/image/");
			String filename = user.getImage().getOriginalFilename();
			File filepath = new File(path, filename);
			//�ж�·���Ƿ���ڣ���������ھʹ���һ��
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//���ϴ��ļ����浽һ���ļ�����
			user.getImage().transferTo(new File(path + File.separator + filename));
			//���û���ӵ�model
			model.addAttribute("user", user);
			return "success";
		}
		return "error";
	}
	
	/**
	 * �ļ�����
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam String filename) throws IOException {
		//�����ļ�·��
		String path = request.getServletContext().getRealPath("/image/");
		File file = new File(path + File.separator + filename);
//		byte[] body = null;
//	    InputStream is = new FileInputStream(file);
//	    body = new byte[is.available()];
//	    is.read(body);
		HttpHeaders httpHeaders = new HttpHeaders();
		//������ʾ���ļ������������������
		String downloadFileName = new String(filename.getBytes("utf-8"), "iso-8859-1");
		//֪ͨ�������attachment��ʽ����ͼƬ
		httpHeaders.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream �� �����������ݣ�������ļ����أ���
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
        		httpHeaders, HttpStatus.CREATED);
//		return new ResponseEntity<byte[]>(body,    
//        		httpHeaders, HttpStatus.CREATED);
	}
	
}









