
import com.ace.wework.Wework;
import com.ace.wework.WeworkConfig;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static io.restassured.RestAssured.given;


public class TestGetToken {
    @Test
    void testToken(){
       Wework wework=new Wework();
        String token=Wework.getWeworkToken(WeworkConfig.getInstance().Secret);
       assertThat(token,not(equalTo(null)));
    }

    @Test
    void createDepartment(){
        given().log().all().queryParam("access_token",Wework.getToken())
                .contentType(ContentType.JSON)
                .body("{\n"+
                        "  \"name\": \"广州研发中心\",\n"+
                        "  \"parentid\":1,\n" +
                        "  \"order\": 1,\n"+
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).body("errcode",equalTo(0));
    }



}
