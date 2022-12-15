<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1>PetLife</h1><hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Имя</th>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.name}</th>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}<#sep>, </#list></th>
            <th><form action="/admin/user/ban/${user.id?c}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form></th>
            <th><a href="/admin/user/edit/${user.id?c}">Редактирование</a> </th>  <#-- Редактирование ролей -->
            <th><a href="/user/${user.id?c}">Подробная информация</a></th>
        </tr>
        <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
</@t.template>