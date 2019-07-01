package com.ace.wework.contact;
import com.ace.wework.contact.Department;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest extends DepartmentTest{

    static Department department;
    static Member member;

    @BeforeAll
    static void setup(){
        member=new Member();

    }

    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void create(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map).then().statusCode(200).body("errcode",equalTo(0));
    }

    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void get(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map);
        member.get(name+member.random)
                .then().body("errcode", CoreMatchers.equalTo(0));
    }


    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void update(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map);
        HashMap<String, Object> map_1= new HashMap<>();
        map.put("userid","1"+name+member.random);
        member.update(map_1)
                .then().body("errcode", CoreMatchers.equalTo(0));
    }

    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void delete(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map);
        member.delete(name+member.random)
                .then().body("errcode", CoreMatchers.equalTo(0));
    }

    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void batchdelete(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map);
        String nameNew_1=name+member.random;
        String random_1=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map1= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map1);
        member.batchdelete(name+member.random)
                .then().body("errcode", CoreMatchers.equalTo(0));
    }


    @Test
    void create1() {
        HashMap<String, Object>map=new HashMap<String, Object>(){
            {put("name","test"+random);
                put("parentid","1");}
        };
        Department.department.create(map).then().body("errcode", CoreMatchers.equalTo(0));
    }



    @ParameterizedTest
    @ValueSource(strings ={"tester","ace"})
    void convert_to_openid(String name) {
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String, Object> map= new HashMap<>();
        map.put("userid",name+member.random);
        map.put("name",name+member.random);
        map.put("alias","test0617"+member.random);
        map.put("mobile","151"+random);
        map.put("email",random+"@qq.com");
        map.put("department", Arrays.asList(1,2));
        member.create(map);
        member.convert_to_openid(name+member.random)
                .then().body("errcode",CoreMatchers.equalTo(0));

    }

    @Test
    void get_join_qrcode() {
        member.get_join_qrcode("")
                .then().body("errcode",CoreMatchers.equalTo(0));
    }
}