package com.example.blog.Controller;

import com.example.blog.dataobject.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Anita
 * @Date 2017/11/29 15:31
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/addregister")
    public String addRegister(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              @RequestParam("password2")String password2){
        if(password.equals(password2)){
            User  user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
            return "redirect:/login";
        }
        else
            return "register";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/checklogin")
    public ModelAndView checkLogin(@RequestParam("username")String username,
                                   @RequestParam("password")String password,
                                   HttpServletResponse response, RedirectAttributes attributes,
                                   HttpSession session){
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user!=null){
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            Cookie cookie = new Cookie("token",token);
            cookie.setPath("/");
            cookie.setMaxAge(7200);
            response.addCookie(cookie);
            attributes.addAttribute("username",username);
            session.setAttribute("username",username);

                return new ModelAndView("redirect:/blog/bloglist");
        }
            return new ModelAndView("login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        //1.从cookie中查询
        Cookie cookie =get(request,"token");
        //2.清除token
        if(cookie!=null){
           User user = userRepository.findUserByToken(cookie.getValue());
           user.setToken(null);
           userRepository.save(user);
        }
        //3.清楚cookie
        Cookie cookienew = new Cookie("token",null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookienew);
        return new ModelAndView("login");
    }
    public  Cookie get(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else{
            return null;
        }


    }
    private  Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Map<String,Cookie> cookieMap = new HashMap<>();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
