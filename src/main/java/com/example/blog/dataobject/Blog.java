package com.example.blog.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Anita
 * @Date: Created in 20:53 2017/11/21
 */
@Entity
@Data
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue
    private Integer blogid;



    private String blogtitle;

    private String article;

    private String time;


}
