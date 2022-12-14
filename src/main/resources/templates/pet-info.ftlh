<!DOCTYPE html>
<html>
<head>
    <title>PETLIFE</title>
</head>
<body>
<h1>PetLife</h1>
<hr>
<h4>Подробная информация о животном</h4>
<img src="/images/${image.id?c}" height="60ps"/> <br><br>
<b>Кличка: </b>${pet.name} <br>
<b>Вид: </b>${pet.type} <br>
<b>Возраст: </b>${pet.age} <br>
<b>Описание: </b>${pet.description} <br>
<hr>
<form action="/pet/delete/${pet.id?c}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить питомца"/>
</form>
</body>
</html>