<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="users">
    <h2>Список пользователей</h2>

    <div class="table-responsive mt-2">
        <table class="table table-bordered table-hover table-sm">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Логин</th>
                    <th scope="col">Права</th>
                    <th scope="col">Email</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Изменить</th>
                    <th scope="col">Удалить</th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>
                            <#list user.roles as role>
                                ${role}<#sep>,
                            </#list>
                        </td>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td><a class="btn btn-secondary btn-sm btn-block" href="/user/${user.id}">Изменить</a></td>
                        <td><a class="btn btn-secondary btn-sm btn-block" href="/user/delete/${user.id}">Удалить</a></td>
                    </tr>
                        <#else>
                            <tr></tr>
                </#list>
            </tbody>
        </table>
    </div>
</@layout.page>
