package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MainServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Hello!");
//        printWriter.close();
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitorCounter");
        if(visitCounter == null){
            visitCounter = 1;
        }else {
            ++visitCounter;
        }
        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if(username == null){
            printWriter.write("Hello, Anonimous" + visitCounter + "<br>");
        }else {
            printWriter.write("Hello, " + username + "<br>");
        }
        printWriter.write("Page has been visited " + visitCounter + " times.");
        printWriter.close();
    }
}
