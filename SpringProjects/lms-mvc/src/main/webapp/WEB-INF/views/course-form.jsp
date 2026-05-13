<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>

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
            background:#12061f;
            padding:40px;
            border-radius:20px;
            border:1px solid #9333ea;
            box-shadow:0 0 30px rgba(147,51,234,0.4);
        }

        h1{
            color:#a855f7;
            text-align:center;
            margin-bottom:40px;
            font-size:52px;
        }

        input{
            width:100%;
            padding:18px;
            background:#020617;
            border:1px solid #9333ea;
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
            background:linear-gradient(90deg,#7e22ce,#a855f7);
            color:white;
            font-size:28px;
            font-weight:bold;
            cursor:pointer;
            transition:0.3s;
        }

        button:hover{
            transform:scale(1.03);
            box-shadow:0 0 20px #9333ea;
        }

        .links{
            text-align:center;
            margin-top:25px;
        }

        a{
            color:#c084fc;
            text-decoration:none;
            margin:15px;
            font-size:20px;
        }

    </style>

</head>

<body>

<div class="card">

    <h1>Add Course</h1>

    <form action="save-course" method="post">

        <input type="text"
               name="title"
               placeholder="Enter course title"
               required>

        <button type="submit">
            Save Course
        </button>

    </form>

    <div class="links">
        <a href="students">View Students</a>
        <a href="courses">View Courses</a>
    </div>

</div>

</body>
</html>
