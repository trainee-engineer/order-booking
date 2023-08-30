package com.order.booking.servlet;

import com.order.booking.entity.Customer;
import com.order.booking.entity.User;
import com.order.booking.service.CustomerService;
import com.order.booking.util.UniqueID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "CustomerRegistration", urlPatterns = "/customer_signup")
public class CustomerRegistrationServlet extends HttpServlet {
    private static int id = 1;
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmpassword = req.getParameter("confirmPassword");

        long myPhone = phone != null && !phone.isEmpty() ? Long.parseLong(phone) : 0;

        Customer customer = new Customer();
        customer.setId(UniqueID.getNextId());
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setPhone(myPhone);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setConfirmPassword(confirmpassword);
        resp.setContentType("text/html");

        try
        {
            if (confirmpassword.equals(password))
            {
                String result = customerService.save(customer);
              //  resp.sendRedirect("customer_reg_successfully.html");
                resp.getWriter().write(" <h3>Your registration status is:" + result + "<br/>" +
                        "<a href=\"customer_login.html\">Login</a>" +
                             //   customer_login.html
                        "</h3>");
            }
            else
            {
                resp.getWriter().write(" <h3>Password does not match with confirm password, please try again<br/>" +
                        "<a href=\"customer_registration.html\">Try Again</a>" +
                        "</h3>");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            resp.getWriter().write("<h3>Invalid username/password</h3>");
        }
    }
}
