<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Contact" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Contacts</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

    <h1>Saved Contacts</h1>

    <table>

        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
        </tr>

        <%
            ArrayList<Contact> contacts =
                (ArrayList<Contact>) request.getAttribute("contactList");

            if (contacts != null) {

                for (Contact c : contacts) {
        %>

        <tr>
            <td><%= c.getName() %></td>
            <td><%= c.getPhone() %></td>
            <td><%= c.getEmail() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <br>

    <a href="index.jsp">
        <button>Add Another Contact</button>
    </a>

</div>

</body>
</html>