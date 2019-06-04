package com.ace.wework.contact;

import com.ace.wework.Wework;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Department {
    public Response list(String id){
       return given().log().all().param("access_token", Wework.getWeworkToken())
                .param("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all().statusCode(200).extract().response();
    }
}
