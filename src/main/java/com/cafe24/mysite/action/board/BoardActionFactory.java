package com.cafe24.mysite.action.board;

import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else {
			action = new ListAction();
		}

		return action;
	}

}
