package com.ggg.mybatisplus.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.Map;

public class JwtTool {

    private static final String SECRET="ggg20210917";

    private static  final String ISSUER="ggg2021";

    public static String createToken(Map<String,String> claims) throws Exception {

       try {
           Algorithm algorithm = Algorithm.HMAC256(SECRET);

           JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER)
                   .withExpiresAt(DateUtils.addDays(new Date(),30));

           claims.forEach(builder::withClaim);

           return builder.sign(algorithm);
       }catch (Exception e){
           throw new Exception("生成Token失败！");
       }
    }
}
