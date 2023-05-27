package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.UserModel;
import com.example.utils.SessionUtil;

public class AuthorizationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String url = request.getRequestURI();
		if(url.contains("/note")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			if(user != null) {
				// user logged
				filterChain.doFilter(servletRequest, servletResponse);
			}
			else {
				// not login
				response.sendRedirect(request.getContextPath() + "/auth?action=login&message=not_login&alert=danger");
			}
		}
		else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		
	}
 
}
