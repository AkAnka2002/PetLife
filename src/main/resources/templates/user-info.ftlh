<#import "blocks/template.ftlh" as t>
<@t.template user>
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

    <a href="/pet/${user.id?c}/mypet">Питомцы</a>
</@t.template>