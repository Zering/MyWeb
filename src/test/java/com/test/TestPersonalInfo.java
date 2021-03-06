package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.app.pojo.PersonalInfo;
import com.app.service.IPersonalInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestPersonalInfo {

	@Resource
	IPersonalInfoService personalInfoService;
	
	@Test
	public void insertTest(){
		PersonalInfo personalInfo = new PersonalInfo("amdin",
													"sino",
													"gkjk@admin",
													"15721347732",
													"550727632",
													"执念saying",
													"管理员",
													null);
		int result = personalInfoService.insertAtFirst(personalInfo);
		System.out.println(result);
	}
	
	@Test
	public void checkUsernameTest(){
		int result = personalInfoService.checkUsername("amdin");
		System.out.println(result);
	}
	
	@Test
	public void updatePersonalInfoTest(){
		PersonalInfo personalInfo = new PersonalInfo("amdin",
													"sino",
													"sino@admin",
													"15721347732",
													"550727632",
													"执念saying", 
													"管理员",
													null);
		int result = personalInfoService.updatePersonalInfo(personalInfo);
		System.out.println(result);
	}
	
	@Test
	public void uploadImage(){
		int result = personalInfoService.uploadImage("111111", "22222222", "amdin");
		System.out.println(result);
	}
	
	
	@Test
	public void personalCenterTest(){
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo = personalInfoService.personalCenter("admin");
		System.out.println(JSON.toJSONString(personalInfo));
	}
}
