package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PblApplicationTests {


//	测试jwt的生成
	@Test
	public void jwttest(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("wlh","sd");
		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256,"wlhhhh")//签名算法
				.setClaims(claims)//自定义内容
				.setExpiration(new Date(System.currentTimeMillis()+3600*1000))//设置过期时间
				.compact();
		System.out.println(jwt);
	}
	@Test
	public void parseJwt(){
		Claims claims = Jwts.parser()
				.setSigningKey("wlhhhh")
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5NjY4NDczN30.GiK3IisCYkcCoV_UHr3yhY_VhAS4hgE8E4H3P0jaqPU")
				.getBody();
		System.out.println(claims);
	}

}
