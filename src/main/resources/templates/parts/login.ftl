<!-- Форма логина/регистрации -->
<#macro login path button> <!-- Макрос с параметром path для action формы-->
<form action="${path}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен передается глобально -->
    <input type="text" name="username" placeholder="Login">
    <input type="password" name="password" placeholder="Password"> <br/>
    <button type="submit">${button}</button>
</form>
</#macro>