<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h4>Питомцы:</h4>
    <#list pets as pet>
        <div>
            <p><b>${pet.name}</b>, ${pet.type} | <a href="/pet/${pet.id?c}">Подробнее...</a></p>
        </div>
    <#else>
        <h3>Животных нет</h3>
    </#list>
    <hr>
    <a href="/pet/add">Добавить питомца</a>
</@t.template>