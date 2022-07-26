package chap04.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Process {
	
	public String process(HttpServletRequest request, HttpServletResponse response);
}
