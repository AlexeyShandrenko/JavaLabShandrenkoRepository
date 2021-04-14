<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>Profile Page</title>

</head>

<body>
<table>
    <h1>Your profile:</h1>
    <tr>
        <td>${user.getFirstName()}</td>
    </tr>
    <tr>
        <td>${user.getLastName()}</td>
    </tr>
    <tr>
        <td>${user.getEmail()}</td>
    </tr>
</table>
</body>
</html>