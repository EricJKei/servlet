/*
 * ErrorHandler.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Function: 
 *
 * @author yuliang
 * @date 2020/8/13
 */

@WebServlet(name = "Error", urlPatterns = "/error")
public class ErrorHandler extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter opt = res.getWriter();

        //Error
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        opt.println(throwable);
        opt.println(statusCode);
        opt.println(servletName);

        //Header
//        Enumeration enumeration = req.getHeaderNames();
//        while(enumeration.hasMoreElements()){
//            String name = (String)enumeration.nextElement();
//            String value = req.getHeader(name);
//            opt.println(name+":"+value);
//        }

        //Parameters
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        res.setContentType("text/html");

        opt.println(name+" "+age);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }

    @Override
    public void destroy(){
        System.out.println("None");
    }
}