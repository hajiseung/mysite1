package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtill;
import com.cafe24.web.mvc.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserVo authUser = new UserDao().get(email, password);
		if (authUser == null) {
			request.setAttribute("result", "fail");
			WebUtill.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}

		// 로그인 처리

		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		WebUtill.redirect(request, response, request.getContextPath());
	}

}
