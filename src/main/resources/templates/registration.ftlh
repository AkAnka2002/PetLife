<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1>PetLife</h1><hr>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Имя пользователя: <input type="text"  name="name" required><br><br>
    Эл. почта: <input type="email" name="email" required><br><br>
    Номер телефона: <input type="tel" name="phoneNumber" required><br><br>
    Пароль: <input type="password" name="password" required><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" class="btn btn-light me-2 btn-my nav_text" value="Регистрация"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</@t.template>