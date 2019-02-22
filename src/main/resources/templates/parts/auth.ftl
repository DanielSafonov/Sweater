<!-- Фрагмент с формой логина, регистрации и выхода -->

    <!-- Фрагмент с формой логина -->
<#macro login>
    <div class="row text-center">
        <div class="col-md-4">

            <form action="/login" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен -->
                <input type="text" name="username" class="form-control mt-1" placeholder="Логин" required autofocus>
                <input type="password" name="password" class="form-control mt-1" placeholder="Пароль" required>
                <button class="btn btn-lg btn-primary btn-block mt-3 mb-1" type="submit">Вход</button>
            </form>

            <a href="/registration">Регистрация</a>
        </div>
    </div>
</#macro>

    <!-- Фрагмент с формой регистации -->
<#macro registration>
    <div class="row text-center">
        <div class="col-md-4">
            <form action="/registration" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен -->
                <input type="text" name="username" class="form-control mt-1" placeholder="Логин" required autofocus>
                <input type="password" name="password" class="form-control mt-1" placeholder="Пароль" required>
                <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Регистрация</button>
            </form>
        </div>
    </div>
</#macro>

    <!-- Фрагмент с формой выхода -->
<#macro logout>
    <form action="/logout" class="form-inline my-2 my-lg-0" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" /> <!-- CSRF-токен -->
        <button class="btn btn-sm btn-secondary my-2 my-sm-0" type="submit">Выход</button>
    </form>
</#macro>