
package com.max.exception.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.ModelAndView;

public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("e", ex);
		//这里可根据不同异常引起类做不同处理方式，本例做不同返回页面。
		String viewName = ClassUtils.getShortName(ex.getClass());
		return new ModelAndView(viewName, model);
	}

}
