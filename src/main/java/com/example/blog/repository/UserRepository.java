package com.example.blog.repository;

import com.example.blog.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Anita
 * @Date 2017/11/29 15:38
 */
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsernameAndPassword(String username,String password);
    public User findUserByToken(String token);
}
