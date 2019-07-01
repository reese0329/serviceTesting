package com.ace.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.Objects;

public class Member extends Contact{


    public Response create(HashMap<String, Object>map){
        String body=template("/data/Member.json",map);
        reset();
        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();

    }

    public Response get(String userid){
        reset();
        return requestSpecification
                .queryParam("userid",userid)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .then().log().all().extract().response();

    }

    public Response update(HashMap<String, Object>map){
        String body=template("/data/Member/update.json",map);
        reset();
        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then().log().all().extract().response();

    }

    public Response delete(String userid){
        reset();
        return requestSpecification
                .queryParam("userid",userid)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then().log().all().extract().response();

    }


    public Response batchdelete(String useridlist){
        reset();
        return requestSpecification
                .queryParam("useridlist",useridlist)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete")
                .then().log().all().extract().response();

    }


    public Response simplelist(String department_id,String fetch_child ){
        reset();
        return requestSpecification
                .queryParam("department_id",department_id)
                .queryParam("fetch_child",fetch_child)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist")
                .then().log().all().extract().response();

    }
    public Response list(String department_id,String fetch_child ){
        reset();
        return requestSpecification
                .queryParam("department_id",department_id)
                .queryParam("fetch_child",fetch_child)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/list")
                .then().log().all().extract().response();

    }


    public Response convert_to_openid(String userid){
        reset();
        return requestSpecification
                .body("{\n"+
                        " \"userid\":\""+ userid +"\"\n"+
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid")
                .then().log().all().extract().response();

    }

    public Response authsucc(String userid){
        reset();
        return requestSpecification
                .queryParam("userid",userid)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/authsucc")
                .then().log().all().extract().response();
    }


    public Response invite(HashMap<String, Object>map){
        String body=template("/data/Member/invite.json",map);
        reset();
        return requestSpecification
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/batch/invite")
                .then().log().all().extract().response();
    }

    public Response get_join_qrcode(String size_type){
        reset();
        return requestSpecification
                .queryParam("size_type",size_type)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/get_join_qrcode")
                .then().log().all().extract().response();
    }

}
