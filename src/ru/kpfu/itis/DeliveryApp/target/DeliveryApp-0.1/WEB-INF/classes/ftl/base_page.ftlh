<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <title>Base Page</title>

    <link rel="stylesheet" href="/static/css/base_page_style.css">

</head>

<body>

<div class="wrapper">
    <div class="content">
        <div class="menu">
            <ul class="menu__list">
                <li class="menu__element"><a href="#"><@spring.message 'base_page_list1'/></a></li>
                <li class="menu__element"><a href="#"><@spring.message 'base_page_list2'/></a></li>
                <li class="menu__element"><a href="#"><@spring.message 'base_page_list3'/></a></li>
                <li class="menu__element"><a href="/sign_up"><@spring.message 'base_page_list4'/></a></li>
            </ul>
        </div>

        <div class="title">
            <p class="title__main"><@spring.message 'base_page_title__main'/></p>
            <p class="title__text"><@spring.message 'base_page_title__text'/></p>
            <p class="title__text-info"><@spring.message 'base_page_title__info1'/> <b style="font-size: 20px;"><@spring.message 'base_page_title__info2'/></b></p>

            <div class="button">
                <div class="button__element">
                    <a href="/login" class="button__content"><@spring.message 'base_page_enter'/></a>
                </div>
            </div>
        </div>

        <div class="localization-button">
            <p><a href="?lang=ru">RU</a></p>
            <p><a href="?lang=en">EN</a></p>
        </div>

    </div>
</div>

</body>

</html>