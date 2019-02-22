<!-- Фрагмент для получения данных сессии -->

<!-- Определение переменной сессии и приведение ее к bool-->
<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <!-- Сессия существует (вход осуществлен) - получение профиля пользователя -->
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
    >

    <#else >
        <!-- Сессия не существует -->
        <#assign
            name = "unknown"
            isAdmin = false
        >
</#if>