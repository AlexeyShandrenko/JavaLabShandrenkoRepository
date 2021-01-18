<#ftl encoding="utf-8">
<#include "base.ftlh">
<#macro title>Community</#macro>
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
            background: url(../img/header-img.jpg) no-repeat center;
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
            margin-top: 60px;
            display: block;
            text-align: center;
            margin-left: 400px;
            margin-right: 400px;
        }

        .user-block {
            background-color: rgb(248, 249, 250);
            padding: 20px 30px 20px 30px;
            margin-right: 20px;
        }

        .page-footer {
            margin-top: 100px !important;
            background-color: rgb(248, 249, 250);
        }

        .svg-pic {
            float: left;
            margin-top: 10px;
            color: #007bff;
        }
    </style>
</#macro>
<#macro content>
    <div class="navbar-img"></div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/main_page">ABU MUSIC</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
                <input id="search-container" type="text" name="focus" required class="search-box" placeholder="Search"/>
            </form>
        </div>
        <a href="/profile" class="my-profile">
            <div class="my-profile-name">
                My profile
            </div>
            <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor"
                 xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                      d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            </svg>
        </a>
    </nav>
    <div class="main-content">
        <h4 class="list-of-users-text">LIST OF USERS</h4>
        <#list users as user>
            <ol class="list-of-users">
                <div class="user-block">
                    <div class="svg-pic">
                        <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>
                    </div>
                    <a href="../profile/user_profile.html">${user.firstname} ${user.lastname}</a>
                    <div class="user-info">
                        <a class="e-mail">Email:</a>
                        <a class="e-mail-info">${user.email}</a>
                        <a class="e-mail">Age:</a>
                        <a class="e-mail-info">${user.age}</a>
                    </div>
                </div>
                <hr>
                <#--            <div class="user-block">-->
                <#--                <div class="svg-pic">-->
                <#--                    <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">-->
                <#--                        <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>-->
                <#--                    </svg>-->
                <#--                </div>-->
                <#--                <a href="../profile/user_profile.html">USERNAME</a>-->
                <#--                <div class="user-info">-->
                <#--                    <a class="e-mail">E-mail:</a>-->
                <#--                    <a class="e-mail-info">xxx@xxx.xxx</a>-->
                <#--                </div>-->
                <#--            </div>-->
                <#--            <hr>-->
                <#--            <div class="user-block">-->
                <#--                <div class="svg-pic">-->
                <#--                    <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">-->
                <#--                        <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>-->
                <#--                    </svg>-->
                <#--                </div>-->
                <#--                <a href="../profile/user_profile.html">USERNAME</a>-->
                <#--                <div class="user-info">-->
                <#--                    <a class="e-mail">E-mail:</a>-->
                <#--                    <a class="e-mail-info">xxx@xxx.xxx</a>-->
                <#--                </div>-->
                <#--            </div>-->
                <#--            <hr>-->
            </ol>
        </#list>
    </div>
    <footer class="page-footer font-small blue">
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="">ABU Music</a>
        </div>
    </footer>
</#macro>