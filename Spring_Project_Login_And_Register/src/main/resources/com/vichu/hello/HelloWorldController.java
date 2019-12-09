/**
 * 
 */
package com.vichu.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author User
 *
 */
@Controller
public class HelloWorldController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}


@RequestMapping(value="/hello")

public ModelAndView hello(HttpServletRequest request,HttpServletResponse response)
{
	String uname=request.getParameter("t1");
	String pass=request.getParameter("t2");
ModelAndView mv=new ModelAndView();
mv.setViewName("hello");
mv.addObject("username",uname);
	return mv;
}
}
