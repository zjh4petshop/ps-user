package com.zjh.petstore.userservice.entity;

import com.zjh.petstore.userservice.enums.UserStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
public class User {

    @MongoId
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private UserStatus userStatus;
}
