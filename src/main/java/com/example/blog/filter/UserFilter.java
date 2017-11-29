package com.example.blog.filter;


import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anita
 * @Date 2017/11/29 18:31
 */
@WebFilter(urlPatterns = "/blog/*")
@Slf4j
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter ----ClientOauthFilter---");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie cookie = get(request,"token");
        if (cookie==null) {
            return;
        }
        if (request.isRequestedSessionIdFromURL()) {
            HttpSession session = request.getSession();
            if (session != null) session.invalidate();
        }

        // wrap response to remove URL encoding
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }


            public String encodeRedirectURL(String url) {
                return url;
            }


            public String encodeUrl(String url) {
                return url;
            }


            public String encodeURL(String url) {
                return url;
            }
        };

        // process next request in chain
        filterChain.doFilter(servletRequest, wrappedResponse);
    }

    @Override
    public void destroy() {

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


