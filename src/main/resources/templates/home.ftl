<#import "parts/base.ftl" as base>
<#import "parts/logout.ftl" as logout>

<@base.page>
    <h1>Home page</h1>

    <@logout.logout/> <!-- Кнопка logout -->
    <a href="/user">Admin</a>

    <div>
        <h2>Add message</h2>
        <form method="post">
            <input type="text" name="text" placeholder="Message">
            <input type="text" name="tag" placeholder="Tag">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Add</button>
        </form>
    </div>

    <hr/>

    <div>
        <h2>Messages list:</h2>
        <form method="get" action="home">
            <input type="text" name="filter" value="${filter?if_exists}" placeholder="Filter by tag">
            <button type="submit">Search</button>
        </form>

        <!-- Обход списка messages -->
       <#list messages as message>
           <div>
               <b>#${message.id}</b>
               ${message.text}
               <b>${message.tag}</b>
               <u>${message.authorName}</u>
           </div>
           <#else> <!-- Если messages пустой -->
           No messages
       </#list>
    </div>
</@base.page>