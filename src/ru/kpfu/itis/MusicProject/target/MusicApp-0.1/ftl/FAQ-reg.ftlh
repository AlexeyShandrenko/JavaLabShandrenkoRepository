<#ftl encoding="utf-8">
<#include "base.ftlh">
<#macro title>FAQ</#macro>
<#macro style>
    <style>
        *
        {
            padding:0;
            margin:0;
            outline: 0;
        }
        .navbar-img
        {
            display:block;
            height:200px;
            width: auto;
            background: url(../img/header-img.jpg) no-repeat center;
        }
        .navbar-brand
        {
            margin-left: 150px;
        }
        .my-profile
        {
            display: flex;
            flex-direction: row;
            position: relative;
            right: 170px;
            text-decoration: none;
            transition: color .15s
        }
        a:hover
        {
            text-decoration: none!important;
        }
        .my-profile-name
        {
            white-space: nowrap;
            display: inline-block;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            padding-right: 8px;
            padding-top: 3px;
        }
        .bi-person-fill
        {
            border: solid 1px #007bff;
            border-radius:100px;
            padding: 2px;
        }

        .search-box, .search-wrapper
        {
            position: relative;
            padding: 10px;
        }
        .search-wrapper
        {
            width: 300px;
            margin-right: 312px;
        }
        .search-box
        {
            border: 1px solid #ccc;
            outline: 0;
            border-radius: 15px;
            height: 35px;
        }
        .search-box:focus
        {
            box-shadow: 0 0 5px 5px rgb(235,235,235);
        }
        #faq
        {
            max-width: 700px;
            margin: auto;
            margin-top: 30px;
            padding: 0 15px;
            text-align: center;
        }
        section.faq
        {
            padding-top: 2em;
            padding-bottom: 3em;
        }
        #faq ul
        {
            text-align: center;
        }
        #faq h3
        {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: #000;
            margin-bottom: 30px;
            font-size: 25px;
        }
        #faq h4
        {
            color: #007bff;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            line-height: 34px;
            font-size: 20px;
            text-align: left;
            padding: 15px 20px 0;
            text-transform: none;
            display: block;
            cursor: pointer;
            transition: .2s;
            text-align: center;
        }
        #faq p
        {
            color: #333;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            line-height: 1.45;
            position: relative;
            overflow: hidden;
            max-height: 250px;
            display: inline-block;
            opacity: 1;
            transform: translate(0, 0);
            margin-top: 5px;
            margin-bottom: 15px;
            transition: .3s opacity, .6s max-height;
            z-index: 2;
        }
        #faq ul li
        {
            position: relative;
            overflow: hidden;
        }
        #faq ul li i
        {
            position: absolute;
            transform: translate(-6px, 0);
            margin-top: 25px;
            right: 15px;
        }
        #faq ul li i:before, ul li i:after
        {
            content: "";
            position: absolute;
            background-color: #007bff;;
            width: 3px;
            height: 9px;
        }
        #faq ul li i:before
        {
            transform: translate(-2px, 0) rotate(45deg);
        }
        #faq ul li i:after
        {
            transform: translate(2px, 0) rotate(-45deg);
        }
        #faq ul li input
        {
            position: absolute;
            cursor: pointer;
            width: 100%;
            height: 100%;
            z-index: 1;
            opacity: 0;
            touch-action: manipulation;
        }
        #faq ul li input:checked ~ h4
        {
            color: #000;
        }
        #faq ul li input:checked ~ p
        {
            max-height: 0;
            transition: .3s;
            opacity: 0;
        }
        #faq ul li input:checked ~ i:before
        {
            transform: translate(2px, 0) rotate(45deg);
        }
        #faq ul li input:checked ~ i:after
        {
            transform: translate(-2px, 0) rotate(-45deg);
        }
        .page-footer
        {
            background-color: rgb(248,249,250);
        }
        .btn-primary
        {
            position: relative;
            right: 150px;
        }
    </style>
</#macro>
<#macro content>
    <div class="navbar-img"></div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/main_page">ABU MUSIC</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/community">Community</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/playlist_rock">Playlist</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/my_playlist">My Playlist</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/faq">FAQ</a>
                </li>
            </ul>
        </div>
        <div class="search-wrapper">
            <form>
                <input type="text" name="focus" required class="search-box" placeholder="Search" />
            </form>
        </div>
        <a href="/profile" class="my-profile">
            <div class="my-profile-name">
                My profile
            </div>
            <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            </svg>
        </a>
    </nav>
    <div id="faq">
        <h3>FAQ</h3>
        <ul>
            <li>
                <input type="checkbox" checked>
                <i></i>
                <h4>Что такое ABU MUSIC?</h4>
                <p>Сборище пользователей с общими музыкальными вкусами:)</p>
            </li>
            <hr>
            <li>
                <input type="checkbox" checked>
                <i></i>
                <h4>Как создать форум?</h4>
                <p>Вы можете создать свой собственный чат на главной странице</p>
            </li>
            <hr>
            <li>
                <input type="checkbox" checked>
                <i></i>
                <h4>Почему сайт не работает?</h4>
                <p>Он работает!</p>
            </li>
            <hr>
            <li>
                <input type="checkbox" checked>
                <i></i>
                <h4>Как мне добавить музыку в свой личный плейлист?</h4>
                <p>Нажми кнопочку "добавить"</p>
            </li>
        </ul>
    </div>
    <footer class="page-footer font-small blue">
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="">ABU Music</a>
        </div>
    </footer>
</#macro>