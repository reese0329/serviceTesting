package com.ace.wework;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class Wework {
    private static String token;
    public  static String getWeworkToken(String secret){
        return RestAssured.given().log().all()
                .queryParam("corpid", WeworkConfig.getInstance().corpid)
                .queryParam("corpsecret", secret)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all().statusCode(200)
        .extract().path("access_token");    //获取access token值
    }

//    public static String getWeworkTokenForContact(){
//
//    }

    public static String getToken(){
        // todo:支持两种类型的token
        if(token==null){
            token=getWeworkToken(WeworkConfig.getInstance().contactSecret);
        }
        return token;
    }
}
