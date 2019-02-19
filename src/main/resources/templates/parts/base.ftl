<!-- Базовая обертка для всех страниц -->
<#macro page>
<!DOCTYPE html>
<html>
<head>
    <title>Sweater</title>
    <meta charset="UTF-8" content="text/html" http-equiv="Content-Type"/>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
    <#nested> <!-- Контент страницы - вложенный код -->
</body>
</html>
</#macro>