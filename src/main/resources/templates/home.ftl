<#import "layouts/default.ftl" as base>

<@base.page>
    <!-- Блок создания нового сообщения -->
    <form method="post" enctype="multipart/form-data">
        <div class="row">
                <div class="col-8">
                    <textarea class="form-control h-100" name="text" id="messageArea" required wrap="soft" placeholder="Введите ваше сообщение здесь.."></textarea>
                </div>
                <div class="col-4">
                    <input class="form-control" type="text" name="tag" placeholder="Хэштэг">
                    <div class="custom-file mt-1">
                        <input type="file" class="custom-file-input" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Выберите изображение</label>
                    </div>
                    <input class="form-control mt-1" type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary mt-4 float-right">Отправить</button>
                </div>
        </div>
    </form>
    <hr/>

    <!-- Поиск сообщения по тэгу -->
    <div class="row justify-content-between mb-5 mt-3">
        <div class="col-7">
            <h2 class="mb-n1">Лента сообщений</h2>
        </div>
        <div class="col-5">
            <form class="form-inline float-right" method="get" action="/home">
                <input type="text" class="form-control" name="filter" value="${filter?if_exists}" placeholder="Поиск по тэгу">
                <button type="submit" class="btn btn-secondary ml-2">Поиск</button>
            </form>
        </div>
    </div>

    <!-- Список сообщений -->
    <div class="card-columns">
        <#list messages as message>
            <div class="card">
                <#if message.filename??>
                    <img src="/img/${message.filename}" class="card-img-top">
                </#if>

                <div class="card-body">
                    <p>${message.text}</p>
                </div>

                <div class="card-footer">
                    <b>Tag: </b> ${message.tag}
                    <b class="float-right">${message.authorName}</b>
                </div>


            </div>
        <#else>
            No message
        </#list>
    </div>

</@base.page>