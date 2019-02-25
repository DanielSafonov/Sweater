<!-- Фрагмент с панелью навигации (параметр - текущая страница)-->

<#include "security.ftl">

<#macro navbar currentPage>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="/">Sweater</a>
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

        <!-- Меню пользователя -->
    <#if name != "unknown">
        <!-- Авторизован -->
        <div class="dropdown">
            <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <b>${name} </b>
            </button>

            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenu">

                <button class="dropdown-item" type="button">Профиль</button>

                <form action="/logout" class="form-inline my-2 my-lg-0" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен -->
                    <button class="dropdown-item" type="submit">Выход</button>
                </form>

            </div>
        </div>
        <#else>
            <!-- Не авторизован -->
            <div class="navbar-text mr-3">
                <b><a href="/login">Login</a></b>
            </div>
    </#if>


    </div>
</nav>
</#macro>