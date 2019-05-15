package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.web.WebUtill;
import com.cafe24.web.mvc.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		GuestbookVo vo = new GuestbookVo();
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		
		new GuestbookDao().delete(vo);
		WebUtill.redirect(request, response, request.getContextPath() + "/guestbook");
	}

}
