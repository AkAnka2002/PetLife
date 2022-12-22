<#import "blocks/template.ftlh" as t>
<@t.template user>
<h4>Редактирование пользователя ${user.name}</h4>
<form action="/admin/user/edit" method="post">
   <#list roles as role>
       <div>
           <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
       </div>
   </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit" class="btn btn-light me-2 btn-my nav_text">Сохранить</button>
</form>

</@t.template>