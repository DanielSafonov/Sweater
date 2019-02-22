<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="messages">
    <h2>Список сообщений</h2>


    <div class="table-responsive mt-2">
        <table class="table table-bordered table-hover table-sm">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Author</th>
                <th scope="col">Tag</th>
                <th scope="col">Message</th>
                <th scope="col">Image Link</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
                <#list messages as message>
                    <tr>
                    <td>${message.id}</td>
                    <td>${message.authorName}</td>
                    <td>${message.tag}</td>
                    <td>${message.text}</td>
                    <td>${message.getFilePath()}</td>
                    <td><a href="/message/${message.id}">Edit</a></td>
                    <td><a href="/message/delete/${message.id}">Delete</a></td>
                    </tr>
                <#else>
                    <tr></tr>
                </#list>
            </tbody>
        </table>
    </div>

</@layout.page>