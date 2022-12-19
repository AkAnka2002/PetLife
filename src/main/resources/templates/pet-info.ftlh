<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h4>Подробная информация о животном</h4>
    <img src="/images/${pet.getImage().getId()}" height="60ps"/> <br><br>
    <b>Кличка: </b>${pet.name} <br>
    <b>Вид: </b>${pet.type} <br>
    <b>Порода: </b>${pet.breed} <br>
    <b>Пол: </b>${pet.gender}<br>
    <b>Возраст: </b>${pet.age} <br>
    <b>Кастрация: </b>${pet.castration}<br>
    <b>Описание: </b>${pet.description} <br>
    <hr>
    <b>Заметки: </b><br>
    <#list notes as note>
        <div>
            <p><b>${note.title}</b><br>${note.text}<br>
                <#if note.hasImage()>
                <img src="/images/${note.getImage().getId()}" height="60ps"/> <br><br>
                <#else>
            <p> Изображения нет </p>
            </#if>
            <form action="/note/delete/${note.id?c}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Удалить заметку"/>
            </form>
            </p>
        </div>
    <#else>
        <h3>Заметок нет</h3>
    </#list>
    <a href="/pet/${pet.id?c}/note">Добавить новую заметку</a><br>
    <a href="/pet/${pet.id?c}/update">Редактировать питомца</a>
    <form action="/pet/delete/${pet.id?c}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Удалить питомца"/>
    </form>
</@t.template>