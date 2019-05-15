package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtill;
import com.cafe24.web.mvc.Action;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		System.out.println("authUser:"+authUser);
		if (authUser == null) {
			WebUtill.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		WebUtill.forward(request, response, "/WEB-INF/views/board/write.jsp");

	}

}
