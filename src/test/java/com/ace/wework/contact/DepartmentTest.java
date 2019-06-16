package com.ace.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if (department == null) {
            department = new Department();
        }
    }

    @Test
    void list() {
        department.list("").then().statusCode(200)
                .body("department.name[0]", equalTo("ace"));
//        department.list("39").then().statusCode(200)
//                .body("department.name[0]",equalTo("ningningCenterdd"))
//        .body("department.id[0]",equalTo(39));

    }

    @Test
    void create() {
        department.create("测试部")
                .then().body("errcode", equalTo(0));
    }


    @Test
    void createWithChinese() {
        department.create("测试部"+random)
                .then().body("errcode", equalTo(0));
    }
//
    @Test
    void update() {
        String nameOld="HR_18"+random;
        department.create(nameOld);
        String id=String.valueOf(department.list("").path("department.find{ it.name=='"+ nameOld +"'}.id"));
        department.update("HR061613"+random, id)
                .then().body("errcode", equalTo(0));
    }

    @Test
    void delete()
////    {
////        department.create("python", "190616")
////                .then().body("errcode", equalTo(0));
////        department.delete("190616")
////                .then().body("errcode", equalTo(0));
////    }
//
    {
        String nameOld ="测试部2";
        department.create(nameOld);
        String id = String.valueOf(department.list("").path("department.find{ it.name=='" + nameOld + "'}.id"));
        department.delete(id)
                .then().body("errcode", equalTo(0));
   }

}


