package com.example.blog.repository;

import com.example.blog.dataobject.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Anita
 * @Date: Created in 21:31 2017/11/21
 */
public interface DiaryRepository extends JpaRepository<Diary,Integer> {
}
