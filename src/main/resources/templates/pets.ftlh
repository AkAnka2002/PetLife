<#import "blocks/template.ftlh" as t>
<@t.template user>
    <main class="px-3">
        <h1>PetLife</h1>
        <p class="lead">Удобное приложение для работы с домашними питомцами</p>
        <#if user.email??>
            <h3>Привет, <a href="/user/${user.id?c}"> <i>${user.name}</i></a>!</h3>
            <#if user.isAdmin()>
                <p class="lead">
                    <a href="/admin" class="nav-link px-2 link-dark">Панель
                        администратора</a>
                </p>
            </#if>
        <#else>
            <p class="lead">
                <a href="/login" class="nav-link px-2 link-dark">Начать работу</a>
            </p>
        </#if>
    </main>
<#--<h4><a href="/user/${user.id?c}"> Ваши животные</a></h4>-->
<#--<#if user.email??>-->
<#--    <hr>-->
<#--    <h3>Добавить нового питомца</h3>-->
<#--    <form action="/pet/create" method="post" enctype="multipart/form-data">-->
<#--        Кличка: <input type="text" name="name"/><br><br>-->
<#--        Вид животного: <input type="text" name="type"/><br><br>-->
<#--        Возраст: <input type="number" name="age"/> лет<br><br>-->
<#--        Описание: <input type="text" name="description"/><br><br>-->
<#--        Фотография: <input type="file" name="file"/><br><br>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <input type="submit" value="Добавить питомца"/>-->
<#--    </form>-->
<#--</#if>-->

</@t.template>