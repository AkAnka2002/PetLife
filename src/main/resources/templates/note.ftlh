<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h3>Добавить заметку</h3>
    <form action="/pet/${pet.id?c}/note" method="post" enctype="multipart/form-data">
        Заголовок: <input type="text" name="title"/><br><br>
        Текст:<input type="text" name="text"/><br><br>
        Можно прикрепить изображение: <input type="file" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить заметку"/>
    </form>
</@t.template>