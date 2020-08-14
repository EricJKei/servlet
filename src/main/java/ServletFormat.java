/*
 * ServletTest.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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

@WebServlet(name = "Origin", urlPatterns = "/origin")
public class ServletFormat extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException{
        message = "This is a test";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter opt = res.getWriter();

        Enumeration enumeration = req.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = (String)enumeration.nextElement();
            String value = req.getHeader(name);
            opt.println(name+":"+value);
        }
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
