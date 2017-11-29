package com.example.blog.Controller;


import com.example.blog.dataobject.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/")
    public String blogindex(){
        return "blogindex";
    }

    @PostMapping("/writeBlog")
    public String writeBlog(Blog blog,HttpSession session){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dataString = formatter.format(currentTime);
        blog.setTime(dataString);
        blogService.writeBlog(blog);
        session.setAttribute("username",blog.getUsername());
        return "success";
    }

    @GetMapping("/writeb")
    public String editblog(Model model){
        return "writeblog";
    }


    @GetMapping("/bloglist")
    public String selectAllBlog(@RequestParam("username")String username, Model model){
        List<Blog> blogs = new ArrayList<>();
        blogs = blogRepository.findBlogByUsername(username);
        model.addAttribute("username",username);
        model.addAttribute("blogs",blogs);
        return "index";
    }

    @GetMapping("/selectBlogById")
    public ModelAndView selectBlogById(@RequestParam("blogid") Integer blogid,
                                                     Map<String,Object> map){
        Blog blog = blogService.selectBlogById(blogid);
        map.put("blog",blog);
        return new ModelAndView("adminblog",map);
    }

    @GetMapping("/deleteBlogById")
    public String deleteBlogById(@RequestParam("blogid") Integer blogid){
        blogService.deleteBlogById(blogid);
        return "redirect:/blog/bloglist";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/gustbook")
    public String gustbook(){
        return "gustbook";
    }

}





