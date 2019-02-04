<#import "parts/base.ftl" as base>

<@base.page>
    <h2>List of messages:</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Author</th>
                <th>Tag</th>
                <th>Message</th>
                <th>Image Link</th>
                <th>Edit link</th>
                <th>Delete link</th>
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
                    <td><a href="/message/${message.id}">Edit #${message.id}</a></td>
                    <td><a href="/message/delete/${message.id}">Delete #${message.id}</a></td>
                </tr>
                <#else>
                    <tr></tr>
            </#list>
        </tbody>
    </table>

</@base.page>