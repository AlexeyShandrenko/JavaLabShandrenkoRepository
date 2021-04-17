<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>SignUp Page</title>

    <link rel="stylesheet" href="../static/css/sign_up_style.css">

</head>

<body>
<@spring.bind "userForm"/>
<div class="wrapper">
    <div class="registration">
        <form class="registration__box" action="/sign_up" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <a href="/base_page"><img src="../static/images/logo.png" alt="" class="registration__img"></a>
            <h1 class="registration__title"><@spring.message 'sign_up_registration__title'/></h1>

            <@spring.formInput "userForm.firstname" "placeholder='Firstname'"/>
            <@spring.showErrors "<br>" "error"/>

            <@spring.formInput "userForm.lastname" "placeholder='Lastname'"/>
            <@spring.showErrors "<br>" "error"/>

            <#if namesErrorMessage??>
                <p class="errorMessage">${namesErrorMessage}</p>
            </#if>

            <@spring.formInput "userForm.email" "placeholder='Email'"/>
            <@spring.showErrors "<br>" "error"/>

            <@spring.formPasswordInput "userForm.password" "placeholder='Password'"/>
            <@spring.showErrors "<br>" "error"/>

            <@spring.formPasswordInput "userForm.password_repeat" "placeholder='Password Repeat'"/>
            <@spring.showErrors "<br>" "error"/>

            <#if passwordMatchErrorMessage??>
                <p class="passwordMatchErrorMessage">${passwordMatchErrorMessage}</p>
            </#if>

            <@spring.formInput "userForm.age" "placeholder='Age'"/>
            <@spring.showErrors "<br>" "error"/>
            <a href="/sign_in" class=""><input type="submit" value="<@spring.message 'sign_up_submit'/>"></a>
        </form>
    </div>

    <div class="localization-button">
        <p><a href="?lang=ru">RU</a></p>
        <p><a href="?lang=en">EN</a></p>
    </div>

</div>

</body>

</html>