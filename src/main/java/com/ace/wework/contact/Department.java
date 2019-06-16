package com.ace.wework.contact;

import com.ace.wework.Wework;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Department extends Contact {
    public Response list(String id){
        Response response= requestSpecification
                .param("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().extract().response();
        reset();
        return response;
    }


    public Response create(String name){
        reset();          //reset 清空数据
        String body=JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"))
                .set("$.name",name)
//                .set("id",id)
                .jsonString();
        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().extract().response();
    }

    public Response update(String name,String id){
        reset();
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/update.json"))
                .set("$.name",name)
                .set("$.id",id).jsonString();
        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
                .then().extract().response();
    }

    public Response delete(String id){
        reset();
        return requestSpecification
                .queryParam("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().extract().response();
    }
}
