package com.order.booking.servlet;

import com.order.booking.entity.Customer;
import com.order.booking.service.CustomerService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Customer Login", urlPatterns = "/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        try
        {
            Customer customer = customerService.login(email, password );
            if (customer != null) {
                resp.getWriter().write("Thanks for login !<br/> <h3>Your user details is :" + customer.toString() + "</h3>");
            }
            else
            {
                resp.getWriter().write("<h3>Invalid email/password</h3>");
            }
        }
        catch (Exception exception)
        {
            resp.getWriter().write("<h3>Something went wrong: " + exception.getMessage() + "</h3>");


        }
    }


}
