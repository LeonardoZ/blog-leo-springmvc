package com.leonardoz.blog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leonardoz.blog.controller.StringResources;

public class LoginHandler extends HandlerInterceptorAdapter {

	private final static String LOGIN_JSP = "/login";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (modelAndView != null) {
			String requestURI = request.getRequestURI();
			
			String redirectURI = request.getContextPath() + LOGIN_JSP;
			if (request.getSession().getAttribute(StringResources.AUTOR) == null
					&& !redirectURI.equals(requestURI)
					&& !redirectURI.equals(requestURI + ".do")) {
				response.sendRedirect(redirectURI);
			}
		}
		
	}

}
