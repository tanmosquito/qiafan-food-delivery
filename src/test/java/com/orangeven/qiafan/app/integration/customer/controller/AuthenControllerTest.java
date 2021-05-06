package com.orangeven.qiafan.app.integration.customer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orangeven.qiafan.app.common.enumeration.Gender;
import com.orangeven.qiafan.app.customer.model.Customer;
import com.orangeven.qiafan.configuration.hibernate.HibernateConfig;
import com.orangeven.qiafan.configuration.spring.DeliveryOrderWebAppInitializer;
import com.orangeven.qiafan.configuration.spring.RootConfig;
import com.orangeven.qiafan.configuration.spring.WebConfig;

@SpringJUnitWebConfig({WebConfig.class, RootConfig.class, DeliveryOrderWebAppInitializer.class, HibernateConfig.class})
@TestInstance(Lifecycle.PER_CLASS)
public class AuthenControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@BeforeAll
	public void setUpMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	@Transactional
	public void signUp() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] customerBytes = objectMapper.writeValueAsBytes(customerDataForSignUp());
		RequestBuilder requestBuilder = post("/customer/signup")
				.accept(MediaType.parseMediaType("application/json;charset=utf-8"))
				.content(customerBytes);
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isCreated());
	}
	
	private Customer customerDataForSignUp() {
		Customer customer = new Customer();
		customer.setAccount("test_new_customer");
		customer.setPassword("123456");
		customer.setGender(Gender.MALE);
		customer.setPhone("12888888888");
		customer.setEmail("test_new_customer@qianfan.com");
		customer.setNickname("new_customer");
		
		return customer;
	}
}
