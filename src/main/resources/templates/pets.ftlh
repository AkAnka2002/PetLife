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
                <a href="/login" type="submit" class="btn btn-light me-2 btn-my nav_text">Начать работу</a>
            </p>
        </#if>
    </main>
</@t.template>