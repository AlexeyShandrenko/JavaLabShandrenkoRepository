<#ftl encoding="utf-8">
<#include "base.ftlh">
<#macro title>Главная страница</#macro>
<#macro style>
    <style>
        * {
            padding: 0;
            margin: 0;
            outline: 0;
        }

        .navbar-img {
            display: block;
            height: 200px;
            width: auto;
            background: url(https://static.hollywoodreporter.com/sites/default/files/2016/11/thr3_music2-h_2016.jpg) no-repeat center;
        }

        .navbar-brand {
            margin-left: 150px;
        }

        .my-profile {
            display: flex;
            flex-direction: row;
            position: relative;
            right: 170px;
            text-decoration: none;
            transition: color .15s
        }

        a:hover {
            text-decoration: none !important;
        }

        .my-profile-name {
            white-space: nowrap;
            display: inline-block;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            padding-right: 8px;
            padding-top: 3px;
        }

        .bi-person-fill {
            border: solid 1px #007bff;
            border-radius: 100px;
            padding: 2px;
        }

        .search-box, .search-wrapper {
            position: relative;
            padding: 10px;
        }

        .search-wrapper {
            width: 300px;
            margin-right: 312px;
        }

        .search-box {
            border: 1px solid #ccc;
            outline: 0;
            border-radius: 15px;
            height: 35px;
        }

        .search-box:focus {
            box-shadow: 0 0 5px 5px rgb(235, 235, 235);
        }

        .main-content {
            display: block;
            padding-right: 50px;
            padding-left: 50px;
            margin-top: 50px;
        }

        .left-side-content {
            display: block;
            margin-right: 50px;
            margin-left: 110px;
        }

        .main-page-forums-list {
            display: block;
            margin-bottom: 0;
            width: 710px;
        }

        .block-forums-list {
            display: block;
        }

        .forums-header {
            display: block;
            padding: 10px 10px 10px 10px;
            background-color: rgb(248, 249, 250);
            color: rgb(124, 124, 125);
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        }

        .forum-title-block {
            display: block;
            margin: 20px 100px 20px 30px;
        }

        .forum-title {
            font-size: 15px;
        }

        hr {
            border: none;
            height: 0.1px;
        }

        .forums-header-text {
            font-size: 20px;
            margin-bottom: 0;
            letter-spacing: 0.3px;
        }

        .form-inline {
            margin-right: 335px;
        }

        .right-side-content {
            display: block;
            float: right;
        }

        .page-footer {
            margin-top: 100px !important;
            background-color: rgb(248, 249, 250);
        }

        .btn-primary {
            position: relative;
            right: 150px;
        }

        .btn-2 {
            margin-top: -310px;
        }

        .edit-field {
            text-align: center;
            display: block;
            margin: auto;
            background-color: rgb(248, 249, 250);
            width: 950px;
        }

        .edit-field-content {
            padding: 30px;
        }

        .save-btn {
            height: 30px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            margin-top: 10px;
            width: 200px;
            cursor: pointer;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        }

        .save-btn:hover {
            background-color: rgb(000, 105, 217);
        }

        .input-field {
            margin-top: 10px;
            border-radius: 5px;
            border: 1px solid #ced4da;
            padding: 0 10px 0 10px;
            margin-bottom: 10px;
        }

        h4 {
            font-weight: 400 !important;
        }
    </style>
</#macro>
<#--<#macro css>-->
<#--    <link rel="stylesheet" href="../front/main/index-styles.css">-->
<#--</#macro>-->
<#--<head>-->
<#--    <meta charset="utf-8">-->
<#--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
<!--    <link rel="stylesheet" type="text/css" href="../../../../../../Music_Front/index-styles.css">-->
<#--    <#macro css>-->
<#--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"-->
<#--              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"-->
<#--              crossorigin="anonymous">-->
<#--    </#macro>-->
<#--    <link rel="shortcut icon" href="../icons/favicon.svg" type="image/x-icon">-->
<#--    <title>ITIS MUSIC</title>-->
<#--    <style>-->
<#--        * {-->
<#--            padding: 0;-->
<#--            margin: 0;-->
<#--            outline: 0;-->
<#--        }-->

<#--        .navbar-img {-->
<#--            display: block;-->
<#--            height: 200px;-->
<#--            width: auto;-->
<#--            background: url(../../../../../../Music_Front/img/header-img.jpg) no-repeat center;-->
<#--        }-->

<#--        .navbar-brand {-->
<#--            margin-left: 150px;-->
<#--        }-->

<#--        .my-profile {-->
<#--            display: flex;-->
<#--            flex-direction: row;-->
<#--            position: relative;-->
<#--            right: 170px;-->
<#--            text-decoration: none;-->
<#--            transition: color .15s-->
<#--        }-->

<#--        a:hover {-->
<#--            text-decoration: none !important;-->
<#--        }-->

<#--        .my-profile-name {-->
<#--            white-space: nowrap;-->
<#--            display: inline-block;-->
<#--            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;-->
<#--            padding-right: 8px;-->
<#--            padding-top: 3px;-->
<#--        }-->

<#--        .bi-person-fill {-->
<#--            border: solid 1px #007bff;-->
<#--            border-radius: 100px;-->
<#--            padding: 2px;-->
<#--        }-->

<#--        .search-box, .search-wrapper {-->
<#--            position: relative;-->
<#--            padding: 10px;-->
<#--        }-->

<#--        .search-wrapper {-->
<#--            width: 300px;-->
<#--            margin-right: 312px;-->
<#--        }-->

<#--        .search-box {-->
<#--            border: 1px solid #ccc;-->
<#--            outline: 0;-->
<#--            border-radius: 15px;-->
<#--            height: 35px;-->
<#--        }-->

<#--        .search-box:focus {-->
<#--            box-shadow: 0 0 5px 5px rgb(235, 235, 235);-->
<#--        }-->

<#--        .main-content {-->
<#--            display: block;-->
<#--            padding-right: 50px;-->
<#--            padding-left: 50px;-->
<#--            margin-top: 50px;-->
<#--        }-->

<#--        .left-side-content {-->
<#--            display: block;-->
<#--            margin-right: 50px;-->
<#--            margin-left: 110px;-->
<#--        }-->

<#--        .main-page-forums-list {-->
<#--            display: block;-->
<#--            margin-bottom: 0;-->
<#--            width: 710px;-->
<#--        }-->

<#--        .block-forums-list {-->
<#--            display: block;-->
<#--        }-->

<#--        .forums-header {-->
<#--            display: block;-->
<#--            padding: 10px 10px 10px 10px;-->
<#--            background-color: rgb(248, 249, 250);-->
<#--            color: rgb(124, 124, 125);-->
<#--            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;-->
<#--        }-->

<#--        .forum-title-block {-->
<#--            display: block;-->
<#--            margin: 20px 100px 20px 30px;-->
<#--        }-->

<#--        .forum-title {-->
<#--            font-size: 15px;-->
<#--        }-->

<#--        hr {-->
<#--            border: none;-->
<#--            height: 0.1px;-->
<#--        }-->

<#--        .forums-header-text {-->
<#--            font-size: 20px;-->
<#--            margin-bottom: 0;-->
<#--            letter-spacing: 0.3px;-->
<#--        }-->

<#--        .form-inline {-->
<#--            margin-right: 335px;-->
<#--        }-->

<#--        .right-side-content {-->
<#--            display: block;-->
<#--            float: right;-->
<#--        }-->

<#--        .page-footer {-->
<#--            margin-top: 100px !important;-->
<#--            background-color: rgb(248, 249, 250);-->
<#--        }-->

<#--        .btn-primary {-->
<#--            position: relative;-->
<#--            right: 150px;-->
<#--        }-->

<#--        .btn-2 {-->
<#--            margin-top: -310px;-->
<#--        }-->

<#--        .edit-field {-->
<#--            text-align: center;-->
<#--            display: block;-->
<#--            margin: auto;-->
<#--            background-color: rgb(248, 249, 250);-->
<#--            width: 950px;-->
<#--        }-->

<#--        .edit-field-content {-->
<#--            padding: 30px;-->
<#--        }-->

<#--        .save-btn {-->
<#--            height: 30px;-->
<#--            border: none;-->
<#--            border-radius: 5px;-->
<#--            background-color: #007bff;-->
<#--            color: #fff;-->
<#--            margin-top: 10px;-->
<#--            width: 200px;-->
<#--            cursor: pointer;-->
<#--            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;-->
<#--        }-->

<#--        .save-btn:hover {-->
<#--            background-color: rgb(000, 105, 217);-->
<#--        }-->

<#--        .input-field {-->
<#--            margin-top: 10px;-->
<#--            border-radius: 5px;-->
<#--            border: 1px solid #ced4da;-->
<#--            padding: 0 10px 0 10px;-->
<#--            margin-bottom: 10px;-->
<#--        }-->

<#--        h4 {-->
<#--            font-weight: 400 !important;-->
<#--        }-->

<#--    </style>-->
<#macro content>
<#--    <#if image??>-->
    <div class="navbar-img"></div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/main_page_anonymous">ABU MUSIC</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/community">Community</a>
                </li>
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="/playlist_rock">Playlist</a>-->
<#--                </li>-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="/my_playlist">My Playlist</a>-->
<#--                </li>-->
                <li class="nav-item">
                    <a class="nav-link" href="/faq">FAQ</a>
                </li>
            </ul>
        </div>
        <div class="search-wrapper">
            <form>
                <input id="search-container" type="text" name="focus" required class="search-box"
                       placeholder="Search"/>
            </form>
        </div>
<#--        <a href="/profile" class="my-profile">-->
<#--            <div class="my-profile-name">-->
<#--                My profile-->
<#--            </div>-->
<#--            <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor"-->
<#--                 xmlns="http://www.w3.org/2000/svg">-->
<#--                <path fill-rule="evenodd"-->
<#--                      d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>-->
<#--            </svg>-->
<#--        </a>-->
    </nav>
    <div class="main-content">
        <div class="left-side-content">
            <ol class="main-page-forums-list">
                <ol class="block-forums-list">
                    <div class="forums-header">
                        <h3 class="forums-header-text">
                            Public Chats
                        </h3>
                    </div>
                    <ol class="forums-list">
                        <div class="forum-announcement">
                            <div class="forum-title-block">
                                <h3 class="forum-title">
                                    <a href="../../../../../../Music_Front/chat-flood.html">Flooding</a>
                                </h3>
                            </div>
                        </div>
                        <hr>
                        <div class="forum-announcement">
                            <div class="forum-title-block">
                                <h3 class="forum-title">
                                    <a href="../../../../../../Music_Front/chat-ideas.html">Ideas for concerts</a>
                                </h3>
                            </div>
                        </div>
                    </ol>
                </ol>
            </ol>
        </div>
        <#--            <div class="right-side-content">-->
        <#--                <div class="add-chat-btn">-->
        <#--                    <a href="../../../../../../Music_Front/add-chat.html">-->
        <#--                        <button type="button" class="btn btn-primary btn-2">Create new chat</button>-->
        <#--                    </a>-->
        <#--                </div>-->
        <#--            </div>-->
    </div>
    <footer class="page-footer font-small blue">
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="">ABU Music</a>
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
<#--    </#if>-->
</#macro>
