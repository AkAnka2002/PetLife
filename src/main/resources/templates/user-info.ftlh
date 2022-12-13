<!DOCTYPE html>
<html>
<head>
    <title>PetLife</title>
</head>
<body>
<h1>PetLife</h1><hr>
<h4>Профиль</h4>
<b>Имя: </b> ${user.name} <br>
<b>Адрес электронной почты: </b> ${user.email} <br>
<b>Номер телефона: </b> ${user.phoneNumber} <br>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
<h4>Животные:</h4>
<#--<form action="/" method="get">-->
<#--    Поиск по типу животных: <input type="text" name="type">-->
<#--    <input type="submit" value="Поиск"/>-->
<#--</form>-->
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
</body>
</html>