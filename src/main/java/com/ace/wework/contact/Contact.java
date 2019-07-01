package com.ace.wework.contact;

import com.ace.wework.Restful;
import com.ace.wework.Wework;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Contact extends Restful {
    String random=String.valueOf(System.currentTimeMillis());
    public Contact(){
        reset();
;    }
    //重置
    public void reset() {
        requestSpecification=given()
                .log().all()
                .queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);
    }


}
