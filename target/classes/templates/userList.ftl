<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="users">
    <h2>List of users</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
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
</@layout.page>
