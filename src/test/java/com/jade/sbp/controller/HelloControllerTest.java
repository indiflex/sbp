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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		ResponseEntity<String> hello = restTemplate.getForEntity("/hello", String.class);
		System.out.println("hello=" + hello);
		assertThat(hello.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(hello.getBody().equals("Hello 스프링부트!!"));
		
		String uid = "user1";
		ResponseEntity<User> helloUser = restTemplate.getForEntity("/helloUser/" + uid,
				User.class);
		System.out.println("helloUser=" + helloUser);
		assertThat(helloUser.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(helloUser.getBody().getUid().equals(uid));
		
		uid = "user2";
		helloUser = restTemplate.getForEntity("/helloUser/" + uid, User.class);
		System.out.println("helloUser=" + helloUser);
		assertThat(helloUser.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(helloUser.getBody().getUid().equals(uid));
		
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
