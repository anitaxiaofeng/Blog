package com.example.blog.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Anita
 * @Date: Created in 21:29 2017/11/21
 */
@Entity
@Data
@Table(name = "diary")
public class Diary {

    @Id
    private Integer diaryid;

    private String diary;

    private String time;
}
