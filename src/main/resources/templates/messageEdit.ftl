<#import "parts/base.ftl" as base>

<@base.page>
    <h2>Message edit</h2>
    <form action="/message" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" hidden name="messageID" value="${message.id}" />

        <label><b>Author:</b> <input type="text" name="author" value="${message.authorName}" /></label><br/>
        <label><b>Tag:</b> <input type="text" name="tag" value="${message.tag}" /></label><br/>
        <label><b>Message text:</b> <input type="text" name="text" value="${message.text}"></label><br/>
        <label><b>File:</b> <input type="file" name="file"/></label><br/>
        <p><b>Current filename:</b> ${message.filePath?if_exists}</p>
        <button type="submit">Save</button>
    </form>
</@base.page>