/*
 * FilterTest.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Function: 
 *
 * @author yuliang
 * @date 2020/8/13
 */

@WebFilter(filterName = "HelloFilter", initParams = {@WebInitParam(name="name", value="Eric")},
        urlPatterns = "/origin")
public class FilterTest implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException{
        String name = config.getInitParameter("name");
        System.out.println("name_init: "+name);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{

        String age = request.getParameter("age");
        if(age!=null&&age!="12"){
            PrintWriter opt = response.getWriter();
            opt.println("Need authentication!!!, The age is "+request.getParameter("age"));
        }

        // 把请求传回过滤链
        chain.doFilter(request,response);
    }

    @Override
    public void destroy(){

    }

}
