<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>Profile Page</title>

    <style>
        a {
            position: relative;
            bottom: 0;
            left: 0;
        }
    </style>

</head>

<body>
<table>
    <h1>Your profile:</h1>
    <tr>
        <td>${users.getFirstName()}</td>
    </tr>
    <tr>
        <td>${users.getLastName()}</td>
    </tr>
<#--    <tr>-->
<#--        <td>${users.getEmail()}</td>-->
<#--    </tr>-->
    <a href="/logout">Exit</a>
</table>
</body>
</html>