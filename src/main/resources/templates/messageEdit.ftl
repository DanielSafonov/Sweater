<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

<@layout.page currentPage="messages">
    <h2 class="mb-3">Изменение сообщения</h2>

    <div class="row">
        <div class="col-6">
            <form action="/message" method="post" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="text" hidden name="messageID" value="${message.id}" />

                <div class="form-group">
                    <label for="author" class="font-weight-bold">Автор</label>
                    <input type="text" class="form-control" id="author" value="${message.authorName}" name="author">
                </div>

                 <div class="form-group">
                    <label for="tag" class="font-weight-bold">Тэг</label>
                    <input type="text" class="form-control" id="tag" value="${message.tag}" name="tag">
                </div>

                <div class="form-group">
                    <label for="text" class="font-weight-bold">Сообщение</label>
                    <input type="text" class="form-control" id="text" value="${message.text}" name="text">
                </div>

                <div class="form-group">
                    <label for="customFile" class="font-weight-bold">Изображение</label>
                     <div class="custom-file">
                        <input type="file" accept="image/*" class="custom-file-input" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">${message.filePath?if_exists?substring(message.filePath?index_of(".")+1)}</label>
                    </div>
                </div>

                <button class="btn btn-primary mt-2" type="submit">Сохранить</button>
            </form>
        </div>
    </div>
</@layout.page>