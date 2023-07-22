package com.order.booking.servlet;

import com.order.booking.entity.User;
import com.order.booking.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        try {
            User user = userService.login(username,password);
            if(user != null)
            {
                resp.getWriter().write("Thanks for login !<br/> <h3>Your user details is :" + user.toString() + "</h3>");
            }
            else
            {
                resp.getWriter().write("<h3>Invalid username/password</h3>");
            }
        }
        catch (Exception exception)
        {
            resp.getWriter().write("<h3>Something went wrong:: "+exception.getMessage()+"</h3>");
        }




    }
}
