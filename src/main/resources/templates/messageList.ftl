<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="messages">
    <h2>Список сообщений</h2>

    <div class="table-responsive mt-2">
        <table class="table table-bordered table-hover table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Автор</th>
                <th scope="col">Тэг</th>
                <th scope="col">Сообщение</th>
                <th scope="col">Изображение</th>
                <th scope="col">Изменить</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
                <#list messages as message>
                    <tr>
                    <td>${message.id}</td>
                    <td>${message.authorName}</td>
                    <td>${message.tag}</td>
                    <td>${message.text}</td>
                    <td><a href="/img/${message.filePath?if_exists}" target="_blank">${message.filePath?if_exists?substring(message.filePath?index_of(".")+1)}</a></td>
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