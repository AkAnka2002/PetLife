<!DOCTYPE html>
<html>
<head>
    <title>PetLife</title>
</head>
<body>
<h1>PetLife</h1><hr>
<h4>Редактирование пользователя ${user.name}</h4>
<form action="/admin/user/edit" method="post">
   <#list roles as role>
       <div>
           <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
       </div>
   </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</body>
</html>