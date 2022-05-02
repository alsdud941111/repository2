package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class TestController_POJO implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("������� ������ Ȯ��~!");
		
		ModelAndView mv1 = new ModelAndView("test"); //�𵨰� ��
		mv1.addObject("data1","������ MVC�� ���̿���~!"); //data1�� ��(model)
		mv1.setViewName("test"); //test.jsp�� ��(view) �ΰű���
		
		//InternalResourceViewResolver resolver1;
		
		return mv1; //�𵨰� �並 ��ȯ�ϴ°ſ���
	}

}
