package com.order.booking.servlet;

import com.order.booking.entity.Customer;
import com.order.booking.entity.User;
import com.order.booking.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "CustomerRegistrationServlet", urlPatterns = "/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
    private static int id = 1;






    private CustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

      long myPhone =phone != null && !phone.isEmpty()?Long.parseLong(phone):0;

        Customer customer = new Customer();
        customer.setId(getId());
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhone(myPhone);
        customer.setConfirmPassword(confirmPassword);
        resp.setContentType("text/html");

        try {
            if(confirmPassword.equals(password)){
                String result = customerService.save(customer);
                resp.getWriter().write(" <h3>Your registration status is:" + result + "<br/><a href=\"index1.html\">Login</a></h3>");
            }else{
                resp.getWriter().write(" <h3>Password does not match with confirm password, please try again<br/>" +
                        "<a href=\"customer_registration.html\">Try Again</a></h3>");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            resp.getWriter().write("<h3>Invalid email/password</h3>");
        }
    }

    private Integer getId()
    {
        LocalDateTime time = LocalDateTime.now();
        return time.getYear() + time.getMonthValue() + time.getDayOfMonth() + time.getHour() + time.getMinute() + time.getSecond() + time.getNano() + (id++);
    }
}
