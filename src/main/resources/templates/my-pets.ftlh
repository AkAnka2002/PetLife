<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h4>Питомцы:</h4>
    <#list pets as pet>
        <div class="nav_text">
            <img src="/images/${pet.image.id?c}" height="20ps"/>
            <p><b>${pet.name}</b>, ${pet.type} | <a type="submit" class="btn btn-light me-2 btn-my nav_text" href="/pet/${pet.id?c}">Подробнее...</a></p>
        </div>
    <#else>
        <h5>Животных нет</h5>
    </#list>
    <hr>
    <a type="submit" class="btn btn-light me-2 btn-my nav_text" href="/pet/add">Добавить питомца</a>
</@t.template>