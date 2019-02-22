<!-- Фрагмент с панелью навигации -->

<#include "security.ftl">
<#import "auth.ftl" as auth>

<#macro navbar>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="index.html">Sweater</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Развернуть">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home">Лента</a>
            </li>

            <!-- Доступные только админу элементы меню -->
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Администрирование</a>
                </li>
            </#if>

        </ul>

        <!-- Имя пользователя или ссылка на вход -->
        <div class="navbar-text">
            <#if name != "unknown">
                <!-- Имя пользователя и кнопка logout -->
                <span><b class="mr-3">${name}</b> <@auth.logout/></span>
                <#else>
                    <!-- Ссылка на вход в аккаунт -->
                    <a href="/login">Login</a>
            </#if>
        </div>

    </div>
</nav>
</#macro>