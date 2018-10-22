package com.jade.sbp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jade.sbp.domain.User;
import com.jade.sbp.mapper.UserMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SbpApplicationTests {
	@Autowired
	private DataSource ds;
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void testUserMapper() throws Exception {
		User user = mapper.getLoginInfo("user1");
		System.out.println("User>>" + user);
		assertEquals("김일수", user.getUname());
		
		String uname = mapper.getUname("user2");
		assertEquals("김이수", uname);
	}
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);

		try (Connection conn = ds.getConnection()) {
			System.out.println("Cooooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);

			assertEquals(100, getLong(conn, "select 100"));
			assertTrue(0 < getLong(conn, "select count(*) from User"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Test
	public void contextLoads() {
	}

}
