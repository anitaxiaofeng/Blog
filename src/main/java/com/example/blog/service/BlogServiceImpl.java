package com.example.blog.service;

import com.example.blog.dataobject.Blog;
import com.example.blog.repository.BlogRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class BlogServiceImpl {

    @Autowired
    private BlogRepository blogRepository;


    public void writeBlog(Blog blog){
         blogRepository.save(blog);
         log.info("存博客");
    }

    public List<Blog> selectAllBlog(){
        return blogRepository.findAll();
    }

    public Blog selectBlogById(Integer blogid){
        return blogRepository.findBlogByBlogid(blogid);
    }

    public void deleteBloyById(Integer blogid){
        blogRepository.deleteBlogByBlogid(blogid);
    }


}
