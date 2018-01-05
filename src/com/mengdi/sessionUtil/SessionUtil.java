package com.mengdi.sessionUtil;

import java.util.ArrayList;

import com.mengdi.sessionlistener.User;

public class SessionUtil {
	public static Object getUserBySessionId(ArrayList<User> userList, String sessionId) {
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			if (user.getSessionId().equals(sessionId)) {
				return user;
			}
		}
		return null;
	}
}
