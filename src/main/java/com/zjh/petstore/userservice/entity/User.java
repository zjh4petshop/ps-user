package com.zjh.petstore.userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zjh.petstore.userservice.enums.UserStatus;

import lombok.Data;

@Document
@Data
public class User {

  @Id private String id;
  private String userName;
  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private String phone;
  private UserStatus userStatus;
}
