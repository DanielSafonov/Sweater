<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="users">
    <h2>User edit</h2>

    <form action="/user" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" hidden name="userID" value="${user.id}" />

        <label><b>Username:</b> <input type="text" value="${user.username}" name="username"/></label><br/>
        <div>
        <b>Roles: </b>
            <#list roles as role>
                <label><input type="checkbox" name="${role}"  ${user.roles?seq_contains(role)?string("checked", "")}/>
                    ${role} </label>
            </#list>
        </div>
        <label><b>Password:</b> <input type="password" value="${user.password}" name="password"/></label><br/>
        <button type="submit">Save</button>
    </form>
</@layout.page>