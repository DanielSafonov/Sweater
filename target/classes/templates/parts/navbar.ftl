<!-- Фрагмент с панелью навигации (параметр - текущая страница)-->

<#include "security.ftl">
<#import "auth.ftl" as auth>

<#macro navbar currentPage>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="index.html">Sweater</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Развернуть">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">

            <#if currentPage == "greeting">
                <li class="nav-item active">
                <#else>
                    <li class="nav-item">
            </#if>
                    <a class="nav-link" href="/">Главная</a>
                </li>

            <#if currentPage == "main">
                <li class="nav-item active">
                <#else>
                    <li class="nav-item">
            </#if>
                    <a class="nav-link" href="/main">Лента</a>
                </li>

            <!-- Доступные только админу элементы меню -->
            <#if isAdmin>
                <#if currentPage == "users">
                    <li class="nav-item active">
                    <#else>
                        <li class="nav-item">
                </#if>
                        <a class="nav-link" href="/user">Пользователи</a>
                    </li>

                <#if currentPage == "messages">
                    <li class="nav-item active">
                    <#else>
                        <li class="nav-item">
                </#if>
                        <a class="nav-link" href="/message">Сообщения</a>
                    </li>
            </#if>
        </ul>

        <!-- Имя пользователя и кнопка выхода или ссылка на вход -->
        <#if name != "unknown">
            <!-- Имя пользователя и кнопка logout -->
            <div class="navbar-text mr-3"><b>${name} </b></div>
            <@auth.logout />
            <#else>
                <!-- Ссылка на вход в аккаунт -->
                <div class="navbar-text mr-3">
                    <b><a href="/login">Login</a></b>
                </div>
        </#if>
    </div>
</nav>
</#macro>