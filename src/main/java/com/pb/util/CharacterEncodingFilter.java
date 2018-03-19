package com.pb.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 绫昏鏄庯細瀛楃杩囨护鍣�
 * @author 璁哥浖
 *
 */
public  class CharacterEncodingFilter implements Filter {

	private String encode = "UTF-8";// 榛樿UTF-8缂栫爜

	public void init(FilterConfig filterConfig) throws ServletException {
		String encoding = filterConfig.getInitParameter("encode");
		if (encoding != null) {
			encode = encoding;
		}
	}

	/**
	 * post鏂瑰紡鎻愪氦
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 璁剧疆request缂栫爜
		request.setCharacterEncoding(encode);
		// 璁剧疆鐩稿簲淇℃伅
		response.setContentType("text/html;charset=" + encode);
		response.setCharacterEncoding(encode);
		chain.doFilter(new CharacterEncodingRequest(request), response);
	}

	public void destroy() {

	}



}

/**
 * 瀵笹et鏂瑰紡浼犻�掔殑璇锋眰鍙傛暟杩涜缂栫爜
 */
class CharacterEncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request = null;

	public CharacterEncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	/**
	 * 瀵瑰弬鏁伴噸鏂扮紪鐮�
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
         if(value == null)
               return null;
         String method = request.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
				value = new String(value.getBytes("ISO8859-1"),
						request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

}
