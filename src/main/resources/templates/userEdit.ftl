<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="users">
    <h2 class="mb-3">Изменение профиля пользователя</h2>

    <div class="row">
        <div class="col-6">
            <form action="/user" method="post">
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
                                <input type="checkbox" class="form-check-input" id="role" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                                <label class="form-check-label" for="role">${role}</label>
                            </div>
                        </#list>
                    </div>
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