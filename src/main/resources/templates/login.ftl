<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->
<#import "parts/auth.ftl" as auth><!-- Подключение шаблона формы логина -->

<@layout.page currentPage="none">
    <h2>Вход в аккаунт</h2>
    <@auth.login/>
</@layout.page>