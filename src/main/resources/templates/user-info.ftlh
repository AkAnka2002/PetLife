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
    <h3>Добавить нового питомца</h3>
    <form action="/pet/create" method="post" enctype="multipart/form-data">
        Кличка: <input type="text" name="name"/><br><br>
        Вид животного: <input type="text" name="type"/><br><br>
        Возраст: <input type="number" name="age"/> лет<br><br>
        Описание: <input type="text" name="description"/><br><br>
        Фотография: <input type="file" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить питомца"/>
    </form>
</@t.template>