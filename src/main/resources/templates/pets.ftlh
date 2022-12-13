<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>PETLIFE</title>
</head>
<body>
<h1>PetLife</h1>
<hr>
<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
<#else>
    <a href="/login">Войти</a>
</#if>
<h4>Ваши животные</h4>
<form action="/" method="get">
    Поиск по типу животных: <input type="text" name="type">
    <input type="submit" value="Поиск"/>
</form>
<#list pets as pet>
    <div>
        <p><b>${pet.name}</b>, ${pet.type} | <a href="/pet/${pet.id?c}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Животных нет</h3>
</#list>
<#if user.email??>
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
</#if>
</body>
</html>