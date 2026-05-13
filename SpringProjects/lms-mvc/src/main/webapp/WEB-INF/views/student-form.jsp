<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>

    <style>

        body{
            background:#020617;
            font-family:Arial;
            display:flex;
            justify-content:center;
            align-items:center;
            height:100vh;
            margin:0;
        }

        .card{
            width:420px;
            background:#081028;
            padding:40px;
            border-radius:20px;
            border:1px solid #00d9ff;
            box-shadow:0 0 30px rgba(0,217,255,0.4);
        }

        h1{
            color:#22d3ee;
            text-align:center;
            margin-bottom:40px;
            font-size:52px;
        }

        input{
            width:100%;
            padding:18px;
            background:#020617;
            border:1px solid #00d9ff;
            border-radius:12px;
            color:white;
            font-size:20px;
            margin-bottom:25px;
        }

        button{
            width:100%;
            padding:18px;
            border:none;
            border-radius:12px;
            background:#22d3ee;
            color:black;
            font-size:28px;
            font-weight:bold;
            cursor:pointer;
            transition:0.3s;
        }

        button:hover{
            transform:scale(1.03);
            box-shadow:0 0 20px #22d3ee;
        }

        .links{
            text-align:center;
            margin-top:25px;
        }

        a{
            color:#22d3ee;
            text-decoration:none;
            margin:15px;
            font-size:20px;
        }

    </style>

</head>

<body>

<div class="card">

    <h1>Add Student</h1>

    <form action="save-student" method="post">

        <input type="text"
               name="name"
               placeholder="Enter student name"
               required>

        <button type="submit">
            Save Student
        </button>

    </form>

    <div class="links">
        <a href="students">View Students</a>
        <a href="courses">View Courses</a>
    </div>

</div>

</body>
</html>
