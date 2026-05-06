<!DOCTYPE html>
<html>
<head>
    <title>QuickCart</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(135deg, #0f172a, #1e3a5f);
            display: flex;
            justify-content: center;
            align-items: center;
            }       

        .card {
            width: 340px;
            padding: 35px;
            border-radius: 16px;

            background: rgba(20, 30, 50, 0.9);
            backdrop-filter: blur(10px);

            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);
            }

        .title {
            color: #00ffd5;
            font-size: 26px;
            margin-bottom: 25px;
            letter-spacing: 1px;
        }

        .input-group {
            position: relative;
            margin: 20px 0;
        }

        input {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            outline: none;
            background: rgba(255,255,255,0.08);
            color: white;
        }

        label {
            position: absolute;
            left: 12px;
            top: 12px;
            color: #aaa;
            font-size: 14px;
            pointer-events: none;
            transition: 0.3s;
        }

        input:focus + label,
        input:valid + label {
            top: -10px;
            left: 10px;
            font-size: 11px;
            color: #00ffd5;
            background: #0f172a;
            padding: 0 5px;
        }

        .btn {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            border-radius: 10px;
            border: none;
            background: linear-gradient(90deg, #00ffd5, #00c2a8);
            color: #0f172a;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn:hover {
            transform: scale(1.05);
            box-shadow: 0 0 15px #00ffd5;
        }

        .footer {
            margin-top: 15px;
            font-size: 12px;
            color: #aaa;
        }

    </style>
</head>

<body>

<div class="card">

    <div class="title">QuickCart</div>

    <form action="login" method="post">

        <div class="input-group">
            <input type="email" name="email" required>
            <label>Email</label>
        </div>

        <div class="input-group">
            <input type="password" name="password" required>
            <label>Password</label>
        </div>

        <button class="btn">Login</button>

    </form>

    <div class="footer">
        Secure Login Portal
    </div>

</div>

</body>
</html>