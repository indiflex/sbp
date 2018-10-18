package com.jade.sbp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {
	@Autowired
	MockMvc mock;
	
	@Test
	public void testHello() throws Exception {
		mock.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello 스프링부트!!"));

		MvcResult result = mock.perform(get("/hello"))
				.andExpect(status().isOk())
				.andReturn();

		assertEquals("Hello 스프링부트!!", result.getResponse().getContentAsString());
		assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello 스프링부트!!");

		System.out.println("RRR>>" + result.getResponse().getContentAsString());	
	}

}
