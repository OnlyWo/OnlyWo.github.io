package com.yang.car.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxUtils {
	public static void ajaxJson(String jsonString, HttpServletResponse response) {
		ajax(jsonString, "application/json", response);
	}
	// ajax 输出文本
	public static void ajaxText(String text, HttpServletResponse response) {
		ajax(text, "text/plain",response);
	}

	// ajax 输出HTML
	public static void ajaxHtml(String html, HttpServletResponse response) {
		ajax(html, "text/html",response);
	}

	// ajax 输出XML
	public static void ajaxXml(String xml, HttpServletResponse response) {
		ajax(xml, "text/xml",response);
	}

	public static void ajax(String content, String type,
			HttpServletResponse response) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			/**不设置缓存**/
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
