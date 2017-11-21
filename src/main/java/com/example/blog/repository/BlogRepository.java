package com.example.blog.repository;

import com.example.blog.dataobject.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Anita
 * @Date: Created in 21:02 2017/11/21
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
