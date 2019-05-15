package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.web.WebUtill;
import com.cafe24.web.mvc.Action;

public class LogOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("authUser") != null) {
			session.removeAttribute("authUser");
			session.invalidate();
		}
		WebUtill.redirect(request, response, request.getContextPath());

	}

}
