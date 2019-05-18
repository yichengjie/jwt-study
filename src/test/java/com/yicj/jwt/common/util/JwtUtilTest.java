package com.yicj.jwt.common.util;

import org.junit.Test;

import com.yicj.jwt.common.util.JwtUtil;
import com.yicj.jwt.modules.user.entity.User;

import io.jsonwebtoken.Claims;

public class JwtUtilTest {
	
	private User getUser() {
		User user = new User() ;
		user.setId("001");
		user.setUsername("yicj");
		user.setPassword("yicj123456");
		return user ;
	}

	@Test
	public void testCreateJWT() {
		User user = this.getUser() ;
		String token = JwtUtil.createJWT(-1, user) ;
		System.out.println(token);
		System.out.println("len : " + token.length());
	}
	
	@Test
	public void testParseJwt() {
		User user = this.getUser() ;
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5aWNqIiwicGFzc3dvcmQiOiJ5aWNqMTIzNDU2IiwiaWQiOiIwMDEiLCJpYXQiOjE1NTgxNjQ5NTEsImp0aSI6IjgyZmU3ZTRiLTE0YTAtNDc3Yi1hOTBmLThkM2YwODRiNjIwMyIsInVzZXJuYW1lIjoieWljaiJ9.oC5WYsR3RVyYtZ51Uf9vf2J8guZZ3SkDp_6P1m78i5Q" ;
		Claims parseJWT = JwtUtil.parseJWT(token, user);
		System.out.println(parseJWT);
		//{sub=yicj, password=yicj123456, id=001, 
		//iat=1558164951, jti=82fe7e4b-14a0-477b-a90f-8d3f084b6203, 
		//username=yicj}
	}
	
	@Test
	public void testIsVerify() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5aWNqIiwicGFzc3dvcmQiOiJ5aWNqMTIzNDU2IiwiaWQiOiIwMDEiLCJpYXQiOjE1NTgxNjQ5NTEsImp0aSI6IjgyZmU3ZTRiLTE0YTAtNDc3Yi1hOTBmLThkM2YwODRiNjIwMyIsInVzZXJuYW1lIjoieWljaiJ9.oC5WYsR3RVyYtZ51Uf9vf2J8guZZ3SkDp_6P1m78i5Q" ;
		User user = this.getUser() ;
		Boolean verify = JwtUtil.isVerify(token, user);
		System.out.println("verify : " + verify);
	}
	

}
