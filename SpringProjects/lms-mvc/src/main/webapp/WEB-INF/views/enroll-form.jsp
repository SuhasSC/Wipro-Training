<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lms.entity.Student" %>
<%@ page import="com.lms.entity.Course" %>

<html>
<head>

<title>Enroll Student</title>

<style>

body{
    background:#020617;
    color:white;
    font-family:Arial;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card{
    width:550px;
    background:#0f172a;
    padding:40px;
    border-radius:20px;
    border:1px solid #2563eb;
}

h1{
    text-align:center;
    color:#60a5fa;
}

select{
    width:100%;
    padding:14px;
    background:#020617;
    color:white;
    border:1px solid #2563eb;
    border-radius:10px;
    margin-top:20px;
}

.checkbox-group{
    margin-top:25px;
}

.checkbox-group label{
    display:block;
    margin:12px 0;
    font-size:18px;
}

button{
    width:100%;
    padding:15px;
    margin-top:30px;
    border:none;
    border-radius:10px;
    background:#2563eb;
    color:white;
    font-size:20px;
    cursor:pointer;
}

button:hover{
    background:#1d4ed8;
}

</style>

</head>

<body>

<div class="card">

<h1>Enroll Student</h1>

<form action="save-enrollment" method="post">

<select name="studentId">

<%
List<Student> students =
(List<Student>)request.getAttribute("students");

for(Student s : students){
%>

<option value="<%= s.getId() %>">
<%= s.getName() %>
</option>

<%
}
%>

</select>

<div class="checkbox-group">

<%
List<Course> courses =
(List<Course>)request.getAttribute("courses");

for(Course c : courses){
%>

<label>

<input type="checkbox"
name="courseIds"
value="<%= c.getId() %>">

<%= c.getTitle() %>

</label>

<%
}
%>

</div>

<button type="submit">

Save Enrollment

</button>

</form>

</div>

</body>
</html>
