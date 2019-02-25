<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="profile">
    <h2>Личный кабинет</h2>
    <div class="row">
        <div class="col-6">
            <form action="/profile" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="text" hidden name="userID" value="${user.id}" />

                <div class="form-group">
                    <label for="username" class="font-weight-bold">Логин</label>
                    <input type="text" class="form-control" id="username" value="${user.username}" name="username">
                </div>

                <div class="form-group">
                    <b>Права </b>
                    <div class="form-group">
                        <#list roles as role>
                            <div class="form-check">
                            <input type="checkbox" disabled class="form-check-input" id="role" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                            <label class="form-check-label" for="role">${role}</label>
                            </div>
                        </#list>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="font-weight-bold">Email</label>
                    <input type="email" class="form-control" id="email" value="${user.email}" name="email">
                </div>

                <div class="form-group">
                    <label for="firstName" class="font-weight-bold">Имя</label>
                    <input type="text" class="form-control" id="firstName" value="${user.firstName}" name="firstName">
                </div>

                <div class="form-group">
                    <label for="lastName" class="font-weight-bold">Фамилия</label>
                    <input type="text" class="form-control" id="lastName" value="${user.lastName}" name="lastName">
                </div>

                <div class="form-group">
                    <label for="password" class="font-weight-bold">Пароль</label>
                    <input type="password" class="form-control" id="password" value="${user.password}" name="password"/>
                </div>

                <button class="btn btn-primary mt-2" type="submit">Сохранить</button>
            </form>
        </div>
    </div>
</@layout.page>