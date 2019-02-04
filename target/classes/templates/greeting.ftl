<!-- Greeting -->
<#import "parts/base.ftl" as base> <!-- Подключение базового шаблона -->

<!-- Вложенный код для шаблона -->
<@base.page>
<div>
    Hello! <br/>
    <a href="/home">Go to main page</a>
</div>
</@base.page>