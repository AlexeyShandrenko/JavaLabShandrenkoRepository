
<html lang="en">
<head>
    <title>Users</title>
</head>
<body>
<div>
    <h1 style="color: ${color.value}">USERS</h1>
    <form action="/users" method="post">
        <input type="password" name="password" placeholder="password ">
        <select name="color">
            <option value="red">RED</option>
            <option value="green">GREEN</option>
            <option value="blue">BLUE</option>
        </select>
        <input type="submit" value="OK">
    </form>
</div>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <#list users as listUser>
            <tr>
                <td>${listUser.id}</td>
                <td>${listUser.firstname}</td>
                <td>${listUser.lastname}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
