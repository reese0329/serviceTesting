package com.ace.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void list() {
        Department department=new Department();
        department.list("").then().statusCode(200)
        .body("department.name[0]",equalTo("testhome1234"));
        department.list("39").then().statusCode(200)
                .body("department.name[0]",equalTo("ningningCenterdd"));

    }
}