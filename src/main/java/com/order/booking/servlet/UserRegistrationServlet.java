package com.order.booking.servlet;

import com.order.booking.entity.User;
import com.order.booking.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet(name = "UserRegistration", urlPatterns = "/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
    private static int id = 1;
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setId(getId());
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUsername(username);
        user.setPassword(password);
        resp.setContentType("text/html");
        try {
            String result = userService.save(user);
            resp.getWriter().write(" <h3>Your registration status is:" + result + "<br/><a href=\"index.html\">Login</a></h3>");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<h3>Invalid username/password</h3>");
        }
    }

    private Integer getId() {
        LocalDateTime time = LocalDateTime.now();
        return time.getYear() + time.getMonthValue() + time.getDayOfMonth() + time.getHour() + time.getMinute() + time.getSecond() + time.getNano() + (id++);
    }
}
