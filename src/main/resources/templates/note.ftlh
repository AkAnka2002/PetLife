<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h3>Добавить заметку</h3>
    <form action="/pet/${pet.id?c}/note" method="post" enctype="multipart/form-data">
        Заголовок: <input type="text" name="title" required/><br><br>
        Текст:<textarea type="text" class="my-input" name="text" required></textarea><br><br>
        Можно прикрепить изображение: <input type="file" class="btn btn-light me-2 btn-my nav_text" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" class="btn btn-light me-2  btn-my nav_text" value="Добавить заметку"/>
    </form>
</@t.template>