<!-- Форма логина/регистрации -->
<#macro login path button> <!-- Макрос с параметром path для action формы-->
    <div class="row text-center">
        <div class="col-md-4">
            <form action="${path}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен передается глобально -->
                <input type="text" name="username" class="form-control mt-1" placeholder="Логин" required autofocus>
                <input type="password" name="password" class="form-control mt-1" placeholder="Пароль" required>
                <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">${button}</button>
            </form>
            <a href="/registration">SignUp</a>
        </div>
    </div>
</#macro>