<#import "parts/base.ftl" as base> <!-- Подключение базового шаблона -->
<#import "parts/login.ftl" as login><!-- Подключение шаблона формы логина -->

<@base.page>
    <h2>Registration page</h2>
    ${message}
    <@login.login "/registration" "SignUp" />
</@base.page>