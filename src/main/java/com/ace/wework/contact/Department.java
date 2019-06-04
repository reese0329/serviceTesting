package com.ace.wework.contact;

import com.ace.wework.Wework;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Department {
    public Response list(String id){
       return given().log().all().param("access_token", Wework.getToken())
                .param("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all().statusCode(200).extract().response();
    }
    public Response create(String name ,String parentid){
        return given().log().all().queryParam("access_token",Wework.getToken())
                .body("{\n"+
                        "  \"name\": \""+ name +"\",\n"+
                "  \"parentid\":" + parentid + ",\n" +
                "  \"order\": 1,\n"+
                "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();
    }
}
