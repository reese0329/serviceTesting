package com.ace.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;

    @BeforeEach
    void setUp() {
        if (department == null) {
            department = new Department();
        }
    }

    @Test
    void list() {
        department.list("").then().statusCode(200)
        .body("department.name[0]",equalTo("ace"));
//        department.list("39").then().statusCode(200)
//                .body("department.name[0]",equalTo("ningningCenterdd"))
//        .body("department.id[0]",equalTo(39));

    }

    @Test
    void create() {
        department.create("HR3","1")
        .then().body("errcode",equalTo(60008));
        department.create("HR3","1")
        .then().body("errcode",equalTo(60008));

    }
}