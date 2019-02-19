<#import "parts/base.ftl" as base> <!-- Подключение базового шаблона -->
<#import "parts/login.ftl" as login><!-- Подключение шаблона формы логина -->

<@base.page>
    <h2>Login page</h2>
    <@login.login "/login" "SignIn" />
</@base.page>