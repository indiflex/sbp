package com.jade.sbp.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jade.sbp.domain.User;

@RunWith(SpringRunner.class)
//@WebMvcTest(HelloController.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HhTest {
//	@Autowired
//	MockMvc mock;
	
	@Autowired
    private TestRestTemplate restTemplate;
	

	@Test
	public void testHello() throws Exception {
		ResponseEntity<String> hello = restTemplate.getForEntity("/hello", String.class);
		System.out.println("========>>" + hello);
		assertThat(hello.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println("========>>" + hello.getStatusCodeValue() + " : " + hello.getBody());
		assertThat(hello.getBody().equals("Hello 스프링부트!!"));
		
		ResponseEntity<User> helloUser = restTemplate.getForEntity("/helloUser", User.class);
		System.out.println("========>>" + helloUser);
		assertThat(helloUser.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println("========>>" + helloUser.getStatusCodeValue() + " : " + helloUser.getBody());
		assertThat(helloUser.getBody().getUid().equals("user1"));
		
		
//		mock.perform(get("/hello"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello 스프링부트!!"));
//
//		MvcResult result = mock.perform(get("/hello"))
//				.andExpect(status().isOk())
//				.andReturn();
//
//		assertEquals("Hello 스프링부트!!", result.getResponse().getContentAsString());
//		assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello 스프링부트!!");
//
//		System.out.println("RRR>>" + result.getResponse().getContentAsString());	
	}

}
