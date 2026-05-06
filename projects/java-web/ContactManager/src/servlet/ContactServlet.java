package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Contact;

@WebServlet("/addContact")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ArrayList<Contact> contacts = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);

        request.setAttribute("contactList", contacts);

        request.getRequestDispatcher("contacts.jsp").forward(request, response);
    }
}