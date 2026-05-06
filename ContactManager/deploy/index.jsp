<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

    <h1>Contact Manager</h1>

    <form action="addContact" method="post" class="contact-form">

        <input type="text" name="name" placeholder="Enter Name" required>

        <input type="text" name="phone" placeholder="Enter Phone Number" required>

        <input type="email" name="email" placeholder="Enter Email" required>

        <button type="submit">Add Contact</button>

    </form>

</div>

</body>
</html>