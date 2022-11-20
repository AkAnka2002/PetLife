<!DOCTYPE html>
<html>
<head>
    <title>PETLIFE</title>
</head>
<body>
<h1>PetLife</h1><hr>
<h4>Ваши животные</h4>
<form action="/" method="get">
    Поиск по типу животных: <input type="text" name="type"><br>
</form>
<#list pets as pet>
    <div>
        <p><b></b>${pet.name}</b>, ${pet.type} | <a href="/pet/${pet.id}">Подробнее...</a> </p>
    </div>
<#else>
    <h3>Животных нет</h3>
</#list>
<hr>
<h3>Добавить нового питомца</h3>
<form action="/pet/create" method="post">
    Кличка: <input type="text" name="name"/><br><br>
    Вид животного: <input type="text" name="type"/><br><br>
    Возраст: <input type="number" name="age"/> лет<br><br>
    Описание: <input type="text" name="description"/><br><br>
    <input type="submit" value="Добавить питомца"/>
</form>
</body>
</html>