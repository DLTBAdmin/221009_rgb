package com.atguigu.jwt;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class JwtTest {

    private static long tokenExpiration = 1000 * 60 * 60 * 24;
    //秘钥
    private static String tokenSignKey = "atguigu123";

    @Test
    public void testCreatedToken(){

        JwtBuilder jwtBuilder = Jwts.builder();

        //头、载荷、签名哈希
        String jwtToken = jwtBuilder
                //头
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                //载荷：自定义信息
                .claim("nickname", "Helen")
                .claim("avater", "1.jpg")
                .claim("role", "admin")

                //载荷：默认信息
                .setSubject("srb_user")//令牌主题
                .setIssuer("atguigu")//签发者
                .setAudience("atguigu")//接收方
                .setIssuedAt(new Date())//令牌的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))//过期时间
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 20))//生效时间
                .setId(UUID.randomUUID().toString())

                //签名哈希
                .signWith(SignatureAlgorithm.HS256, tokenSignKey)

                .compact();

        System.out.println(jwtToken);

    }

    @Test
    public void testGetUserInfo(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuaWNrbmFtZSI6IkhlbGVuIiwiYXZhdGVyIjoiMS5qcGciLCJyb2xlIjoiYWRtaW4iLCJzdWIiOiJzcmJfdXNlciIsImlzcyI6ImF0Z3VpZ3UiLCJhdWQiOiJhdGd1aWd1IiwiaWF0IjoxNjYzMTczMjYzLCJleHAiOjE2NjMyNTk2NjMsIm5iZiI6MTY2MzE3MzI4MywianRpIjoiYWJiNTQzNWUtMzk1NS00NzA4LTk0YWQtOTMxYmFhYjNjYTJlIn0.bsRy1ai5X_LK0GO41Bz4X_XXVwrv29za_4w4Etn-e9Y";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);

        Claims claims = claimsJws.getBody();

        String subject = claims.getSubject();
        String issuer = claims.getIssuer();
        String audience = claims.getAudience();
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();
        Date notBefore = claims.getNotBefore();
        String id = claims.getId();

        System.out.println(subject);
        System.out.println(issuer);
        System.out.println(audience);
        System.out.println(issuedAt);
        System.out.println(expiration);
        System.out.println(notBefore);
        System.out.println(id);

        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");

        System.out.println(nickname);
        System.out.println(avatar);


    }
}
