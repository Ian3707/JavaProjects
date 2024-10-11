package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/color")
public class ColorTextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");
        String color = request.getParameter("color");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<html>");
            out.println("<head><title>Color Text Servlet</title></head>");
            out.println("<body> <h1 style=\"color:" + color + ";\">" + text + "</h1> </body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }
}
