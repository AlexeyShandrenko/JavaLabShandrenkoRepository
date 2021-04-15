<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>Login Page</title>

    <link rel="stylesheet" href="../static/css/login_style.css">

</head>

<body>

<div class="wrapper">
    <div class="registration">
        <form class="registration__box" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <a href="/base_page"><img src="../static/images/logo.png" alt="" class="registration__img"></a>
            <h1 class="registration__title"><@spring.message 'login_title'/></h1>
            <input type="email" name="email" placeholder="<@spring.message 'login_email'/>">
            <input type="password" name="password" placeholder="<@spring.message 'login_password'/>">
            <a href="" class=""><input type="submit" value="<@spring.message 'login_enter'/>"></a>
            <div class="sign-up"> <@spring.message 'login_sign_up1'/> <a href="/sign_up" class="sign-up__link"><@spring.message 'login_sign_up2'/></a></div>
        </form>
    </div>

    <div class="localization-button">
        <p><a href="?lang=ru">RU</a></p>
        <p><a href="?lang=en">EN</a></p>
    </div>

</div>

</body>

</html>