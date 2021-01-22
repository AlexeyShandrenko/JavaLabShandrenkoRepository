<#ftl encoding="utf-8">
<#include "base.ftlh">
<#macro title>Rock Playlist</#macro>
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
            margin: auto;
            margin-top: 30px;
            text-align: center;
        }

        .btn-secondary {
            background-color: rgb(35, 79, 85) !important;
            border-color: rgb(1, 53, 71) !important;
        }

        .btn-secondary_rock {
            background-color: rgb(0, 123, 255) !important;
            border-color: rgb(248, 243, 243) !important;
            color: white;
        }

        .main-playlist {
            margin-top: 30px;
        }

        .track-info {
            margin-top: 10px;
        }

        #audio {
            margin-top: 10px;
        }

        .page-footer {
            margin-top: 100px !important;
            background-color: rgb(248, 249, 250);
        }

        .btn-primary {
            position: relative;
            right: 150px;
        }
    </style>
</#macro>
<#macro content>
    <div class="navbar-img">
    </div>
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
                <input type="text" name="focus" required class="search-box" placeholder="Search"/>
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
<#--        <div class="btns-group">-->
<#--            <div class="btn-group" role="group" aria-label="Basic example">-->
<#--                <a href="/playlist_rock">-->
<#--                    <button type="button" class="btn btn-secondary_rock">Rock</button>-->
<#--                </a>-->
<#--                <a href="/playlist_pop">-->
<#--                    <button type="button" class="btn btn-secondary">Pop</button>-->
<#--                </a>-->
<#--                <a href="/playlist_classic">-->
<#--                    <button type="button" class="btn btn-secondary">Classical</button>-->
<#--                </a>-->
<#--                <a href="/playlist_hiphop">-->
<#--                    <button type="button" class="btn btn-secondary">Hip-Hop</button>-->
<#--                </a>-->
<#--            </div>-->
<#--        </div>-->

        <#if tracks??>
        <#list tracks as track>
        <div class="main-playlist">
            <div class="block-track">
                <div class="track-info">
                    <a class="artist-name">${track.artist_name}</a>
                    <a>-</a>
                    <a class="track-name">${track.track_name}</a>
                </div>
                <audio id="audio" src="../music/Joji,%20Lil%20Yachty%20-%20pretty%20boy.mp3" controls></audio>
            </div>
        </div>
        </#list>
            <#else>
            <h1>Your playlist is empty! Please, add tracks.</h1>
        </#if>
    </div>
    <footer class="page-footer font-small blue">
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="">ABU Music</a>
        </div>
    </footer>
</#macro>