package org.scoula.Cookie_Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Servlet 요청");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello Servlet</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 호출");
    }
}
