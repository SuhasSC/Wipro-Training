<!DOCTYPE html>
<html>
<head>
    <title>Error</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(135deg, #0f172a, #1e293b);
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .card {
            width: 300px;
            padding: 30px;
            border-radius: 14px;
            text-align: center;

            background: rgba(20, 30, 50, 0.95);
            box-shadow: 0 10px 30px rgba(0,0,0,0.6);

            border: 1px solid rgba(255, 0, 0, 0.2);
        }

        .title {
            color: #ff4d4d;
            font-size: 22px;
            margin-bottom: 10px;
        }

        .btn {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 20px;
            border-radius: 8px;

            background: linear-gradient(90deg, #ff4d4d, #ff1a1a);
            color: white;
            text-decoration: none;
            font-weight: bold;

            transition: 0.3s;
        }

        .btn:hover {
            transform: scale(1.05);
            box-shadow: 0 0 10px rgba(255, 0, 0, 0.6);
        }

    </style>
</head>

<body>

<div class="card">

    <div class="title">Access Denied</div>

    <a href="login.jsp" class="btn">Try Again</a>

</div>

</body>
</html>