package com.example.blog.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Anita
 * @Date 2017/11/29 15:33
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer userid;

    private String username;

    private String password;

    private String token;
}
