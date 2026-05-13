<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lms.entity.Student" %>
<%@ page import="com.lms.entity.Course" %>

<html>

<head>

<title>Enrollment View</title>

<style>

body{
    background:#020617;
    color:white;
    font-family:Arial;
    padding:40px;
}

.card{
    background:#0f172a;
    padding:30px;
    border-radius:20px;
    margin-bottom:40px;
    border:1px solid #2563eb;
}

h1{
    color:#60a5fa;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

th{
    background:#2563eb;
    padding:14px;
}

td{
    padding:14px;
    border-bottom:1px solid #1e293b;
}

tr:hover{
    background:#111827;
}

.course-tag{
    display:inline-block;
    background:#2563eb;
    padding:6px 12px;
    border-radius:20px;
    margin:4px;
}

.student-tag{
    display:inline-block;
    background:#9333ea;
    padding:6px 12px;
    border-radius:20px;
    margin:4px;
}

</style>

</head>

<body>

<div class="card">

<h1>Student Enrollments</h1>

<table>

<tr>
<th>ID</th>
<th>Student Name</th>
<th>Assigned Courses</th>
</tr>

<%
List<Student> students =
(List<Student>)request.getAttribute("students");

for(Student s : students){
%>

<tr>

<td><%= s.getId() %></td>

<td><%= s.getName() %></td>

<td>

<%
for(Course c : s.getCourses()){
%>

<span class="course-tag">
<%= c.getTitle() %>
</span>

<%
}
%>

</td>

</tr>

<%
}
%>

</table>

</div>

<div class="card">

<h1>Courses & Enrolled Students</h1>

<table>

<tr>
<th>ID</th>
<th>Course</th>
<th>Students Enrolled</th>
</tr>

<%
List<Course> courses =
(List<Course>)request.getAttribute("courses");

for(Course c : courses){
%>

<tr>

<td><%= c.getId() %></td>

<td><%= c.getTitle() %></td>

<td>

<%
for(Student s : c.getStudents()){
%>

<span class="student-tag">
<%= s.getName() %>
</span>

<%
}
%>

</td>

</tr>

<%
}
%>

</table>

</div>

</body>

</html>
