<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="users">
    <h2>Список пользователей</h2>

    <div class="table-responsive mt-2">
        <table class="table table-bordered table-hover table-sm">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Role</th>
                    <th scope="col">Edit</th>
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
                        <td><a href="/user/${user.id}">Edit ${user.username}</a</td>
                    </tr>
                        <#else>
                            <tr></tr>
                </#list>
            </tbody>
        </table>
    </div>
</@layout.page>
