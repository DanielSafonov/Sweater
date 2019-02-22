<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->
<#import "parts/auth.ftl" as login><!-- Подключение шаблона формы логина -->

<@layout.page>
    <h2>Регистрация</h2>
    <@auth.registration/>
</@layout.page>