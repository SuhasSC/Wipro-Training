<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>

    <style>
        body {
            margin: 0;
            padding: 40px;
            font-family: 'Segoe UI', sans-serif;

            background: linear-gradient(135deg, #0f172a, #1e3a5f);
            color: white;
        }

        .header {
            display: flex;
            justify-content: space-between;
            margin-bottom: 40px;
        }

        .title {
            font-size: 26px;
            color: #00ffd5;
        }

        .message {
            font-size: 16px;
            color: #cbd5e1;
        }

        .grid {
            display: flex;
            gap: 20px;
        }

        .card {
            width: 220px;
            padding: 20px;
            border-radius: 12px;

            background: #1e293b;
            text-align: center;

            transition: 0.3s;
        }

        .card:hover {
            background: #00ffd5;
            color: #0f172a;
            transform: translateY(-5px);
        }

        .product {
            font-size: 18px;
            font-weight: bold;
        }

    </style>
</head>

<body>

<div class="header">
    <div class="title">QuickCart</div>
    <div class="message">${message}</div>
</div>

<div class="grid">
    <div class="card">
        <div class="product">Wireless Headphones</div>
    </div>

    <div class="card">
        <div class="product">Smart Watch</div>
    </div>

    <div class="card">
        <div class="product">Bluetooth Speaker</div>
    </div>
</div>

</body>
</html>