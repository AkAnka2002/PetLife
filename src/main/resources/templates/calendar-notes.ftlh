<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h4>Заметки: за ${date} </h4>
    <#list notes as note>
        <div>
            <p> ${note.text} <form action="/calnote/${user.id?c}/delete/${note.id?c}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="btn btn-light me-2 btn-my nav_text" value="Удалить"/>
            </form></p><hr>
        </div>
    <#else>
        <h3>Заметок нет</h3>
    </#list>
</@t.template>