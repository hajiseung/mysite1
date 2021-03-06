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

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 접근제어
		HttpSession session = request.getSession();
		if (session == null) {
			WebUtill.redirect(request, response, request.getContextPath());
			return;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			WebUtill.redirect(request, response, request.getContextPath());
			return;
		}

		long userNo = authUser.getNo();
		UserVo userVo = new UserDao().get(userNo);

		request.setAttribute("userVo", userVo);
		WebUtill.forward(request, response, "/WEB-INF/views/user/updateform.jsp");
	}

}
