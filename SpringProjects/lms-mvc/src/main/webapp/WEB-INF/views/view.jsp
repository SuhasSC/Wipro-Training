<%@ page import="java.util.*" %>
<%@ page import="com.lms.entity.Student" %>
<%@ page import="com.lms.entity.Course" %>

<!DOCTYPE html>
<html>
<head>

<title>LMS Analytics Dashboard</title>

<style>

body{
    margin:0;
    font-family:Arial;
    background:#020617;
    color:white;
}

.navbar{
    display:flex;
    justify-content:center;
    gap:20px;
    padding:25px;
    margin-bottom:30px;
    flex-wrap:wrap;
}

.navbar a{
    text-decoration:none;
    padding:14px 28px;
    background:#2f66e0;
    color:white;
    border-radius:12px;
    font-weight:600;
    transition:0.3s ease;
    box-shadow:0 0 15px rgba(47,102,224,0.4);
}

.navbar a:hover{
    transform:translateY(-3px) scale(1.05);
    background:#4d7eff;
    box-shadow:0 0 25px rgba(77,126,255,0.8);
}

.dashboard{
    width:90%;
    margin:40px auto;
}

.analytics{
    display:grid;
    grid-template-columns:repeat(3,1fr);
    gap:20px;
    margin-bottom:40px;
}

.card-box{
    background:#0f172a;
    padding:25px;
    border-radius:14px;
    border:1px solid #1e40af;
    transition:0.3s;
}

.card-box:hover{
    transform:translateY(-5px);
    box-shadow:0 0 20px rgba(37,99,235,0.4);
}

.card-box h3{
    margin:0;
    color:#60a5fa;
    font-size:18px;
}

.card-box p{
    font-size:34px;
    margin-top:15px;
    font-weight:bold;
}

.table-card{
    background:#0f172a;
    border-radius:14px;
    padding:25px;
    margin-bottom:40px;
    border:1px solid #1e40af;
}

.table-card h2{
    color:#60a5fa;
    margin-bottom:20px;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

th{
    background:#2563eb;
    color:white;
    padding:18px;
    text-align:center;
}

td{
    padding:18px;
    text-align:center;
    border-bottom:1px solid #1e293b;
    vertical-align:middle;
}

tr:hover{
    background:#111827;
}

.delete-btn{
    text-decoration:none;
    background:#dc2626;
    color:white;
    padding:8px 14px;
    border-radius:6px;
    transition:0.3s;
}

.delete-btn:hover{
    background:#b91c1c;
    box-shadow:0 0 10px rgba(220,38,38,0.5);
}

.course-tag{
    display:inline-block;
    padding:8px 18px;
    margin:5px;
    border-radius:20px;
    background:linear-gradient(45deg,#7b2ff7,#9d4edd);
    color:white;
    font-size:14px;
    font-weight:600;
    text-align:center;
    min-width:90px;
}

</style>

</head>

<body>

<div class="navbar">

    <a href="student-form">Add Student</a>

    <a href="course-form">Add Course</a>

    <a href="enroll-form">Enroll</a>

    <a href="enrollments">Enrollments</a>

    <a href="students">Students</a>

    <a href="courses">Courses</a>

</div>

<div class="dashboard">

<%

List students =
(List)request.getAttribute("students");

List courses =
(List)request.getAttribute("courses");

int studentCount =
students != null ? students.size() : 0;

int courseCount =
courses != null ? courses.size() : 0;

%>

<div class="analytics">

<div class="card-box">
<h3>Total Students</h3>
<p><%= studentCount %></p>
</div>

<div class="card-box">
<h3>Total Courses</h3>
<p><%= courseCount %></p>
</div>

<div class="card-box">
<h3>System Status</h3>
<p>ACTIVE</p>
</div>

</div>

<%

if(students != null){

%>

<div class="table-card">

<h2>Student Records</h2>

<table>

<tr>

<th>ID</th>
<th>Name</th>
<th>Assigned Courses</th>
<th>Action</th>

</tr>

<%

for(Object obj : students){

Student s = (Student)obj;

%>

<tr>

<td><%= s.getId() %></td>

<td><%= s.getName() %></td>

<td>

<%

if(s.getCourses() != null){

for(Course c : s.getCourses()){

%>

<span class="course-tag">
<%= c.getTitle() %>
</span>

<%
}
}
%>

</td>

<td>

<a class="delete-btn"
href="delete-student/<%= s.getId() %>">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

</div>

<%
}
%>

<%

if(courses != null){

%>

<div class="table-card">

<h2>Course Records</h2>

<table>

<tr>

<th>ID</th>
<th>Title</th>
<th>Students Enrolled</th>
<th>Action</th>

</tr>

<%

for(Object obj : courses){

Course c = (Course)obj;

%>

<tr>

<td><%= c.getId() %></td>

<td><%= c.getTitle() %></td>

<td>

<%

if(c.getStudents() != null){

for(Student s : c.getStudents()){

%>

<span class="course-tag">
<%= s.getName() %>
</span>

<%
}
}
%>

</td>

<td>

<a class="delete-btn"
href="delete-course/<%= c.getId() %>">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

</div>

<%
}
%>

</div>

</body>
</html>