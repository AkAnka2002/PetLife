<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1>PetLife</h1>
    <hr>
    <h4>Профиль</h4>
    <img src="/images/${image.id?c}" height="60ps"/> <br><br>
    <b>Имя: </b> ${user.name} <br>
    <b>Адрес электронной почты: </b> ${user.email} <br>
    <b>Номер телефона: </b> ${user.phoneNumber} <br>
    <b>Пол: </b> ${user.gender} <br>
    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
    <a href="/user/${user.id?c}/update">Редактировать</a>
    <h4>Животные:</h4>
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