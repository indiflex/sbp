package com.jade.sbp.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude={"upw", "naverid", "googleid"})
public class User {
	private String uid;
	private String upw;
	private String uname;
	private Integer upoint;
	
	private String email;
	private String googleid;
	private String naverid;
	private String nickname;
	
	private String loginip;
	private Date lastlogin;
	
}
