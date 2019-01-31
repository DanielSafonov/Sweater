<#import "parts/base.ftl" as base>

<@base.page>
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
                            ${role} <#sep>,
                        </#list>
                    </td>
                    <td><a href="/user/${user.id}">Edit ${user.username}</a</td>
                </tr>
                <#else>
                    <tr></tr>
            </#list>
        </tbody>
    </table>
</@base.page>
