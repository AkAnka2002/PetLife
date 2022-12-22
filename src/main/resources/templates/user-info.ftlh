<#import "blocks/template.ftlh" as t>
<@t.template user>
    <main class="form-signin w-100 m-auto text-center nav_text">
        <h4>Профиль</h4>
        <img src="/images/${image.id?c}" height="60ps"/> <br><br>
        <b>Имя:</b> ${user.name} <br>
        <b>Адрес электронной почты:</b> ${user.email} <br>
        <b>Номер телефона:</b> ${user.phoneNumber} <br>
        <b class="nav_text">Пол:</b> ${user.gender} <br>
            <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
        </#if>
        <a type="submit" class="btn btn-light me-2 btn-my nav_text" href="/pet/${user.id?c}/mypet">Питомцы</a>
        <hr>
        <a type="submit" class="btn btn-light me-2 btn-my" href="/user/${user.id?c}/update">Редактировать</a>
    </main>
</@t.template>