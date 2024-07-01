package pack.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandInter {
	String showDate(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
