package com.ace.wework;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class Wework {
    private static String token;
    public  static String getWeworkToken(){
        return RestAssured.given().log().all()
                .queryParam("corpid", WeworkConfig.getInstance().corpid)
                .queryParam("corpsecret", WeworkConfig.getInstance().Secret)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all().statusCode(200)
        .extract().path("access_token");    //获取access token值
    }

    public String getToken(){
        if(token==null){
            token=getWeworkToken();
        }
        return token;
    }
}
