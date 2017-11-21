package com.example.blog.repository;

import com.example.blog.dataobject.Blog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


/**
 * @Author: Anita
 * @Date: Created in 21:07 2017/11/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void saveTest(){
        Blog blog = new Blog();
        blog.setBlogid(123);
        blog.setArticle("第一篇博客");
        blog.setBlogtitle("博客");
        LocalDateTime localDateTime = LocalDateTime.now();
        blog.setTime(localDateTime.toString());
        Blog result = blogRepository.save(blog);
        Assert.assertNotNull(result);

    }

}