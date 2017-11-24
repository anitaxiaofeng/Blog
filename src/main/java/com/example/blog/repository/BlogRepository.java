package com.example.blog.repository;

import com.example.blog.dataobject.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Anita
 * @Date: Created in 21:02 2017/11/21
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {


    List<Blog> findAll();

     Blog findBlogByBlogid(Integer blogid);




    @Transactional
    @Modifying
    @Query(value = "delete from blog  where blogid = :id" , nativeQuery = true)
    void deleteById(@Param("id")Integer blogid);
}